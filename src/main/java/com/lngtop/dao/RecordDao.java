package com.lngtop.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lngtop.bean.Record;

/**
 * 
 * @author caoxiaoming
 *
 */
public class RecordDao {
  
  private Connection conn;
  
  private QueryRunner runner = new QueryRunner();
  
  private static final BeanHandler<Record> beanMapper = new BeanHandler<Record>(Record.class);
  
  public RecordDao(Connection conn){
    this.conn = conn;
  }
  
  
  /**
   * 查询
   * @param id
   * @return
   * @throws SQLException
   */
  public Record findById(String id) throws SQLException{
    String sql = "SELECT * FROM tb_record WHERE id = ?";
    return runner.query(conn, sql, beanMapper);
  }
  
  
  public List<Record> findList() throws SQLException{
    String sql = " SELECT * FROM tb_record";
    return runner.query(conn, sql, new BeanListHandler<Record>(Record.class));
  }
  
  public Record insert(Record record) throws SQLException{
    String sql = "INSERT INTO tb_record (foo)VALUES(?)";
    Object[] params = {record.getFoo()};
    return runner.insert(conn, sql,beanMapper,params);
  }
  
  public int update(Record record) throws SQLException{
    String sql = " UPDATE tb_record SET foo=? WHERE id =?";
    Object[] params = {record.getId(),record.getFoo()};
    return runner.update(conn, sql, params);
  }
}
