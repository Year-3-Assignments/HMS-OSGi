package reportpublisher;

public interface ReportService {
	
	public void createReport();
	public void getAllReport();
	public void searchReport(Integer reportID);
	public void requestReport(Integer reportID);


}
