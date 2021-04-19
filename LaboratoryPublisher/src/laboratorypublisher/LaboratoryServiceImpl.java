package laboratorypublisher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import hms_db.Database;
import hms_db.DatabaseImpl;
import java.util.Scanner;


public class LaboratoryServiceImpl implements LaboratoryService{
	
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private Database database;
	
	public LaboratoryServiceImpl () {
		database = new DatabaseImpl();
		connection = database.getDatabaseConnection();
	}

	Scanner scanner = new Scanner(System.in);
	@Override
	public void createTest() {
		System.out.println("\n-------- New Lab Test --------");
		System.out.print("Enter the Test Name: ");
		String testName = scanner.nextLine();
		
		System.out.print("Enter the Patient ID: ");
		Integer patientId = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Description : ");
		String description = scanner.nextLine();
		
		System.out.print("Price : ");
		Integer price = scanner.nextInt();
		scanner.nextLine();
		
		String sqlQuery = "INSERT INTO laboratory(test_name, patientId, description, price) VALUES('"+ testName+"', '"+ patientId +"', '"+ description +"', '"+ price +"')";
		
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sqlQuery);
			System.out.println("Laboratory tests information successfully inserted ...");
			
		} catch (SQLException exc) {
			System.out.println("Issue in inserting laboratory details !!!");
			System.out.println(exc.getMessage());
		}
	}

	@Override
	public void getAllTests() {
		String sqlQuery = "SELECT * FROM laboratory";
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
			System.out.println("\n------------------------------------- Lab Information ----------------------------------------");
			System.out.println(String.format("%-10s %-25s %-20s %-30s %-20s", "Lab ID" , "Test Name", "Patient ID", "Description" , "Price"));
			while (resultSet.next()) {
				String result = String.format("%-10s %-25s %-20s %-30s %-20s", resultSet.getInt("id"), resultSet.getString("test_name"), 
						resultSet.getInt("patientId"), resultSet.getString("description"),resultSet.getInt("price"));
				System.out.println(result);
			}
		} catch (SQLException exc) {
			System.out.println("There is an issue in getting all the lab tests !!!");
			System.out.println(exc.getMessage());
		} 	
	}

	@Override
	public void getTestById() {
		Integer testID;
		System.out.print("\nSelect a Laboratory ID: ");
		testID = scanner.nextInt();
		scanner.nextLine();
		String sqlQuery = "SELECT * FROM laboratory WHERE id = '"+ testID +"'";
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
			System.out.println("------------------------------------- Lab Results -------------------------------------");
			System.out.println(String.format("%-10s %-25s %-20s %-30s %-30s", "Lab ID" , "Test Name", "Patient ID", "Description" , "Price"));
			while (resultSet.next()) {
				String result = String.format("%-10s %-25s %-20s %-30s %-30s", resultSet.getInt("id"), resultSet.getString("test_name"), 
						resultSet.getInt("patientId"), resultSet.getString("description"),resultSet.getInt("price"));
				System.out.println(result);
			}
		} catch (SQLException exc) {
			System.out.println("There is an issue in getting the tests!!!");
			System.out.println(exc.getMessage());
		} 
	
	}
}
