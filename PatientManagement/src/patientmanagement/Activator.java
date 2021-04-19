package patientmanagement;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import doctorpublisher.DoctorService;
import patientpublisher.Patient;
import patientpublisher.PatientPublisher;

public class Activator implements BundleActivator {

	private ServiceReference patientManagementReference;
	private ServiceReference doctorPublisherReference;
	
	public void start(BundleContext context) throws Exception {
		patientManagementReference = context.getServiceReference(PatientPublisher.class.getName());
		doctorPublisherReference = context.getServiceReference(DoctorService.class.getName());
		DoctorService doctorService = (DoctorService) context.getService(doctorPublisherReference);
		PatientPublisher service = (PatientPublisher) context.getService(patientManagementReference);
		
		service.insertPatientDetails();
		doctorService.getAvailableDoctors();
		doctorService.channelDoctor();
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Patient Management Service Stopped!!!");
		context.ungetService(patientManagementReference);
	}

}
