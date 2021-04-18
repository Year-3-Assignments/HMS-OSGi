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
			
		System.out.println("=== Add Medicine Information to the Pharmacy Stock ===");
		
		System.out.print("Enter Medicine name: ");
		medicinename = scan.nextLine();
		
		System.out.print("Enter Unit Cost: ");
		unitcost = scan.nextLine();
		
		System.out.print("Enter Number of amount added: ");
		noOfStock = scan.nextLine();
		
		String sqlQuery = "INSERT INTO medicine_pharmacy(medicineName, unitCost , noOfStock ) "
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
	
	@SuppressWarnings("finally")
	@Override
	public ResultSet getAllMedicineDetails() {
		
		String sqlQuery = "SELECT * FROM medicine_pharmacy";
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
			while(resultSet.next()) {
				System.out.println("Medicine Name: " +resultSet.getString("medicineName"));
				System.out.println("Medicine Unitcost: " +resultSet.getInt("unitCost"));
				System.out.println("Medicine No.of Stock: " +resultSet.getInt("noOfStock"));
				System.out.println("=============  ============");
			}
			
		} catch (SQLException exc) {
			System.out.println("Issue with getting Pharmacy Medicine details !!!");
			System.out.println(exc.getMessage());
		} finally {
			return resultSet;
		}
		
	}

	@SuppressWarnings("finally")
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
				
		System.out.println("=== Enter Prescription Information ===");
		
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
		// TODO Auto-generated method stub
		
		String sqlQuery = "SELECT * FROM prescription_pharmacy";
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
			while(resultSet.next()) {
				System.out.println("Patient Id: " +resultSet.getString("patiendid"));
				System.out.println("Prescribed Date: " +resultSet.getInt("prescribedDate"));
				System.out.println("Description: " +resultSet.getInt("description"));
				System.out.println("=============  ============");
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
		
		System.out.println("=== Enter Patient Id to get Prescriptions ===");
		
		System.out.print("Enter Patient id: ");
		
		patientId = scan.nextLine();
		
		String sqlQuery = "SELECT * FROM prescription_pharmacy Where patiendid ='"+patientId+"'";
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
			while(resultSet.next()) {
				System.out.println("Patient Id: " +resultSet.getString("patiendid"));
				System.out.println("Prescribed Date: " +resultSet.getDate("prescribedDate"));
				System.out.println("Description: " +resultSet.getString("description"));
				System.out.println("=============  ============");
			}
			
		} catch (SQLException exc) {
			System.out.println("Issue with getting Pharmacy Medicine details !!!");
			System.out.println(exc.getMessage());
		} finally {
			return resultSet;
		}	
		
	}
	
}
