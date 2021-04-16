package doctorpublisher;

public class Doctor {
	private Integer doctorId;
	private String firstName;
	private String lastName;
	private String speciality;
	private String phoneNumber;
	private boolean available;
	
	public Doctor() {};
	
	public Doctor(Integer doctorId, String firstName, String lastName, String speciality, String phoneNumber, boolean available) {
		this.doctorId = doctorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.speciality = speciality;
		this.phoneNumber = phoneNumber;
		this.available = available;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public Integer getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
}
