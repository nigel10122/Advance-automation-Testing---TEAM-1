package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Conversions {
	
    private DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
	private DateFormat timeformat = new SimpleDateFormat("HH:mm:ss");
	private String currentDate = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
	private	String currentTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
	
	
	public Date ConvertedStartTimeLimit()
	{
		
		Date StartTimeLimit = null;
		try {
			StartTimeLimit = timeformat.parse("07:00:00");
		} catch (ParseException e) {} 
		return StartTimeLimit;
	}
	
	public Date ConvertedEndTimeLimit()
	{
		
		Date EndTimeLimit = null;
		try {
			EndTimeLimit = timeformat.parse("22:00:00");
		} catch (ParseException e) {} 
		return EndTimeLimit;
	}
	
	
	
	public Date ConvertedEnteredDate(String Entereddate)
	{
		
		Date EnteredDate = null;
		try {
			EnteredDate = dateformat.parse(Entereddate);
		} catch (ParseException e) {} 
		return EnteredDate;
	}
	
	public Date ConvertedCurrentDate()
	{
		
		String Currentdate = currentDate;
		
		Date CurrentDate = null;
		try {
			CurrentDate = dateformat.parse(Currentdate);
		} catch (ParseException e) {} 
		return CurrentDate;
	}
	
	public Date ConvertedEnteredTime(String Enteredtime)
	{
		
		Date EnteredTime = null;
		try {
			EnteredTime = timeformat.parse(Enteredtime);
		} catch (ParseException e) {} 
		return EnteredTime;
	}
	

	public Date ConvertedCurrentTime()
	{
		
		String Currenttime= currentTime;
		
		Date CurrentTime = null;
		try {
			CurrentTime = timeformat.parse(Currenttime);
		} catch (ParseException e) {} 
		return CurrentTime;
	}
	

	
	public Date CalculateEndTime(String starttime, String duration)
	{
		
		Date EndTime = null;
	
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
		} catch (ParseException e) {} 
		
		return EndTime;
		
		
	}
	
	

}
