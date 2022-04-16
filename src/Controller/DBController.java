package Controller;

public interface DBController {

	public void AddToDB(Object o, String URL);
	public void RemoveFromDB(String removal_criterion, String URL);
	public void ShowTable(String URL);
}
