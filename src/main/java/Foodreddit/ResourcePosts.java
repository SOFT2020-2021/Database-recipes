package Foodreddit;

import DatabaseConnection.MongoDB;
import DatabaseConnection.Redis;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.bson.Document;

import java.util.Date;

import java.sql.Timestamp;

@Path("posts")
public class ResourcePosts {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response getallposts(){
        try {
            MongoDB tempmongoCON = new MongoDB();
            String[] tempString = tempmongoCON.getAllPosts();
            String urls = "";
        for (String k : tempString) {
            urls += "<a href=\"posts/" + k + "\">"+ k + "</a>\n";
        }
            return Response.status(200).entity(urls).build();
        }
        catch (Exception E){
            return Response.status(500).entity(E.getMessage()).build();
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPostByID(@PathParam("id") String id) {
        try {
            Redis tempredis = new Redis();
            tempredis.startup();
            String tempstring = tempredis.getKey(id);
            if(tempstring==null){
                MongoDB tempmongoCON = new MongoDB();
                tempstring = tempmongoCON.getDocument(id);
                tempredis.putKey(id,tempstring);
            }
            return Response.status(200).entity(tempstring).build();
        }
        catch(Exception E){
            return Response.status(500).entity(E.getMessage()).build();
        }
    }




    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public Response createPost (String postJson) {

        try {
            MongoDB tempmongoCON = new MongoDB();
            Document document = Document.parse(postJson);
            Date date= new Date();

            Timestamp ts = new Timestamp(date.getTime());
            document.append("timestamp" , ts);

            document.append("_id", tempmongoCON.getNextId());
            tempmongoCON.insertPost(document);
            return Response.status(200).entity("OK").build();
        }
        catch (Exception E){
            return Response.status(500).entity(E.getMessage()).build();
        }
    }
}
