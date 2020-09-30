package challenge3;

public class Node {
	private Node leftNode;
	private Node rightNode;
	private int value;

	public Node(int value) {
		this.value = value;
		this.leftNode = this.rightNode = null;
	}

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}

	public Node getLeftNode() {
		return this.leftNode;
	}

	public Node getRightNode() {
		return this.rightNode;
	}

	public int getValue() {
		return this.value;
	}

}