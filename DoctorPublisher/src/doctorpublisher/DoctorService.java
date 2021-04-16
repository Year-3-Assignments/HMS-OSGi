package doctorpublisher;

import java.util.ArrayList;

public interface DoctorService {
	public void createDoctor();
	public void getAvailableDoctors();
	public void getAllDoctors();
	public void searchDoctorDetails(Integer doctorId);
	public void channelDoctor(Integer doctorId);
}
