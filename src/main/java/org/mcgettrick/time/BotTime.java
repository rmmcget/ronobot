package org.mcgettrick.time;

import java.sql.Timestamp;
import java.util.Calendar;

import lombok.Data;

@Data
public class BotTime {
	
	private Timestamp nowTime;
	private Calendar cal;
	
	public BotTime() {
		getTimeNow();
	}
			
	private void getTimeNow() {
		
		cal = Calendar.getInstance();
		nowTime = new Timestamp(cal.getTimeInMillis());
	}
	
	public String getGMTMessage(){
		return "GMT Time is Now : " + nowTime;		
	}
	
	public String getTotalHoursLeftOfWork(){
		int currentHour;
		int endofDay = 17;
		String totalHoursToGo = null;
		String hoursLeftOfWorkMessage = null;
		
		currentHour = cal.get(Calendar.HOUR_OF_DAY);
		
		if (currentHour < endofDay ) {
			totalHoursToGo = Integer.toString(endofDay - currentHour);
			hoursLeftOfWorkMessage = "Soldier you have  " + totalHoursToGo + " hours to go before it party time";
			
			
		}else{
			totalHoursToGo = Integer.toString(currentHour - endofDay);
			hoursLeftOfWorkMessage = "Soldier you are off mission, you are " + totalHoursToGo + "past the mission end time - time to go home";			
		}	
		return hoursLeftOfWorkMessage;

		
	}
	

	


	

}
