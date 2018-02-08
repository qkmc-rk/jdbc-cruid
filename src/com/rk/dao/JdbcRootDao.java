package com.rk.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 * 采用commons提供的JDBC工具类dbutils实现
 * RootDao,此类方法为通用的dao方法.
 * 具体dao(例如UserDao)可以继承自此Dao然后实现自己的方法.
 * 
 * 采用DBUtil中提供的QueryRunner(线程安全)与默认handler
 * @param T 泛型
 */
public abstract class JdbcRootDao implements RootDao {

	private QueryRunner queryRunner;
	
	public JdbcRootDao() {
		super();
		this.queryRunner = new QueryRunner();	
	}

	@Override
	public Integer update(Connection connection, String sql, Object... args) {
		try {
			Integer rs = queryRunner.update(connection, sql, args);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer add(Connection connection, String sql, Object... args) {
		Integer rs = update(connection,sql,args);
		return rs;
	}

	@Override
	public Integer delete(Connection connection, String sql, Object... args) {
		Integer rs = update(connection,sql,args);
		return rs;
	}

	@Override
	public <T> T select(Class<T> clazz,Connection connection, String sql, Object... args) {
		
		try {
			return queryRunner.query(connection, sql, new BeanHandler<>(clazz), args);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public <A> List<A> selectForList(Class<A> clazz,Connection connection, String sql, Object... args) {
		
		try {
			return queryRunner.query(connection, sql, new BeanListHandler<>(clazz), args);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <A> A selctForValue(Connection connection, String sql, Object... args) {
		try {
			return (A) queryRunner.query(connection, sql, new ResultSetHandler<Object>() {

				@Override
				public Object handle(ResultSet rs) throws SQLException {
					if(rs.next()) {
						return rs.getObject(1);
					}
					return null;
				}
			}, args);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int[] batch(Connection connection, String sql, Object[]... args) {
		try {
			return queryRunner.batch(connection, sql, args);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
