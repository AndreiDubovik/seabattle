package by.seabattle.boats;

import by.seabattle.field.Cell;

public abstract class Boat {
	
	private Cell head;
	
	public Boat(Cell head){
		this.head = head;
	}
	
	public abstract Cell[] getBody();
	
	public boolean isAlive(){
		for(Cell cell:this.getBody())if(!cell.isStriked())return true;
		return false;
	}
	public boolean isDamaged(){
		for(Cell cell:this.getBody())if(cell.isStriked())return true;
		return false;
	}
	
	public Cell getHead(){
		return this.head;
	}

}
