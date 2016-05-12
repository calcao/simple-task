package com.lngtop.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lngtop.dao.RecordDao;
import com.lngtop.utils.JdbcConnectionUtil;

/**
 * 
 * @author caoxiaoming
 *
 */
public class RecordService {
  
  private static Logger logger = LoggerFactory.getLogger(RecordService.class);
  
  public void doTask(){
    Connection conn = null;
    
    try {
      conn = JdbcConnectionUtil.getConnection();
      conn.setAutoCommit(false);
      
      RecordDao recordDao = new RecordDao(conn);
      
      //TODO
      recordDao.findById("someid");
      
      //commit
      conn.commit();
    } catch (Exception e) {
      
      //rollback
      try {
        conn.rollback();
      } catch (SQLException e1) {
        logger.error(e1.getMessage());
      }
      
      logger.error(e.getMessage());
    }finally{
      //close connection
      try {
        conn.close();
      } catch (SQLException e) {
        logger.error(e.getMessage());
      }
    }
    
  }
  
}
