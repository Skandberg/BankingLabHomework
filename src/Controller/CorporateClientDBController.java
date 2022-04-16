package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.CorporateClient;


public class CorporateClientDBController implements DBController {
	private DataConverter converter=new DataConverter();
	@Override
	public void AddToDB(Object o, String URL) {
		try {
			
			CorporateClient client = (CorporateClient) o;
			String cells =converter.ConvertCellsNumbersToText(client.GetCells());
			Connection connection = DriverManager.getConnection(URL);
			String query1 = "CREATE TABLE IF NOT EXISTS CorporateClients (Title varchar(255), Type varchar (255), Cells text);";
			Statement statement = connection.createStatement();
			int result1 = statement.executeUpdate(query1);
			String query2 = "INSERT INTO CorporateClients (Title, Type, Cells) VALUES ("+"'"+client.GetTitle()+"'"
			+ ", "+"'"+client.GetType() +"'"+ ", " + "'"+cells+"'" + ");";
			int result2 = statement.executeUpdate(query2);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void RemoveFromDB(String removal_criterion, String URL) {
		try {
			Connection connection = DriverManager.getConnection(URL);
			String query = "DELETE FROM CorporateClients WHERE Title = " +"'" +removal_criterion+"'" +";";
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate(query);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void ShowTable(String URL) {
		try {
			
			Connection connection = DriverManager.getConnection(URL);
			String query = "Select * FROM CorporateClients;";
			Statement statement = connection.createStatement();
			statement.executeQuery(query);
			ResultSet result = statement.executeQuery(query);
			while (result.next()) {
				System.out.println(result.getString("Title") + "|" 
			+ result.getString("Type")+ "|" + result.getString("Cells") );
			}
		}catch (SQLException e){
			e.printStackTrace();			
		}
		
	}

}
