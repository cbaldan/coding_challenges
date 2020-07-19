package coding.website.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 * 
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the sum
 * of zero. Note: The solution set must not contain duplicate triplets.
 * 
 * Example: Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 * 
 * @author Cleber
 */
public class ThreeSumSolution {

	public static List<List<Integer>> threeSum(int[] nums) {
		return threeSum(nums, 0);
	}

	public static List<List<Integer>> threeSum(int[] nums, final int targetSum) {
		Arrays.parallelSort(nums);

		List<List<Integer>> result = new LinkedList<>();

		for (int i = 0; i < nums.length; i++) {
			int j = i + 1;
			int k = nums.length - 1;

			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			while (j < k) {
				if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
					k--;
					continue;
				}

				if (nums[i] + nums[j] + nums[k] > targetSum) {
					k--;
				} else if (nums[i] + nums[j] + nums[k] < targetSum) {
					j++;
				} else {
					result.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
					k--;
				}
			}
		}

		return result;
	}

}
