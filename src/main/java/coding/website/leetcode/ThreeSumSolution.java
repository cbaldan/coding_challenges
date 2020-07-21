package coding.website.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 * 
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array
 * which gives the sum of zero. Note: The solution set must not contain duplicate triplets.
 * 
 * Example: Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 * 
 * @author Cleber Baldan Junior
 */
public class ThreeSumSolution {

    /**
     * Returns a list of unique triplets that sum to {@code targetSum}.
     * <p>
     * This is a generic version of the common 3Sum problem, which accepts any value as target sum. It's a little slower than the specialist
     * version, but still performs very fast.
     * 
     * @param nums      array of integers to be searched for triplets
     * @param targetSum sum to which the triplets must match
     * @return a list with the triplets, or an empty list, if no triplets are found.
     */
    public static List<List<Integer>> threeSumWithGenericTarget(int[] nums, final int targetSum) {
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

    /**
     * Returns a list of unique triplets that sum to {@code targetSum}.
     * <p>
     * This is a specialist version of the common 3Sum problem, which always the target sum as 0.
     * <p>
     * Top 0.1% solution as of 07/21/2020: https://leetcode.com/submissions/detail/369495430/
     * 
     * @param nums      array of integers to be searched for triplets
     * @param targetSum sum to which the triplets must match
     * @return a list with the triplets, or an empty list, if no triplets are found.
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.parallelSort(nums);

        for (int i = 0, sumComplement; i < nums.length - 2; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i - 1] == nums[i])
                continue;

            sumComplement = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[right] < 0) {
                    break;
                } else if (nums[left] + nums[right] == sumComplement) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    if (nums[left] == nums[left + 1]) {
                        while (left < right && nums[left] == nums[left + 1])
                            left++;
                    }
                    left++;
                    if (nums[right] == nums[right - 1]) {
                        while (left < right && nums[right] == nums[right - 1])
                            right--;
                    }
                    right--;
                } else if (nums[left] + nums[right] > sumComplement) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return res;
    }

}
