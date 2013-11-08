package com.example.inc1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class responsible for JDBC connection to SQLite
 */
public class ConnectionHelper {
	/*
	 * SQLite Driver connection constants
	 */
	private static final String DB_DRIVER = "org.sqlite.JDBC";
	private static final String DB_CONNECTION = "jdbc:sqlite:D:/tmp/db/INCIDENTS.sqlite";

	/**
	 * Connection to DB (SQLite, INCIDENTS database)
	 */
	public static Connection getConnection() {
		Connection dbConnection = null;

		// Load Driver
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		// Make connection
		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION);
			return dbConnection;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return dbConnection;
	}

	public static void close(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
