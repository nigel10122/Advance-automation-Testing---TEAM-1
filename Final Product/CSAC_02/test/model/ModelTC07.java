package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

import org.junit.runner.RunWith;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

	@RunWith(JUnitParamsRunner.class)
	public class ModelTC07 { 
		
		Event event;
		EventErrorMsgs eventerrormsg; 
		
		@Before
		public void setUp() throws Exception {
			event = new Event();
			eventerrormsg = new EventErrorMsgs();
		}	

		@Test
		@FileParameters("test/excel/Model_TC07_test_cases.csv")
		public void test(int tc, int eventid, String eventname,  String eventdate, String starttime, String duration, String location, 
				         String numberofattendees, String capacity,String eventcoordinator, String type, String estattendees, 
				         String eventdateError, String starttimeError, String durationError, String locationError, 
				         String numberofattendeesError, String capacityError,String estattendeesError, String errorMsg) {

			Event eventmodel= new Event(eventid, eventname, eventdate, starttime, duration, location, numberofattendees,capacity,eventcoordinator, type, estattendees);
			
			event.getEventid();
			event.getEventname();
			event.setEventname(eventname);
			event.setEventdate(eventdate);
			event.setStarttime(starttime);
			event.setDuration(duration);
			event.setNumberofattendees(numberofattendees);
			event.setCapacity(capacity);
			event.getEventcoordinator();
			event.setEventcoordinator(eventcoordinator);
			event.setType(type);
			event.setLocation(location);
			event.getType();
			event.setEstattendees(estattendees);
			
			event.SetEvent(eventid, eventname, eventdateError, starttimeError, durationError, locationError, numberofattendeesError, capacityError, eventcoordinator, type, estattendeesError);
			event.SetEvent_Summary(eventname, eventdateError, starttimeError, durationError, locationError, estattendeesError);
		
		
			eventmodel.validateModifyEvent(eventmodel, eventerrormsg);
			assertTrue(eventdateError.equals(eventerrormsg.getEventdateError()));
			assertTrue(starttimeError.equals(eventerrormsg.getStarttimeError()));
			assertTrue(durationError.equals(eventerrormsg.getDurationError()));
			assertTrue(locationError.equals(eventerrormsg.getLocationError()));
			assertTrue(numberofattendeesError.equals(eventerrormsg.getNumberofattendeesError()));
			assertTrue(capacityError.equals(eventerrormsg.getCapacityError()));
			assertTrue(estattendeesError.equals(eventerrormsg.getEstattendeesError()));
			assertTrue(errorMsg.equals(eventerrormsg.getErrorMsg()));

		}
	}

	