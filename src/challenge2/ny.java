package challenge2;

import java.util.Scanner;

public class ny {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter base string:");
		String baseString = sc.next();
		System.out.println("Enter target string:");
		String targetString = sc.next();
		InsertionDistanceCalculator cal = new InsertionDistanceCalculator(baseString, targetString);
		sc.close();
	}

}
