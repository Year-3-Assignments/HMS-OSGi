package doctorpublisher;

import java.time.LocalDateTime;

public class ChannelDoctor {
	private Integer id;
	private Integer doctorId;
	private Integer patientId;
	private LocalDateTime time;
	
	public ChannelDoctor(Integer doctorId, Integer patientId) {
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.time = LocalDateTime.now();
	}

	public Integer getId() {
		return id;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public LocalDateTime getTime() {
		return time;
	}
}
