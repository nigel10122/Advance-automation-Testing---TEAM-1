package util;



import java.sql.*;


public class ConnectionPro {
    private static Connection con;
    
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cruiseship","root","Plmqaz@098");
            
        }catch(Exception e){}
        return con;
    }
}
