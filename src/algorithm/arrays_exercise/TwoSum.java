package algorithm.arrays_exercise;

import java.util.Arrays;

/**
 * Created by sunnyDay on 2019/12/31 17:15
 * 两数和
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1]
 */
public class TwoSum {
    private static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = nums[i];
                if (temp + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4, 6};
        System.out.println(Arrays.toString(twoSum(nums, 10)));
    }
}
