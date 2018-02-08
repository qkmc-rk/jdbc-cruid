package com.rk.dao;

import java.sql.Connection;
import java.util.List;

public interface RootDao {
	
	/**
	 * �÷�����ִ�и������ݿ��¼����
	 * @param connection ���ݿ�����
	 * @param sql sql���
	 * @param args sql������ֵ
	 * @return ִ��sqlʱ�ķ���ֵ ����,<i>affected row number</i>
	 * 
	 */
	Integer update(Connection connection,String sql,
			Object... args);
	
	/**
	 * �÷�����ִ���������ݿ��¼����
	 * 
	 * @param connection ���ݿ�����
	 * @param sql sql���
	 * @param args sql������ֵ
	 * @return ִ��sqlʱ�ķ���ֵ ����,<i>affected row number</i>
	 */
	Integer add(Connection connection,String sql,
			Object... args);
	
	/**
	 * �÷�����ִ��ɾ�����ݿ��¼����
	 * 
	 * @param connection ���ݿ�����
	 * @param sql sql���
	 * @param args sql������ֵ
	 * @return ִ��sqlʱ�ķ���ֵ ����,<i>affected row number</i>
	 * 
	 */
	Integer delete(Connection connection,String sql,
			Object... args);
	
	
	/**
	 * �÷�����ִ�в�ѯ�������ݿ��¼����
	 * @param clazz ����
	 * @param connection ���ݿ�����
	 * @param sql sql���
	 * @param args sql������ֵ
	 * @return ִ��sqlʱ�ķ���ֵ ����T,<i>record of db tables</i>

	 */
	<T> T select(Class<T> clazz,Connection connection,String sql, 
			Object... args);
	
	/**
	 * �÷�����ִ�в�ѯ�������ݿ��¼����
	 * @param clazz ����
	 * @param connection ���ݿ�����
	 * @param sql sql���
	 * @param args sql������ֵ
	 * @return ִ��sqlʱ�ķ���ֵList[ T ],<i>record of db tables</i>
	 */
	public <A> List<A> selectForList(Class<A> clazz,Connection connection, String sql, Object... args);
	
	/**
	 * �÷����������ݿ���ĳ���е�ֵ
	 * @param clazz ����
	 * @param connection ���ݿ�����
	 * @param sql sql���
	 * @param args sql������ֵ
	 * @return ĳ���е�ֵ
	 */
	<E> E selctForValue(Connection connection, String sql,
			Object... args);
	
	/**
	 * ��������sql����
	 * @param clazz ����
	 * @param connection ���ݿ�����
	 * @param sql sql���
	 * @param args sql������ֵ
	 * @return ĳ���е�ֵ
	 */
	int[] batch(Connection connection, String sql,
			Object[]... args);
}
