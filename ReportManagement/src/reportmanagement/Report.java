package reportmanagement;

public class Report {
	private Integer reportID;
	private String patientName;
	private String doctorName;
	private String description;
	private Integer reportType;
	
	
	public Report(Integer reportID, String patientName, String doctorName, String description, Integer reportType) {
		super();
		this.reportID = reportID;
		this.patientName = patientName;
		this.doctorName = doctorName;
		this.description = description;
		this.reportType = reportType;
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
	public Integer getReportType() {
		return reportType;
	}
	public void setReportType(Integer reportType) {
		this.reportType = reportType;
	}
	
	
	
	

}
