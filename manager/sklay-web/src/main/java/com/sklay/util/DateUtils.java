package com.sklay.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

	public static Calendar getCalendar(Date date) {
		Calendar calendar = Calendar.getInstance();
		if (date == null) {
			calendar.setTime(new Date());
		} else {
			calendar.setTime(date);
		}
		return calendar;
	}

	public static void setToStartTimeOfTheDay(Calendar c) {
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
	}

	public static void setToEndTimeOfTheDay(Calendar c) {
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 999);
	}

	public static Calendar getFirstDayOf(Date date, int field) {
		Calendar c = getCalendar(date);
		setToStartTimeOfTheDay(c);
		int index = c.getActualMinimum(field);
		if (Calendar.DAY_OF_WEEK == field) {
			index++;
		} else if (Calendar.DAY_OF_WEEK_IN_MONTH == field) {
			// TODO
		}
		c.set(field, index);
		return c;
	}

	public static Calendar getFirstDayOfNext(Date date, int field) {
		Calendar c = getFirstDayOf(date, field);
		c.add(field, 1);
		return c;
	}

	public static Calendar getLastDayBegining(Date date, int field) {
		Calendar c = getCalendar(date);
		setToStartTimeOfTheDay(c);
		c.set(field, c.getActualMaximum(field));
		return c;
	}

	public static Calendar getLastDayEnding(Date date, int field) {
		Calendar c = getCalendar(date);
		setToEndTimeOfTheDay(c);
		c.set(field, c.getActualMaximum(field));
		return c;
	}

	public static int get(Date date, int field) {
		return getCalendar(date).get(field);
	}

	public static String getCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("",
				Locale.SIMPLIFIED_CHINESE);

		sdf.applyPattern("yyyy年MM月dd日 HH时mm分ss秒");

		String timeStr = sdf.format(new Date());

		return timeStr;
	}
	
	public static String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("",
				Locale.SIMPLIFIED_CHINESE);

		sdf.applyPattern("MM月dd日 HH时mm分");

		String timeStr = sdf.format(new Date());

		return timeStr;
	}
	
	public static void main(String[] args) {
		System.out.println(getCurrentTime());
	}
}
