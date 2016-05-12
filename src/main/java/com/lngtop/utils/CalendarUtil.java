package com.lngtop.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author caoxiaoming
 *
 */
public class CalendarUtil {
  
  /**
   * 
   * @Title: getDayStartTimes
   * @Description: 获取一天开始时间(00:00:00)
   * @param date
   * @return
   * @return: Long
   */
  public static Long getDayStartTimes(Date date){
    Calendar calendar = Calendar.getInstance();     
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.setTimeInMillis(date.getTime());
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    return calendar.getTimeInMillis();
  }
  
  /**
   * 
   * @Title: getDayEndTimes
   * @Description: 获取一天结束时间(23:59:59)
   * @param date
   * @return
   * @return: Long
   */
  public static Long getDayEndTimes(Date date){
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(date.getTime());
    calendar.set(Calendar.HOUR_OF_DAY, 23);
    calendar.set(Calendar.MINUTE, 59);
    calendar.set(Calendar.SECOND, 59);
    return calendar.getTimeInMillis();
  }
  
  /**
   * @Title: getLastDayTimes
   * @Description: 获取前一天时间
   * @return
   * @return: Long
   */
  public static Long getLastDayTimes(){
    Calendar calendar = Calendar.getInstance();     
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.add(Calendar.DATE, -1);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    return calendar.getTimeInMillis();
  }
  
  /**
   * @Title: getMonthFirstDayTimes
   * @Description: 获取指定时间的前一个月的第一天时间  MM.01 00:00:00
   * @param times
   * @return
   * @return: Long
   */
  public static Long getMonthFirstDayTimes(Long times){
    Calendar calendar = Calendar.getInstance();     
    calendar.setTimeInMillis(times);
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    return calendar.getTimeInMillis();
  }
  
  /**
   * @Title: getMonthLastDayTimes
   * @Description: 获取指定时间的前一个月的最后一天 MM.31 23:59:59
   * @param times
   * @return
   * @return: Long
   */
  public static Long getMonthLastDayTimes(Long times){
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(times);
    calendar.add(Calendar.MONTH, 1);
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    calendar.add(Calendar.DATE, -1);
    calendar.set(Calendar.HOUR_OF_DAY, 23);
    calendar.set(Calendar.MINUTE, 59);
    calendar.set(Calendar.SECOND, 59);
    return calendar.getTimeInMillis();
  }
  
  /**
   * @Title: createTimes
   * @Description: 创建一个指定时分秒的时间
   * @param h
   * @param m
   * @param s
   * @return
   * @return: Long
   */
  public static Long createTimes(int h,int m,int s){
    Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH);
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    calendar.set(year, month, day, h, m,s);
    return calendar.getTimeInMillis();
  }
  
  
  /**
   * 获取下一个月时间
   * @return
   */
  public static Long getNextMonthTimes(){
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.MONTH, 1);
    return calendar.getTimeInMillis();
  }
  
  /**
   * 获取下个月时间
   * @return
   */
  public static Long getLastMonthTimes(){
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.MONTH, -1);
    return calendar.getTimeInMillis();
  }
}
