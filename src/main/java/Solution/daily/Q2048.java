package Solution.daily;

/**
 * @Author: Byin
 * @Description: 2048. 下一个更大的数值平衡数 medium
 * @DateTime: 2023/12/10 21:46
 **/

public class Q2048 {
    public static void main(String[] args) {
        int n = 3000;
        int ans = nextBeautifulNumber(n);
        System.out.println(ans);
    }

    public static int nextBeautifulNumber(int n) {
        for (int i = n + 1; i <= 1224444; i++) {
            if (isBeautiful(i)) {
                return i;
            }
        }
        return -1;
    }

    public static Boolean isBeautiful(int n) {
        int[] count = new int[10];
        while (n > 0) {
            count[n % 10]++;
            n /= 10;
        }
        for (int i = 0; i < 10; i++) {
            if (count[i] > 0 && count[i] != i) {
                return false;
            }
        }
        return true;
    }
}
