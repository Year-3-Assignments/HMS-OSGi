package doctorpublisher;

import java.util.ArrayList;
import java.util.Scanner;

public class DoctorServiceImpl implements DoctorService {
	private ArrayList<Doctor> doctors = new ArrayList<>();
	private ArrayList<Doctor> channeledDoctors = new ArrayList<>();

	@Override
	public void getAvailableDoctors() {
		System.out.println("==== Available Doctors ====");
		for (Doctor doctor: doctors) {
			if (doctor.isAvailable()) {
				System.out.println("Doctor ID - " + doctor.getDoctorId());
				System.out.println("Doctor Name - Dr." + doctor.getFirstName() + " " + doctor.getLastName());
				System.out.println("Phone Number - " + doctor.getPhoneNumber());
			}
		}
	}

	@Override
	public void getAllDoctors() {
		System.out.println("==== Doctor List ====");
		for (Doctor doctor: doctors) {
			System.out.println("Doctor ID - " + doctor.getDoctorId());
			System.out.println("Doctor Name - Dr." + doctor.getFirstName() + " " + doctor.getLastName());
			System.out.println("Phone Number - " + doctor.getPhoneNumber());
		}
	}

	@Override
	public void searchDoctorDetails(Integer doctorId) {
		for (Doctor doctor: doctors) {
			if (doctor.getDoctorId().equals(doctorId)) {
				System.out.println("Doctor ID - " + doctor.getDoctorId());
				System.out.println("Doctor Name - Dr." + doctor.getFirstName() + " " + doctor.getLastName());
				System.out.println("Phone Number - " + doctor.getPhoneNumber());
				System.out.println("Availability - " + doctor.isAvailable());
			}
		}
	}

	@Override
	public void channelDoctor(Integer doctorId) {
		for (Doctor doctor: doctors) {
			if(doctor.getDoctorId().equals(doctorId)) {
				doctor.setAvailable(false);
				channeledDoctors.add(doctor);
			}
		}
	}

	@Override
	public void createDoctor() {
		Integer ID, availability;
		String firstName, lastName, phoneNumber, specialization;
		boolean available;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("==== Add a New Doctor ====");
		System.out.print("Enter Doctor ID - ");
		ID = scan.nextInt();
		scan.nextLine();
		System.out.print("Enter first name - ");
		firstName = scan.nextLine();
		System.out.print("Enter last name - ");
		lastName = scan.nextLine();
		System.out.println("Enter Specialization - ");
		specialization = scan.nextLine();
		System.out.print("Enter phone number - ");
		phoneNumber = scan.nextLine();
		System.out.print("Enter availability (1 = Yes, 0 = No) - ");
		availability = scan.nextInt();
		
		switch (availability) {
			case 1:
				available = true;
				break;
			case 0:
				available = false;
				break;
			default:
				available = false;
				break;
		}
		
		Doctor doctor = new Doctor(ID, firstName, lastName, specialization, phoneNumber, available);
		doctors.add(doctor);
	}

}
