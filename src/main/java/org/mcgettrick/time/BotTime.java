package org.mcgettrick.time;

import java.sql.Timestamp;
import java.util.Calendar;

import lombok.Data;

@Data
public class BotTime {
	
	private Timestamp nowTime;
	private Calendar cal;
	private int currentHour;
	private int currentMinute;
	
	
	public BotTime() {
		getTimeNow();
		currentHour = currentHour();
		currentMinute = currentMinute();
		
	}
			
	private void getTimeNow() {
		
		cal = Calendar.getInstance();
		nowTime = new Timestamp(cal.getTimeInMillis());
	}
	
	public String getGMTMessage(){
		return "GMT Time is Now : " + nowTime;		
	}
	
	public String getTotalHoursLeftOfWork(){
		int endofDay = 17;
		int totalMinutes = 60;
		String totalHoursToGo = null;
		String totalMinutesToGo = null;
		String hoursLeftOfWorkMessage = null;
		
		
		if (currentHour < endofDay ) {
			totalHoursToGo = Integer.toString(endofDay - currentHour);
			totalMinutesToGo = Integer.toString(totalMinutes - currentMinute);
			hoursLeftOfWorkMessage = "Soldier you have  " + totalHoursToGo + " hours and " + totalMinutesToGo + " minutes before you can move your convoy out !";
			
			
		}else{
			totalHoursToGo = Integer.toString(currentHour - endofDay);
			hoursLeftOfWorkMessage = "Soldier you are off mission, you are " + totalHoursToGo + "past the mission end time - time to go home";			
		}	
		return hoursLeftOfWorkMessage;

}

	private int currentHour() {
		int currentHour;
		currentHour = cal.get(Calendar.HOUR_OF_DAY);
		return currentHour;
	}
	
	private int currentMinute() {
		int currentMinute;
		currentMinute = cal.get(Calendar.MINUTE);
		return currentMinute;
	}
	
}
