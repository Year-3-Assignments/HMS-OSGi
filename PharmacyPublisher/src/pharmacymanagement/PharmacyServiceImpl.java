package pharmacymanagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import hms_db.Database;
import hms_db.DatabaseImpl;

public class PharmacyServiceImpl implements PharmacyService {
	private Connection connection = null;
	private Statement statement = null;
	private Database database;
	private ResultSet resultSet;
	private Scanner scan;

	public PharmacyServiceImpl() {
		database = new DatabaseImpl();
		connection = database.getDatabaseConnection();
		this.scan = new Scanner(System.in);
	}

	@Override
	public void insertPharmacyMedicines() {

		String medicinename, unitcost, noOfStock;
			
		System.out.println("\n----------- Add Medicine Information to the Pharmacy Stock ------------");
		
		System.out.print("\nEnter Medicine name: ");
		medicinename = scan.nextLine();
		
		System.out.print("Enter Unit Cost: ");
		unitcost = scan.nextLine();
		
		System.out.print("Enter Number of amount added: ");
		noOfStock = scan.nextLine();
		
		String sqlQuery = "INSERT INTO medicine_pharmacy(medicineName, unitCost, noOfStock) "
				+ "VALUES('"+ medicinename +"', '"+ 
				unitcost + "', '"+ 
				noOfStock + "')";
		
		try 
		{
			statement = connection.createStatement();
			statement.executeUpdate(sqlQuery);
			System.out.println("Pharmacy Medicine details successfully inserted ...");
		} catch (SQLException exc) {
			System.out.println("Issue with inserting Pharmacy Medicine details !!!");
			System.out.println(exc.getMessage());
		}
	}
	
	@Override
	public ResultSet getAllMedicineDetails() {
		
		String sqlQuery = "SELECT * FROM medicine_pharmacy";

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
			System.out.println("\n----------------------Pharmacy Medicine Information----------------------");
			System.out.println(String.format("%-15s %-25s %-20s %-20s", "Medicine ID", "Type", "Number of Units", "Unit Price"));
			while(resultSet.next()) {
				String result = String.format("%-15s %-25s %-20s %-20s", resultSet.getInt("id"), resultSet.getString("medicineName"), 
						resultSet.getString("noOfStock"), "Rs." + resultSet.getString("unitCost")+ ".00");
				System.out.println(result);
			}
			
		} catch (SQLException exc) {
			System.out.println("Issue with getting Pharmacy Medicine details !!!");
			System.out.println(exc.getMessage());
		} finally {
			return resultSet;
		}
		
	}

	@Override
	public ResultSet getOpenHours() {
		
		String sqlQuery = "SELECT openHours FROM pharmacy";
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
		} catch (SQLException exc) {
			System.out.println("Issue with getting Pharmacy Medicine details !!!");
			System.out.println(exc.getMessage());
		} finally {
			return resultSet;
		}
	
	}

	@Override
	public void insertPharmacyPrescription() {
		
		String patientid, prescribedDate, description;
				
		System.out.println("\n----- Enter Prescription Information -----");
		
		System.out.print("Enter Patient id: ");
		patientid = scan.nextLine();
		System.out.print("Enter the date prescription issued: ");
		prescribedDate = scan.nextLine();
		System.out.print("Enter Description: ");
		description = scan.nextLine();


		String sqlQuery = "INSERT INTO prescription_pharmacy(patiendid, prescribedDate, description) "
				+ "VALUES('"+ patientid +"', '"+ 
				prescribedDate + "', '"+ 
				description + "')";
		try 
		{
			statement = connection.createStatement();
			statement.executeUpdate(sqlQuery);
			System.out.println("Pharmacy Prescription details successfully inserted ...");
		} catch (SQLException exc) {
			System.out.println("Issue with inserting Pharmacy Prescription details !!!");
			System.out.println(exc.getMessage());
		}
	}

	@Override
	public ResultSet getAllPrescriptionDetails() {	
		String sqlQuery = "SELECT * FROM prescription_pharmacy";
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
			// Display the results
			System.out.println(String.format("%-15s %-25s %-20s", "Patient ID", "Description", "Created Date"));
			while(resultSet.next()) {
				String result = String.format("%-15s %-25s %-20s", resultSet.getInt("patiendid"), resultSet.getString("description"), 
						resultSet.getString("prescribedDate"));
				System.out.println(result);
			}
			
		} catch (SQLException exc) {
			System.out.println("Issue with getting Pharmacy Medicine details !!!");
			System.out.println(exc.getMessage());
		} finally {
			return resultSet;
		}
	}

	@Override
	public ResultSet getAllPrescriptionDetailsbyId() {
		String patientId;
		System.out.print("\nEnter Patient ID: ");
		patientId = scan.nextLine();
		
		String sqlQuery = "SELECT * FROM prescription_pharmacy Where patiendid ='"+patientId+"'";
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
			// Display the results
			System.out.println(String.format("%-15s %-25s %-20s", "Patient ID", "Description", "Created Date"));
			while(resultSet.next()) {
				String result = String.format("%-15s %-25s %-20s", resultSet.getInt("patiendid"), resultSet.getString("description"), 
						resultSet.getString("prescribedDate"));
				System.out.println(result);
			}
			
		} catch (SQLException exc) {
			System.out.println("Issue with getting Pharmacy Medicine details !!!");
			System.out.println(exc.getMessage());
		} finally {
			return resultSet;
		}	
		
	}
	
}
