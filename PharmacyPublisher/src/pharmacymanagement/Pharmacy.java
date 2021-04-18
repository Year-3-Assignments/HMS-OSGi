package pharmacymanagement;

public class Pharmacy {
	
	private Integer medicineId;
	private String medicineName;
	private String unitCost;
	private String noOfStock;
	
	public Pharmacy(String medicineName, String unitCost, String noOfStock) {
		this.medicineName = medicineName;
		this.unitCost = unitCost;
		this.noOfStock = noOfStock;
	}
	
	public Integer getMedicineId() {
		return medicineId;
	}
	
	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}
	
	public String getMedicineName() {
		return medicineName;
	}
	
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	
	public String getUnitCost() {
		return unitCost;
	}
	
	public void setUnitCost(String unitCost) {
		this.unitCost = unitCost;
	}
	
	public String getNoOfStock() {
		return noOfStock;
	}
	
	public void setNoOfStock(String noOfStock) {
		this.noOfStock = noOfStock;
	}
	
}
