package model;

import java.util.ArrayList;
import java.util.List;

public class EventErrorMsgs {

	
	private String errorMsg;
	private String eventdateError;
	private String starttimeError;
	private String durationError;
	private String locationError;
	private String numberofattendeesError;
	private String capacityError;
	private String estattendeesError;
	
	
	
	public EventErrorMsgs() {
		this.errorMsg = "";
		this.eventdateError = "";
		this.starttimeError = "";
		this.durationError = "";
		this.locationError = "";
		this.numberofattendeesError = "";
		this.capacityError = "";
		this.estattendeesError = "";
	
	
	}

	public String getErrorMsg() {
		return errorMsg;
	}

public void setErrorMsg() {
	List<String> errorPresent = new ArrayList<String>(6); 
	errorPresent.add(eventdateError); 
	errorPresent.add(capacityError);
	errorPresent.add(durationError);
	errorPresent.add(locationError);
	errorPresent.add(numberofattendeesError);
	errorPresent.add(estattendeesError);
	errorPresent.add(starttimeError);

	

	String check;
	for(int counter = 0; counter < errorPresent.size(); counter++) {
		check = errorPresent.get(counter);
		if(check!="") {
			this.errorMsg = "Please correct the following errors";

		}
	}
	
}

	public String getEventdateError() {
		return eventdateError;
	}
	public void setEventdateError(String eventdateError) {
		this.eventdateError = eventdateError;
	}

	public String getStarttimeError() {
		return starttimeError;
	}
	public void setStarttimeError(String starttimeError) {
		this.starttimeError = starttimeError;
	}

	public String getNumberofattendeesError() {
		return numberofattendeesError;
	}
	public void setNumberofattendeesError(String numberofattendeesError) {
		this.numberofattendeesError = numberofattendeesError;
	}

	public String getDurationError() {
		return durationError;
	}
	public void setDurationError(String durationError) {
		this.durationError = durationError;
	}

	public String getLocationError() {
		return locationError;
	}
	public void setLocationError(String locationError) {
		this.locationError = locationError;
	}

	public String getCapacityError() {
		return capacityError;
	}
	public void setCapacityError(String capacityError) {
		this.capacityError = capacityError;
	}
	public String getEstattendeesError() {
		return estattendeesError;
	}
	public void setEstattendeesError(String estattendeesError) {
		this.estattendeesError = estattendeesError;
	}
	


}