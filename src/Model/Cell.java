package Model;

import java.util.ArrayList;

public class Cell {
    private static int cell_number;
    private static ArrayList<String> items = new ArrayList<String>();
    public int GetCellNumber(){
        return cell_number;
    }
    public ArrayList<String> GetItems(){
        return items;
    }
    public void AddItems(String item) {
    	items.add(item);
    }
 

    public Cell (int cell_number){
        Cell.cell_number = cell_number;
    }
}
