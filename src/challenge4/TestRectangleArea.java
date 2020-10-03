package challenge4;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

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
		cellNodes=matrix.createMatrix();
		System.out.println(cellNodes[0][0]);
	}

	@Test
	void testLeftConnection() {
//		System.out.println("LALALALALAL");
		System.out.println(cellNodes[0][0]);
		assertEquals(cellNodes[0][0].getRightCellNode(),2);
//		fail("Not yet implemented");

	}

}
