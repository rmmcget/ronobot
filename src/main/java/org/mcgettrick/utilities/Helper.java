package org.mcgettrick.utilities;

import org.mcgettrick.sender.Sender;
import org.mcgettrick.time.BotTime;


public class Helper {
	
	private Helper(){
		
	}
	
	
	public static String getSpecialMessages(String message,String sender){
		
		if (message.equalsIgnoreCase("!ATTime")){
        	BotTime timestamp = new BotTime();
        	return timestamp.getGMTMessage();
        }
        
        if (message.equalsIgnoreCase("!MissionTime")){
        	BotTime timestamp = new BotTime();
        	return timestamp.getTotalHoursLeftOfWork();
        }
        else{
        	return null;
	
        }
		
	}
	
	public static Sender setSenderMessages(int senderId){
		
		Sender mySender = new Sender(); 
		
		switch (senderId) {
		case 0:
			mySender.setId(senderId);
			mySender.setDefaultGreeting(" : Hi !");
			mySender.setMorningGreeting(" : How are you doing today ?");
			mySender.setMidDayGreeting(" : So what did you have for lunch ?");
			mySender.setAfternoonGreeting(" : A couple hours to go.... !");	
			break;
		case 1:
			mySender.setId(senderId);
			mySender.setDefaultGreeting(" : Aloha !");
			mySender.setMorningGreeting(" : How it hanging ?");
			mySender.setMidDayGreeting(" : Your back, I missed you ");
			mySender.setAfternoonGreeting(" : Working Hard are you !");
			break;
		case 2:
			mySender.setId(senderId);
			mySender.setDefaultGreeting(" : Howdy Partner !");
			mySender.setMorningGreeting(" : Top of the Morning to you ");
			mySender.setMidDayGreeting(" : The day is half over ...");
			mySender.setAfternoonGreeting(" : admit I am the one you love !");
			break;
		case 3:
			mySender.setId(senderId);
			mySender.setDefaultGreeting(" : Hello !");
			mySender.setMorningGreeting(" : What a beatiful day !");
			mySender.setMidDayGreeting(" : Time to wake up !");
			mySender.setAfternoonGreeting(" : brontobot is sleeping again isnt he ? !");
			break;
		case 4:
			mySender.setId(senderId);
			mySender.setDefaultGreeting(" : I like talking to you !");
			mySender.setMorningGreeting(" : Another Awesome AT day !");
			mySender.setMidDayGreeting(" : Only a couple hours to go...");
			mySender.setAfternoonGreeting(" : Yabba Dabba Doo is quiting time soon !");
			break;
		case 5:
			mySender.setId(senderId);
			mySender.setDefaultGreeting(" : Buenos Diaz Amigos (aka Good Morning) !");
			mySender.setMorningGreeting(" : Morning");
			mySender.setMidDayGreeting(" : So have you seen bitsbot ?");
			mySender.setAfternoonGreeting(" : My complex algorithms is giving me a headache shortly time to put me to bed");
			break;
		default:
			mySender.setId(senderId);
			mySender.setDefaultGreeting(" : Greetings");
			mySender.setMorningGreeting(" : Good Morning");
			mySender.setMidDayGreeting(" : Good Afternoon");
			mySender.setAfternoonGreeting(" : Good Evening");
			break;
		}
		return mySender;
		
	}
	
	public static int getUserId (String sender) {
		int userId;
				
		if (sender.equalsIgnoreCase("sysbajesse")){
			userId = 0;
		} 
		else if (sender.equalsIgnoreCase("sys_kmburke1")) {
			userId = 1;
		}
		else if (sender.equalsIgnoreCase("enricopulatzo")) {
			userId = 2;
		}
		else if (sender.equalsIgnoreCase("jathom5")) {
			userId = 3;
		}
		else if (sender.equalsIgnoreCase("nathanic")) {
			userId = 4;
		}
		else{
			userId = 5;
		}
		
		return userId;
		
	}
	
	
}
