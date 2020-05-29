package DatabaseConnection;

import com.mongodb.*;
import com.mongodb.client.*;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Arrays;

import static com.mongodb.client.model.Filters.eq;

public class MongoDB {
    String user = "backend";     // the user name
    String source = "recipepage";   // the source where the user is defined
    char[] password = {'p','a','s','s','w','o','r','d'}; // the password as a character array
    // ...
    MongoCredential credential = MongoCredential.createCredential(user, source, password);
    MongoClient mongoClient = MongoClients.create(
            MongoClientSettings.builder()
                    .applyToClusterSettings(builder ->
                            builder.hosts(Arrays.asList(new ServerAddress("192.168.1.140", 27017))))
                    .credential(credential)
                    .build());
    MongoDatabase database = mongoClient.getDatabase("recipepage");
    MongoCollection<Document> collectionPost = database.getCollection("posts");
    MongoCollection<Document> collectionComment = database.getCollection("comments");
    MongoCollection<Document> collectionIngridents = database.getCollection("ingridents");
    MongoCollection<Document> collectionNutrients = database.getCollection("nutrients");
    MongoCollection<Document> collectionCounter = database.getCollection("counter");

    public boolean insertPost (Document document){
        collectionPost.insertOne(document);
        return true;
    }

    public boolean deletePost (String id){
        try {
            collectionPost.deleteOne(eq("_id", "115"));
        }
        catch (MongoException e){
            return false;
        }
        return true;
    }

    public String getDocument(String id){
        int x =  Integer.valueOf(id);
        FindIterable<Document> temp =collectionPost.find(eq("_id",x));
        Document test = temp.first() ;
        return temp.first().toJson();
    }

    public int getNextId(){
        FindIterable<Document> temp = collectionCounter.find(eq("_id","itemId"));
        Document tempdoc1 = temp.first();
        double i = (int) tempdoc1.get("seqValue");
        int x = (int) i;


        Document query = new Document();
        query.put("_id", "itemId");

        Document newdocu = new Document();
        newdocu.put("seqValue", x+1);

        Document updateQuery = new Document();
        updateQuery.put("$set", newdocu);

        database.getCollection("counter").updateOne(query,updateQuery);
        return x;
    }

    public String[] getAllPosts (){
        FindIterable<Document> tempdoks = collectionPost.find();
        int count = 0;
        for(Document k : tempdoks){
            count++;
        }

        String[] tempString = new String[count];
        int x = 0;
        for(Document k : tempdoks) {
            double tempdoubleID = (double) k.get("_id");
            int tempint = (int) tempdoubleID;
            tempString[x++] = Integer.toString(tempint);
        }
        return tempString;
    }
}
