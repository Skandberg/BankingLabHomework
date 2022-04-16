package Controller;

import java.util.ArrayList;

import Model.Cell;

public class DataConverter {
	public String ConvertCellsNumbersToText(ArrayList<Integer> cell_numbers) {
		String temp="";
		for (int i=0;i<cell_numbers.size();i++)
		{
			temp+=Integer.toString(cell_numbers.get(i))+"; ";
		}
		return temp;
	}
	public String ConvertCellsItemsToText(Cell cell) {
		String temp ="";
		for (int i=0;i<cell.GetItems().size(); i++) {
			temp+=cell.GetItems().get(i)+"; ";
		}
		return temp;
	}
	public ArrayList<Integer> ConvertTextToCellsNumbers(String text){
		String[] temp_arr = text.split("; ");
		ArrayList<Integer> temp_list = new ArrayList<Integer>();
		for (int i = 0; i<temp_arr.length;i++) {
			temp_list.add(Integer.parseInt(temp_arr[i]));
		}
		return temp_list;
	}
	public ArrayList<String> ConvertTextToCellsItems(String text){
		String[] temp_arr = text.split("; ");
		ArrayList<String> temp_list = new ArrayList <String>();
		for (int i=0;i<temp_arr.length;i++) {
			temp_list.add(temp_arr[i]);
		}
		return temp_list;
	}
	
}
