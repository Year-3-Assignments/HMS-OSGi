package doctorpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private ServiceRegistration doctorServiceRegister;

	public void start(BundleContext context) throws Exception {
		System.out.println("Doctor Service Started...");
		DoctorService service = new DoctorServiceImpl();
		doctorServiceRegister = context.registerService(DoctorService.class.getName(), service, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Doctor Service Stopped !!!");
		doctorServiceRegister.unregister();
	}
}
