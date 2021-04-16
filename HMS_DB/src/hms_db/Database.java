package hms_db;

import java.sql.Connection;

public interface Database {
	public Connection getDatabaseConnection();
}
