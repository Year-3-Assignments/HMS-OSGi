package reportmanagement;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private ServiceRegistration reportServiceRegister;

	

	public void start(BundleContext context) throws Exception {
		System.out.println("Report Service Started...");
		ReportService service = new ReportServiceImpl();
		reportServiceRegister = context.registerService(ReportService.class.getName(), service, null);
		service.createReport();
		service.getAllReport();
		
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Report Service Stopped !!!");
		reportServiceRegister.unregister();
	}

}
