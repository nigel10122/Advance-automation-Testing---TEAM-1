package com.java.data;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.java.util.SQLConnection;
import com.java.model.*;
public class UserDAO {

	static SQLConnection DBMgr = SQLConnection.getInstance();
	
	private static ArrayList<User> ReturnMatchingUsersList (String queryString) {
		ArrayList<User> userListInDB = new ArrayList<User>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
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
				user.setRoomnumber(userList.getString("roomnumber"));
				user.setDecknumber(userList.getString("decknumber"));
				user.setMembership(userList.getString("membership"));  
				userListInDB.add(user);	
			}
		} catch (SQLException e) {}
		return userListInDB;
	}
	
	public static void insertUser (User user) {
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			String insertUser = "INSERT INTO user (iduser,user_name,phone,email,date_ins) " + " VALUES ('"  
					+ user.getUsername()  + "','"
					+ user.getPassword() + "','"		
					+ user.getLastname() + "','"
					+ user.getFirstname() + "',"
					+ user.getEmail()  + "','"
					+ user.getNumber() + "','"		
					+ user.getRoomnumber() + "','"
					+ user.getDecknumber() + "',"
					+ user.getMembership() + "',"
					+ " SYSDATE())";
			stmt.executeUpdate(insertUser);	
			conn.commit(); 
		} catch (SQLException e) {}
	}
	
	public static ArrayList<User>  UserLogin(String username, String password) {  
		return ReturnMatchingUsersList(" SELECT * from USERS where username = '"+username+"' and password = '"+password+"'  ");
}

	public static ArrayList<User>  listUsers() {  
			return ReturnMatchingUsersList(" SELECT * from USERS ORDER BY lastname");
	}
	
	//search companies
	public static ArrayList<User>  searchUser(String lastname)  {  
			return ReturnMatchingUsersList(" SELECT * from USERS WHERE lastname LIKE '%"+lastname+"%' ORDER BY lastname");
	}
	
	//determine if companyID is unique
	public static Boolean Usernameunique(String username)  {  
			return (ReturnMatchingUsersList(" SELECT * from USERS WHERE username = '"+username+"' ORDER BY lastname").isEmpty());
	}

}