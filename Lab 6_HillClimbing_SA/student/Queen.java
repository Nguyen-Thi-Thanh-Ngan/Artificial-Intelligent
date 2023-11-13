package student;

public class Queen {
	private int row;
	private int column;

	public Queen(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	public void move() {
		Queen q = new Queen(row, column);
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if(q.isConflict(q)) {
					i++;
				}
				j++;
			}
		}
	}

	// check whether this Queen can attack the given Queen (q)
	public boolean isConflict(Queen q) {
		Queen[] state = new Queen[q.row];
		Node newNode = new Node(state);
		for (int i = 0; i < q.row; i++) {
			for (int j = 0; j < q.column; j++) {
				if(state[i].row == state[j].row) {
					return true;
				}else {
					if((state[i].row - state[j].row) == Math.abs(state[i].column - state[j].column)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public void setRow(int row) {
		this.row = row;
	}

	@Override
	public String toString() {
		return "(" + row + ", " + column + ")";
	}
}
