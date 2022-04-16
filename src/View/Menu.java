package View;

import java.util.Scanner;

import Controller.CellsDBController;
import Controller.CorporateClientDBController;
import Controller.PrivateClientDBController;
import Model.Cell;
import Model.CorporateClient;
import Model.PrivateClient;

public class Menu {
	private String db_path = "jdbc:sqlite:/";
	private PrivateClientDBController private_controller= new PrivateClientDBController();
	private CorporateClientDBController corporate_controller = new CorporateClientDBController();
	private CellsDBController cell_controller = new CellsDBController();
	public void ControlPanel() {
		System.out.println("1. Set connection \n");
		System.out.println("2. Add Private Client \n");
		System.out.println("3. Remove Private Client \n");
		System.out.println("4. Show Private Clients \n");
		System.out.println("5. Add Corporate Client \n");
		System.out.println("6. Remove Corporate Client \n");
		System.out.println("7. Show CorporateClients \n");
		System.out.println("8. Add Cell \n");
		System.out.println("9. Remove Cell \n");
		System.out.println("10. Show cells \n");
		Scanner console = new Scanner(System.in);
		int choice = console.nextInt();
		switch (choice) {
		case 1:
			SetDBPath();
			break;
		case 2:
			CreatePrivateClient();
			break;
		case 3:
			RemovePrivateClient();
			break;
		case 4:
			ShowPrivateClients();
			break;
		case 5:
			CreateCorporateClient();
			break;
		case 6:
			RemoveCorporateClient();
			break;
		case 7:
			ShowCorporateClients();
			break;
		case 8:
			CreateCell();
			break;
		case 9:
			RemoveCell();
			break;
		case 10:
			ShowCells();
			break;
		default:
			System.out.println ("Please enter valid choice\n");
			
		}
		
	}
	private void CreatePrivateClient() {
		Scanner console = new Scanner(System.in);
		PrivateClient client;
		System.out.println("Enter Name\n");
		String Name = console.nextLine();
		System.out.println("Enter Surname\n");
		String Surname = console.nextLine();
		client = new PrivateClient (Name, Surname);
		System.out.println("How many cells do tou want to add\n");
		int amount= console.nextInt();
		int cell_number;
		for (int i=0;i<amount;i++) {
			System.out.println("Input Cell number\n");
			cell_number=console.nextInt();
			client.GetCells().add(cell_number);
		}

		private_controller.AddToDB(client, db_path);
		
	}
	private void RemovePrivateClient() {
		Scanner console = new Scanner(System.in);
		System.out.println("Enter Name\n");
		String Name = console.nextLine();
		private_controller.RemoveFromDB(Name, db_path);
		
	}
	private void ShowPrivateClients() {
		private_controller.ShowTable(db_path);
	}
	private void CreateCorporateClient() {
		Scanner console = new Scanner(System.in);
		CorporateClient client;
		System.out.println("Enter Title\n");
		String Title = console.nextLine();
		System.out.println("Enter Type\n");
		String Type = console.nextLine();
		client = new CorporateClient (Title, Type);

		System.out.println("How many cells do tou want to add\n");
		int amount= console.nextInt();
		int cell_number;
		for (int i=0;i<amount;i++) {
			System.out.println("Input Cell number\n");
			cell_number=console.nextInt();
			client.GetCells().add(cell_number);
		}
		
		corporate_controller.AddToDB(client, db_path);
		
	}
	private void RemoveCorporateClient() {
		Scanner console = new Scanner(System.in);
		System.out.println("Enter Title\n");
		String title = console.nextLine();
		corporate_controller.RemoveFromDB(title, db_path);
		
	}
	private void ShowCorporateClients() {
		corporate_controller.ShowTable(db_path);
	}
	private void CreateCell() {
		Scanner console = new Scanner(System.in);
		Cell cell;
		System.out.println("Enter cell number\n");
		int number = console.nextInt();
		cell = new Cell(number);
		
		System.out.println("How many Items do you wanna add\n");
		int amount= console.nextInt();
		String item;
		for (int i=0; i<amount;i++) {
			System.out.println("Enter item title\n");
			item=console.nextLine();
			cell.AddItems(item);
		}
		cell_controller.AddToDB(cell, db_path);
		
	}
	private void RemoveCell() {
		Scanner console = new Scanner(System.in);
		System.out.println("Enter Cell Number\n");
		String CellNumber= console.nextLine();
		cell_controller.RemoveFromDB(CellNumber, db_path);
		
	}
	private void ShowCells() {
		cell_controller.ShowTable(db_path);
	}
	private void SetDBPath() {
		Scanner console = new Scanner(System.in);
		String path = console.next();
		db_path+=path;
		
	}
}
