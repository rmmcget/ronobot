package org.mcgettrick.ronobot;

import org.jibble.pircbot.PircBot;
import org.mcgettrick.time.BotTime;

public class RonoBot extends PircBot {

    public RonoBot() {
        this.setName("ronobot");
    }

    public void onMessage(String channel, String sender,
                        String login, String hostname, String message) {
        
        if (message.equalsIgnoreCase("ATTime")){
        	BotTime timestamp = new BotTime();
        	sendMessage(channel, timestamp.getGMTMessage());
        }
        
        if (message.equalsIgnoreCase("MissionTime")){
        	BotTime timestamp = new BotTime();
        	sendMessage(channel, timestamp.getTotalHoursLeftOfWork());
        }
        ;
        if (message.equalsIgnoreCase("Good Morning")){
        	sendMessage(channel, "Good Morning " + sender.toString() + " : Today is an awesome AT Day");
        	
        }
        
        if (message.equalsIgnoreCase("Good Afternoon")){
        	sendMessage(channel, "Soldier " + sender.toString()+ " : Wake up its not nap nap time time. Drop and do some push ups ! ");
        	
        }
        
        if (message.equalsIgnoreCase("Good Evening")){
        	sendMessage(channel, "Good Night " + sender.toString() + " : Soldier its time to move your your convoy out to the HQ ! ");        	
        }
        
        
    }
    
    
}
