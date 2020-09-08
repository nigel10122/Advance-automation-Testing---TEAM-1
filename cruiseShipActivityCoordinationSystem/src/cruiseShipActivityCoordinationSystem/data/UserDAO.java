package cruiseShipActivityCoordinationSystem.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import cruiseShipActivityCoordinationSystem.util.SQLConnection;
import cruiseShipActivityCoordinationSystem.model.User;

public class UserDAO {
	
	static SQLConnection DBMgr = SQLConnection.getInstance();
	
	private static ArrayList<User> ReturnMatchingCompaniesList (String queryString) {
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
				user.setPhone(userList.getString("phone")); 
				user.setEmail(userList.getString("email")); 
				user.setRoomnumber(userList.getString("roomnumber"));  
				user.setDecknumber(userList.getString("decknumber"));  
				user.setMembershiptype(userList.getString("membershiptype"));  





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
			String insertuser = "INSERT INTO REGISTER (username,password,lastname,firstname,phone,email,roomnumber,decknumber,membershiptype) " + " VALUES ('"  
					+ user.getUsername()  + "','"
					+ user.getPassword() + "','"		
					+ user.getLastname() + "','"
					+ user.getFirstname() + "','"
					+ user.getPhone() + "','"
					+ user.getEmail() + "','"
					+ user.getRoomnumber() + "','"
					+ user.getDecknumber() + "','"
					+ user.getMembershiptype() + "')";
			stmt.executeUpdate(insertuser);	
			conn.commit(); 
		} catch (SQLException e) {}
	}
	
	//determine if user name is unique
		public static Boolean UsernameUnique(String username)  {  
				return (ReturnMatchingCompaniesList(" SELECT * from REGISTER WHERE username = '"+username+"' ORDER BY roomnumber").isEmpty());
		}
		
		//determine if name combination is unique
				public static Boolean NameCombination(String firstname, String lastname)  {  
						return (ReturnMatchingCompaniesList(" SELECT * from REGISTER WHERE firstname = '"+firstname+"' AND lastname = '"+lastname+"' ORDER BY roomnumber").isEmpty());
				}


		//search user with user name and password
				public static Boolean searchUser (String username, String password)  {  
						return (ReturnMatchingCompaniesList(" SELECT * from REGISTER WHERE username = '"+username+"' AND password = '"+password+"' ORDER BY roomnumber").isEmpty());
				}
}