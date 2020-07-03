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

	// converts to 12-hr format. Assumes normalized time values
	public String toString() {
		int hr = hour;

		if (hour > 12) {  // 1 pm or later
			return String.format("%02d:%02d:%04.1f p.m.", hour - 12, minute, second);
		} else if (hour > 11) {  // 12 pm noon to 12:59:59.9 pm
			return String.format("12:%02d:%04.1f p.m.", minute, second);
		} else if (hour > 0) {  // 1 am to 11:59:59.9 am
			return String.format("%02d:%02d:%04.1f a.m.", hour, minute, second);
		} else {  // 12:00 am midnight to 12:59:59.9 am
			return String.format("12:%02d:%04.1f a.m.", minute, second);
		}

		/* 24-hr format
		return String.format("%02d:%02d:%04.1f", hour, minute, second);
		*/
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
	// But first gets rid of negative min or sec
	public void normalize() {
		if (second < 0) {
			second += 60;
			minute--;
		}
		if (minute < 0) {
			minute += 60;
			hour--;
		}

		// Div. gives carry; mod gives remainder
		// EX: 62 mins = 1 hr 2 mins, cuz 62/60=1, 62%60=2
		minute += second / 60.0;
		hour += minute / 60;

		// Must "save" carries first by doing mod last
		second %= 60.0;  // sec = sec % 60.0
		minute %= 60;
		hour %= 24;
	}

	public static Time addTime(Time t1, Time t2) {
		int hr = t1.hour + t2.hour;
		int min = t1.minute + t2.minute;
		double sec = t1.second + t2.second;

		Time t = new Time(hr, min, sec);
		t.normalize();  // reduce overflows

		return t;  // skips new Time variable
	}  // end addTime()

	// pure method
	public Time add(Time t2) {
		int hr = this.hour + t2.hour;
		int min = this.minute + t2.minute;
		double sec = this.second + t2.second;

		Time t = new Time(hr, min, sec);
		t.normalize();  // reduce overflows
		return t;  // skips new Time variable

	}  // end add()

	// modifier - is it  bad practice to omit "this"
	public void increment(double seconds) {
		second += seconds;
		this.normalize();

	}  // end add()

	// instance method
	public void addMinutes(int mins) {
		minute += mins;
		this.normalize();

	}  // end addMinutes()

	// return the (+) number of seconds between the original time and other
	// Find out which is later time, subtract the other
	// Assumes both Time are noramlized: hr<24, min<60, sec<60
	public Time difference(Time other) {
		int compared = this.compareTo(other);  // -1=earlier, 0=same, 1=later
		int hr, min, sec;  // calculated diff

		if (compared < 0) {  // this earlier than other
			hr = other.hour - this.hour;
			min = other.minute - this.minute;
			sec = (int) (other.second - this.second);
		} else {
			hr = this.hour - other.hour;
			min = this.minute - other.minute;
			sec = (int) (this.second - other.second);
		}  // end if else

		Time t = new Time(hr, min, sec);
		t.normalize();  // normalize if min or sec is negative

		return t;
	}

	/* Returns int x such that:
	   x < 0  if this is earlier than other
	   x == 0 if this.equals(other) or diff < 0.1 s
	   x > 0  if this is later than other
	 */
	public int compareTo(Time other) {
		return (this.hour - other.hour) * 256 + (this.minute - other.minute) * 256
				+ (this.second - other.second);

/* v2: easier to read, but may be less efficient
		int diff = this.hour - other.hour;
		if (diff != 0)
			return diff;

		diff = this.minute - other.minute;
		if (diff != 0)
			return diff;

		diff = (int)((this.second - other.second) * 10);
		return diff;
*/

/*	original, probably faster algorithm
	if (this.hour < other.hour)
			return -1;
		else if (this.hour > other.hour)
			return 1;

		if (this.minute < other.minute)  // same hour
			return -1;
		else if (this.minute > other.minute)
			return 1;

		if (this.second < other.second)  // same hour & same minute
			return -1;
		else if (this.second > other.second)
			return 1;

		return 0; // no diffs, so they're same
*/	}  // end compareTo()


}  // end class
