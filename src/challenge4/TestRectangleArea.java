package challenge4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRectangleArea {
	Matrix matrix;
	List<List<Integer>> lists;
	CellNode[][] cellNodes;

	@BeforeEach
	void setUp() throws Exception {
		List<Integer> list1 = Arrays.asList(1, 2);
		List<Integer> list2 = Arrays.asList(3, 4, 5, 6);
		List<Integer> list3 = Arrays.asList(7, 8);
		List<Integer> list4 = Arrays.asList(9);
		lists = Arrays.asList(list1, list2, list3, list4);
		matrix = new Matrix(lists);
		// cellNodes=matrix.createMatrix();
		// System.out.println(cellNodes[0][0]);
	}

	@Test
	void testMatrixCreation() {
		cellNodes = matrix.createMatrix();
		// System.out.println(cellNodes[0][0].getValue());
		assertEquals(cellNodes[0][0].getValue(), 1);
		assertEquals(cellNodes[0][1].getValue(), 2);
		assertEquals(cellNodes[1][0].getValue(), 3);
		assertEquals(cellNodes[1][1].getValue(), 4);
		assertEquals(cellNodes[1][2].getValue(), 5);
		assertEquals(cellNodes[1][3].getValue(), 6);
		assertEquals(cellNodes[2][0].getValue(), 7);
		assertEquals(cellNodes[2][1].getValue(), 8);
		assertEquals(cellNodes[3][0].getValue(), 9);
		// fail("Not yet implemented");

	}

	@Test
	void testRightConnections() {
		cellNodes = matrix.createMatrix();
		assertEquals(cellNodes[0][0].getRightCellNode().getValue(), 2);
		assertEquals(cellNodes[0][1].getRightCellNode(), null);
		assertEquals(cellNodes[1][0].getRightCellNode().getValue(), 4);
		assertEquals(cellNodes[1][1].getRightCellNode().getValue(), 5);
		assertEquals(cellNodes[1][2].getRightCellNode().getValue(), 6);
		assertEquals(cellNodes[1][3].getRightCellNode(), null);
		assertEquals(cellNodes[2][0].getRightCellNode().getValue(), 8);
		assertEquals(cellNodes[2][1].getRightCellNode(), null);
		assertEquals(cellNodes[3][0].getRightCellNode(), null);
	}

	@Test
	void testLeftConnections() {
		cellNodes = matrix.createMatrix();
		assertEquals(cellNodes[0][0].getLeftCellNode(), null);
		assertEquals(cellNodes[0][1].getLeftCellNode().getValue(), 1);
		assertEquals(cellNodes[1][0].getLeftCellNode(), null);
		assertEquals(cellNodes[1][1].getLeftCellNode().getValue(), 3);
		assertEquals(cellNodes[1][2].getLeftCellNode().getValue(), 4);
		assertEquals(cellNodes[1][3].getLeftCellNode().getValue(), 5);
		assertEquals(cellNodes[2][0].getLeftCellNode(), null);
		assertEquals(cellNodes[2][1].getLeftCellNode().getValue(), 7);
		assertEquals(cellNodes[3][0].getLeftCellNode(), null);
	}

}
