import java.io.*;
import java.util.*;

public class Time {
	public static void main(String[] args) {
		int hour,  minute, second;  // current time
		int startHour, startMinute, startSecond;

		hour = 11;
		minute = 58;
		second = 21;
		
		startHour = 11;
		startMinute = 40;
		startSecond = 26;

		int timePassed = (hour-startHour)*3600 + (minute-startMinute)*60 + (second-startSecond);
		
		System.out.println("time since start of this problem: " + timePassed);

/* first part		
		hour = minute = 13;
		second = 41;
		
		int timePassed = hour*3600 + minute*60 + second;
		int timeLeft = 24*3600 - (hour*3600 + minute*60 + second);
		int pctPassed = timePassed * 100 / (timePassed + timeLeft);  // left to right
		
		System.out.println("Seconds past midnight: " + timePassed);
		System.out.println("Seconds to midnight  : " + timeLeft);
		System.out.println("% of day passed      : " + pctPassed);
*/		
		
	}
}