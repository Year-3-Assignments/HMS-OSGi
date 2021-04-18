package hms_db;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DatabaseImpl implements Database {
	private Connection connection;
	private final String diverName;
	private String databaseConnectionLink;
	private String databaseUser;
	private String databasePassword;
	
	public DatabaseImpl() {
		this.diverName = "com.mysql.jdbc.Driver";
		this.databaseConnectionLink = "jdbc:mysql://localhost:3306/hms_db?characterEncoding=latin1&useConfigs=maxPerformance";
		this.databaseUser = "root";
		this.databasePassword = "RavB1998";
	}

	@Override
	public Connection getDatabaseConnection() {
		// TODO Auto-generated method stub
		try {
			Class.forName(diverName);
			connection = (Connection) DriverManager.getConnection(databaseConnectionLink, databaseUser, databasePassword);
		} catch (ClassNotFoundException exc) {
			System.out.println("Class not found");
			System.out.println(exc.getMessage());
		} catch (SQLException exc) {
			System.out.println("SQL Error !!!");
			System.out.println(exc.getMessage());
		} finally {
			return connection;
		}
	}
}
