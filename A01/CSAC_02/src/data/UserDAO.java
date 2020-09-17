package data;


import java.sql.*;
import java.util.ArrayList;

import util.ConnectionPro;
import model.*;







public class UserDAO {
    Connection con ;

    public UserDAO(Connection con) {
        this.con = con;
    }
    
    private static ArrayList<User> ReturnMatchingUsersList (String queryString) {
		ArrayList<User> userListInDB = new ArrayList<User>();
		
		Statement stmt = null;
		Connection conn = ConnectionPro.getConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet userList = stmt.executeQuery(queryString);
			while (userList.next()) {
				User user = new User(); 
				user.setUsername(userList.getString("username"));
				user.setPassword(userList.getString("password"));
				user.setLastname(userList.getString("lastname"));
				user.setFirstname(userList.getString("firstname"));
				user.setEmail(userList.getString("email")); 
				user.setNumber(userList.getString("number"));
				user.setRoomnumber(userList.getInt("roomnumber"));
				user.setDecknumber(userList.getInt("decknumber"));
				user.setMembership(userList.getString("membership"));  
				userListInDB.add(user);	
			}
		} catch (SQLException e) {}
		return userListInDB;
	}
    

    
    //for register user 
    public boolean saveUser(User user){
        boolean set = false;
        try{
            //Insert register data to database
            String query = "insert into user(username,password,lastname,firstname,email,number,roomnumber,decknumber,membership) values(?,?,?,?,?,?,?,?,?)";
           
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, user.getUsername());
           pt.setString(2, user.getPassword());
           pt.setString(3, user.getLastname());
           pt.setString(4, user.getFirstname());
           pt.setString(5, user.getEmail());
           pt.setString(6, user.getNumber());
           pt.setInt(7, user.getRoomnumber());
           pt.setInt(8, user.getDecknumber());
           pt.setString(9, user.getMembership());
      
           
           pt.executeUpdate();
           set = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return set;
    }
    
  //user login
    public User login(String username, String pass){
        User usr=null;
        try{
            String query ="select * from user where username=? and password=?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, pass);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                usr = new User();
                usr.setId(rs.getInt("id"));
                usr.setUsername(rs.getString("username"));
                usr.setPassword(rs.getString("password"));
                usr.setLastname(rs.getString("lastname"));
                usr.setFirstname(rs.getString("firstname"));
                usr.setEmail(rs.getString("email"));
                usr.setNumber(rs.getString("number"));
                usr.setRoomnumber(rs.getInt("roomnumber"));
                usr.setDecknumber(rs.getInt("decknumber"));
                usr.setMembership(rs.getString("membership"));
             
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return usr;
       
    }
    
    public static Boolean NameCombination(String firstname, String lastname)  {  
		return (ReturnMatchingUsersList(" SELECT * from USER WHERE firstname = '"+firstname+"' AND lastname = '"+lastname+"' ORDER BY roomnumber").isEmpty());
}
    
	//determine if username is unique
	public static Boolean Usernameunique(String username)  {  
			return (ReturnMatchingUsersList(" SELECT * from USER WHERE username = '"+username+"' ORDER BY username").isEmpty());
	}
    


}

