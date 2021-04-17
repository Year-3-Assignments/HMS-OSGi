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
			
		System.out.println("=== Add Medicine Imformation ===");
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

}
