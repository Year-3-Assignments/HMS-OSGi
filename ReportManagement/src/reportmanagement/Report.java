package reportmanagement;

public class Report {
	private Integer reportID;
	private String patientName;
	private String doctorName;
	private String description;
	
	
	public Report() {}
	
	public Report(String patientName, String doctorName, String description) {
		this.patientName = patientName;
		this.doctorName = doctorName;
		this.description = description;
	}
	public Report(Integer reportID, String patientName, String doctorName, String description) {
		super();
		this.reportID = reportID;
		this.patientName = patientName;
		this.doctorName = doctorName;
		this.description = description;
		
	}
	public Integer getReportID() {
		return reportID;
	}
	public void setReportID(Integer reportID) {
		this.reportID = reportID;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
