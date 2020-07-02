import java.io.*;
import java.util.*;


public class Time{

    // your time class code goes in here
	// instance attributes
	private int hour;
	private int minute;
	private double second;

	// default constructor
	public Time() {
		this.hour = this.minute = 0;
		this.second = 0.0;
	}

	// value constructor overloads default
	public Time(int hour, int minute, double second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	// getters, aka. accessors
	public int getHour() {
		return this.hour;
	}

	public int getMinute() {
		return this.minute;
	}

	public double getSecond() {
		return this.second;
	}

	// setters, aka. modifiers
	public void setHour(int hour) {
		this.hour = hour;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public void setSeond(double second) {
		this.second = second;
	}

	public String toString() {
		return String.format("%02d:%02d:%04.1f", this.getHour(), this.getMinute(), this.getSecond());
	}

	public void printTime() {
		System.out.println(this.toString());
	}

	public boolean equals(Time that) {
		return this.hour == that.hour
			&& this.minute == that.minute
			&& this.second == that.second;
	}

	public static Time addTime(Time t1, Time t2) {
		return new Time(t1.hour + t2.hour,
					t1.minute + t2.minute,
					t1.second + t2.second);
	}

}  // end class
