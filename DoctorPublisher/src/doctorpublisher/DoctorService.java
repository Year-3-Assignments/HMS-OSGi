package doctorpublisher;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface DoctorService {
	public void insertDoctorDetails();
	public void getAvailableDoctors();
	public void getAllDoctors();
	public ResultSet searchDoctorDetails(Integer doctorId);
	public void channelDoctor();
	public void getAssignPatients();
}
