package doctormanagement;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import doctorpublisher.DoctorService;

public class Activator implements BundleActivator {

	private ServiceReference doctorServiceReference;
	
	public void start(BundleContext context) throws Exception {
		doctorServiceReference = context.getServiceReference(DoctorService.class.getName());
		DoctorService doctorService = (DoctorService) context.getService(doctorServiceReference);
		doctorService.getAssignPatients();
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Doctor Management Service Stopped!!!");
		context.ungetService(doctorServiceReference);
	}

}
