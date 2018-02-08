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
 * JDBCUtil������
 * ������DBCP����Դ��������
 * ������Դ��ȡ���ݿ�����
 * ��������ʹ��,ʹ����Ͻ����ӻ�������Դ
 * 
 */
public class JDBCUtil {

	private static Properties properties = null;
	private static DataSource dataSource = null;
	/**
	 * ��ʼ������,���ڼ�������,���������ļ�
	 */
	static {
		properties = new Properties();
		InputStream inStream = JDBCUtil.class.getClassLoader()
				.getResourceAsStream("dbcp.properties");
		try {
			//���������ļ�
			properties.load(inStream);
			//��ȡ����Դ
			dataSource = BasicDataSourceFactory.createDataSource(properties);
		} catch (IOException e) {
			System.out.println("��ȡ�����ļ��쳣,�����ļ�λ��Ϊclasspath:dbcp.properties");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		
		BasicDataSource basicDataSource = null;
		//�״�ʹ����Ҫ�������Դ�Ƿ��ʼ���ɹ�
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
