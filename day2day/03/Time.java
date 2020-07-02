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

	// Normalizes results: <24 hrs, <60 mins, <60 secs
	public static Time addTime(Time t1, Time t2) {
		int hr = t1.hour + t2.hour;
		int min = t1.minute + t2.minute;
		double sec = t1.second + t2.second;

		// Div. gives carry; mod gives remainder
		// EX: 62 mins = 1 hr 2 mins, cuz 62/60=1, 62%60=2
		min += sec / 60.0;
		hr += min / 60;
		// Must "save" carries first by doing mod last
		sec %= 60.0;  // sec = sec % 60.0
		min %= 60;
		hr %= 24;

		return new Time(hr, min, sec);  // skips new Time variable
	}  // end addTime()

	// pure method
	public Time add(Time t2) {
		int hr = this.hour + t2.hour;
		int min = this.minute + t2.minute;
		double sec = this.second + t2.second;

		// normalize
		min += sec / 60.0;
		hr += min / 60;
		sec %= 60.0;  // sec = sec % 60
		min %= 60;
		hr %= 24;

		return new Time(hr, min, sec);
	}  // end add()

	// modifier - is it  bad practice to omit "this"
	public void increment(double seconds) {
		second += seconds;

		minute += second / 60.0;  // initially, overflow happens only in seconds
		hour += minute / 60;  // which can result in overflow in mins
		second %= 60.0;
		minute %= 60;
		hour %= 24;

	}  // end add()


}  // end class
