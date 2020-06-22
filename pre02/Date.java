import java.io.*;
import java.util.*;

public class Date {
	public static void main(String[] args) {
		String day, month;
		int date, year;
		
		day = "Monday";
		date = 22;
		month = "June";
		year = 2020;
/*
		System.out.println(day);
		System.out.println(date);
		System.out.println(month);
		System.out.println(year);
*/		
		System.out.println("American format:");
		System.out.println("Today is " + day + ", " + month + " " + date + ", " + year);
		System.out.println("European format:");
		System.out.println("Today is " + day + " " + date + " " + month + " " + year);
	}
}