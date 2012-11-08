package org.mcgettrick.ronobot;

import org.jibble.pircbot.*;

public class RonoBotMain {
    
    public static void main(String[] args) throws Exception {
        
        // Now start our bot up.
        RonoBot bot = new RonoBot();
        
        // Enable debugging output.
        bot.setVerbose(true);
        
        // Connect to the IRC server.
        bot.connect("irc.freenode.net");

        // Join the #pircbot channel.
        bot.joinChannel("#silly-bot-test");
    }
}
