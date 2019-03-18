package by.seabattle.boats;

import by.seabattle.field.Cell;

public class SingleCellBoat extends Boat{

	public SingleCellBoat(Cell head) {
		super(head);
	}

	@Override
	public Cell[] getBody() {
		Cell[]body = {this.getHead()};
		return body;
	}

}
