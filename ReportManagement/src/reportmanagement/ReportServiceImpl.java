package reportmanagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Scanner;

import hms_db.Database;
import hms_db.DatabaseImpl;

public class ReportServiceImpl implements ReportService {
	
	private Connection connection = null;
	private Statement statement = null;
	private Database database;
	private ResultSet resultSet;
	Integer reportID;
	

	public ReportServiceImpl() {
		database = new DatabaseImpl();
		connection = database.getDatabaseConnection();
	}
	
	@Override
	public void createReport() {
		// TODO Auto-generated method stub
		Integer reportID;
		String patientName,doctorName;
		
		String description;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("==== Create a report ====");
		System.out.print("Enter Report ID - ");
		reportID = scanner.nextInt();
		
		System.out.print("Enter Patient Name- ");
		patientName = scanner.nextLine();
		scanner.nextLine();
		
		System.out.print("Enter Doctor Name - ");
		doctorName = scanner.nextLine();
		
		System.out.print("Description - ");
		description = scanner.nextLine();
		
		String sqlQuery = "INSERT INTO reports VALUES('"+ reportID+"', '"+ patientName +"', '"+ doctorName +"', '"+ description +"')";
		
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
			System.out.println("==== Reports ====");
			System.out.println( "Report ID, Patient Name, Doctor Name, Description");
			while (resultSet.next()) {
				String result = String.format("%-10s %-25s %-20s %-20s", resultSet.getInt("id"), " " + resultSet.getString("patient_name") + 
						" " + resultSet.getString("doctor_name"), resultSet.getString("description"));
				System.out.println(result);
			}
			
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
