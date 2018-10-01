package com.jmanuelrc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {
	
	public static Connection getConnection(String dbConnectionName) {
		Connection databaseConnection = null;
		String path = DatabaseUtils.getDatabasePath(dbConnectionName);
		try {
			Class.forName("org.sqlite.JDBC");
			databaseConnection = DriverManager.getConnection("jdbc:sqlite:"+path);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return databaseConnection;
	}
	
	private static String getDatabasePath(String databaseName) {
		ClassLoader loader = DatabaseUtils.class.getClassLoader();
		return loader.getResource(databaseName).getPath();
	}
}
