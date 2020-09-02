package com.java.form;


import java.text.SimpleDateFormat;
import java.util.Calendar;



public class NameForm {
	private String name="";
	private String id="";
	private String greetingText="";
	private String greetingText1="";
	private String currentTime = "Current time is : "+new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
	
	
	public String getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getID() {
		return id;
	}
	public void setID(String id) {
		this.id = id;
	}
	public String getGreetingText() {
		return greetingText;
	}
	public void setGreetingText(String greetingText) {
		this.greetingText = greetingText;
	}
	public String getGreetingText1() {
		return greetingText1;
	}
	public void setGreetingText1(String greetingText1) {
		this.greetingText1 = greetingText1;
	}
}
