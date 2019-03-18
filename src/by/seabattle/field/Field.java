package by.seabattle.field;

import by.seabattle.boats.Boat;

public class Field {
	
	private Cell[][] field;
	
	public Field(int sizeX, int sizeY){
		this.field = new Cell[sizeY][sizeX];
		for(int row = 0; row<sizeY;row++){
			for(int column = 0; column<sizeX; column++){
				this.field[row][column]=new Cell(row,column);
				this.field[row][column].setField(this);
			}
		}
	}
	
	public Cell getCell(int x, int y){
		return this.field[y][x];
	}
	
	public int getHeight(){
		return this.field.length;
	}
	
	public int getWidth(){
		return this.field[0].length;
	}
	
	public boolean canPlaceBoat(Boat boat){
		if(boat==null)return false;
		Cell[]cells = boat.getBody();
		for(Cell cell:cells){
			int x = cell.getX();
			int y = cell.getY();
			if(x<0||x>=this.field[0].length||y<0||y>=this.field.length)
				return false;
			if(!this.field[y][x].isFree())
				return false;
			if(x>0&&y>0&&(!this.field[y-1][x-1].isFree()))
				return false;
			if(y>0&&(!this.field[y-1][x].isFree()))return false;
			if(y>0&&x<this.field[0].length-1&&(!this.field[y-1][x+1].isFree()))
				return false;
			if(x>0&&(!this.field[y][x-1].isFree()))return false;
			if(x<this.field[0].length-1&&(!this.field[y][x].isFree()))return false;
			if(y<this.field.length-1&&x>0&&(!this.field[y+1][x-1].isFree()))
				return false;
			if(y<this.field.length-1&&(!this.field[y+1][x].isFree()))return false;
			if(y<this.field.length-1&&x<this.field[0].length-1&&(!this.field[y+1][x+1].isFree()))
				return false;
		}
		return true;
	}
	
	public void placeBoat(Boat boat){
		Cell[]body = boat.getBody();
		for(Cell cell:body){
			this.field[cell.getY()][cell.getX()] = cell;
			cell.setBoat(boat);
		}
	}

}