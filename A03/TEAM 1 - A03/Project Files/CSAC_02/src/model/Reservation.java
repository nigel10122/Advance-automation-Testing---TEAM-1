package model;

import data.ReservationDAO;

public class Reservation {
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
	 String firstname;
	 String lastname;
	 String number;
	 String email;

	 public Reservation(){
		 
	 }
	 
	   public Reservation(String eventname,String eventdate, String starttime, 
			   			  String duration , String location, String numberofattendees, 
			   			  String capacity, String eventcoordinator, String type, String estattendees,
			   			  String firstname, String lastname, String number, String email) {
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
	        this.firstname = firstname;
	        this.lastname = lastname;
	        this.number = number;
	        this.email = email;
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
    

	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
        this.number = number;
	}

	
	public String getCountShowTypeModel(String type, String eventdate, String firstname, String lastname) {
	
		int count=0;
		count = ReservationDAO.getCountShowType(type,eventdate,firstname,lastname);
		String msgg="";
		if(type.equalsIgnoreCase("Show")) {
		if(count==1) {
			msgg="already one show event has been reserved.";
		}}else {
			if(count==2) {
				msgg="already two athletic events have been reserved.";

			}
		}
		return msgg;
	}
	
    
}

