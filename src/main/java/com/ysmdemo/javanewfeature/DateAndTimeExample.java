package com.ysmdemo.javanewfeature;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/*
 * 
 * 
 * Why new API?
 * to handle date and time value we have classes like Date, Calendar,TimeStamp .. 1.7 
 *  many of them were depr.
 *  New Date & Time API --> also known as Joda Time APi why?
 *  API was developed by joda.org thats why... 
 *  
 *   java.time package ----> 
 *	LocalDate class to get current date 
 *	LocalTime class to get current time
 *	LocalDateTime class
 *  Period class  quantity of time how many years 
 *  Year class
 *  ZoneId class
 * */
public class DateAndTimeExample {

	public static void main(String[] args) {
		LocalDate date= LocalDate.now();
		LocalTime time=LocalTime.now();
		System.out.println(date+"--"+time);
		LocalDateTime day=LocalDateTime.now();
		System.out.println(day);
		//LocalDateTime dt=LocalDateTime.of(year, month, dayOfMonth, hour, minute)
		Period p=Period.between(LocalDate.of(1990, 12, 9), LocalDate.now());
		System.out.println(p.getYears());
		Year year=Year.of(2020);
		System.out.println("is leapyear"+year.isLeap());
		
		ZoneId zone=ZoneId.systemDefault();
		System.out.println(zone);
		ZoneId la=ZoneId.of("America/Los_Angeles");
		System.out.println(la);
		ZonedDateTime dtime=ZonedDateTime.now(la);
		System.out.println(dtime);
		
		
		
	}
}
