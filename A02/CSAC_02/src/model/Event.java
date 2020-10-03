package model;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.sun.jdi.Value;





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
	 DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
	 DateFormat timeformat = new SimpleDateFormat("hh:mm a");
	 DateFormat timeformat24 = new SimpleDateFormat("HH:mm");
	 String currentDate = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
	 String currentTime = new SimpleDateFormat("hh:mm aa").format(Calendar.getInstance().getTime());
	 
	 


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
    
    

    public Event(String eventname,String eventdate, String starttime, String duration , String location, String numberofattendees, String capacity, String eventcoordinator, String type, String estattendees) {
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
    
	public String getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}
	
	public String getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
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
	
	
	
	public Date ConvertedStartTimeLimit()
	{
		
		Date StartTimeLimit = null;
		try {
			StartTimeLimit = timeformat24.parse("07:00");
		} catch (ParseException e) {
			
			e.printStackTrace();
		} 
		return StartTimeLimit;
	}
	
	public Date ConvertedEndTimeLimit()
	{
		
		Date EndTimeLimit = null;
		try {
			EndTimeLimit = timeformat24.parse("22:00");
		} catch (ParseException e) {
			
			e.printStackTrace();
		} 
		return EndTimeLimit;
	}
	
	
	
	public Date ConvertedEnteredDate(String Entereddate)
	{
		
		Date EnteredDate = null;
		try {
			EnteredDate = dateformat.parse(Entereddate);
		} catch (ParseException e) {
			
			e.printStackTrace();
		} 
		return EnteredDate;
	}
	
	public Date ConvertedCurrentDate()
	{
		Event event = new Event();
		String Currentdate = event.getCurrentDate();
		
		Date CurrentDate = null;
		try {
			CurrentDate = dateformat.parse(Currentdate);
		} catch (ParseException e) {
			
			e.printStackTrace();
		} 
		return CurrentDate;
	}
	
	public Date ConvertedEnteredTime(String Enteredtime)
	{
		
		Date EnteredTime = null;
		try {
			EnteredTime = timeformat.parse(Enteredtime);
		} catch (ParseException e) {
			
			e.printStackTrace();
		} 
		return EnteredTime;
	}
	
	
	public Date ConvertedEnteredTime24(String Enteredtime)
	{
		
		Date EnteredTime = null;
		try {
			EnteredTime = timeformat24.parse(Enteredtime);
		} catch (ParseException e) {
			
			e.printStackTrace();
		} 
		return EnteredTime;
	}
	
	

	
	public Date ConvertedCurrentTime()
	{
		Event event = new Event();
		String Currenttime= event.getCurrentTime();
		
		Date CurrentTime = null;
		try {
			CurrentTime = timeformat.parse(Currenttime);
		} catch (ParseException e) {
			
			e.printStackTrace();
		} 
		return CurrentTime;
	}
	

public String validateDate(String Date) 
	{
		String result = "";
		Event event = new Event();

		if(!isDateValid(Date))
		{
			result = "Invalid Date format";
		}
		else
			if(event.ConvertedEnteredDate(Date).before(event.ConvertedCurrentDate()))
			{
				result = "Date cannot be in the past";
			}
			
			
		
		return result;
	}

	
	public String validateDateTime(String Date, String Time)
	{
	
		
		String result = "";
		if(!isTimeValid(Time))
		{
			result = "Invalid Time format";
		}
		else
			if(ConvertedEnteredDate(Date).before(ConvertedCurrentDate()))
			{
				result = " Time cannot be in the past";
			}
			else
				if(ConvertedEnteredTime(Time).before(ConvertedStartTimeLimit()) && ConvertedEnteredTime(Time).after(ConvertedEndTimeLimit()))
				{
					result = "Event Timings must be between 7:00 AM(inclusive) and 10:00 PM(inclusive)";
				}
			else
				if(ConvertedEnteredDate(Date).equals(ConvertedCurrentDate())) 
					if( ConvertedEnteredTime(Time).before(ConvertedCurrentTime()))
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
	
	final static String TIME_FORMAT = "hh:mm aa";

	public  boolean isTimeValid(String time) 
	{
	        try {
	            DateFormat df = new SimpleDateFormat(TIME_FORMAT);
	            df.setLenient(false);
	            df.parse(time);
	            return true;
	        } catch (ParseException e) {
	            return false;
	        }
	}

	
	
	
    
}


