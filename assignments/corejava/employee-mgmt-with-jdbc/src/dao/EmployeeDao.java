package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.RowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import com.mysql.cj.jdbc.MysqlDataSource;

public class EmployeeDao {
	Connection conn = null;
	Statement stmt = null;

	public Connection getConnection() {
		try {
			
			MysqlDataSource dataSource = new MysqlDataSource();

			
			Properties prop = new Properties();
			prop.load(new FileInputStream("jdbc.properties"));

			String dbServerName = prop.getProperty("dbServerName");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");

			dataSource.setDatabaseName("jdbctraining");
			dataSource.setServerName(dbServerName);
			dataSource.setUser(username);
			dataSource.setPassword(password);

	
			System.out.println("Connecting to database...");
			conn = dataSource.getConnection();
			conn.setAutoCommit(false); // enable transaction

			System.out.println("Connection estabilished: " + conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	}
