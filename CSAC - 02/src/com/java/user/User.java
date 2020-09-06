package com.java.user;


public class User {
	 int id;
	 String username;
	 String password;
	 String lastname;
	 String firstname;
	 String email;
	 String number;
	 int roomnumber;
	 int decknumber;
	 String membership;

    public User()
    {
    	
    }
    
    public User(String firstname, String email, String username) {
        this.firstname = firstname;
        this.email = email;
        this.username = username;
    }


    public User(int id, String username,String password, String lastname, String firstname , String email, String number, int roomnumber, int decknumber, String membership) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.number = number;
        this.roomnumber = roomnumber;
        this.decknumber = decknumber;
        this.membership = membership;
       
    }

    public User(String username,String password, String lastname, String firstname , String email, String number, int roomnumber, int decknumber, String membership) {
    	this.username = username;
        this.password = password;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.number = number;
        this.roomnumber = roomnumber;
        this.decknumber = decknumber;
        this.membership = membership;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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

	public int getRoomnumber() {
		return roomnumber;
	}
	
	public void setRoomnumber(int roomnumber) {
        this.roomnumber = roomnumber;
	}

	public int getDecknumber() {
		return decknumber;
	}
	
	public void setDecknumber(int decknumber) {
        this.decknumber = decknumber;
	}

	public String getMembership() {
		return membership;
	}
	
	public void setMembership(String membership) {
        this.membership = membership;
	}
    
	
	
    
}

