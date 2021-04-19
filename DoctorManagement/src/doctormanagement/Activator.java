package doctormanagement;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import reportmanagement.ReportService;
import doctorpublisher.DoctorService;
import laboratorypublisher.LaboratoryService;

public class Activator implements BundleActivator {

	private ServiceReference doctorServiceReference;
	private ServiceReference reportServiceReference;
	private ServiceReference laboratoryServiceReference;
	
	public void start(BundleContext context) throws Exception {
		reportServiceReference = context.getServiceReference(ReportService.class.getName());
		doctorServiceReference = context.getServiceReference(DoctorService.class.getName());
		laboratoryServiceReference = context.getServiceReference(LaboratoryService.class.getName());
		DoctorService doctorService = (DoctorService) context.getService(doctorServiceReference);
		ReportService reportService = (ReportService) context.getService(reportServiceReference);
		LaboratoryService laboratoryService = (LaboratoryService) context.getService(laboratoryServiceReference);
		
		doctorService.getAssignPatients();
		reportService.createReport();
		reportService.getAllReport();
		reportService.searchReport();
		laboratoryService.createTest();
		laboratoryService.getAllTests();
		laboratoryService.getTestById();
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Doctor Management Service Stopped!!!");
		context.ungetService(doctorServiceReference);
		context.ungetService(reportServiceReference);
	}

}
