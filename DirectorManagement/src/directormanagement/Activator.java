package directormanagement;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import doctorpublisher.DoctorService;
import pharmacymanagement.PharmacyService;

public class Activator implements BundleActivator {
	
	ServiceReference doctorServiceReference;
	ServiceReference pharmacyServiceReference;

	public void start(BundleContext context) throws Exception {
		doctorServiceReference = context.getServiceReference(DoctorService.class.getName());
		pharmacyServiceReference = context.getServiceReference(PharmacyService.class.getName());
		DoctorService doctorService = (DoctorService) context.getService(doctorServiceReference);
		PharmacyService pharmacyService = (PharmacyService) context.getService(pharmacyServiceReference);
		
		doctorService.insertDoctorDetails();
		doctorService.getAllDoctors();
		pharmacyService.insertPharmacyMedicines();
		pharmacyService.getAllMedicineDetails();
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Director service stopped !!!");
		context.ungetService(doctorServiceReference);
		context.ungetService(pharmacyServiceReference);
	}

}
