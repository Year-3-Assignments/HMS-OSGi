package patientpublisher;

import java.sql.ResultSet;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	
	private ServiceRegistration patientPublisherRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println("Patient Publisher Service Started...");
		PatientPublisher patientPublisherService = new PatientPublisherImpl();
		patientPublisherRegistration = context.registerService(PatientPublisher.class.getName(), patientPublisherService, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Patient Publisher Service Stopped !!!");
		patientPublisherRegistration.unregister();
	}

}
