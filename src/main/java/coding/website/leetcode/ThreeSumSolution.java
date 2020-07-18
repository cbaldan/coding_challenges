package coding.website.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 * 
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *     [-1, -1, 2]
 * ]
 * 
 * @author Cleber
 */
public class ThreeSumSolution {
	
	public static List<List<Integer>> threeSum(int[] nums) {

		Arrays.sort(nums);

		List<List<Integer>> resultList = new LinkedList<>();
		HashSet<Integer> startingNumber = new HashSet<>();

		if (nums.length >= 3) {
			for (int i = 0; i < nums.length; i++) {
				
				System.out.println(i);

				boolean added = startingNumber.add(nums[i]);
				if (!added)
					continue;

				for (int j = i + 1; j < nums.length; j++) {

					for (int k = j + 1; k < nums.length; k++) {
						if ((nums[i] + nums[j] + nums[k]) == 0) {

							List<Integer> newResult = new ArrayList<>(3);
							newResult.add(nums[i]);
							newResult.add(nums[j]);
							newResult.add(nums[k]);

							boolean addNewResult = true;
							for (int l = 0; l < resultList.size(); l++) {
								List<Integer> result = resultList.get(l);
								if (result.equals(newResult)) {
									addNewResult = false;
									break;
								}
							}

							if (addNewResult) {
								resultList.add(newResult);
							}
						}
					}
				}
			}
		}

		return resultList;
	}

}
