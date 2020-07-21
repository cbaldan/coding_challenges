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

    /**
     * Found the fastest version of the algorithm on LeetCode and improved it to beat itself!
     * <p>
     * https://leetcode.com/submissions/detail/369521410/
     * 
     * @param nums array to be searched for triplets
     * @return List with triplets, or empty list
     */
    public static List<List<Integer>> threeSumFastest(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        int posNums = 0;
        int negNums = 0;
        int zeroNums = 0;

        for (int num : nums) {
            if (num < minVal)
                minVal = num;
            if (num > maxVal)
                maxVal = num;
            if (num == 0)
                zeroNums++;
            else if (num > 0)
                posNums++;
            else
                negNums++;
        }

        List<List<Integer>> result = new LinkedList<>();
        if (zeroNums >= 3) {
            result.add(Arrays.asList(0, 0, 0));
        }

        if (minVal >= 0 || maxVal <= 0)
            return result;
        if (maxVal + 2 * minVal > 0)
            maxVal = -2 * minVal;
        if (minVal + 2 * maxVal < 0)
            minVal = -2 * maxVal;
        int[] numMap = new int[maxVal - minVal + 1];
        int[] posNumMap = new int[posNums];
        int[] negNumMap = new int[negNums];
        posNums = 0;
        negNums = 0;
        for (int num : nums) {
            if (num >= minVal && num <= maxVal) {
                if (numMap[num - minVal]++ == 0) {
                    if (num > 0) {
                        posNumMap[posNums++] = num;
                    } else if (num < 0) {
                        negNumMap[negNums++] = num;
                    }
                }
            }
        }

        Arrays.parallelSort(posNumMap, 0, posNums);
        Arrays.parallelSort(negNumMap, 0, negNums);
        int posStart = 0;
        for (int i = negNums - 1; i >= 0; i--) {
            int nv = negNumMap[i];
            int minpv = (-nv) / 2;
            while (posStart < posNums && posNumMap[posStart] < minpv)
                posStart++;
            for (int j = posStart; j < posNums; j++) {
                int pv = posNumMap[j];
                int ln = 0 - nv - pv;
                if (ln >= nv && ln <= pv) {
                    if (numMap[ln - minVal] == 0)
                        continue;
                    else if (ln == nv && numMap[ln - minVal] > 1) {
                        result.add(Arrays.asList(nv, ln, pv));
                    } else if (ln == pv && numMap[ln - minVal] > 1) {
                        result.add(Arrays.asList(nv, ln, pv));
                    } else if (ln != nv && ln != pv) {
                        result.add(Arrays.asList(nv, ln, pv));
                    }
                } else if (ln < nv) {
                    break;
                }
            }
        }

        return result;
    }

}
