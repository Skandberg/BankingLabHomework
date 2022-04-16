package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Cell;

public class CellsDBController implements DBController {
	private DataConverter converter=new DataConverter();
	@Override
	public void AddToDB(Object o, String URL) {
		try {
			
			Cell cell = (Cell) o;
			String items =converter.ConvertCellsItemsToText(cell);
			Connection connection = DriverManager.getConnection(URL);
			String query = "CREATE TABLE IF NOT EXISTS Cells (CellNumber int, Items text);";
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate(query);
			query = "INSERT INTO Cells (CellNumber, Items) VALUES ("+cell.GetCellNumber()
			+ ", "+"'"+items+"'"+ ");";
			result = statement.executeUpdate(query);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void RemoveFromDB(String removal_criterion, String URL) {
		try {
			Connection connection = DriverManager.getConnection(URL);
			String query = "DELETE FROM Cells WHERE ID = " + Integer.parseInt(removal_criterion) +";";
			Statement statement = connection.createStatement();
			statement.executeQuery(query);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	@Override
	public void ShowTable(String URL) {
		try {
			
			Connection connection = DriverManager.getConnection(URL);
			String query = "Select * FROM Cells;";
			Statement statement = connection.createStatement();
			statement.executeQuery(query);
			ResultSet result = statement.executeQuery(query);
			while (result.next()) {
				System.out.println(result.getInt("CellNumber") + "|" 
			+ result.getString("Items"));
			}
		}catch (SQLException e){
			e.printStackTrace();			
		}
		
	}
	public Cell GetCellFromDB(int cell_number, String URL) {
		try {
			Connection connection = DriverManager.getConnection(URL);
			String query = "Select * FROM Cells WHERE CellNumber = "+Integer.toString(cell_number)+";";
			Statement statement = connection.createStatement();
			statement.executeQuery(query);
			ResultSet result = statement.executeQuery(query);
			//ArrayList<String> items = new ArrayList<String>();
				//	converter.ConvertTextToCellsItems(result.getString("Items"));
			Cell cell = new Cell(result.getInt(cell_number));
			for (int i=0;i<converter.ConvertTextToCellsItems(result.getString("Items")).size();i++)
				cell.AddItems(converter.ConvertTextToCellsItems(result.getString("Items")).get(i));
			return cell;
		}catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}

}
