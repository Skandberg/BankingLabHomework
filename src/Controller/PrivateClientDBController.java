package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.PrivateClient;

public class PrivateClientDBController implements DBController{

	private DataConverter converter=new DataConverter();
	@Override
	public void AddToDB(Object o, String URL) {
		try {
			
			PrivateClient client = (PrivateClient) o;
			String cells =converter.ConvertCellsNumbersToText(client.GetCells());
			Connection connection = DriverManager.getConnection(URL);
			String query = "CREATE TABLE IF NOT EXISTS PrivateClients (Name varchar(255), Surname varchar (255), Cells text);";
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate(query);
			query = "INSERT INTO PrivateClients (Name, Surname, Cells) VALUES ("+"'"+client.GetName()+"'"+
			 ", "+"'"+client.GetSurname()+"'"+ ","+"'"+cells+"'"+");";						
			result = statement.executeUpdate(query);
			connection.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void RemoveFromDB(String removal_criterion, String URL) {
		try {
			Connection connection = DriverManager.getConnection(URL);
			String query = "DELETE FROM PrivateClients WHERE Name = '" +removal_criterion + "');";
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
			String query = "Select * FROM PrivateClients; ";
			Statement statement = connection.createStatement();
			statement.executeQuery(query);
			ResultSet result = statement.executeQuery(query);
			while (result.next()) {
				System.out.println(result.getString("Name") + "|" 
			+ result.getString("Surname")+ "|" + result.getString("Cells"));
			}
		}catch (SQLException e){
			e.printStackTrace();			
		}
		
	}



}
