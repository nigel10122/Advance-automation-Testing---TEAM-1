package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

import org.junit.runner.RunWith;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

	@RunWith(JUnitParamsRunner.class)
	public class ModelTC05 { 
		
		Event event;
		Reservation reservation;
		ReservationErrorMsgs reservationerrormsg; 
		
		@Before
		public void setUp() throws Exception {
			reservation = new Reservation();
			reservationerrormsg = new ReservationErrorMsgs();
		}	

		@Test
		@FileParameters("test/excel/Model_TC05_test_cases.csv")
		public void test(int tc,String eventname,  String eventdate, String starttime, String duration, String location, 
				String numberofattendees, String capacity,String eventcoordinator, String type, String estattendees, String firstname, String lastname, String number, String email,
			    String eventname_output,  String eventdate_output, String starttime_output, String duration_output, String location_output, 
				String numberofattendees_output, String capacity_output,String eventcoordinator_output, String type_output, String estattendees_output,
				         String firstname_output, String lastname_output, String number_output, String email_output,  String eventtypecountErrormsg
				        ) {

		

			
			
			if(eventtypecountErrormsg.equals(""))
			{
				int eventid = 1;
				
				reservation.SetEvent(eventid, eventname, eventdate, starttime, duration, location, numberofattendees, capacity, eventcoordinator, type, estattendees);
				reservation.setEventid(eventid);
				reservation.getEventid();
				reservation.getEventname();
				reservation.getEventdate();
				reservation.getStarttime();
				reservation.getDuration();
				reservation.getNumberofattendees();
				reservation.getCapacity();
				reservation.getEventcoordinator();
				reservation.getType();
				reservation.getLocation();
				reservation.getEstattendees();
				reservation.getFirstname();
				reservation.getLastname();
				reservation.getEmail();
				reservation.getNumber();
				
				
				assertEquals(eventname,eventname_output);
				assertEquals(eventdate,eventdate_output);
				assertEquals(starttime,starttime_output);
				assertEquals(duration,duration_output);
				assertEquals(location,location_output);
				assertEquals(numberofattendees,numberofattendees_output);
				assertEquals(capacity,capacity_output);
				assertEquals(estattendees,estattendees_output);
				assertEquals(firstname,firstname_output);
				assertEquals(lastname,lastname_output);
				assertEquals(number,number_output);
				assertEquals(email,email_output);
				
				
			}
		else {
			
		
			//String reservationerror = custom.validateEventTypeCount(type, eventdate, firstname, lastname);
			Reservation reservationmodel= new Reservation(eventname, eventdate, starttime, duration, location, numberofattendees,capacity,eventcoordinator, type, estattendees, firstname, lastname, number, email);
			
			reservationmodel.validateReservation(reservationmodel, reservationerrormsg);
			
		
		
			reservation.setEventname(eventname);
			reservation.setEventdate(eventdate);
			reservation.setStarttime(starttime);
			reservation.setDuration(duration);
			reservation.setNumberofattendees(numberofattendees);
			reservation.setLocation(location);
			reservation.setCapacity(capacity);
			reservation.setEventcoordinator(eventcoordinator);
			reservation.setType(type);
			reservation.setEstattendees(estattendees_output);
			reservation.setFirstname(firstname);
			reservation.setLastname(lastname);
			reservation.setEmail(email);
			reservation.setNumber(number_output);
			

			
			
			
			reservationerrormsg.getEventTypeCountError();
			
			System.out.println(reservationerrormsg.getEventTypeCountError());
			
			assertTrue(eventtypecountErrormsg.equals(reservationerrormsg.getEventTypeCountError()));
			

		}
	}
}
	