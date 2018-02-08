package com.rk.dao;

import java.sql.Connection;
import java.util.List;

public interface RootDao {
	
	/**
	 * 该方法会执行更新数据库记录操作
	 * @param connection 数据库连接
	 * @param sql sql语句
	 * @param args sql语句填充值
	 * @return 执行sql时的返回值 整形,<i>affected row number</i>
	 * 
	 */
	Integer update(Connection connection,String sql,
			Object... args);
	
	/**
	 * 该方法会执行增添数据库记录操作
	 * 
	 * @param connection 数据库连接
	 * @param sql sql语句
	 * @param args sql语句填充值
	 * @return 执行sql时的返回值 整形,<i>affected row number</i>
	 */
	Integer add(Connection connection,String sql,
			Object... args);
	
	/**
	 * 该方法会执行删除数据库记录操作
	 * 
	 * @param connection 数据库连接
	 * @param sql sql语句
	 * @param args sql语句填充值
	 * @return 执行sql时的返回值 整形,<i>affected row number</i>
	 * 
	 */
	Integer delete(Connection connection,String sql,
			Object... args);
	
	
	/**
	 * 该方法会执行查询单条数据库记录操作
	 * @param clazz 泛型
	 * @param connection 数据库连接
	 * @param sql sql语句
	 * @param args sql语句填充值
	 * @return 执行sql时的返回值 泛型T,<i>record of db tables</i>

	 */
	<T> T select(Class<T> clazz,Connection connection,String sql, 
			Object... args);
	
	/**
	 * 该方法会执行查询单条数据库记录操作
	 * @param clazz 泛型
	 * @param connection 数据库连接
	 * @param sql sql语句
	 * @param args sql语句填充值
	 * @return 执行sql时的返回值List[ T ],<i>record of db tables</i>
	 */
	public <A> List<A> selectForList(Class<A> clazz,Connection connection, String sql, Object... args);
	
	/**
	 * 该方法返回数据库中某个列的值
	 * @param clazz 泛型
	 * @param connection 数据库连接
	 * @param sql sql语句
	 * @param args sql语句填充值
	 * @return 某个列的值
	 */
	<E> E selctForValue(Connection connection, String sql,
			Object... args);
	
	/**
	 * 批量处理sql方法
	 * @param clazz 泛型
	 * @param connection 数据库连接
	 * @param sql sql语句
	 * @param args sql语句填充值
	 * @return 某个列的值
	 */
	int[] batch(Connection connection, String sql,
			Object[]... args);
}
