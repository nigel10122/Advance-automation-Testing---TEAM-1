package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class timeDate {

	 String currentDate = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
	 String currentTime = new SimpleDateFormat("hh:mm aa").format(Calendar.getInstance().getTime());
	
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
	
	
	
	
	
	
	
}
