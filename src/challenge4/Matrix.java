package challenge4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
		this.setRightLeftConnections();
		return this.matrix;

	}

	public void setRightLeftConnections() {
		for (CellNode[] row : this.matrix) {
			List<CellNode> cellNodesInARow = new ArrayList<>();
			for (CellNode node : row) {
				if (node != null) {
					cellNodesInARow.add(node);
				} else {
					break;
				}
			}
			ListIterator<CellNode> cellNodeListItrRow = cellNodesInARow.listIterator();
			for (int i = 0; i < cellNodesInARow.size(); i++) {
				if (i != cellNodesInARow.size() - 1) {
					CellNode leftNode = cellNodeListItrRow.next();
					CellNode rightNode = cellNodeListItrRow.next();
					leftNode.setRightCellNode(rightNode);
					rightNode.setLeftCellNode(leftNode);
					cellNodeListItrRow.previous();
				}
			}
		}

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
}
