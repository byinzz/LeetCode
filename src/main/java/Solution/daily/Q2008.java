package Solution.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Byin
 * @Description: 2008. 出租车的最大盈利 medium
 * @DateTime: 2023/12/8 9:16
 **/

public class Q2008 {
    public static void main(String[] args) {
        int n = 20;
        int[][] rides = {{1, 6, 1}, {3, 10, 2}, {10, 12, 3}, {11, 12, 2}, {12, 15, 2}, {13, 18, 1}};
        long ans = maxTaxiEarnings(n, rides);
        System.out.println(ans);
    }

    public static long maxTaxiEarnings(int n, int[][] rides) {
        // 按照下车点位置将rides归类
        List<int[]>[] groups = new ArrayList[n + 1];
        for (int[] e : rides) {
            int start = e[0], end = e[1], tip = e[2];
            if (groups[end] == null) {
                groups[end] = new ArrayList<>();
            }
            groups[end].add(new int[]{start, end - start + tip});
        }
        // res数组用来存储枚举下车点最大收益
        long[] res = new long[n + 1];
        for (int i = 2; i <= n; i++) {
            // 暂存上一站点的收益进行比较
            res[i] = res[i - 1];
            if (groups[i] != null) {
                for (int[] e : groups[i]) {
                    // 比较i下车与i-1下车的收益
                    res[i] = Math.max(res[i], res[e[0]] + e[1]);
                }
            }
        }

        return res[n];
    }
}
