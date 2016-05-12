package com.lngtop.task;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.configuration.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lngtop.service.RecordService;
import com.lngtop.utils.CalendarUtil;
import com.lngtop.utils.SystemConfiguration;

public class RecordTask {
  private static Logger logger = LoggerFactory.getLogger(RecordTask.class);
  
  public void doTask(){
    Configuration conf = SystemConfiguration.createConfiguration("conf/conf.properties");

    final int excuteDay = conf.getInt("task.day_of_month");

    TimerTask resetTask = new TimerTask() {

      @Override
      public void run() {

        Calendar calendar = Calendar.getInstance();

        int day = calendar.get(Calendar.DAY_OF_MONTH);

        if (day == excuteDay) {
          
          //do task
          RecordService record = new RecordService();
          record.doTask();
        }

      }
    };

    long dailySpan = 24 * 60 * 60 * 1000;

    // 任务执行指定时分秒
    int hh = conf.getInt("task.hh");
    int mm = conf.getInt("task.mm");

    logger.info(" wechat task excute time:{}--{}:{}",excuteDay,hh, mm);

    long excuteTimes = CalendarUtil.createTimes(hh, mm, 0);

    if (System.currentTimeMillis() > excuteTimes) {
      excuteTimes = excuteTimes + dailySpan;
    }

    Timer timer = new Timer();

    timer.scheduleAtFixedRate(resetTask, new Date(excuteTimes), dailySpan);
  }
}
