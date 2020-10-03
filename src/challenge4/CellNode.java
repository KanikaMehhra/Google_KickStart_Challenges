package challenge4;

public class CellNode {
	private int value;
	private int intermediateSumValue;
	private int totalRectValue;
	private CellNode leftCellNode;
	private CellNode rightCellNode;
	private CellNode upCellNode;

	public CellNode(int value) {
		this.value = value;
		this.intermediateSumValue = 0;
		this.totalRectValue = 0;
		this.leftCellNode = null;
		this.rightCellNode = null;
		this.upCellNode = null;
	}

	public int getValue() {
		return this.value;
	}

	public int getIntermediateSumValue() {
		return this.intermediateSumValue;
	}

	public int getTotalRectValue() {
		return this.totalRectValue;
	}

	public CellNode getLeftCellNode() {
		return this.leftCellNode;
	}

	public CellNode getRightCellNode() {
		return this.rightCellNode;
	}

	public CellNode getUpCellNode() {
		return this.upCellNode;
	}

	public void setIntermediateSumValue(int intermediateSumValue) {
		this.intermediateSumValue = intermediateSumValue;
	}

	public void setTotalRectValue(int totalRectValue) {
		this.totalRectValue = totalRectValue;
	}

	public void setLeftCellNode(CellNode leftCellNode) {
		this.leftCellNode = leftCellNode;
	}

	public void setRightCellNode(CellNode rightCellNode) {
		this.rightCellNode = rightCellNode;
	}

	public void setUpCellNode(CellNode upCellNode) {
		this.upCellNode = upCellNode;
	}
}
