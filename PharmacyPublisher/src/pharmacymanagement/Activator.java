package pharmacymanagement;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import pharmacymanagement.PharmacyService;
import pharmacymanagement.PharmacyServiceImpl;

public class Activator implements BundleActivator {

	private ServiceRegistration pharamacyServiceRegister;

	public void start(BundleContext context) throws Exception {
		System.out.println("Pharmacy Management Service Started...");
		PharmacyService service = new PharmacyServiceImpl();
		pharamacyServiceRegister = context.registerService(PharmacyService.class.getName(), service, null);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Pharmacy Management Service Stopped !!!");
		pharamacyServiceRegister.unregister();
	}
}
