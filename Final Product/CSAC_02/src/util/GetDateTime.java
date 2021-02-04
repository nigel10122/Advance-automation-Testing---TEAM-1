package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GetDateTime {

	 String currentDate = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
	 String currentTime = new SimpleDateFormat("hh:mm:ss").format(Calendar.getInstance().getTime());
	
	public String getCurrentTime() {
		return currentTime;
	}
	

	public String getCurrentDate() {
		return currentDate;
	}
	

	
	
	
	
	
	
}
