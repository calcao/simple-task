package com.lngtop.utils;


import java.sql.*;

import org.apache.commons.configuration.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class JdbcConnectionUtil {
	
	private static String url = "";
    private static String user = "";
    private static String password = "";
    
    
    private static  Logger logger = LoggerFactory.getLogger(JdbcConnectionUtil.class);
    
    private JdbcConnectionUtil(){
    	
    }

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        	logger.error(e.toString());
            throw new ExceptionInInitializerError(e);
        }
    }
    
    /**
     * load
     */
    public static void load(){
      Configuration conf = SystemConfiguration.createConfiguration("conf/conf.properties");
      url = conf.getString("db.url");
      user = conf.getString("db.user");
      password = conf.getString("db.password");
    }
    /**
     * 链接数据库
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
    	load();
        return DriverManager.getConnection(url, user, password);
    }
    
    /**
     * 释放数据库
     * @param rs
     * @param st
     * @param conn
     */
    public static void free(ResultSet rs, Statement st, Connection conn) {
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null)
                    st.close();
            } catch (SQLException e) {
                e.printStackTrace();
                logger.error(e.toString());
            } finally {
                if (conn != null)
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                        logger.error(e.toString());
                    }
            }
        }
    }
}
