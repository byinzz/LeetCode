package Solution.daily;

import java.util.Arrays;

/**
 * @Author: Byin
 * @Description: 2454. 下一个更大元素 IV Hard
 * @DateTime: 2023/12/12 9:06
 **/

public class Q2454 {
    public static void main(String[] args) {
        int[] nums = {2, 4, 0, 9, 6};
        int[] ans = secondGreaterElement(nums);
        System.out.println(Arrays.toString(ans));

    }

    // 枚举超时
    public static int[] secondGreaterElement1(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (res[i] > -3) {
                    if (nums[j] > nums[i]) {
                        res[i]--;
                    }
                }
                if (res[i] == -3) {
                    res[i] = nums[j];
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (res[i] < 0) {
                res[i] = -1;
            }
        }
        return res;
    }

    public static int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        return ans;
    }
}
