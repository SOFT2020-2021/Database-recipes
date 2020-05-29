package DatabaseConnection;

import java.nio.channels.ScatteringByteChannel;
import java.sql.*;
import java.util.logging.Logger;
import java.sql.DriverManager;

public class PostgreSQL {
    String url = "jdbc:postgresql://192.168.1.141:5432/recipepage";
    String user = "backend";
    String password = "password";
    Connection con;

    public void startUp (){
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void stop(){
        try {
            con.close();
        }
        catch (SQLException e){
            System.out.println("no connection");
        }
        }

    public boolean addUser(String username, String password, String email){
        try {
            Statement stm = con.createStatement();
            String query = "insert into users (" +
                    "username," +
                    "password," +
                    "email)" +
                    " VALUES " +
                    "('" +username + "','" +
                    password + "',' "+
                    email + "');";
            stm.executeUpdate(query);
        }
        catch (SQLException e) {
            return false;
        }
        return true;
    }

    public boolean userLogin (String username, String password){
        try {
            Statement stm = con.createStatement();
            String query = "select * from users where username = '" + username + "' and password = '"+password+"';";
            ResultSet rs = stm.executeQuery(query);
            if(rs.next())return true;
            else return false;
        }
        catch (SQLException e) {
            return false;
        }
    }

    public boolean userUpdate (String username, String password, String email){
        try {
            Statement stm = con.createStatement();
            String query = "update users set password = '" + password +"' where username = '" + username + "';";
            stm.executeUpdate(query);
            query = "update users set email = '" + email +"' where username = '" + username + "';";
            stm.executeUpdate(query);
        }
        catch (SQLException e) {
            return false;
        }
        return true;
    }
}