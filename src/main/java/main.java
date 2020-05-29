
import DatabaseConnection.MongoDB;
import DatabaseConnection.Redis;
import org.bson.Document;
import redis.clients.jedis.Jedis;

import java.util.Arrays;


public class main {
    public static void main(String[] args) {
/*
        Redis tempredis = new Redis();
        tempredis.startup();
        //System.out.println(tempredis.getKey("alex"));

        tempredis.putKey("christian", "laver det hele");

        System.out.println(tempredis.getKey("christian"));

        tempredis.stop();*/




        MongoDB tempmongodb = new MongoDB();
        System.out.println(tempmongodb.getNextId());
        //System.out.println(tempmongodb.getAllPosts().length);
        //System.out.println(tempmongodb.getDocument("1"));
        /*Document document = new Document("_id", "135")
                .append("alexwashere", "true")
                .append("contact", new Document("phone", "228-555-0149")
                        .append("email", "cafeconleche@example.com")
                        .append("location", Arrays.asList(-73.92502, 40.8279556)))
                .append("stars", 3)
                .append("categories", Arrays.asList("Bakery", "Coffee", "Pastries"));
//tempmongodb.insertPost(document);

        //String tempjson = "{ \"name\":\"John\" }";
       // tempmongodb.insertPost( Document.parse(tempjson));

//tempmongodb.deletePost("115");
      //  Document tempdocu = tempmongodb.getDocument("135");
      //  String tempString = tempdocu.toJson();

      //  System.out.println(tempdocu.toJson());
      //  System.out.println("hej");
        /*PostgreSQL temppostgres = new PostgreSQL();
        temppostgres.startUp();
    if (temppostgres.addUser("janudanie","1234","yeahrigth")) {
            System.out.println("user created");
        }
        else{
            System.out.println("user not created");
        }
        if(temppostgres.userLogin("janudanie","1234")) {
            System.out.println("ok");
        }
        else System.out.println("login failed");
        temppostgres.userUpdate("janudanie","1234","yeahrigth");


        if(temppostgres.userUpdate("janudanie","1234","yeahrigth")) System.out.println("updated");

        temppostgres.stop();
        if(temppostgres.userUpdate("janudanie","1123234","yeahrigth")) System.out.println("updated");
        */

    }
}
