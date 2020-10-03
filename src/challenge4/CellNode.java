package challenge4;

public class CellNode {
	private int value;
	private int intermediateSumValue;
	private int totalRectValue;
	private CellNode leftCellNode;
	private CellNode upCellNode;
	private int xId;
	private int yId;

	public CellNode(int value, int xId, int yId) {
		this.value = value;
		this.intermediateSumValue = 0;
		this.totalRectValue = 0;
		this.leftCellNode = null;
		this.upCellNode = null;
		this.xId = xId;
		this.yId = yId;
	}

	public int getXId() {
		return this.xId;
	}

	public int getYId() {
		return this.yId;
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

	public void setUpCellNode(CellNode upCellNode) {
		this.upCellNode = upCellNode;
	}
}
