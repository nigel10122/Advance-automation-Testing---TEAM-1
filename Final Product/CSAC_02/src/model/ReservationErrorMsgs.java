package model;

import java.util.ArrayList;
import java.util.List;

public class ReservationErrorMsgs {

	
	
	private String eventtypecountError;
	
	
	
	public ReservationErrorMsgs() {
		this.eventtypecountError = "";
	
	
	}



public void setErrorMsg() {
	List<String> errorPresent = new ArrayList<String>(6); 
	errorPresent.add(eventtypecountError); 
}
	


	
	public String getEventTypeCountError() {
		return eventtypecountError;
	}
	
	public void setEventTypeCountError(String eventtypecountError)
	{
		this.eventtypecountError = eventtypecountError;
	}
	


}