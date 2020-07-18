package interview.bigcompanyN;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import interview.bigcompanyN.FindSumPair;

public class FindSumPairTest {

	@Test
	public void countPairTestOne() {
		int k = 0;
		int[] a = { 0, 0 };
		int expectedCount = 1;

		int count = FindSumPair.countPairsWithSum(k, a);
		assertEquals(expectedCount, count);
	}

	@Test
	public void countPairTestOneTwo() {
		int k = 0;
		int[] a = { -1, +1 };
		int expectedCount = 1;

		int count = FindSumPair.countPairsWithSum(k, a);
		assertEquals(expectedCount, count);
	}

	@Test
	public void countPairTestSimpleCase() {
		int k = 12;
		int[] a = { 7, 15, 9, 10, 2, 1, 5, 2, 6, 11, 6 };
		int expectedCount = 4;

		int count = FindSumPair.countPairsWithSum(k, a);
		assertEquals(expectedCount, count);
	}

	@Test
	public void countPairTestLargerNumbers() {
		int k = 5931;
		int[] a = { 5660, 3641, 5775, 5543, 5701, 156, 4357, 5278, 388, 271, 1999, 5125, 653, 485, 230, 5446 };
		int expectedCount = 6;

		int count = FindSumPair.countPairsWithSum(k, a);
		assertEquals(expectedCount, count);
	}

	@Test
	public void countPairTestZeroPairs() {
		int k = 0;
		int[] a = { 0, 1 };
		int expectedCount = 0;

		int count = FindSumPair.countPairsWithSum(k, a);
		assertEquals(expectedCount, count);
	}

	@Test
	public void countPairTestZeroPairsTwo() {
		int k = 0;
		int[] a = { 0, 1, 2, 3, 4, 5 };
		int expectedCount = 0;

		int count = FindSumPair.countPairsWithSum(k, a);
		assertEquals(expectedCount, count);
	}

}
