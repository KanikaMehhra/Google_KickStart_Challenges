package challenge2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSubstringInsertion {
	InsertionDistanceCalculator calculate = null;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test1() {
		String baseString = "(((())))";
		String targetString = "(()(()(";
		calculate = new InsertionDistanceCalculator(baseString, targetString);
		assertEquals(calculate.computeSubstringInsertionDistance(baseString, targetString), 2);
	}

	@Test
	void test2() {
		String baseString = "abcdefg";
		String targetString = "acfg";
		calculate = new InsertionDistanceCalculator(baseString, targetString);
		assertEquals(calculate.computeSubstringInsertionDistance(baseString, targetString), 2);
	}

	@Test
	void test3() {
		String baseString = "abcdefg";
		String targetString = "abcdefg";
		calculate = new InsertionDistanceCalculator(baseString, targetString);
		assertEquals(calculate.computeSubstringInsertionDistance(baseString, targetString), 0);
	}

	@Test
	void test4() {
		String baseString = "abcdefg";
		String targetString = "ef";
		calculate = new InsertionDistanceCalculator(baseString, targetString);
		assertEquals(calculate.computeSubstringInsertionDistance(baseString, targetString), 0);
	}

}
