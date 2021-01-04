package com.learning.java8.dateandtime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class DateAndTime {

	public static void main(String[] args) {
		// Get the current date and time
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println("Current DateTime: " + currentTime);

		LocalDate date1 = currentTime.toLocalDate();
		System.out.println("date1: " + date1);

		Month month = currentTime.getMonth();
		int day = currentTime.getDayOfMonth();
		int seconds = currentTime.getSecond();

		System.out.println("Month: " + month + ", Day: " + day + ", Seconds: " + seconds);

		LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
		System.out.println("date2: " + date2);

		// 12 december 2014
		LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
		System.out.println("date3: " + date3);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		System.out.println("date3 in yyyyMMdd format: " + date3.format(formatter));

		// 22 hour 15 minutes
		LocalTime date4 = LocalTime.of(22, 15);
		System.out.println("date4: " + date4);

		// parse a string
		LocalTime date5 = LocalTime.parse("20:15:30");
		System.out.println("date5: " + date5);

		/**
		 * Result :
		 * 
		 * Current DateTime: 2020-12-30T15:53:50.256 
		 * date1: 2020-12-30 
		 * Month: DECEMBER, Day: 30, Seconds: 50 
		 * date2: 2012-12-10T15:53:50.256 
		 * date3: 2014-12-12 
		 * date3 in yyyyMMdd format: 20141212 
		 * date4: 22:15 
		 * date5: 20:15:30
		 */
	}

}
