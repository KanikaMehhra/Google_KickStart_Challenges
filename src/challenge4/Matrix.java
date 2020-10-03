package challenge4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class Matrix {
	private CellNode[][] matrix;
	private List<List<Integer>> lists;

	public Matrix(List<List<Integer>> lists) {
		this.lists = lists;
		int x = lists.size();
		int y = lists.stream().map(List::size).max(Comparator.naturalOrder()).get();
		// System.out.println(x);
		// System.out.println(y);
		this.matrix = new CellNode[x][y];
		// this.createMatrix();
	}

	public List<ListIterator<Integer>> getListOfListIterators() {
		List<ListIterator<Integer>> listOfListIterators = new ArrayList<ListIterator<Integer>>();
		for (List<Integer> list : this.lists) {
			ListIterator<Integer> listIterator = list.listIterator();
			listOfListIterators.add(listIterator);
		}
		return listOfListIterators;
	}

	public CellNode[][] createMatrix() {
		// Fill the matrix
		this.fillMatrix();
		this.setHorizontalConnections();
		return this.matrix;

	}

	public void fillMatrix() {
		List<ListIterator<Integer>> listOfListIterators = this.getListOfListIterators();
		int x = 0;
		int y = 0;
		for (ListIterator<Integer> listIterator : listOfListIterators) {
			while (listIterator.hasNext()) {
				this.matrix[x][y] = new CellNode(listIterator.next());
				y++;
			}
			x++;
			y = 0;
		}

	}

	public void setHorizontalConnections() {
		for (int listIndex = 0; listIndex < this.lists.size(); listIndex++) {
			for (int j = 0; j < this.lists.get(listIndex).size(); j++) {
				if (j == this.lists.get(listIndex).size() - 1) {
					this.matrix[listIndex][j].setLeftCellNode(this.matrix[listIndex][j - 1]);
				} else {
					if (j != 0) {
						this.matrix[listIndex][j].setLeftCellNode(this.matrix[listIndex][j - 1]);
					}

					this.matrix[listIndex][j].setRightCellNode(this.matrix[listIndex][j + 1]);

				}

			}
		}
	}

	/*
	 * public void createMatrix() { List<ListIterator<Integer>> listOfListIterators
	 * = this.getListOfListIterators(); int previousX = 0; int previousY = 0;
	 * this.matrix[previousX][previousY] = new
	 * CellNode(listOfListIterators.get(0).next()); //
	 * System.out.println(this.matrix[previousX][previousY].getValue()); for
	 * (ListIterator<Integer> listIterator : listOfListIterators) { int currentX =
	 * previousX; while (listIterator.hasNext()) { int currentY = previousY++;
	 * CellNode cellNode = new CellNode(listIterator.next()); if (previousX == 0 &&
	 * previousY == 0) {
	 * this.matrix[previousX][previousY].setRightCellNode(cellNode);
	 * cellNode.setLeftCellNode(this.matrix[previousX][previousY]);
	 * this.matrix[currentX][currentY] = cellNode; previousX = currentX; previousY =
	 * currentY; } else if (previousX == 0) {
	 * this.matrix[previousX][previousY].setRightCellNode(cellNode);
	 * cellNode.setLeftCellNode(this.matrix[previousX][previousY]);
	 * this.matrix[currentX][currentY] = cellNode; previousX = currentX; previousY =
	 * currentY; } else if (previousY == 0) { this.matrix[currentX][previousY] =
	 * cellNode; if(listIterator.hasNext()) { CellNode nextCellNode = new
	 * CellNode(listIterator.next()); cellNode.setRightCellNode(nextCellNode);
	 * nextCellNode.setLeftCellNode(cellNode);
	 * cellNode.setUpCellNode(this.matrix[currentX - 1][previousY]);
	 * this.matrix[currentX][currentY]=nextCellNode;
	 * nextCellNode.setUpCellNode(this.matrix[currentX-1][currentY]); previousX =
	 * currentX; previousY = currentY; } } else {
	 * this.matrix[currentX][currentY]=cellNode;
	 * cellNode.setLeftCellNode(this.matrix[previousX][previousY]);
	 * this.matrix[previousX][previousY].setRightCellNode(cellNode);
	 * cellNode.setUpCellNode(this.matrix[currentX-1][currentY]); //
	 * this.matrix[previousX][previousY].setUpCellNode(this.matrix[currentX -
	 * 1][previousY]); if(listIterator.hasNext()) { CellNode nextCellNode = new
	 * CellNode(listIterator.next());
	 * this.matrix[currentX][currentY].setRightCellNode(nextCellNode);
	 * nextCellNode.setLeftCellNode(this.matrix[currentX][currentY]); //
	 * this.matrix[previousX][previousY].setUpCellNode(this.matrix[currentX -
	 * 1][previousY]); nextCellNode.setUpCellNode(this.matrix[currentX -
	 * 1][currentY+1]); this.matrix[currentX][currentY+1]=nextCellNode; previousX =
	 * currentX; previousY = currentY; }
	 * 
	 * } } previousX++; previousY = 0; // System.out.println(listIterator.next()); }
	 * }
	 */

}
