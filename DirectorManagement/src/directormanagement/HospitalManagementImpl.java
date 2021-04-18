package directormanagement;

import java.util.Scanner;

import doctorpublisher.Doctor;
import doctorpublisher.DoctorService;
import doctorpublisher.DoctorServiceImpl;

public class HospitalManagementImpl implements HospitalManagement {
	private Scanner scan = new Scanner(System.in);

	@Override
	public void registerDoctor() {
		Integer available;
		String firstName, lastName, speciality, phoneNumber;
		
		System.out.println("=== Add Doctor Imformation ===");
		System.out.print("Enter first name: ");
		firstName = scan.nextLine();
		System.out.print("Enter last name (Optional): ");
		lastName = scan.nextLine();
		System.out.print("Enter speciality: ");
		speciality = scan.nextLine();
		System.out.print("Enter phone number: ");
		phoneNumber = scan.nextLine();
		System.out.print("Enter availability (1 = Yes, 0 = No): ");
		available = scan.nextInt();
		
		Doctor doctor = new Doctor(firstName, lastName, speciality, phoneNumber, available);
		DoctorService service = new DoctorServiceImpl();
		service.insertDoctorDetails(doctor);
	}

}
