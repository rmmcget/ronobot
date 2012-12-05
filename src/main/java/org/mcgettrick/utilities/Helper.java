package org.mcgettrick.utilities;

import static org.mcgettrick.ronobot.RonoBotMain.USER1;
import static org.mcgettrick.ronobot.RonoBotMain.USER2;
import static org.mcgettrick.ronobot.RonoBotMain.USER3;
import static org.mcgettrick.ronobot.RonoBotMain.USER4;
import static org.mcgettrick.ronobot.RonoBotMain.USER5;

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
	
	public static Sender setSenderMessages(String nickName){
		
		Sender mySender = new Sender(); 
		
		if (nickName.equalsIgnoreCase(USER1)){
			
			mySender.setMorningGreeting(" : How are you doing today ?");
			mySender.setLunchGreeting(" : So what did you have for lunch ?");
			mySender.setAfternoonGreeting(" : A couple hours to go.... !");	
			mySender.setGoodNightGreeting("Adios Amigo !");
			
		}else if (nickName.equalsIgnoreCase(USER2)){
			
			mySender.setMorningGreeting(" : How it hanging ?");
			mySender.setLunchGreeting(" : Your back, I missed you ");
			mySender.setAfternoonGreeting(" : Working Hard are you !");
			mySender.setGoodNightGreeting("Ding...Dong...Ding...Dong..Quiting Time !");
			
		} else if (nickName.equalsIgnoreCase(USER3)){

			mySender.setMorningGreeting(" : Top of the Morning to you ");
			mySender.setLunchGreeting(" : The day is half over ...");
			mySender.setAfternoonGreeting(" : admit I am the one you love !");
			mySender.setGoodNightGreeting("Yabba Dabba Doo...time to roll !");
			
		}else if (nickName.equalsIgnoreCase(USER4)){

			mySender.setMorningGreeting(" : What a beatiful day !");
			mySender.setLunchGreeting(" : Time to wake up !");
			mySender.setAfternoonGreeting(" : brontobot is sleeping again isnt he ? !");
			mySender.setGoodNightGreeting("The Day is over....Time go home and have some fun !");
			
		}else if (nickName.equalsIgnoreCase(USER5)){

			mySender.setMorningGreeting(" : Another Awesome AT day !");
			mySender.setLunchGreeting(" : Only a couple hours to go...");
			mySender.setAfternoonGreeting(" : Yabba Dabba Doo is quiting time soon !");
			mySender.setGoodNightGreeting("Aloha...time to grab the surfboard and ride that wave out of here !");
			
		}else {

			mySender.setMorningGreeting(" : R");
			mySender.setLunchGreeting(" : Ronobot Mid Day Recharge Process Completed.   Ronobot Energy Level: 100%    Ronobot is ready to serve all !");
			mySender.setAfternoonGreeting(" : My complex algorithms is giving me a headache shortly time to put me to bed");
			mySender.setGoodNightGreeting("Soldier time to move out the convoy...");
		}
					
		return mySender;
		
	}
	
	
	
	
}
