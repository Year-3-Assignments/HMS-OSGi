package pharmacymanagement;

import java.sql.ResultSet;

import pharmacymanagement.Pharmacy;

public interface PharmacyService {
	public void insertPharmacyMedicines(Pharmacy pharmacy);
	public ResultSet getOpenHours();
	public ResultSet getAllMedicineDetails();
	public void insertPharmacyPrescription(String patientid, String prescribedDate, String description);
	public ResultSet getAllPrescriptionDetails();
	public ResultSet getAllPrescriptionDetailsbyId(String patientId);
}
