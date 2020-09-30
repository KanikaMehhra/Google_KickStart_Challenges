package challenge1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApplicationClass {
	private static FlattenedBidirectionalIterator flatBiDirIt = null;
	private static List<List<Integer>> lists = new ArrayList<List<Integer>>();
	private static List<Integer> listOfIntegers = new ArrayList<Integer>();

	public static void main(String[] args) {

		System.out.println("Kanika");
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of Iterator lists you wish to enter:");
		int numberOfIteratorLists = 0;
		boolean error = true;
		do {
			try {
				numberOfIteratorLists = Integer.parseInt(sc.next());
				error = false;

			} catch (Exception e) {
				System.out.println("Please enter a +ve integer.");
			}
		} while (error);

		for (int i = 0; i < numberOfIteratorLists; i++) {
			System.out.printf("List %d : \n", (i + 1));
			List<Integer> list = new ArrayList<Integer>();
			boolean addMore = true;
			boolean error2 = true;
			while (addMore) {
				System.out.println("Enter the number you want to add to this list:");
				int number = 0;
				do {
					try {
						number = Integer.parseInt(sc.next());
						error2 = false;
					} catch (Exception e) {
						System.out.println("Please enter a +ve integer.");
					}
				} while (error2);
				list.add(number);
				System.out.println("Want to add more numbers to the list(y/n):");
				String decision = sc.next();
				while (!decision.equals("n") && !decision.equals("y")) {
					System.out.println("Please enter either 'y' or 'n':");
					decision = sc.next();
				}
				if (decision.equals("n"))
					addMore = false;
			}
			lists.add(list);
		}

		populateListForFlattenedBidirectionalIterator();

		System.out.println("Provided lists are as follows:");
		for (List<Integer> list : lists) {
			System.out.println(list);
		}
		flatBiDirIt = new FlattenedBidirectionalIterator(listOfIntegers);
		iterate(listOfIntegers);
	}

	public static void populateListForFlattenedBidirectionalIterator() {
		BidirectionalIterators[] biDirItrs = new BidirectionalIterators[lists.size()];
		for (List<Integer> list : lists) {
			biDirItrs[lists.indexOf(list)] = new BidirectionalIterators(list);
		}

		int max = biDirItrs[0].getListLength();
		for (int i = 1; i < biDirItrs.length; i++) {
			max = Math.max(max, biDirItrs[i].getListLength());
		}

		for (int i = 0; i < max; i++) {
			for (int j = 0; j < biDirItrs.length; j++) {
				if (biDirItrs[j].hasNext()) {
					biDirItrs[j].previous();
					listOfIntegers.add(biDirItrs[j].next());
				}
			}
		}
	}

	public static void iterate(List<Integer> listOfIntegers) {
		Scanner sc = new Scanner(System.in);
		boolean iterateMore = true;
		while (iterateMore) {
			System.out.println("Resulted lists is as follows: \n" + listOfIntegers);
			System.out.println("Select the following iteration process to perform on the resulted list:");
			System.out.println("1. Get next element in the list.");
			System.out.println("2. Get previous element in the list.");
			System.out.println("3. Check list has next element.");
			System.out.println("4. Check list has previous element.");
			int process = Integer.parseInt(sc.next());
			while (process != 1 && process != 2 && process != 3 && process != 4) {
				System.out.println("Please select from (1/2/3/4):");
				process = Integer.parseInt(sc.next());
			}
			switch (process) {
			case 1:
				System.out.println(flatBiDirIt.next());
				break;
			case 2:
				System.out.println(flatBiDirIt.previous());
				break;
			case 3:
				System.out.println(flatBiDirIt.hasNext());
				flatBiDirIt.previous();
				break;
			case 4:
				System.out.println(flatBiDirIt.hasPrevious());
				flatBiDirIt.next();
				break;
			}
			System.out.println("Want to perform more iterations(y/n):");
			String decision = sc.next();
			while (!decision.equals("n") && !decision.equals("y")) {
				System.out.println("Please enter either 'y' or 'n':");
				decision = sc.next();
			}
			if (decision.equals("n"))
				iterateMore = false;
		}

	}

	public FlattenedBidirectionalIterator getFlattenedBidirectionalIterator() {
		return flatBiDirIt;
	}

}
