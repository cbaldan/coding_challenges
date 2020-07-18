package interview.bigcompanyN;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Date: 07/16/2020
 * 
 * @author Cleber Baldan Junior
 */
public class FindSumPair {

	/**
	 * Given an input {@code int[] a}, return the count of unique pairs that summed
	 * are equal to {@code k}.
	 * 
	 * @param k integer which the pairs have to sum equals to
	 * @param a array of integers
	 * @return the count of unique pairs
	 */
	public static int countPairsWithSum(int k, int[] a) {

		int count = 0;
		Set<Integer> seenNumbersSet = new HashSet<>();

		System.out.println(String.format("Input set: %s\nk: %s", Arrays.toString(a), k));

		Arrays.parallelSort(a);

		for (int i = 0; i + 1 < a.length && a[i] + a[i + 1] <= k; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] + a[j] > k) {
					break;
				} else if (a[i] + a[j] == k) {
					boolean neverSeen = seenNumbersSet.add(a[i]);

					if (neverSeen) {
						count++;
						System.out.println(a[i] + ":" + a[j]);
					}
				}
			}
		}

		System.out.println(String.format("Count: %s\n", count));
		return count;
	}
}
