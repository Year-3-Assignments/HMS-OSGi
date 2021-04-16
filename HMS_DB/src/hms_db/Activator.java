package hms_db;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private ServiceRegistration serviceRegistration;

	public void start(BundleContext context) throws Exception {
		System.out.println("HMS DB Publisher service started...");
		Database database = new DatabaseImpl();
		serviceRegistration = context.registerService(Database.class.getName(), database, null);
		database.getDatabaseConnection();
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("HMS DB Publisher service stopped !!!");
		serviceRegistration.unregister();
	}
}
