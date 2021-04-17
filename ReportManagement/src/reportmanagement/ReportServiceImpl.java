package reportmanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class ReportServiceImpl implements ReportService {
	
	private ArrayList<Report> reports = new ArrayList<>();
	private ArrayList<Report> reportRequest = new ArrayList<>();

	Integer reportType;
	
	@Override
	public void createReport() {
		// TODO Auto-generated method stub
		Integer reportID;
		String patientName,doctorName;
		
		String description;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("==== Create a report ====");
		System.out.print("Enter Report ID - ");
		reportID = scan.nextInt();
		scan.nextLine();
		System.out.print("Enter Patient Name- ");
		patientName = scan.nextLine();
		System.out.println("1 - Doctors' prescription");
		System.out.println("2 - Pharmacy prescription");
		System.out.println("3 - Clinical Report");
		System.out.println("4 - Medical Report");
		System.out.println("5 - Other");
		System.out.println("Select Report Type - ");
		reportType = scan.nextInt();
		
		switch(reportType) {
			case 3:
				System.out.println(" Doctors' prescription");
				break;
			case 2:
				System.out.println("Pharmacy prescription");
				break;
			case 1:
				System.out.println("Clinical Report");
				break;	
			case 0:
				System.out.println(" Medical Report ");
				break;		
			default:
				System.out.println("Other");
				break;
					
		}
		
		System.out.print("Enter Doctor Name - ");
		doctorName = scan.nextLine();
		
		System.out.print("Description - ");
		description = scan.nextLine();
		
		Report report = new Report(reportID, patientName, doctorName, description, reportType);
		reports.add(report);
		
	}

	@Override
	public void getAllReport() {
		// TODO Auto-generated method stub
		System.out.println("==== Reports ====");
		for (Report report: reports) {
			System.out.println("Report ID - " + report.getReportID());
			System.out.println("Doctor Name - Dr." + report.getDoctorName());
			System.out.println("Patient Name - " + report.getPatientName());
			System.out.println("Description - " + report.getDescription());
		}
	}

	@Override
	public void searchReport(Integer reportID) {
		// TODO Auto-generated method stub
		for (Report report: reports) {
			if (report.getReportID().equals(reportID)) {
				System.out.println("Report ID - " + report.getReportID());
				System.out.println("Patient Name" + report.getPatientName() );
				System.out.println("Doctor Name - Dr. " + report.getDoctorName());
				System.out.println("Report Type - " + report.getReportType());
				System.out.println("Description - "+report.getDescription());
			}
		}
	}

	@Override
	public void requestReport(Integer reportID) {
		// TODO Auto-generated method stub
		for (Report report: reports) {
			if(report.getReportID().equals(reportID)) {
				report.setReportType(reportType);
				reportRequest.add(report);
			}
		}
	}
	
	

	
}
