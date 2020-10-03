package challenge4;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Rectangle extends Matrix {
	private ListIterator<CellNode> cellNodesInRectItr;
	private int max;

	public Rectangle(List<List<Integer>> lists) {
		super(lists);
		this.setCellNodesInRect(this.getMatrix());
		this.max = 0;
		this.setBiggestRectSum();
	}

	private void setCellNodesInRect(CellNode[][] matrix) {
		List<CellNode> cellNodesInRect = new ArrayList<>();
		for (CellNode[] row : matrix) {
			cellNodesInRect.addAll(this.getNonNullCellNodesList(row));
		}
		this.cellNodesInRectItr = cellNodesInRect.listIterator();
	}

	public int getBiggestRectSum() {
		return this.max;
	}

	public void setBiggestRectSum() {
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
			this.max = Math.max(this.max, totalRectValue);
		}
	}
}
