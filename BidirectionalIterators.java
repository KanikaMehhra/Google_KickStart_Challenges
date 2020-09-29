package challenge1;

import java.util.ArrayList;
import java.util.List;

public class BidirectionalIterators extends AbstractBidirectionalIterators {
	private List<Integer> listOfIntegers = new ArrayList<Integer>();

	public BidirectionalIterators(List<Integer> listOfIntegers) {
		super(listOfIntegers);
		this.listOfIntegers = listOfIntegers;
	}

	public int getListLength() {
		return this.listOfIntegers.size();
	}
}
