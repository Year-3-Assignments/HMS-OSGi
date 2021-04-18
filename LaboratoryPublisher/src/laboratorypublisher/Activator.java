package laboratorypublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;



public class Activator implements BundleActivator {

	private ServiceRegistration labServiceRegister;


	public void start(BundleContext context) throws Exception {
		System.out.println("Report Service Started...");
		LaboratoryService service = new LaboratoryServiceImpl();
		labServiceRegister = context.registerService(LaboratoryService.class.getName(), service, null);
	}
	

	public void stop(BundleContext context) throws Exception {
		System.out.println("Laboratory Service Stopped !!!");
		labServiceRegister.unregister();
	}

}
