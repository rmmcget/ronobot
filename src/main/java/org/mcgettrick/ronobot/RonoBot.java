package org.mcgettrick.ronobot;

import static org.mcgettrick.ronobot.RonoBotMain.USER1;
import static org.mcgettrick.ronobot.RonoBotMain.USER2;
import static org.mcgettrick.ronobot.RonoBotMain.USER3;
import static org.mcgettrick.ronobot.RonoBotMain.USER4;
import static org.mcgettrick.ronobot.RonoBotMain.USER5;

import java.util.HashMap;
import java.util.Map;

import org.jibble.pircbot.Colors;
import org.jibble.pircbot.PircBot;
import org.jibble.pircbot.User;
import org.mcgettrick.sender.Sender;
import org.mcgettrick.time.BotTime;
import org.mcgettrick.utilities.Helper;


public class RonoBot extends PircBot {
	

    public RonoBot() {
        this.setName("ronobot");
    }
    
   
    private Map<String, Sender> messagesMap = new HashMap<String, Sender>();
    
    private BotTime serverTime = new BotTime();

    public void onMessage(String channel, String sender,
                        String login, String hostname, String message) { 

    	String responseMessage = getMessages(message, sender);
        	   	  	
    	if (null != responseMessage){
    		sendBotMessage(channel, responseMessage, sender);  
    	}  	     
    }
    
    public void onUserList(String channel, User[] users){
    	for(int i=0; i<users.length; i++){
    		User user = users[i];
    		String nick = user.getNick();
    		Sender sender = Helper.setSenderMessages(nick);
    		messagesMap.put(nick, sender);
    	}
    }
 
    
    private String getMessages(String botMessages, String sender){
    	String messageToSend = null;
    	int currentHour = serverTime.getCurrentHour();

    	   	 	
    	if (ifSpecialMessage(botMessages)) {
    		
    		messageToSend = Helper.getSpecialMessages(botMessages, sender);
    		
    	}else { 		
    		if (messagesMap.containsKey(sender)){
    			Sender myMessage = messagesMap.get(sender);
    			if ((currentHour == 8 ) || (currentHour == 9) || (currentHour == 10)) {
    				
    				if (myMessage.getMorningCnt() == 0) {
    					messageToSend = sender + myMessage.getMorningGreeting();
    					myMessage.setMorningCnt(myMessage.getMorningCnt() + 1);

    				}
    				   				
    			}else if ((currentHour == 11) ||(currentHour == 12) ||(currentHour == 13)){
    				if (myMessage.getLunchCnt() == 0) {
    					messageToSend = sender + myMessage.getMorningGreeting();
    					myMessage.setLunchCnt(myMessage.getLunchCnt() + 1);

    				}
    				
    			}else if ((currentHour == 14) ||(currentHour == 15)) {
    				if (myMessage.getAfternoonCnt()== 0){
    					messageToSend = sender + myMessage.getAfternoonGreeting();
        				myMessage.setAfternoonCnt(myMessage.getAfternoonCnt() + 1);
    				} 				
    			}else if ((currentHour == 16) ||(currentHour == 17)) {
    				if (myMessage.getGoodNightCnt()== 0){
    					messageToSend = sender + myMessage.getGoodNightGreeting();
    					myMessage.setGoodNightCnt(myMessage.getGoodNightCnt() + 1);
    				} 				
    			}      			
    		}
    	}  	

    	return messageToSend;
    }
  
    
    public void sendBotMessage(String channel, String responseMessage, String sender) {
    	
    	
		if (sender.equalsIgnoreCase(USER1)){
			
			sendMessage(channel,Colors.BLUE + responseMessage);
			
		}else if (sender.equalsIgnoreCase(USER2)){
			
			sendMessage(channel, Colors.DARK_GREEN + responseMessage);
						
		} else if (sender.equalsIgnoreCase(USER3)){
			
			sendMessage(channel, Colors.PURPLE + responseMessage);
			
		}else if (sender.equalsIgnoreCase(USER4)){
			
			sendMessage(channel, Colors.RED + responseMessage);
						
		}else if (sender.equalsIgnoreCase(USER5)){
			
			sendMessage(channel, Colors.BROWN + responseMessage);
						
		}else {
			sendMessage(channel, Colors.DARK_BLUE + responseMessage);			
		}
		
	}
    
    public static boolean ifSpecialMessage(String message){
		boolean decision = false;
		if ((message.equalsIgnoreCase("!ATTime")) || (message.equalsIgnoreCase("!MissionTime")|| (message.equalsIgnoreCase("!Favorite")))){
			decision = true;
		}
		return decision;
		
	}		
    
    
}
