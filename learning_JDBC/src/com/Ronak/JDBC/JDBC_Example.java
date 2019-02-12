package com.Ronak.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Example {

	private String databaseServerName = "localhost";
	private String databasePort = "1521";
	private String databaseName = "xe";
	private String USER = "hr";
	private String PASS = "hr";

	private String connectionURL = "jdbc:oracle:thin:@localhost:1521:xe"; 
	//+ databaseServerName + ":" + databasePort + "/"
			//+ databaseName;

	private ResultSet resultSet = null;
	private Statement statement = null;
	private Connection connection = null;

	private void connectionToOracleDB() throws SQLException, ClassNotFoundException {
		// load the driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// create connection
		connection = DriverManager.getConnection(connectionURL, USER, PASS);
		statement = connection.createStatement();

	}

	public ResultSet runSQLQuery(String sqlQuery) throws ClassNotFoundException, SQLException {
		connectionToOracleDB();
		resultSet = statement.executeQuery(sqlQuery);
		return resultSet;
	}

	public static void main(String[] args) throws Exception, SQLException {
		JDBC_Example db = new JDBC_Example();
		ResultSet data = db.runSQLQuery("select * from COUNTRIES");
		// System.out.println("data:"+ data );

		System.out.println("COUNTRY_ID" + "\t COUNTRY_NAME" + "\t\t\t\t" + "REGION_ID");
		System.out.println("----------------------------------------------------------");
		while (data.next()) {
			String countryID = data.getString("COUNTRY_ID");
			String countryName = data.getString("COUNTRY_NAME");
			int region_ID = data.getInt("REGION_ID");
			System.out.println(countryID + "\t" + countryName + "\t\t\t\t" + region_ID);
		}
	}
}
