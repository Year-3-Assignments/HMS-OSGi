package reportmanagement;
import java.sql.ResultSet;

public interface ReportService {
	
	public void createReport();
	public ResultSet getAllReport();
	public ResultSet searchReport(Integer reportID);
	public void requestReport(Integer reportID);


}
