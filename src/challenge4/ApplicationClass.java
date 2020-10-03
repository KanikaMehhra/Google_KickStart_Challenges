package challenge4;

import java.util.Arrays;
import java.util.List;

public class ApplicationClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("kanika");
		List<Integer> list1 = Arrays.asList(1, 2);
		List<Integer> list2 = Arrays.asList(3, 4, 5, 6);
		List<Integer> list3 = Arrays.asList(7, 8);
		List<Integer> list4 = Arrays.asList(9);
		List<List<Integer>> lists = Arrays.asList(list1, list2, list3, list4);
		Rectangle rect =new Rectangle(lists);
//		Matrix matrix = new Matrix(lists);
		
		

		// List<List<Integer>> lists=new ArrayList<List<Integer>>([[1, 2], [3, 4, 5, 6],
		// [7, 8], [9]]);
	}

}
