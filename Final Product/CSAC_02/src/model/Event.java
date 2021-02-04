package model;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import util.Conversions;








public class Event {
	 int eventid;
	 String eventname;
	 String eventdate;
	 String starttime;
	 String duration;
	 String location;
	 String numberofattendees;
	 String capacity;
	 String eventcoordinator;
	 String type;
	 String estattendees;

	 
	 Conversions conversions = new Conversions();


    public Event()
    {
    	
    }
    
    public Event(String eventdate, String starttime, String type) {
        this.eventdate = eventdate;
        this.starttime = starttime;
        this.type = type;
    }
    
 


    public Event(int eventid, String eventname, String eventdate, String starttime, String duration,
			String location, String numberofattendees, String capacity, String eventcoordinator, String type,
			String estattendees) {
        this.eventid = eventid;
        this.eventname = eventname;
        this.eventdate = eventdate;
        this.starttime = starttime;
        this.duration = duration;
        this.location = location;
        this.numberofattendees = numberofattendees;
        this.capacity = capacity;
        this.eventcoordinator = eventcoordinator;
        this.type = type;
        this.estattendees = estattendees;
        
       
    }
    
    


    public Event(String eventdate, String starttime) {
        this.eventdate = eventdate;
        this.starttime = starttime;
    }

    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    public String getEventname() {
		return eventname;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}
	
	public String getEventdate() {
		return eventdate;
	}
	public void setEventdate(String eventdate) {
		this.eventdate = eventdate;
	}
	
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getNumberofattendees() {
		return numberofattendees;
	}
	public void setNumberofattendees(String numberofattendees) {
		this.numberofattendees = numberofattendees;
	}

	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
        this.capacity = capacity;
	}

	public String getEventcoordinator() {
		return eventcoordinator;
	}
	public void setEventcoordinator(String eventcoordinator) {
        this.eventcoordinator = eventcoordinator;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
        this.type = type;
	}
	
	public String getEstattendees() {
		return estattendees;
	}
	public void setEstattendees(String estattendees) {
        this.estattendees = estattendees;
	}
    
	
	
	public void validateSearchAllEvent (Event event, EventErrorMsgs errorMsgs) {
		
		errorMsgs.setEventdateError(validateDate(event.getEventdate()));
		errorMsgs.setStarttimeError(validateDateTime(event.getEventdate(),event.getStarttime()));
		errorMsgs.setErrorMsg();
	}
	

	public void SetEvent(int eventid, String eventname, String eventdate, String starttime, String duration,
			String location, String numberofattendees, String capacity, String eventcoordinator, String type,
			String estattendees) {
		setEventid(eventid);
		setEventname(eventname);
		setEventdate(eventdate);
		setStarttime(starttime);
		setDuration(duration);
		setLocation(location);
		setNumberofattendees(numberofattendees);
		setCapacity(capacity);
		setEventcoordinator(eventcoordinator);
		setType(type);
		setEstattendees(estattendees);
		
	}
	
	public void SetEvent_Summary( String eventname, String eventdate, String starttime, String duration, String location, String estattendees) {
		
		setEventname(eventname);
		setEventdate(eventdate);
		setStarttime(starttime);
		setDuration(duration);
		setLocation(location);
		setEstattendees(estattendees);
		
	}
	

	
	public void validateModifyEvent(Event event, EventErrorMsgs errorMsgs) {
		
		errorMsgs.setEventdateError(validateDate(event.getEventdate()));
		errorMsgs.setStarttimeError(validateDateTime(event.getEventdate(),event.getStarttime()));
		errorMsgs.setDurationError(validateDuration(event.getStarttime(),event.getDuration()));
		errorMsgs.setLocationError(validateDecknumber(event.getLocation()));
		errorMsgs.setCapacityError(validateCapacity(event.getCapacity()));
		errorMsgs.setNumberofattendeesError(validateNumberofattendees(event.getEstattendees(),event.getNumberofattendees(),event.getCapacity()));
		errorMsgs.setEstattendeesError(validateEstattendees(event.getNumberofattendees(),event.getEstattendees(),event.getCapacity()));
		errorMsgs.setErrorMsg();
	}
	
	
	public void validateDate_Time (Event event, EventErrorMsgs errorMsgs) {
		
		errorMsgs.setEventdateError(validateDate(event.getEventdate()));
		errorMsgs.setStarttimeError(validateDateTime(event.getEventdate(),event.getStarttime()));
		errorMsgs.setErrorMsg();
	}
	

	

public String validateDate(String Date) 
	{
		String result = "";
		

		if(!isDateValid(Date))
		{
			result = "Invalid Date format";
		}
		else
			if(conversions.ConvertedEnteredDate(Date).before(conversions.ConvertedCurrentDate()))
			{
				result = "Date cannot be in the past";
			}
			
			
		
		return result;
	}

	
	public String validateDateTime(String Date, String Time)
	{
	
		
		String result = "";
		if(!isDateValid(Date))
		{
			result = "Invalid Date-Time format";
		}
		else
			if(conversions.ConvertedEnteredDate(Date).before(conversions.ConvertedCurrentDate()))
			{
				result = "Time cannot be in the past";
			}
			else
				//if(!(ConvertedEnteredDate(Date).before(ConvertedCurrentDate())))
				if(conversions.ConvertedEnteredTime(Time).before(conversions.ConvertedStartTimeLimit()) || conversions.ConvertedEnteredTime(Time).after(conversions.ConvertedEndTimeLimit()))
				{
					result = "Event Timings must be between 7:00 AM(inclusive) and 10:00 PM(inclusive)";
				}
			else
				if(conversions.ConvertedEnteredDate(Date).equals(conversions.ConvertedCurrentDate())) 
					if(conversions.ConvertedEnteredTime(Time).before(conversions.ConvertedCurrentTime()))
						{
						result = "Time cannot be in the past";
						}
		
		return result;
	}


	final static String DATE_FORMAT = "MM/dd/yyyy";

	public  boolean isDateValid(String date) 
	{
	        try {
	            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
	            df.setLenient(false);
	            df.parse(date);
	            return true;
	        } catch (ParseException e) {
	            return false;
	        }
	}
	


	
	
	public String validateDuration(String starttime, String duration)
	{
		
		String result = "";
		
		if(conversions.CalculateEndTime(starttime,duration).after(conversions.ConvertedEndTimeLimit()))
		{
			
			result = "Duration cannot exceed end of day";
		}
		
		return result;
		
		
	}
	

	
	public String validateNumberofattendees(String estattendees, String numberofattendees, String capacity)
	{
		String result  = "";
		
		if(!isTextAnInteger(numberofattendees))
		{
			result = "Number of attendees should be a number";
		}
		else
			if(Integer.parseInt(numberofattendees) > Integer.parseInt(capacity))
		{
			result = "The number of attendees should not exceed capacity";
		}
		
		else
			if(!(Integer.parseInt(estattendees) >= 1 && Integer.parseInt(estattendees) <= 100) )
			{
				result = "Number of attendees must be between 1(inclusive) and 100(inclusive)";
			}
					else
						if(!numberofattendees.equals(estattendees))
						{
							result = "The number of attendees should be the same as Estimated attendees";
						}
			
		
		
		return result;
		
	}
	
	
	
	public String validateEstattendees(String numberofattendees, String estattendees, String capacity)
	{
		String result  = "";
		
		if(!isTextAnInteger(estattendees))
		{
			result = "Number of attendees should be a number";
		}
		else
			if(Integer.parseInt(estattendees) > Integer.parseInt(capacity))
		{
			result = "The number of attendees should not exceed capacity";
		}
			
				else
					if(!(Integer.parseInt(estattendees) >= 1 && Integer.parseInt(estattendees) <= 100) )
					{
						result = "Number of attendees must be between 1(inclusive) and 100(inclusive)";
					}
					else
						if(!numberofattendees.equals(estattendees))
						{
							result = "The number of attendees should be the same as Estimated attendees";
						}
			
		
		
		return result;
		
	}
	
	
	public String validateCapacity(String capacity)
	{
		String result  = "";
		int length_capacity = String.valueOf(capacity).length();

				if(!(length_capacity <= 3 ))
			{
				result = "Capacity should be 1 to 3 characters long";
			}
				else
					if(!(Integer.parseInt(capacity) >= 1 && Integer.parseInt(capacity) <= 100) )
					{
						result = "Capacity should be between 0 (not inclusive) to 100 (inclusive)";
					}
			
		
		
		return result;
		
	}
	
	public String validateDecknumber(String decknumber) {
		String result="";
		int length_decknumber = String.valueOf(decknumber).length();
		if (!(length_decknumber <= 2 ))
			result="Decknumber must be 1 or 2 digits in length";
		else
			if (!isTextAnInteger(decknumber))
				result="Decknumber must be a number";
			else
				if (!(Integer.parseInt(decknumber) >= 1 && Integer.parseInt(decknumber) <=15))
					result="Decknumber must be between 1 and 15";
		return result;		
	}
	


	
	private boolean isTextAnInteger (String string) {
        boolean result;
		try
        {
            Long.parseLong(string);
            result=true;
        } 
        catch (NumberFormatException e) 
        {
            result=false;
        }
		return result;
	}
	
	
}
	
	
    



