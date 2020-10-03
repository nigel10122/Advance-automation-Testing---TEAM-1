package data;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Reservation;

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
	
	
	
}
