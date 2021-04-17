package patientpublisher;

public class Patient {
	private Integer patientId;
	private Integer age;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String address_1;
	private String address_2;
	
	public Patient() {}

	public Patient(Integer age, String firstName, String lastName, String email, String phoneNumber, String address_1, String address_2) {
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address_1 = address_1;
		this.address_2 = address_2;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public Integer getAge() {
		return age;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress_1() {
		return address_1;
	}

	public String getAddress_2() {
		return address_2;
	}
}
