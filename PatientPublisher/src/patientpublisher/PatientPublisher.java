package patientpublisher;

import java.sql.ResultSet;

public interface PatientPublisher {
	public void insertPatientDetails();
	public ResultSet getAllPatientDetails();
	public ResultSet getPatientById(Integer id);
}
