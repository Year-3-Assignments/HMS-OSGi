package pharmacymanagement;

import java.sql.ResultSet;

import pharmacymanagement.Pharmacy;

public interface PharmacyService {
	public void insertPharmacyMedicines(Pharmacy pharmacy);
	public ResultSet getOpenHours();
	public ResultSet sendPrescription();
	public ResultSet getAllMedicineDetails();
}
