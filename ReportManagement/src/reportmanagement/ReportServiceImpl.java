package reportmanagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Scanner;

import hms_db.Database;
import hms_db.DatabaseImpl;

public class ReportServiceImpl implements ReportService {
	
	private Connection connection = null;
	private Statement statement = null;
	private Database database;
	private ResultSet resultSet;
	private Scanner scanner;
	

	public ReportServiceImpl() {
		database = new DatabaseImpl();
		connection = database.getDatabaseConnection();
		scanner = new Scanner(System.in);
	}
	
	@Override
	public void createReport() {

		String patientName, doctorName, description;
		LocalDateTime createdDate = LocalDateTime.now();
		
		System.out.println("==== Create a report ====");
		
		System.out.print("Enter Patient Name: ");
		patientName = scanner.nextLine();
		scanner.nextLine();
		
		System.out.print("Enter Doctor Name: ");
		doctorName = scanner.nextLine();
		
		System.out.print("Description: ");
		description = scanner.nextLine();
		
		String sqlQuery = "INSERT INTO reports(patient_name, doctor_name, description, created_date) VALUES('"+ patientName +"', "
				+ "'"+ doctorName +"', '"+ description +"', '"+ createdDate +"')";
		
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
	public void getAllReport() {	
		String sqlQuery = "SELECT * FROM reports";
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
			System.out.println("==== Reports ====");
			System.out.println(String.format("%-10s %-25s %-20s %-20s", "Report ID", "Patient Name", "Doctor Name", "Description"));
			while (resultSet.next()) {
				String result = String.format("%-10s %-25s %-20s %-20s", resultSet.getInt("id"), " " + resultSet.getString("patient_name") + 
						" " + resultSet.getString("doctor_name"), resultSet.getString("description"));
				System.out.println(result);
			}
		} catch (SQLException exc) {
			System.out.println("There is an issue in getting all the reports !!!");
			System.out.println(exc.getMessage());
		}
	}

	@Override
	public void searchReport() {
		Integer reportID;
		System.out.print("Select a report ID: ");
		reportID = scanner.nextInt();
		scanner.nextLine();
		String sqlQuery = "SELECT * FROM reports WHERE id = '"+ reportID +"'";
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
			
			System.out.println(String.format("%-10s %-25s %-20s %-20s", "Report ID", "Patient Name", "Doctor Name", "Description"));
			while (resultSet.next()) {
				String result = String.format("%-10s %-25s %-20s %-20s", resultSet.getInt("id"), " " + resultSet.getString("patient_name") + 
						" " + resultSet.getString("doctor_name"), resultSet.getString("description"));
				System.out.println(result);
			}
		} catch (SQLException exc) {
			System.out.println("There is an issue in getting the reports!!!");
			System.out.println(exc.getMessage());
		} 
	}
}
