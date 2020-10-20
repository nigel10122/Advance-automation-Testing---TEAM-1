package data;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;



import util.ConnectionPro;
import model.*;






public class EventDAO {
    Connection con ;

    public EventDAO(Connection con) {
        this.con = con;
    }


    
    public boolean ModifyEvent(Event event){
        boolean set = false;
        try{
            //Insert register data to database
            String query = "Update event set eventname = ?, eventdate = ?, starttime = ?, duration = ?, location = ?, numberofattendees = ?, capacity = ?, eventcoordinator = ?, type = ?, estattendees = ? where eventid=? ";
           
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, event.getEventname());
           pt.setString(2, event.getEventdate());
           pt.setString(3, event.getStarttime());
           pt.setString(4, event.getDuration());
           pt.setString(5, event.getLocation());
           pt.setString(6, event.getNumberofattendees());
           pt.setString(7, event.getCapacity());
           pt.setString(8, event.getEventcoordinator());
           pt.setString(9, event.getType());
           pt.setString(10, event.getEstattendees());
           pt.setInt(11, event.getEventid());
      
           
           pt.executeUpdate();
           set = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return set;
    }
    
    public boolean AssignCoordinator(Event event){
        boolean set = false;
        try{
            //Update event set eventcoordinator = ? where eventname = ? and eventdate = ? and starttime = ? and duration = ? and location = ? and numberofattendees = ? and capacity = ? and type = ? and estattendees = ?
            String query = "Update event set eventcoordinator = ? where eventid = ? ";
           
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, event.getEventcoordinator());
           pt.setInt(2, event.getEventid());
           
          
      
           
           pt.executeUpdate();
           set = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return set;
    }
    

    
    public static  ArrayList<Event> geteventsbasedonshowtype (String eventdate, String starttime, String type) {
		ArrayList<Event> eventListInDB = new ArrayList<Event>();

		Statement stmt = null;
		Connection conn = ConnectionPro.getConnection();
		try {
			
			stmt = conn.createStatement();
			String query = "SELECT * from EVENT WHERE eventdate LIKE '%"+eventdate+"%' AND starttime > '"+starttime+"' AND type = '"+type+"' ORDER BY eventid";
			ResultSet eventList = stmt.executeQuery(query);
			while (eventList.next()) {
				Event event = new Event();
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
    
    
    
    public static  ArrayList<Event> getAllevents (String eventdate, String starttime) {
		ArrayList<Event> eventListInDB = new ArrayList<Event>();

		Statement stmt = null;
		Connection conn = ConnectionPro.getConnection();
		try {
			
			stmt = conn.createStatement();
			String query = "SELECT * from EVENT WHERE eventdate LIKE '%"+eventdate+"%' AND starttime > '"+starttime+"' ORDER BY eventid";
			ResultSet eventList = stmt.executeQuery(query);
			while (eventList.next()) {
				Event event = new Event();
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
    
    
    public static  ArrayList<Event> ListSpecificEvent (String eventid) {
		ArrayList<Event> eventListInDB = new ArrayList<Event>();

		Statement stmt = null;
		Connection conn = ConnectionPro.getConnection();
		try {
			
			stmt = conn.createStatement();
			String query = "SELECT * from EVENT where eventid = '"+eventid+"' ORDER BY eventid " ;
			ResultSet eventList = stmt.executeQuery(query);
			while (eventList.next()) {
				Event event = new Event();
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



    //for adding event
    public boolean saveEvent(Event event){
        boolean set = false;
        try{
            //Insert register data to database
            String query = "insert into event(eventname,eventdate,starttime,duration,location,numberofattendees,capacity,eventcoordinator,type,estattendees) values(?,?,?,?,?,?,?,?,?,?)";

           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, event.getEventname());
           pt.setString(2, event.getEventdate());
           pt.setString(3, event.getStarttime());
           pt.setString(4, event.getDuration());
           pt.setString(5, event.getLocation());
           pt.setString(6, event.getNumberofattendees());
           pt.setString(7, event.getCapacity());
           pt.setString(8, event.getEventcoordinator());
           pt.setString(9, event.getType());
           pt.setString(9, event.getEstattendees());


           pt.executeUpdate();
           set = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return set;
    }
    
    
    public static  ArrayList<Event> CoordinatorAssignedevents (String eventdate, String starttime, String eventcoordinator) {
		ArrayList<Event> eventListInDB = new ArrayList<Event>();

		Statement stmt = null;
		Connection conn = ConnectionPro.getConnection();
		try {
			
			stmt = conn.createStatement();
			String query = "SELECT * from EVENT WHERE eventdate LIKE '%"+eventdate+"%' AND starttime > '"+starttime+"' AND eventcoordinator LIKE '"+eventcoordinator+"' ";
			ResultSet eventList = stmt.executeQuery(query);
			while (eventList.next()) {
				Event event = new Event();
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
    
    
    
    
    
    
    

  //user Search event
    public Event SearchEvent(String eventdate, String starttime){
        Event evnt=null;
        try{
            String query ="select * from event where eventdate=? and starttime>?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, eventdate);
            pst.setString(2, starttime);

            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                evnt = new Event();
                evnt.setEventid(rs.getInt("eventid"));
                evnt.setEventname(rs.getString("eventname"));
                evnt.setEventdate(rs.getString("eventdate"));
                evnt.setStarttime(rs.getString("starttime"));
                evnt.setDuration(rs.getString("duration"));
                evnt.setLocation(rs.getString("location"));
                evnt.setNumberofattendees(rs.getString("numberofattendees"));
                evnt.setCapacity(rs.getString("capacity"));
                evnt.setEventcoordinator(rs.getString("eventcoordinator"));
                evnt.setType(rs.getString("type"));
                evnt.setEstattendees(rs.getString("estattendees"));


            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return evnt;

    }
    







}
