package challenge4;

import java.util.ArrayList;
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
		this.matrix = new CellNode[x][y];
		this.createMatrix();
	}

	public CellNode[][] getMatrix() {
		return this.matrix;
	}

	private void setUpwardConnection() {
		for (int i = 1; i < this.lists.size(); i++) {
			CellNode[] row = this.matrix[i];
			List<CellNode> nonNullCellNodeRow = getNonNullCellNodesList(row);
			ListIterator<CellNode> listItr = nonNullCellNodeRow.listIterator();
			while (listItr.hasNext()) {
				int currentColumn = listItr.nextIndex();
				CellNode upCellNode = this.matrix[i - 1][currentColumn];
				if (upCellNode != null) {
					listItr.next().setUpCellNode(upCellNode);
				} else {
					break;
				}
			}
		}
	}

	private List<ListIterator<Integer>> getListOfListIterators() {
		List<ListIterator<Integer>> listOfListIterators = new ArrayList<ListIterator<Integer>>();
		for (List<Integer> list : this.lists) {
			ListIterator<Integer> listIterator = list.listIterator();
			listOfListIterators.add(listIterator);
		}
		return listOfListIterators;
	}

	public void createMatrix() {
		this.fillMatrix();
		this.setLeftConnections();
		this.setUpwardConnection();
	}

	public List<CellNode> getNonNullCellNodesList(CellNode[] row) {
		List<CellNode> cellNodesInARow = new ArrayList<>();
		for (CellNode node : row) {
			if (node != null) {
				cellNodesInARow.add(node);
			} else {
				break;
			}
		}
		return cellNodesInARow;
	}

	private void setLeftConnections() {
		for (CellNode[] row : this.matrix) {
			List<CellNode> cellNodesInARow = this.getNonNullCellNodesList(row);
			ListIterator<CellNode> cellNodeListItrRow = cellNodesInARow.listIterator(cellNodesInARow.size());
			while (cellNodeListItrRow.hasPrevious()) {
				CellNode currentNode = cellNodeListItrRow.previous();
				if (cellNodeListItrRow.hasPrevious()) {
					CellNode leftNode = cellNodeListItrRow.previous();
					currentNode.setLeftCellNode(leftNode);
					cellNodeListItrRow.next();
				} else {
					break;
				}

			}
		}

	}

	private void fillMatrix() {
		List<ListIterator<Integer>> listOfListIterators = this.getListOfListIterators();
		int x = 0;
		int y = 0;
		for (ListIterator<Integer> listIterator : listOfListIterators) {
			while (listIterator.hasNext()) {
				this.matrix[x][y] = new CellNode(listIterator.next(), x, y);
				y++;
			}
			x++;
			y = 0;
		}

	}
}
