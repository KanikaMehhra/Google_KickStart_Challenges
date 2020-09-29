package challenge1;

import java.util.List;
import java.util.ListIterator;

public abstract class AbstractBidirectionalIterators implements IBidirectionalIterators {
	private ListIterator<Integer> listItr = null;

	public AbstractBidirectionalIterators(List<Integer> listOfIntegers) {
		this.listItr = listOfIntegers.listIterator();
	}

	@Override
	public int next() {
		if (!this.listItr.hasNext()) {
			while (this.listItr.hasPrevious()) {
				this.listItr.previous();
			}
		}
		return this.listItr.next();
	};

	@Override
	public boolean hasNext() {
		while (this.listItr.hasNext()) {
			this.listItr.next();
			return true;
		}
		return false;
	};

	@Override
	public int previous() {
		if (!this.listItr.hasPrevious()) {
			while (this.listItr.hasNext()) {
				this.listItr.next();
			}
		}
		return this.listItr.previous();
	};

	@Override
	public boolean hasPrevious() {
		while (this.listItr.hasPrevious()) {
			this.listItr.previous();
			return true;
		}
		return false;
	};
}
