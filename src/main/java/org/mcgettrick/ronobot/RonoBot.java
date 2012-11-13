package org.mcgettrick.ronobot;

import org.jibble.pircbot.PircBot;

public class RonoBot extends PircBot {

    public RonoBot() {
        this.setName("ronobot");
    }

    public void onMessage(String channel, String sender,
                        String login, String hostname, String message) {
        if (message.equalsIgnoreCase("!time")) {
            String time = new java.util.Date().toString();
            sendMessage(channel, sender + ": The time is now " + time);
        }       
        
        if (message.equalsIgnoreCase("Good Morning")){
        	sendMessage(channel, "Good Morning " + sender.toString() + " today is an awesome AT Day");
        	
        }
        
    }
}
