package com.jmanuelrc.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BaseRepository {
	
	private String tableName;
	
	public BaseRepository() {};

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName the tableName to set
	 */
	protected void setTableName(String tableName) {
		this.tableName = tableName;
	}

	protected boolean insert(PreparedStatement statement) {
		try {
			statement.executeUpdate();
			statement.getConnection().close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	protected void select(PreparedStatement statement) {
		
	}
	
}
