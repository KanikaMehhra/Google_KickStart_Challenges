package challenge4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.util.Pair;

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
	}

	@Test
	void testMatrixCreation() {
		matrix = new Matrix(lists);
		cellNodes = matrix.getMatrix();
		assertEquals(cellNodes[0][0].getValue(), 1);
		assertEquals(cellNodes[0][1].getValue(), 2);
		assertEquals(cellNodes[1][0].getValue(), 3);
		assertEquals(cellNodes[1][1].getValue(), 4);
		assertEquals(cellNodes[1][2].getValue(), 5);
		assertEquals(cellNodes[1][3].getValue(), 6);
		assertEquals(cellNodes[2][0].getValue(), 7);
		assertEquals(cellNodes[2][1].getValue(), 8);
		assertEquals(cellNodes[3][0].getValue(), 9);
	}

	@Test
	void testLeftConnections() {
		matrix = new Matrix(lists);
		cellNodes = matrix.getMatrix();
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

	@Test
	void testUpwardConnections() {
		matrix = new Matrix(lists);
		cellNodes = matrix.getMatrix();
		assertEquals(cellNodes[0][0].getUpCellNode(), null);
		assertEquals(cellNodes[0][1].getUpCellNode(), null);
		assertEquals(cellNodes[1][0].getUpCellNode().getValue(), 1);
		assertEquals(cellNodes[1][1].getUpCellNode().getValue(), 2);
		assertEquals(cellNodes[1][2].getUpCellNode(), null);
		assertEquals(cellNodes[1][3].getUpCellNode(), null);
		assertEquals(cellNodes[2][0].getUpCellNode().getValue(), 3);
		assertEquals(cellNodes[2][1].getUpCellNode().getValue(), 4);
		assertEquals(cellNodes[3][0].getUpCellNode().getValue(), 7);
	}

	@Test
	void testBiggestRectSum() {
		Rectangle rect = new Rectangle(lists);
		assertEquals(rect.getBiggestRectSum(), 25);

		List<Integer> list1, list2, list3, list4 = new ArrayList<>();
		list1 = Arrays.asList(1, 2);
		list2 = Arrays.asList(3, 4, 5, 6);
		list3 = Arrays.asList(7, 8, 10);
		list4 = Arrays.asList(9);
		lists = Arrays.asList(list1, list2, list3, list4);
		Rectangle rect2 = new Rectangle(lists);
		assertEquals(rect2.getBiggestRectSum(), 37);

		list1 = Arrays.asList(1, 2);
		list2 = Arrays.asList(3, 4, 5, 6, 11);
		list3 = Arrays.asList(7, 8, 10);
		list4 = Arrays.asList(9);
		lists = Arrays.asList(list1, list2, list3, list4);
		Rectangle rect3 = new Rectangle(lists);
		assertEquals(rect3.getBiggestRectSum(), 37);

		list1 = Arrays.asList(1, 2);
		list2 = Arrays.asList(3, 4, 5, 6, 11, 12);
		list3 = Arrays.asList(7, 8, 10);
		list4 = Arrays.asList(9);
		lists = Arrays.asList(list1, list2, list3, list4);
		Rectangle rect4 = new Rectangle(lists);
		assertEquals(rect4.getBiggestRectSum(), 41);
	}

	@Test
	void testIndicesPairArray() {
		Pair pair1;
		Pair pair2;
		Pair pair3;
		Pair pair4;
		Pair pair5;
		Pair pair6;

		Rectangle rect = new Rectangle(lists);
		Pair<Integer, Integer>[] actualPairs = rect.getIndicesPAirArray();
		pair1 = new Pair(0, 0);
		pair2 = new Pair(0, 1);
		pair3 = new Pair(1, 0);
		pair4 = new Pair(1, 1);
		pair5 = new Pair(2, 0);
		pair6 = new Pair(2, 1);
		assertEquals(actualPairs.length, 6);
		assertEquals(actualPairs[0], pair1);
		assertEquals(actualPairs[1], pair2);
		assertEquals(actualPairs[2], pair3);
		assertEquals(actualPairs[3], pair4);
		assertEquals(actualPairs[4], pair5);
		assertEquals(actualPairs[5], pair6);

		List<Integer> list1, list2, list3, list4 = new ArrayList<>();
		list1 = Arrays.asList(1, 2);
		list2 = Arrays.asList(3, 4, 5, 6);
		list3 = Arrays.asList(7, 8, 10);
		list4 = Arrays.asList(9);
		lists = Arrays.asList(list1, list2, list3, list4);
		Rectangle rect2 = new Rectangle(lists);
		Pair<Integer, Integer>[] actualPairs2 = rect2.getIndicesPAirArray();
		pair1 = new Pair(1, 0);
		pair2 = new Pair(1, 1);
		pair3 = new Pair(1, 2);
		pair4 = new Pair(2, 0);
		pair5 = new Pair(2, 1);
		pair6 = new Pair(2, 2);
		assertEquals(actualPairs2.length, 6);
		assertEquals(actualPairs2[0], pair1);
		assertEquals(actualPairs2[1], pair2);
		assertEquals(actualPairs2[2], pair3);
		assertEquals(actualPairs2[3], pair4);
		assertEquals(actualPairs2[4], pair5);
		assertEquals(actualPairs2[5], pair6);

		list1 = Arrays.asList(1, 2);
		list2 = Arrays.asList(3, 4, 5, 6, 11);
		list3 = Arrays.asList(7, 8, 10);
		list4 = Arrays.asList(9);
		lists = Arrays.asList(list1, list2, list3, list4);
		Rectangle rect3 = new Rectangle(lists);
		Pair<Integer, Integer>[] actualPairs3 = rect3.getIndicesPAirArray();
		pair1 = new Pair(1, 0);
		pair2 = new Pair(1, 1);
		pair3 = new Pair(1, 2);
		pair4 = new Pair(2, 0);
		pair5 = new Pair(2, 1);
		pair6 = new Pair(2, 2);
		assertEquals(actualPairs3.length, 6);
		assertEquals(actualPairs3[0], pair1);
		assertEquals(actualPairs3[1], pair2);
		assertEquals(actualPairs3[2], pair3);
		assertEquals(actualPairs3[3], pair4);
		assertEquals(actualPairs3[4], pair5);
		assertEquals(actualPairs3[5], pair6);

		list1 = Arrays.asList(1, 2);
		list2 = Arrays.asList(3, 4, 5, 6, 11, 12);
		list3 = Arrays.asList(7, 8, 10);
		list4 = Arrays.asList(9);
		lists = Arrays.asList(list1, list2, list3, list4);
		Rectangle rect4 = new Rectangle(lists);
		Pair<Integer, Integer>[] actualPairs4 = rect4.getIndicesPAirArray();
		pair1 = new Pair(1, 0);
		pair2 = new Pair(1, 1);
		pair3 = new Pair(1, 2);
		pair4 = new Pair(1, 3);
		pair5 = new Pair(1, 4);
		pair6 = new Pair(1, 5);
		assertEquals(actualPairs4.length, 6);
		assertEquals(actualPairs4[0], pair1);
		assertEquals(actualPairs4[1], pair2);
		assertEquals(actualPairs4[2], pair3);
		assertEquals(actualPairs4[3], pair4);
		assertEquals(actualPairs4[4], pair5);
		assertEquals(actualPairs4[5], pair6);

	}

}
