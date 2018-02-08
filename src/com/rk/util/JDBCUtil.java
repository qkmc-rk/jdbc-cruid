package com.rk.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;


/**
 * JDBCUtil工具类
 * 依赖于DBCP数据源创建连接
 * 从数据源获取数据库连接
 * 交给程序使用,使用完毕将连接还给数据源
 * 
 */
public class JDBCUtil {

	private static Properties properties = null;
	private static DataSource dataSource = null;
	/**
	 * 初始化代码,用于加载驱动,加载配置文件
	 */
	static {
		properties = new Properties();
		InputStream inStream = JDBCUtil.class.getClassLoader()
				.getResourceAsStream("dbcp.properties");
		try {
			//加载配置文件
			properties.load(inStream);
			//获取数据源
			dataSource = BasicDataSourceFactory.createDataSource(properties);
		} catch (IOException e) {
			System.out.println("获取配置文件异常,配置文件位置为classpath:dbcp.properties");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		
		BasicDataSource basicDataSource = null;
		//首次使用需要检查数据源是否初始化成功
		if(dataSource != null) {
			synchronized(JDBCUtil.class) {
				basicDataSource = (BasicDataSource) dataSource;
			}
		}
		
		try {
			return basicDataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void release(Connection conn,Statement stmt,ResultSet rs) {
		try {
			if(conn != null)
				conn.close();
			if(stmt != null)
				stmt.close();
			if(rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static  DataSource getDataSource() {
		if(dataSource != null)
			return dataSource;
		return null;
		
	}
	
}
