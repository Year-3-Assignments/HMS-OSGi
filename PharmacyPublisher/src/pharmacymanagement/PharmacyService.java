package pharmacymanagement;

import java.sql.ResultSet;

import pharmacymanagement.Pharmacy;

public interface PharmacyService {
	public void insertPharmacyMedicines();
	public ResultSet getOpenHours();
	public ResultSet getAllMedicineDetails();
	public void insertPharmacyPrescription();
	public ResultSet getAllPrescriptionDetails();
	public ResultSet getAllPrescriptionDetailsbyId();
}
