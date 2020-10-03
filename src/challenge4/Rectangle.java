package challenge4;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javafx.util.Pair;

public class Rectangle extends Matrix {
	private ListIterator<CellNode> cellNodesInRectItr;
	private int max;
	private CellNode targetCellNode;
	private Pair<Integer, Integer>[] indicesPairArray;

	// private class IndicesPair {
	// int x;
	// int y;
	//
	// public IndicesPair() {
	// this.x = 0;
	// this.y = 0;
	// }
	// }

	public Rectangle(List<List<Integer>> lists) {
		super(lists);
		this.setCellNodesInRect(this.getMatrix());
		this.max = 0;
		this.targetCellNode = null;
		this.indicesPairArray = null;
		this.setBiggestRectSum();
		this.setIndicesPairArray();
	}

	private void setCellNodesInRect(CellNode[][] matrix) {
		List<CellNode> cellNodesInRect = new ArrayList<>();
		for (CellNode[] row : matrix) {
			cellNodesInRect.addAll(this.getNonNullCellNodesList(row));
		}
		this.cellNodesInRectItr = cellNodesInRect.listIterator();
	}

	public Pair<Integer, Integer>[] getIndicesPAirArray() {
		return this.indicesPairArray;
	}

	public int getBiggestRectSum() {
		return this.max;
	}

	private void setBiggestRectSum() {
		int intermediateSumValue = 0;
		int totalRectValue = 0;
		while (this.cellNodesInRectItr.hasNext()) {
			CellNode cellNode = this.cellNodesInRectItr.next();
			int cellNodevalue = cellNode.getValue();
			if (cellNode.getUpCellNode() == null && cellNode.getLeftCellNode() == null) {
				intermediateSumValue = totalRectValue = cellNodevalue;
			} else if (cellNode.getUpCellNode() == null) {
				intermediateSumValue = totalRectValue = cellNodevalue
						+ cellNode.getLeftCellNode().getIntermediateSumValue();
			} else if (cellNode.getLeftCellNode() == null) {
				intermediateSumValue = cellNodevalue;
				totalRectValue = cellNodevalue + cellNode.getUpCellNode().getTotalRectValue();

			} else {
				intermediateSumValue = cellNodevalue + cellNode.getLeftCellNode().getIntermediateSumValue();
				totalRectValue = intermediateSumValue + cellNode.getUpCellNode().getTotalRectValue();
			}
			cellNode.setIntermediateSumValue(intermediateSumValue);
			cellNode.setTotalRectValue(totalRectValue);
			int new_max = Math.max(this.max, totalRectValue);
			if (new_max > this.max) {
				this.targetCellNode = cellNode;
				this.max = new_max;
			}
		}
		// System.out.println(this.targetCellNode.getXId());
		// System.out.println(this.targetCellNode.getYId());
		// System.out.println("KAKAKAKAK");
	}

	private void setIndicesPairArray() {
		CellNode currentUpNode = this.targetCellNode;
		int x = 0;
		while (currentUpNode.getUpCellNode() != null) {
			x++;
			currentUpNode = currentUpNode.getUpCellNode();
		}

		List<Pair<Integer, Integer>> indicesPairList = new ArrayList<>();
		for (int i = this.targetCellNode.getXId()-x; i <= this.targetCellNode.getXId(); i++) {
			for (int j = 0; j <= this.targetCellNode.getYId(); j++) {
				Pair<Integer, Integer> indexPair = new Pair(i, j);
				indicesPairList.add(indexPair);
			}
		}

		Pair<Integer, Integer>[] indicesPairArray = new Pair[indicesPairList.size()];
		indicesPairList.toArray(indicesPairArray);
		this.indicesPairArray = indicesPairArray;
		// IndicesPair[] array = new IndicesPair[0];
		// int x=0;
		// int y=0;
		//
		// CellNode currentLeftNode=this.targetCellNode;
		// CellNode currentUpNode=this.targetCellNode;
		//
		// while(currentLeftNode.getLeftCellNode()!=null) {
		// y++;
		// currentLeftNode=currentLeftNode.getLeftCellNode();
		// }
		//
		// while(currentUpNode.getUpCellNode()!=null) {
		// x++;
		// currentUpNode=currentUpNode.getUpCellNode();
		// }
	}

}
