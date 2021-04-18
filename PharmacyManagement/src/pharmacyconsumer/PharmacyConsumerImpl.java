package pharmacyconsumer;

import java.util.Scanner;

import pharmacymanagement.Pharmacy;
import pharmacymanagement.PharmacyService;
import pharmacymanagement.PharmacyServiceImpl;

public class PharmacyConsumerImpl implements PharmacyConsumer {

	@Override
	public void insertMedicine() {
		
		Scanner scan = new Scanner(System.in);

		String medicinename, unitcost, noOfStock;
			
		System.out.println("=== Add Medicine Information to the Pharmacy Stock ===");
		System.out.print("Enter Medicine name: ");
		medicinename = scan.nextLine();
		System.out.print("Enter Unit Cost: ");
		unitcost = scan.nextLine();
		System.out.print("Enter Number of amount added: ");
		noOfStock = scan.nextLine();

		Pharmacy pharmacy = new Pharmacy(medicinename, unitcost, noOfStock);
		PharmacyService service = new PharmacyServiceImpl();
		service.insertPharmacyMedicines(pharmacy);
			
	}
	
	public void getAllDetails() {
		PharmacyService service = new PharmacyServiceImpl();
		service.getAllMedicineDetails();
	}

	@Override
	public void insertPrescription() {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);

		String patientId, prescribedDate, description;
			
		System.out.println("=== Enter Prescription Information ===");
		System.out.print("Enter Patient id: ");
		patientId = scan.nextLine();
		System.out.print("Enter the date prescription issued: ");
		prescribedDate = scan.nextLine();
		System.out.print("Enter Description: ");
		description = scan.nextLine();

		PharmacyService service = new PharmacyServiceImpl();
		service.insertPharmacyPrescription(patientId, prescribedDate, description);
		
	}

	@Override
	public void getAllPrescriptionDetails() {
		// TODO Auto-generated method stub
		PharmacyService service = new PharmacyServiceImpl();
		service.getAllPrescriptionDetails();
	}

	@Override
	public void getAllPrescriptionDetailsbyId() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		String patientId;
			
		System.out.println("=== Enter Patient Id to get Prescriptions ===");
		System.out.print("Enter Patient id: ");
		patientId = scan.nextLine();
		
		PharmacyService service = new PharmacyServiceImpl();
		service.getAllPrescriptionDetailsbyId(patientId);
	}

}
