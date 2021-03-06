package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

import org.junit.runner.RunWith;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

	@RunWith(JUnitParamsRunner.class)
	public class ModelTC04 { 
		
		Event event;
		EventErrorMsgs eventerrormsg; 
		
		@Before
		public void setUp() throws Exception {
			event = new Event();
			eventerrormsg = new EventErrorMsgs();
		}	

		@Test
		@FileParameters("test/excel/Model_TC04_test_cases.csv")
		public void test(int tc, String eventdate, String starttime,String type, String eventdateError, String starttimeError , String errorMsg) {

			Event eventmodel= new Event(eventdate, starttime, type);
		
			eventmodel.validateSearchAllEvent(eventmodel, eventerrormsg);
			assertTrue(eventdateError.equals(eventerrormsg.getEventdateError()));
			assertTrue(starttimeError.equals(eventerrormsg.getStarttimeError()));
			assertTrue(errorMsg.equals(eventerrormsg.getErrorMsg()));

		}
	}

	