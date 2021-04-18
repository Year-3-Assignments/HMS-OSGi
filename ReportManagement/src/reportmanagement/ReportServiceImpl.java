package reportmanagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import hms_db.Database;
import hms_db.DatabaseImpl;

public class ReportServiceImpl implements ReportService {
	
	private Connection connection = null;
	private Statement statement = null;
	private Database database;
	private ResultSet resultSet;
	
	public ReportServiceImpl() {
		database = new DatabaseImpl();
		connection = database.getDatabaseConnection();
	}
	
	@Override
	public void createReport(Report reports) {
		// TODO Auto-generated method stub
	
		String sqlQuery = "INSERT INTO reports(patientname, doctor_name, description) "
				+ "VALUES('"+ reports.getPatientName() +"', '"+ reports.getDoctorName() +"', '"+ reports.getDescription() +"', "
						+ "')";
		
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sqlQuery);
			System.out.println("Report details successfully inserted ...");
		} catch (SQLException exc) {
			System.out.println("Issue in inserting report details !!!");
			System.out.println(exc.getMessage());
		}
	}
		
		

	@Override
	public ResultSet getAllReport() {
		// TODO Auto-generated method stub
		String sqlQuery = "SELECT * FROM reports WHERE patientname = NOT NULL";
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
		} catch (SQLException exc) {
			System.out.println("There is an issue in getting all the reports !!!");
			System.out.println(exc.getMessage());
		}finally {
			return resultSet;
		} 
	}

	@Override
	public ResultSet searchReport(Integer reportID) {
		// TODO Auto-generated method stub
		String sqlQuery = "SELECT * FROM reports WHERE id = '"+ reportID +"'";
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
		} catch (SQLException exc) {
			System.out.println("There is an issue in getting the reports!!!");
			System.out.println(exc.getMessage());
		} finally {
			return resultSet;
		}
	}

	@Override
	public void requestReport(Integer reportID) {
		// TODO Auto-generated method stub
		String sqlQuery = "SELECT * FROM reports where id ='"+reportID +"'";
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
		} catch (SQLException exc) {
			System.out.println("There is an issue in getting the reports!!!");
			System.out.println(exc.getMessage());
		} 
	}
	
	

	
}
