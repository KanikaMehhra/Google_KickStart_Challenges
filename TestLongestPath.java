package challenge3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestLongestPath {
	List<Node> nodes = new ArrayList<Node>();

	Node node1 = new Node(1);
	Node node12 = new Node(12);
	Node node7 = new Node(7);
	Node node8 = new Node(8);
	Node node6 = new Node(6);
	Node node9 = new Node(9);
	Node node14 = new Node(14);
	Node node10 = new Node(10);
	Node node3 = new Node(3);
	Node node4 = new Node(4);
	Node node5 = new Node(5);
	Node node11 = new Node(11);
	Node node13 = new Node(13);
	Node node15 = new Node(15);
	Node node16 = new Node(16);
	Node node17 = new Node(17);
	Node node18 = new Node(18);

	@BeforeEach
	void setUp() throws Exception {
		nodes.add(node1);
		nodes.add(node12);
		nodes.add(node7);
		nodes.add(node8);
		nodes.add(node6);
		nodes.add(node9);
		nodes.add(node14);
		nodes.add(node10);
		nodes.add(node3);
		nodes.add(node4);
		nodes.add(node5);
		nodes.add(node11);
		nodes.add(node13);
		nodes.add(node15);
		nodes.add(node16);
		nodes.add(node17);
		nodes.add(node18);
	}

	@Test
	void test1() {
		node5.setRightNode(node6);
		node7.setLeftNode(node8);
		node1.setLeftNode(node14);
		node1.setRightNode(node10);
		node14.setLeftNode(node3);
		node14.setRightNode(node4);
		node4.setLeftNode(node7);
		node4.setRightNode(node5);
		node8.setRightNode(node9);
		node10.setRightNode(node11);
		node11.setLeftNode(node12);
		node11.setRightNode(node13);
		node13.setLeftNode(node15);
		node15.setLeftNode(node16);
		node16.setRightNode(node17);
		node17.setLeftNode(node18);
		Tree tree = new Tree(node1, nodes);
		assertEquals(tree.getLongestPath(), 4);
	}

	@Test
	void test2() {
		node5.setRightNode(node6);
		node7.setLeftNode(node8);
		node1.setLeftNode(node14);
		node1.setRightNode(node10);
		node14.setLeftNode(node3);
		node14.setRightNode(node4);
		node4.setLeftNode(node7);
		node4.setRightNode(node5);
		node8.setRightNode(node9);
		node10.setRightNode(node11);
		node11.setLeftNode(node12);
		node11.setRightNode(node13);
		node13.setLeftNode(node15);
		node15.setLeftNode(node16);
		Tree tree = new Tree(node1, nodes);
		assertEquals(tree.getLongestPath(), 3);
	}

}
