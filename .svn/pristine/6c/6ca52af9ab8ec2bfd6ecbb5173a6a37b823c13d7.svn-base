/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * ClassName: DateTimeUtils
 * 
 * @description
 * @author nikm
 * @Date 2013-3-7
 * 
 */
public final class DateTimeUtils {

	public static void main(String[] argvs) {
		// System.out.println(DateTimeUtils.getDateWithDay(0));
		// System.out.println(DateTimeUtils.formatStrToDate("2010/12/12",
		// DATE_TYPE_01));

		// Date d1 = DateTimeUtils.formatStrToDate("2015-03-14 00:00:00",
		// DATE_TYPE_02);
		// Date d2 = formatStrToDate("2012/12/12", DATE_TYPE_01);
		// System.out.println(d1.after(d2));
		// System.out.println(d1.compareTo(d2));

		// System.out.println(DateTimeUtils.getMonthCardLeftDays(d1, 30));

		// System.out.println(DateTimeUtils.isSingleMonth());
		// System.out.println(DateTimeUtils.isCurrBetween2Days("20150701","20150729",new
		// Date()));
		Date d1 = DateTimeUtils.formatStrToDate("2016-03-25 23:59:59",DATE_TYPE_02);
		System.out.println(DateTimeUtils.isSameDay(new Date(),d1));
		System.out.println(DateTimeUtils.getDays(new Date()));
		// System.out.println(isValidRangeDate(d1, d2,
		// formatStrToDate("2012/02/23", DATE_TYPE_01)));
	}

	/** the day of the format date **/
	public final static int DAY = 0;
	/** the week of the format date **/
	public final static int WEEK = 1;
	/** the time of the format date **/
	public final static int TIME = 2;
	/** the all of the format date **/
	public final static int ALL = 3;
	/** Formatter with: yyyy/MM/dd **/
	public final static int DATE_TYPE_01 = 4;
	/** Formatter with: yyyy-MM-dd HH:mm:ss **/
	public final static int DATE_TYPE_02 = 5;

	public final static String DF_FOR_SCHEDULE = "yyyy-MM-dd HH:mm:ss";
	public final static String EVERY_DAY_HHMMSS = "HH:mm:ss";

	private final static SimpleDateFormat[] DATE_FORMATTER = new SimpleDateFormat[] {
			new SimpleDateFormat("MMM d, yyy"), new SimpleDateFormat("EEE, MMM d, yyyy"),
			new SimpleDateFormat("MMM d, yyyy HH:mm:ss"), new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss"),
			new SimpleDateFormat("yyyy/MM/dd"), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),
			new SimpleDateFormat("yyyyMMdd"), new SimpleDateFormat("MM/dd/yyyy") };

	/**
	 * 
	 * @return
	 */
	public static Date getDateWithDay(int amount) {
		Calendar date = Calendar.getInstance();
		date.add(Calendar.DAY_OF_YEAR, amount);
		date.set(Calendar.HOUR_OF_DAY, 0);
		date.set(Calendar.MINUTE, 0);
		date.set(Calendar.SECOND, 0);
		date.set(Calendar.MILLISECOND, 0);

		return date.getTime();
	}

	/**
	 * 达到每天指定的小时Date对象
	 * 
	 * @param hour
	 * @return
	 */
	public static Date getHourWithDay(int hour) {
		Calendar date = Calendar.getInstance();
		date.set(Calendar.HOUR_OF_DAY, hour);
		date.set(Calendar.MINUTE, 0);
		date.set(Calendar.SECOND, 0);
		date.set(Calendar.MILLISECOND, 0);
		return date.getTime();
	}

	/**
	 * 
	 * @return
	 */
	public static Date getDateWithDiff(Date date, int amount) {
		return getDateWithDiff(date, amount, Calendar.DATE);
	}

	/**
	 * 
	 * @return
	 */
	public static Date getDateWithDiff(Date date, int amount, int field) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(field, amount);
		return calendar.getTime();
	}

	/**
	 * 
	 * @param c1
	 * @param c2
	 * @return
	 */
	public static boolean isSameDay(Calendar c1, Calendar c2) {
		return c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR) && c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH)
				&& c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 判断2个date是否同一天
	 * 
	 * @param lastTime
	 * @param currDate
	 * @return
	 */
	public static boolean isSameDay(Date lastTime, Date currDate) {
		Calendar action = Calendar.getInstance();
		action.setTime(lastTime);
		Calendar curr = Calendar.getInstance();
		curr.setTime(currDate);
		return DateTimeUtils.isSameDay(action, curr);
	}

	/**
	 * 2个date是否同一周
	 * 
	 * @param lastTime
	 * @param currDate
	 * @return
	 */
	public static boolean isSameWeek(Date lastTime, Date currDate) {
		Calendar action = Calendar.getInstance();
		action.setTime(lastTime);
		Calendar curr = Calendar.getInstance();
		curr.setTime(currDate);
		return DateTimeUtils.isSameWeek(action, curr);

	}

	/**
	 * 2个Calendar 是否 同一个月
	 * 
	 * @param c1
	 * @param c2
	 * @return
	 */
	public static boolean isSameMonth(Calendar c1, Calendar c2) {
		return c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR) && c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH);
	}

	/**
	 * 2个Calendar 是否同一个周
	 * 
	 * @param c1
	 * @param c2
	 * @return
	 */
	public static boolean isSameWeek(Calendar c1, Calendar c2) {
		return c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR) && c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH)
				&& c1.get(Calendar.WEEK_OF_MONTH) == c2.get(Calendar.WEEK_OF_MONTH);
	}

	/**
	 * 2个Date 是否同一个月
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static boolean isSameMonth(Date d1, Date d2) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(d1);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(d2);
		return DateTimeUtils.isSameMonth(c1, c2);
	}

	/**
	 * true: 同一个周期，false: 不是同一个周期
	 * 
	 * @param times
	 * @param buyTime
	 * @param curr
	 * @return
	 */
	public static boolean isSameCycle(String[] times, Date lastBuyTime, Date curr) {
		boolean flag = true;
		Calendar cal = Calendar.getInstance();
		Calendar buyCal = Calendar.getInstance();
		buyCal.setTime(lastBuyTime);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int buyHour = buyCal.get(Calendar.HOUR_OF_DAY);
		if (!DateTimeUtils.isSameDay(lastBuyTime, curr)) {
			// 不同天，0---23:59:59
			if (buyHour >= Integer.parseInt(times[times.length - 1])) {
				if (hour >= Integer.parseInt(times[0])) {
					flag = false;
				}
			} else {
				flag = false;
			}
		} else {
			// 同一天
			if (buyHour < Integer.parseInt(times[0])) {
				// 小于等于9点
				if (hour >= Integer.parseInt(times[0])) {
					flag = false;
				}
			} else if (buyHour < Integer.parseInt(times[1])) {
				// 大于9点 小于 12点
				if (hour >= Integer.parseInt(times[1])) {
					flag = false;
				}
			} else if (buyHour < Integer.parseInt(times[2])) {
				// 大于12点 小于18点
				if (hour >= Integer.parseInt(times[2])) {
					flag = false;
				}
			} else if (buyHour < Integer.parseInt(times[3])) {
				// 大于18点 小于23点
				if (hour >= Integer.parseInt(times[3]) && hour <= 24) {
					flag = false;
				}
			}
		}
		return flag;
	}

	/**
	 * 
	 * @param from
	 * @param to
	 * @param date
	 * @return
	 */
	public static boolean isValidRangeDate(Date from, Date to, Date date) {
		// boolean rel = true;
		// if (c.compareTo(from) >= 0 && c.compareTo(to) <= 0){
		// if (from != null) {
		// rel = rel && from.compareTo(date) <= 0;
		// }
		// if (to != null) {
		// rel = rel && to.compareTo(date) >= 0;
		// }
		// return rel;
		return (date.compareTo(from) >= 0 && date.compareTo(to) <= 0);
	}

	/**
	 * 判断currDate 是否在 from ，to 之间
	 * 
	 * @param from
	 * @param to
	 * @param currDate
	 * @return
	 */
	public static boolean isValidRangeDate(Calendar from, Calendar to, Calendar currDate) {
		return (currDate.compareTo(from) >= 0 && currDate.compareTo(to) <= 0);
	}

	/**
	 * Do format date with specified type.
	 * 
	 * @param date
	 *            the date
	 * @param format
	 *            the format type
	 * @return the formatted date
	 */
	public final static String formatDateToString(java.util.Date date, int format) {
		String rel = null;
		if (date != null) {
			if (format >= DATE_FORMATTER.length || format < 0) {
				format = 0;
			}
			rel = DATE_FORMATTER[format].format(date);
		}
		return rel;
	}

	public final static String formatDateToString(java.util.Date date, String format) {
		String rel = null;
		if (date != null) {
			rel = new SimpleDateFormat(format).format(date);
		}
		return rel;
	}

	public final static java.util.Date formatStrToDate(String strDate, int format) {
		java.util.Date rel = null;
		if (strDate != null && !strDate.equals("")) {
			if (format >= DATE_FORMATTER.length || format < 0) {
				format = 0;
			}
			try {
				rel = DATE_FORMATTER[format].parse(strDate);
			} catch (ParseException e) {
				rel = null;
			}
		}
		return rel;
	}

	public static Calendar getSpecifyDate(int hour, int minute, int second) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, hour);
		c.set(Calendar.MINUTE, minute);
		c.set(Calendar.SECOND, second);
		return c;
	}

	/**
	 * 获取当前所在月的天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getDays(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = 0;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			day = 31;
			break;
		case 2:
			day = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			day = 30;
			break;
		default:
			day = 30;
			break;
		}
		return day;
	}

	/**
	 * false: 在30个自然日之内， 禁止月卡充值 true: 距离上次月卡充值，已经过了30个自然日,可以再次使用月卡充值
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static boolean afterSpecifyDay(Date date, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		// System.out.println(cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)
		// + 1)+"-"+cal.get(Calendar.DAY_OF_MONTH) +" "
		// + cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE) +":" +
		// cal.get(Calendar.SECOND));
		cal.add(Calendar.DATE, day + 1);

		Calendar curr = Calendar.getInstance();
		curr.setTime(new Date());
		return curr.after(cal);
	}

	/**
	 * 距离下一次月卡可充值 剩余的 天数
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static int getMonthCardLeftDays(Date date, int day) {
		Date curr = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		// cal.add(Calendar.DATE, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		Calendar calCurr = Calendar.getInstance();
		calCurr.setTime(curr);
		long monthMill = cal.getTimeInMillis();
		long currMill = calCurr.getTimeInMillis();
		long betweenDays = (currMill - monthMill) / (1000 * 3600 * 24);
		betweenDays = day - betweenDays;
		return (int) (betweenDays <= 0 ? 0 : betweenDays);
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int daysBetween(Date date1, Date date2) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		long time1 = cal.getTimeInMillis();
		cal.setTime(date2);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 判断是否是昨天
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isLastDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1); // 得到前一天
		Date currentTime = calendar.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String ds1 = sdf.format(date);
		String ds2 = sdf.format(currentTime);
		if (ds1.equals(ds2)) {
			return true;
		}
		return false;
	}

	/**
	 * 2个时间之间的 秒数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long secondsBetween(Date date1, Date date2) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		long time1 = cal.getTimeInMillis();
		cal.setTime(date2);
		long time2 = cal.getTimeInMillis();
		return (time2 - time1) / 1000;
	}

	public static long secondsBetween(Calendar date1, Calendar date2) {
		return (date2.getTimeInMillis() - date1.getTimeInMillis()) / 1000;
	}

	public static final String getCurrDateStr(Date date) {
		return DateTimeUtils.formatDateToString(date, DF_FOR_SCHEDULE);
	}

	public static boolean isSingleMonth() {
		Calendar cal1 = Calendar.getInstance();
		int month = (cal1.get(Calendar.MONTH) + 1);
		return (month % 2 == 1);
	}

	/**
	 * 当前时间 是否处于2个时间之间
	 * 
	 * @param strDate1
	 * @param strDate2
	 * @param curr
	 * @return
	 */
	public static boolean isCurrBetween2Days(String strDate1, String strDate2, Date curr) {
		Date beginDate = DateTimeUtils.formatStrToDate(strDate1, 6);
		Date endDate = DateTimeUtils.formatStrToDate(strDate2, 6);
		return curr.after(beginDate) && curr.before(endDate);
	}

}
