package challenge2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertionDistanceCalculator {
	private String baseString;
	private String targetString;
	private List<Integer> listOfInsertions = new ArrayList<Integer>();

	public InsertionDistanceCalculator(String baseString, String targetString) {
		this.baseString = baseString;
		this.targetString = targetString;
		System.out.println(this.computeSubstringInsertionDistance(baseString, targetString));
	}

	public int computeSubstringInsertionDistance(String baseString, String targetString) {
		if (targetString.length() == 0)
			return baseString.length();

		if (baseString.equals(targetString) || baseString.contains(targetString))
			return 0;

		boolean atLeastOneCharMatch = true;
		for (char ch : targetString.toCharArray()) {
			if (baseString.indexOf(ch) != -1) {
				atLeastOneCharMatch = true;
				break;
			} else {
				atLeastOneCharMatch = false;
			}
		}
		if (!atLeastOneCharMatch)
			return targetString.length();

		for (int i = 0; i < this.baseString.length(); i++) {
			int insertions = 0;
			int teampi = i;
			for (int j = 0; j < this.targetString.length(); j++) {
				if (teampi == this.baseString.length()) {
					insertions += (this.targetString.length() - j);
					break;
				}
				if (this.computeSubstringInsertionDistance(Character.toString(this.baseString.charAt(teampi)),
						Character.toString(this.targetString.charAt(j))) == 0) {
					teampi++;
				} else
					insertions++;
			}
			this.listOfInsertions.add(insertions);
		}
		return this.findMin(this.listOfInsertions);
	}

	private int findMin(List<Integer> list) {
		List<Integer> sortedlist = new ArrayList<>(list);
		Collections.sort(sortedlist);
		return sortedlist.get(0);
	}
}
