package org.mcgettrick.ronobot;


public class RonoBotMain {
	
	public static final String USER1 = "sysbajesse";
	public static final String USER2 = "sys_kmburke";
	public static final String USER3 = "enricopulatzo";
	public static final String USER4 = "jathom5";
	public static final String USER5 = "nathanic";
	public static final String USER6 = "rmmcget";
	
   
    public static void main(String[] args) throws Exception {
    	
    	//String channel = "#ronobot-test";
    	String channel = "#bitswebteam";
    	        
        // Now start our bot up.
        RonoBot bot = new RonoBot();
        
        // Enable debugging output.
        bot.setVerbose(true);
        
        // Connect to the IRC server.
        bot.connect("irc.freenode.net");

        bot.joinChannel(channel);
     
    }
    
}
