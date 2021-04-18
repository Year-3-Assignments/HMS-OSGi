package doctorpublisher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import hms_db.Database;
import hms_db.DatabaseImpl;
import patientpublisher.PatientPublisher;
import patientpublisher.PatientPublisherImpl;

public class DoctorServiceImpl implements DoctorService {
	private Connection connection = null;
	private Statement statement = null;
	private Database database;
	private ResultSet resultSet;
	private Scanner scan;
	
	public DoctorServiceImpl() {
		database = new DatabaseImpl();
		connection = database.getDatabaseConnection();
		scan = new Scanner(System.in);
	}

	@Override
	public void getAvailableDoctors() {
		String sqlQuery = "SELECT * FROM doctors WHERE availability = 1";
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
			
			// Display available doctor information to the console
			System.out.println("\n---------------------------Available Doctors--------------------------");
			System.out.println(String.format("%-10s %-25s %-20s %-20s", "Doctor ID", "Name", "Specialization", "Phone Number"));
			while (resultSet.next()) {
				String result = String.format("%-10s %-25s %-20s %-20s", resultSet.getInt("id"), "Dr. " + resultSet.getString("first_name") + 
						" " + resultSet.getString("last_name"), resultSet.getString("specialization"), resultSet.getString("phone_number"));
				System.out.println(result);
			}
			
		} catch (SQLException exc) {
			System.out.println("Issue with getting available doctor details !!!");
			System.out.println(exc.getMessage());
		} 
	}

	@Override
	public ResultSet getAllDoctors() {
		String sqlQuery = "SELECT * FROM doctors";
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
		} catch (SQLException exc) {
			System.out.println("Issue with getting doctor details !!!");
			System.out.println(exc.getMessage());
		} finally {
			return resultSet;
		}
	}

	@Override
	public ResultSet searchDoctorDetails(Integer doctorId) {
		String sqlQuery = "SELECT * FROM doctors WHERE id = '"+ doctorId +"'";
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
		} catch (SQLException exc) {
			System.out.println("Issue with getting doctor details !!!");
			System.out.println(exc.getMessage());
		} finally {
			return resultSet;
		}
	}

	@Override
	public void channelDoctor() {
		Integer channelling, doctorId, patientId;
		String patientName;
		System.out.print("\nDo you want to channel a doctor(1 = Yes, 0 = No): ");
		channelling = scan.nextInt();
		scan.nextLine();
		
		if (channelling.equals(1)) {
			System.out.print("Enter your first name: ");
			patientName = scan.nextLine();
			System.out.print("Select doctor ID: ");
			doctorId = scan.nextInt();
			scan.nextLine();
			
			try {
				PatientPublisher patient = new PatientPublisherImpl();
				// Fetch patient information
				ResultSet patientDetails = patient.getPatientByName(patientName);
				// Fetch doctor information
				ResultSet doctorDetails = this.searchDoctorDetails(doctorId);
				// Create channel doctor object
				
				while(patientDetails.next() && doctorDetails.next()) {
					patientId = patientDetails.getInt("id");
					doctorId = doctorDetails.getInt("id");
					
					ChannelDoctor channelDoctor = new ChannelDoctor(doctorId, patientId);
					// Insert channeling details to database
					String sqlQuery = "INSERT INTO channel_doctors(doctor_id, patient_id, time) VALUES('"+ channelDoctor.getDoctorId() +"', "
							+ "'"+ channelDoctor.getPatientId() +"', '"+ channelDoctor.getTime() +"')";
					
					String updateQuery = "UPDATE doctors SET availability = 0 WHERE id = '"+ doctorId +"'"; 
					
					statement = connection.createStatement();
					statement.executeUpdate(sqlQuery);
					statement.executeUpdate(updateQuery);
				}
				System.out.println("Your channel details successfully stored...");
			} catch (SQLException exc) {
				System.out.println("Issue with channelling !!!");
				System.out.println(exc.getMessage());
			}
		}
	}

	@Override
	public void insertDoctorDetails(Doctor doctor) {
		String sqlQuery = "INSERT INTO doctors(first_name, last_name, phone_number, specialization, availability) "
				+ "VALUES('"+ doctor.getFirstName() +"', '"+ doctor.getLastName() +"', '"+ doctor.getPhoneNumber() +"', "
						+ "'"+ doctor.getSpeciality() +"', '"+ doctor.getAvailability() + "')";
		
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sqlQuery);
			System.out.println("Doctor details successfully inserted ...");
		} catch (SQLException exc) {
			System.out.println("Issue with inserting doctor details !!!");
			System.out.println(exc.getMessage());
		}
	}

	@Override
	public void getAssignPatients() {
		Integer doctorId;
		
		System.out.print("Enter your doctor ID: ");
		doctorId = scan.nextInt();
		
		String sqlQuery = "SELECT p.id, p.first_name, p.last_name, p.email, p.phone_number, p.address_1, p.address_2 "
				+ "FROM doctors d, channel_doctors cd, patients p WHERE cd.doctor_id=d.id AND cd.patient_id=p.id "
				+ "AND cd.doctor_id = '"+ doctorId +"'";
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
			
			System.out.println("\n-----------------------------------------Assigned Patients---------------------------------------");
			System.out.println(String.format("%-10s %-25s %-20s %-20s %-20s", "Patient ID", "Name", "Email", "Phone Number", "Address"));
			
			while (resultSet.next()) {
				String result = String.format("%-10s %-25s %-20s %-20s %-20s", resultSet.getInt("id"), resultSet.getString("first_name") + " " + resultSet.getString("last_name")
						, resultSet.getString("email"), resultSet.getString("phone_number"), resultSet.getString("address_1") + ", " + resultSet.getString("address_2"));
				System.out.println(result);
			}
			
		} catch (SQLException exc) {
			System.out.println("Issue with getting assigned patients detail !!!");
			System.out.println(exc.getMessage());
		}
	}
}
