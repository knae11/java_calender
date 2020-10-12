package naeun.calender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Calender {

	private static final int[] MAX_DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = {0,  31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	private HashMap <Date, String> planMap;
	
	public Calender() {
		planMap = new HashMap<Date, String>();
	}
	
	/*
	 * @param  date ex : "2017-06-20"
	 * */
	public void registerPlan(String strdate, String plan) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-mm-dd").parse(strdate);
		planMap.put(date, plan);
	}
	
	public String searchPlan(String strdate ) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-mm-dd").parse(strdate);
		String plan = planMap.get(date); 
		return plan;
				

		
	}
	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		}

		return false;
	}

	public int maxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month];
		}
		return MAX_DAYS[month];
	}

	public void printCalender(int year, int month) {

//		for (int i = 1; i < month; i++) {
//			day += maxDaysOfMonth(year, i);
//		}
		int weekday = getWeekDay(year, month, 1);
		System.out.printf("   <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA\r\n" + "----------------------");
		// print blank space
		for (int i = 0; i < weekday; i++) {
			System.out.print("   ");
		}

		int maxDay = maxDaysOfMonth(year, month);
		int count = 7 - weekday;
		int delim = count < 7 ? count : 0;

		// print first line
		for (int i = 1; i <= count; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();

		for (int j = count + 1; j <= maxDay; j++) {
			System.out.printf("%3d", j);
			if (j % 7 == delim) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println();
	}

	private int getWeekDay(int year, int month, int day) {
		// 기준날짜의 요일 얻어냄
		int syear = 1970;
		final int STANDARD_WEEKDAY = 4; // 1970. 1. 1 : Thursday

		int count = 0;

		for (int i = syear; i < year; i++) {
			int delta = isLeapYear(i) ? 366 : 365;
			count += delta;
		}
		//System.out.println(count);
		for ( int i =0; i<month; i++) {
			int delta = maxDaysOfMonth(year,i);
			count += delta;
			
		}

		count += day-1;
		int weekday =( count+STANDARD_WEEKDAY) %7;
		return weekday;
	}
	public static void main(String[] args) throws ParseException {
		Calender cal = new Calender();
		cal.registerPlan("2017-06-23", "meal");
		System.out.println(cal.searchPlan("2017-06-23").equals("meal"));
	}
	
}
