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

    public static  ArrayList<Event> getAllevents (String eventdate, String starttime) {
		ArrayList<Event> eventListInDB = new ArrayList<Event>();

		Statement stmt = null;
		Connection conn = ConnectionPro.getConnection();
		try {
			
			stmt = conn.createStatement();
			String query = "SELECT * from EVENT WHERE eventdate LIKE '%"+eventdate+"%' AND starttime >= '"+starttime+"' ORDER BY eventid";
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
    
    
    public static  ArrayList<Event> ListSpecificEvent () {
		ArrayList<Event> eventListInDB = new ArrayList<Event>();

		Statement stmt = null;
		Connection conn = ConnectionPro.getConnection();
		try {
			
			stmt = conn.createStatement();
			String query = "SELECT * from EVENT";
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
    
    
    
    
    

  //user Search event
    public Event SearchEvent(String eventdate, String starttime){
        Event evnt=null;
        try{
            String query ="select * from event where eventdate=? and starttime=?";
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
