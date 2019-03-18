package by.seabattle.main;

import by.seabattle.boats.Boat;
import by.seabattle.boats.PolyCellBoat;
import by.seabattle.boats.SingleCellBoat;
import by.seabattle.field.Cell;
import by.seabattle.field.Field;

public class Main {

	public static void main(String[] args) {
		Field field = new Field(10,10);
		Boat boat = new SingleCellBoat(new Cell(5,2));
		Cell cell = new Cell(5,88);
		Boat boat2 = new PolyCellBoat(cell,3,true);
		field.placeBoat(boat);
		if(field.canPlaceBoat(boat2))field.placeBoat(boat2);
		show(field);
	}
	
	public static void show(Field field){
		int height = field.getWidth();
		int width = field.getHeight();
		for(int y=0;y<height;y++){
			for(int x = 0; x<width; x++){
				String s = field.getCell(x, y).getBoat()==null?"O":"X";
				System.out.print(s+" ");
			}
			System.out.println();
		}
	}

}
