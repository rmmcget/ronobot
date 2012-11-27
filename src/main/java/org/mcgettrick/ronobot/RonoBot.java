package org.mcgettrick.ronobot;

import java.util.HashMap;
import java.util.Map;

import org.jibble.pircbot.PircBot;
import org.mcgettrick.sender.Sender;
import org.mcgettrick.time.BotTime;
import org.mcgettrick.utilities.Helper;


public class RonoBot extends PircBot {
	
	private int mMsgSentCnt = 0;
	private int aMsgSentCnt = 0;
	private int eMsgSentCnt = 0;

    public RonoBot() {
        this.setName("ronobot");
        loadSenders();
    }
    
   
    private Map<Integer, Sender> messagesMap = new HashMap<Integer, Sender>();
    
    private BotTime serverTime = new BotTime();

    public void onMessage(String channel, String sender,
                        String login, String hostname, String message) { 

    	String responseMessage = getMessages(message, sender);
        	   	  	
    	if (null != responseMessage){
    		sendBotMessage(channel, responseMessage, sender);  
    	}  	     
    }
 
    
    private String getMessages(String botMessages, String sender){
    	String messageToSend = null;
    	Integer userId = null; 	
    	int currentHour = serverTime.currenthour();
    	   	 	
    	if ((currentHour == 9) || (currentHour == 14) || (currentHour == 16)) {
    		userId = Helper.getUserId(sender);
    		
    		if (messagesMap.containsKey(userId)){
    			Sender myMessage = messagesMap.get(userId);
    			if (currentHour == 9 ){
    				
    				if (mMsgSentCnt == 0) {
    					messageToSend = sender + myMessage.getMorningGreeting();
        				mMsgSentCnt = mMsgSentCnt + 1;
    				}
    				   				
    			}else if (currentHour == 13){
    				if (aMsgSentCnt == 0) {
    					messageToSend = sender + myMessage.getMidDayGreeting();
        				aMsgSentCnt = aMsgSentCnt + 1;
    				}
    				
    			}else {
    				if (eMsgSentCnt== 0){
    					messageToSend = sender + myMessage.getAfternoonGreeting();
        				eMsgSentCnt = eMsgSentCnt + 1;
    				} 				
    			}   			
    		}
    		
    	}else {
    		messageToSend = Helper.getSpecialMessages(botMessages, sender);
    	}  	

    	return messageToSend;
    }
    
    private void loadSenders(){
    	for (int i=0; i < 6; i++ ){
    		Sender user = Helper.setSenderMessages(i);
    		messagesMap.put(i, user);
    	}    		
    }
    
    public void sendBotMessage(String channel, String responseMessage, String sender) {
    	Integer userId = null; 	
    	userId = Helper.getUserId(sender);
    	
    	switch (userId) {
		case 0:
			
			//1st 10 minutes
			if (serverTime.currentMinute() < 11){
				sendMessage(channel, responseMessage);
			}
			break;
		case 1:
			//11 minutes to 21 minutes
			if (serverTime.currentMinute() > 10 & serverTime.currentMinute() < 22){
				sendMessage(channel, responseMessage);
			}
			break;
		case 2:
			//22 minutes to 31 minutes
			if (serverTime.currentMinute() > 21 & serverTime.currentMinute() < 32){
				sendMessage(channel, responseMessage);
			}
			break;
		case 3:
			//32 minutes to 41 minutes
			if (serverTime.currentMinute() > 31 & serverTime.currentMinute() < 42){
				sendMessage(channel, responseMessage);
			}
			break;
		case 4:
			//greater than 42 minutes 
			if (serverTime.currentMinute() > 41 ){
				sendMessage(channel, responseMessage);
			}
			break;
			
		default:
			sendMessage(channel, responseMessage);
		}
		
	}
    
    
}
