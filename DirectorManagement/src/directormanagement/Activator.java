package directormanagement;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	
	ServiceRegistration directorService;

	public void start(BundleContext context) {
		try {
			System.out.println("Director service started...");
			HospitalManagement service = new HospitalManagementImpl();
			directorService = context.registerService(HospitalManagement.class.getName(), service, null);
			service.registerDoctor();
		} catch (Exception exc) {
			System.out.println(exc.getMessage());
		}
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Director service stopped !!!");
		directorService.unregister();
	}

}
