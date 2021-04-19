package pharmacyconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import pharmacymanagement.PharmacyService;

public class Activator implements BundleActivator {
	
	private ServiceReference directorService;

	public void start(BundleContext context) throws Exception {

			System.out.println("Pharmacy Management service started...");
			directorService = context.getServiceReference(PharmacyService.class.getName());
			
			PharmacyService service = (PharmacyService) context.getService(directorService); 

			Scanner scan = new Scanner(System.in);
			
			String option = "1";

			do{
				System.out.println("\n-------- Pharmacy Management System --------");
				System.out.println("1. Insert Prescription details");
				System.out.println("2. Get all Prescription details");
				System.out.println("3. Get Prescription details by Patient Id");

				System.out.print("Enter your choice: ");
				option = scan.nextLine();
				
				if (Integer.parseInt(option) == 1) {
					service.insertPharmacyPrescription();
				}else if (Integer.parseInt(option) == 2) {
					service.getAllPrescriptionDetails();
				}else if (Integer.parseInt(option) == 3) {
					service.getAllPrescriptionDetailsbyId();
				}
			}while(Integer.parseInt(option) != 0);	
			
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Pharmacy Management service stopped !!!");
		context.ungetService(directorService);
	}

}