package laboratorypublisher;

import java.time.LocalDateTime;

public class Laboratory {
	
	private int id;
	private String testName;
	private int patientId;
	private String description;
	private double price;
	private LocalDateTime time;
	
	public Laboratory(int id, String testName, int patientId, String description, double price, LocalDateTime time) {
		super();
		this.id = id;
		this.testName = testName;
		this.patientId = patientId;
		this.description = description;
		this.price = price;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	
	
	
	

}
