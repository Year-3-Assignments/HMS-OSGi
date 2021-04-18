package pharmacyconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	
	private ServiceRegistration directorService;

	public void start(BundleContext context) {
		try {
			System.out.println("Pharmacy Management service client started...");
			PharmacyConsumer service = new PharmacyConsumerImpl();
			directorService = context.registerService(PharmacyConsumer.class.getName(), service, null);
			
			Scanner scan = new Scanner(System.in);
			String option = "1";

			do{
				
				System.out.println("=== Pharmacy Management System ===");
				
				System.out.println("1. Insert medicine details");
				System.out.println("2. Get all medicine details");
				System.out.println("3. Insert Prescription details");
				System.out.println("4. Get all Prescription details");
				System.out.println("5. Get Prescription details by Patient Id");

				System.out.print("Enter your choice: ");
				option = scan.nextLine();
				
				if(Integer.parseInt(option) == 1) {
					service.insertMedicine();
				}else if (Integer.parseInt(option) == 2) {
					service.getAllDetails();
				}else if (Integer.parseInt(option) == 3) {
					service.insertPrescription();
				}else if (Integer.parseInt(option) == 4) {
					service.getAllPrescriptionDetails();
				}else if (Integer.parseInt(option) == 5) {
					service.getAllPrescriptionDetailsbyId();
				}
				
			}while(Integer.parseInt(option) != 0);	
			
		} catch (Exception exc) {
			System.out.println(exc.getMessage());
		}
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Pharmacy Management service client stopped !!!");
		directorService.unregister();
	}

}