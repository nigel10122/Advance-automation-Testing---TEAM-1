package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Event;
import model.Reservation;
import util.ConnectionPro;

public class ReservationDAO {
	  Connection con ;

	    public ReservationDAO(Connection con) {
	        this.con = con;
	    }

	
	 public boolean ReserveEvent(Reservation reservation){
	        boolean set = false;
	        try{
	            //Insert register data to database
	            String query = "insert into reservation(eventname,eventdate,starttime,duration,location,numberofattendees,capacity,eventcoordinator,type,estattendees,firstname,lastname,number,email) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	           
	           PreparedStatement pt = this.con.prepareStatement(query);
	           pt.setString(1, reservation.getEventname());
	           pt.setString(2, reservation.getEventdate());
	           pt.setString(3, reservation.getStarttime());
	           pt.setString(4, reservation.getDuration());
	           pt.setString(5, reservation.getLocation());
	           pt.setString(6, reservation.getNumberofattendees());
	           pt.setString(7, reservation.getCapacity());
	           pt.setString(8, reservation.getEventcoordinator());
	           pt.setString(9, reservation.getType());
	           pt.setString(10, reservation.getEstattendees());
	           pt.setString(11, reservation.getFirstname());
	           pt.setString(12, reservation.getLastname());
	           pt.setString(13, reservation.getEmail());
	           pt.setString(14, reservation.getNumber());
	      
	           
	           pt.executeUpdate();
	           set = true;
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	        return set;
	    }
	 
	    public static  ArrayList<Reservation> getPassengerEvents (String eventdate, String starttime, String firstname, String lastname) {
			ArrayList<Reservation> eventListInDB = new ArrayList<Reservation>();

			Statement stmt = null;
			Connection conn = ConnectionPro.getConnection();
			try {
				
				stmt = conn.createStatement();
				String query = "SELECT * from RESERVATION WHERE eventdate LIKE '%"+eventdate+"%' AND starttime > '"+starttime+"' AND firstname LIKE '"+firstname+"' AND lastname LIKE '"+lastname+"' ";
				ResultSet eventList = stmt.executeQuery(query);
				while (eventList.next()) {
					Reservation event = new Reservation();
					event.setEventid(eventList.getInt("eventid"));
					event.setEventname(eventList.getString("eventname"));
					event.setEventdate(eventList.getString("eventdate"));
					event.setStarttime(eventList.getString("starttime"));
					event.setDuration(eventList.getString("duration"));
					event.setLocation(eventList.getString("location"));
					event.setNumberofattendees(eventList.getString("numberofattendees"));
					event.setCapacity(eventList.getString("capacity"));
					event.setEventcoordinator(eventList.getString("eventcoordinator"));
					event.setType(eventList.getString("type"));
					event.setEstattendees(eventList.getString("estattendees"));
					event.setFirstname(eventList.getString("firstname"));
					event.setLastname(eventList.getString("lastname"));
					event.setNumber(eventList.getString("number"));
					event.setEmail(eventList.getString("email"));
					eventListInDB.add(event);
				}
			} catch (SQLException e) {}
			return eventListInDB;
		}
	    
	    
	    public static  ArrayList<Reservation> ListSpecificEvent (String eventid) {
			ArrayList<Reservation> eventListInDB = new ArrayList<Reservation>();

			Statement stmt = null;
			Connection conn = ConnectionPro.getConnection();
			try {
				
				stmt = conn.createStatement();
				String query = "SELECT * from RESERVATION where eventid = '"+eventid+"' ORDER BY eventid " ;
				ResultSet eventList = stmt.executeQuery(query);
				while (eventList.next()) {
					Reservation event = new Reservation();
					event.setEventid(eventList.getInt("eventid"));
					event.setEventname(eventList.getString("eventname"));
					event.setEventdate(eventList.getString("eventdate"));
					event.setStarttime(eventList.getString("starttime"));
					event.setDuration(eventList.getString("duration"));
					event.setLocation(eventList.getString("location"));
					event.setNumberofattendees(eventList.getString("numberofattendees"));
					event.setCapacity(eventList.getString("capacity"));
					event.setEventcoordinator(eventList.getString("eventcoordinator"));
					event.setType(eventList.getString("type"));
					event.setEstattendees(eventList.getString("estattendees"));
					eventListInDB.add(event);
				}
			} catch (SQLException e) {}
			return eventListInDB;
		}
	    
	    public static  int getCountShowType (String type,String eventdate, String firstname, String lastname) {
			
	    	int count = 0;
	    	ResultSet getcount;
	    	Statement stmt = null;
			Connection conn = ConnectionPro.getConnection();
			try {
				
				stmt = conn.createStatement();
				String query = " SELECT * FROM RESERVATION WHERE type = '"+type+"' AND eventdate = '"+eventdate+"' AND firstname = '"+firstname+"' AND lastname = '"+lastname+"'";
				
				getcount = stmt.executeQuery(query);
					while(getcount.next()) {
					count++;
				}
			
				}
			catch (SQLException e) {}
			return count;
		}
	
	
	
}