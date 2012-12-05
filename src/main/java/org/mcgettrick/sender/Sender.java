package org.mcgettrick.sender;

import lombok.Data;

@Data
public class Sender {
	
private int morningCnt = 0;
private int lunchCnt = 0;
private int afternoonCnt = 0;
private int goodNightCnt = 0;

private String morningGreeting;

private String lunchGreeting;

private String afternoonGreeting;

private String goodNightGreeting;


}
