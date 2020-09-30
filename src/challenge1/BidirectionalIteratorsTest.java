package challenge1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BidirectionalIteratorsTest {
	public BidirectionalIterators[] biDirIt = new BidirectionalIterators[3];
	// FlattenedBidirectionalIterator flatBiDirIts = null;

	@BeforeEach
	void setUp() throws Exception {
		List<Integer> listOfIntegers1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
		List<Integer> listOfIntegers2 = new ArrayList<Integer>(Arrays.asList(4, 5));
		List<Integer> listOfIntegers3 = new ArrayList<Integer>(Arrays.asList(6, 7, 8));
		biDirIt[0] = new BidirectionalIterators(listOfIntegers1);
		biDirIt[1] = new BidirectionalIterators(listOfIntegers2);
		biDirIt[2] = new BidirectionalIterators(listOfIntegers3);
		// flatBiDirIts = new FlattenedBidirectionalIterator(biDirIt);
	}

	@Test
	void testNext() {
		assertEquals(biDirIt[0].next(), 1);
		assertEquals(biDirIt[0].next(), 2);
		assertEquals(biDirIt[0].next(), 3);
		assertEquals(biDirIt[0].next(), 1);
	}

	@Test
	void testHasNext() {
		assertTrue(biDirIt[0].hasNext());
		assertTrue(biDirIt[0].hasNext());
		assertTrue(biDirIt[0].hasNext());
		assertFalse(biDirIt[0].hasNext());
	}

	@Test
	void testPrevious() {
		assertEquals(biDirIt[0].previous(), 3);
		assertEquals(biDirIt[0].previous(), 2);
		assertEquals(biDirIt[0].previous(), 1);
		assertEquals(biDirIt[0].previous(), 3);
	}

	@Test
	void testHasPrevious() {
		assertFalse(biDirIt[0].hasPrevious());
		biDirIt[0].next();
		biDirIt[0].next();
		biDirIt[0].next();
		assertTrue(biDirIt[0].hasPrevious());
		assertTrue(biDirIt[0].hasPrevious());
		assertTrue(biDirIt[0].hasPrevious());
		assertFalse(biDirIt[0].hasPrevious());
	}

	@Test
	void testHasNextAndNext() {
		assertFalse(biDirIt[0].hasPrevious());
		biDirIt[0].next();
		biDirIt[0].next();
		biDirIt[0].next();
		assertTrue(biDirIt[0].hasPrevious());
		assertTrue(biDirIt[0].hasPrevious());
		assertTrue(biDirIt[0].hasPrevious());
		assertFalse(biDirIt[0].hasPrevious());
	}

}
