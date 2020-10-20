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
	 DateFormat timeformat = new SimpleDateFormat("HH:mm:ss");
	 DateFormat timeformat24 = new SimpleDateFormat("HH:mm");
	 String currentDate = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
	 String currentTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
	 
	 


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
			StartTimeLimit = timeformat.parse("07:00:00");
		} catch (ParseException e) {
			
			e.printStackTrace();
		} 
		return StartTimeLimit;
	}
	
	public Date ConvertedEndTimeLimit()
	{
		
		Date EndTimeLimit = null;
		try {
			EndTimeLimit = timeformat.parse("22:00:00");
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
				if(ConvertedEnteredDate(Date).equals(ConvertedCurrentDate()) || ConvertedEnteredDate(Date).after(ConvertedCurrentDate()) )
				if(ConvertedEnteredTime(Time).before(ConvertedStartTimeLimit()) || ConvertedEnteredTime(Time).after(ConvertedEndTimeLimit()))
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
	
	final static String TIME_FORMAT = "HH:mm:ss";

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

	

	
	
	public Date ConvertedDuration(String duration)
	{
		
		Date Duration = null;
		try {
			Duration = timeformat.parse(duration);
		} catch (ParseException e) {
			
			e.printStackTrace();
		} 
		return Duration;
	}
	
	


	/*@SuppressWarnings("deprecation")
	public Date CalculateEndTime(String starttime, String duration)
	{
		
		Date EndTime = null;
		int StartTimehours = ConvertedEnteredTime(starttime).getMinutes();
		int StartTimeminutes = ConvertedEnteredTime(starttime).getHours();
		int StartTimeseconds = ConvertedEnteredTime(starttime).getSeconds();
		int Durationhours = ConvertedDuration(duration).getHours();
		int Durationminutes = ConvertedDuration(duration).getMinutes();
		int Durationseconds = ConvertedDuration(duration).getSeconds();
		
		int endhour =  StartTimehours + Durationhours;
		String EndHour = Integer.toString(endhour);
		int endminutes =  StartTimeminutes + Durationminutes;
		String EndMinutes = Integer.toString(endminutes);
		int endseconds =  StartTimeseconds + Durationseconds;
		String EndSeconds = Integer.toString(endseconds);
		
		String endtime = EndHour+":"+EndMinutes+":"+EndSeconds;
		
		try {
			EndTime = timeformat.parse(endtime);
		} catch (ParseException e) {
			
			e.printStackTrace();
		} 
		
		return EndTime;
		
		
	}*/
	
	public Date CalculateEndTime(String starttime, String duration)
	{
		
		Date EndTime = null;
	
		/*Date StartTime = ConvertedEnteredTime(starttime);
		Date Duration = ConvertedDuration(duration);
		
		long End_Time = StartTime.getTime() + Duration.getTime();
		
		String endtime = timeformat.format(End_Time);*/
		
		int starttimehour= Integer.parseInt(starttime.substring(0,2));
		
		int starttimeminute= Integer.parseInt(starttime.substring(3,5));
		
		int starttimesecond= Integer.parseInt(starttime.substring(6,8));

		int durationhour= Integer.parseInt(duration.substring(0,2));

		int durationminute= Integer.parseInt(duration.substring(3,5));
		
		int durationsecond= Integer.parseInt(duration.substring(6,8));
		
		int endtimehour = starttimehour + durationhour;
		int endtimeminute = starttimeminute + durationminute;
		int endtimesecond = starttimesecond + durationsecond;
		
		String EndTimeHour = Integer.toString(endtimehour);
		String EndTimeMinute = Integer.toString(endtimeminute);
		String EndTimeSecond = Integer.toString(endtimesecond);
		
		String endtime = EndTimeHour+":"+EndTimeMinute+":"+EndTimeSecond;
		
		
	
		try {
			EndTime = timeformat.parse(endtime);
		} catch (ParseException e) {
			
			e.printStackTrace();
		} 
		
		return EndTime;
		
		
	}
	
	
	public String validateDuration(String starttime, String duration)
	{
		
		String result = "";
		
		if(CalculateEndTime(starttime,duration).after(ConvertedEndTimeLimit()))
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
				if(!stringSize(numberofattendees,1,3))
			{
				result = "Number of attendees should be 1 to 3 characters long";
			}
				else
					if(!(Integer.parseInt(estattendees) > 0 || Integer.parseInt(estattendees) <= 100) )
					{
						result = "Number of attendees cannot be more than 100";
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
				if(!stringSize(estattendees,1,3))
			{
				result = "Number of attendees should be 1 to 3 characters long";
			}
				else
					if(!(Integer.parseInt(estattendees) > 0 || Integer.parseInt(estattendees) <= 100) )
					{
						result = "Number of attendees cannot be more than 100";
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
		
		if(!(isTextAnInteger(capacity)))
		{
			result = "Capacity should be a number";
		}
		else
				if(!stringSize(capacity,1,3))
			{
				result = "Capacity should be 1 to 3 characters long";
			}
				else
					if(Integer.parseInt(capacity) < 1 || Integer.parseInt(capacity) > 100 )
					{
						result = "Capacity should be between 0 (not inclusive) to 100 (inclusive)";
					}
			
		
		
		return result;
		
	}
	
	public String validateDecknumber(String decknumber) {
		String result="";

		if (!stringSize(decknumber,1,2) )
			result="Decknumber must be 1 or 2 digits in length";
		else
			if (!isTextAnInteger(decknumber))
				result="Decknumber must be a number";
			else
				if (!(Integer.parseInt(decknumber) >= 1 && Integer.parseInt(decknumber) <=15))
					result="Decknumber must be between 1 and 15";
		return result;		
	}
	
	
	private boolean stringSize(String string, int min, int max) {
		return string.length()>=min && string.length()<=max;
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
	
	
    



