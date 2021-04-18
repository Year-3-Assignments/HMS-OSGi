package patientpublisher;

import java.sql.ResultSet;

public interface PatientPublisher {
	public void insertPatientDetails(Patient patient);
	public ResultSet getAllPatientDetails();
	public ResultSet getPatientByName(String name);
}
