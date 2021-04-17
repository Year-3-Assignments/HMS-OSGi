package pharmacymanagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import hms_db.Database;
import hms_db.DatabaseImpl;

public class PharmacyServiceImpl implements PharmacyService {
	private Connection connection = null;
	private Statement statement = null;
	private Database database;
	private ResultSet resultSet;
	
	public PharmacyServiceImpl() {
		database = new DatabaseImpl();
		connection = database.getDatabaseConnection();
	}

	@Override
	public void insertPharmacyMedicines(Pharmacy pharmacy) {
		// TODO Auto-generated method stub
		String sqlQuery = "INSERT INTO medicine_pharmacy(medicineName, unitCost , noOfStock ) "
				+ "VALUES('"+ pharmacy.getMedicineName() +"', '"+ 
				pharmacy.getUnitCost() + "', '"+ 
				pharmacy.getNoOfStock() + "')";
		
		try 
		{
			statement = connection.createStatement();
			statement.executeUpdate(sqlQuery);
			System.out.println("Pharmacy Medicine details successfully inserted ...");
		} catch (SQLException exc) {
			System.out.println("Issue with inserting Pharmacy Medicine details !!!");
			System.out.println(exc.getMessage());
		}
		
	}
	
	@SuppressWarnings("finally")
	@Override
	public ResultSet getAllMedicineDetails() {
		
		String sqlQuery = "SELECT * FROM medicine_pharmacy";
		
		try {
			
			String medicineName, unitCost, noOfStock;
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
			
			while(resultSet.next()) {

				System.out.println("Medicine Name: " +resultSet.getString("medicineName"));
				System.out.println("Medicine Unitcost: " +resultSet.getInt("unitCost"));
				System.out.println("Medicine No.of Stock: " +resultSet.getInt("noOfStock"));
				System.out.println("=============  ============");

			}
			
		} catch (SQLException exc) {
			System.out.println("Issue with getting Pharmacy Medicine details !!!");
			System.out.println(exc.getMessage());
		} finally {
			return resultSet;
		}
		
	}

	@SuppressWarnings("finally")
	@Override
	public ResultSet getOpenHours() {
		// TODO Auto-generated method stub
		
		String sqlQuery = "SELECT openHours FROM pharmacy";
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
		} catch (SQLException exc) {
			System.out.println("Issue with getting Pharmacy Medicine details !!!");
			System.out.println(exc.getMessage());
		} finally {
			return resultSet;
		}
	
	}

	@Override
	public ResultSet sendPrescription() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
