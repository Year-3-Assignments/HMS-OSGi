package doctorpublisher;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface DoctorService {
	public void insertDoctorDetails(Doctor doctor);
	public void getAvailableDoctors();
	public ResultSet getAllDoctors();
	public ResultSet searchDoctorDetails(Integer doctorId);
	public void channelDoctor();
}
