package model;



import java.text.SimpleDateFormat;
import java.util.Calendar;





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

	


	
	
	
    
}


