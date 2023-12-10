package Solution.daily;

/**
 * @Author: Byin
 * @Description: 70. 爬楼梯 easy
 * @DateTime: 2023/12/10 21:37
 **/

public class Q70 {
    public static void main(String[] args) {
        int n = 45;
        int ans = climbStairs(n);
        System.out.println(ans);
    }

    public static int climbStairs(int n) {
        int f1 = 1, f2 = 2;
        int ans = 0;
        if (n <= 2) {
            return n;
        }
        for (int i = 3; i <= n; i++) {
            ans = f1 + f2;
            f1 = f2;
            f2 = ans;
        }
        return ans;
    }
}
