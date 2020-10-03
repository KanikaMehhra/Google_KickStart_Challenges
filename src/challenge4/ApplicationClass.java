package challenge4;

import java.util.Arrays;
import java.util.List;

import javafx.util.Pair;

public class ApplicationClass {

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1, 2);
		List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 11, 12);
		List<Integer> list3 = Arrays.asList(7, 8, 10);
		List<Integer> list4 = Arrays.asList(9);
		List<List<Integer>> lists = Arrays.asList(list1, list2, list3, list4);
		Rectangle rect = new Rectangle(lists);
		System.out.println("Largest sub of the rectangle is: " + rect.getBiggestRectSum());
		System.out.println("Array of the largect rectancle indices pair is:");
		Pair<Integer, Integer>[] pairs = rect.getIndicesPAirArray();
		for (Pair<Integer, Integer> pair : pairs) {
			System.out.println("(" + pair.getKey() + ", " + pair.getValue() + ")");
		}
	}

}
