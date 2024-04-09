package Solution.daily;

/**
 * @Author: Byin
 * @Description: 2529. 正整数和负整数的最大计数
 * @DateTime: 2024/4/9 14:12
 **/

public class Q2529 {

    public static void main(String[] args) {
        int[] nums = {-3, -2, -1, 0, 0, 1, 2};
        int ans = maximumCount(nums);
        System.out.println(ans);
    }

    public static int maximumCount(int[] nums) {
        int pos1 = lowerBound(nums, 0);
        int pos2 = lowerBound(nums, 1);
        return Math.max(pos1, nums.length - pos2);
    }

    public static int lowerBound(int[] nums, int val) {
        int left = 0, right = nums.length;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] >= val) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }
}
