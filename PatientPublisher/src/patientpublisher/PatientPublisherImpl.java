package patientpublisher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import hms_db.Database;
import hms_db.DatabaseImpl;

public class PatientPublisherImpl implements PatientPublisher {
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private Database database;
	private Scanner scan;
	
	public PatientPublisherImpl() {
		database = new DatabaseImpl();
		connection = database.getDatabaseConnection();
		scan = new Scanner(System.in);
	}

	@Override
	public void insertPatientDetails() {
		Integer age;
		String firstName, lastName, email, phoneNumber, address_1, address_2;
		
		System.out.println("=== Create new Patient Account ===");
		System.out.print("Enter first name: ");
		firstName = scan.nextLine();
		System.out.print("Enter last name: ");
		lastName = scan.nextLine();
		System.out.print("Enter age: ");
		age = scan.nextInt();
		scan.nextLine();
		System.out.print("Enter email address: ");
		email = scan.nextLine();
		System.out.print("Enter phone number: ");
		phoneNumber = scan.nextLine();
		System.out.print("Enter address 1: ");
		address_1 = scan.nextLine();
		System.out.print("Enter address 2: ");
		address_2 = scan.nextLine();
		
		Patient patient = new Patient(age, firstName, lastName, email, phoneNumber, address_1, address_2);
		
		String sqlQuery = "INSERT INTO patients(first_name, last_name, age, email, phone_number, address_1, address_2) "
				+ "VALUES('"+ patient.getFirstName() +"', '"+ patient.getLastName() +"', '"+ patient.getAge() +"', '"+ patient.getEmail() +"', "
						+ "'"+ patient.getPhoneNumber() +"', '"+ patient.getAddress_1() +"', '"+ patient.getAddress_2() +"')";
		
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sqlQuery);
			System.out.println("Patient details are sucssessfully inserted...");
		} catch (SQLException exc) {
			System.out.println("Issue with inserting patient details !!!");
			System.out.println(exc.getMessage());
		}
	}

	@Override
	public ResultSet getAllPatientDetails() {
		String sqlQuery = "SELECT * FROM patients";
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
		} catch (SQLException exc) {
			System.out.println("Issue with getting patients detail !!!");
			System.out.println(exc.getMessage());
		} finally {
			return resultSet;
		}
	}

	@Override
	public ResultSet getPatientByName(String name) {
		String sqlQuery = "SELECT * FROM patients WHERE first_name LIKE '"+ name +"%" + "'";
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
		} catch (SQLException exc) {
			System.out.println("Issue with getting patient details !!!");
			System.out.println(exc.getMessage());
		} finally {
			return resultSet;
		}
	}

}
