package daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Byin
 * @Description: 1466. 重新规划路线 middle
 * @DateTime: 2023/12/7 10:39
 **/

public class Q1466 {
    public static void main(String[] args) {
        int n = 6;
        int[][] connection = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        int ans = minReorder(n, connection);
        System.out.println(ans);
    }

    static int minReorder(int n, int[][] connections) {
        // 初始化二维数组列表
        List<int[]>[] res = new List[n];
        for (int i = 0; i < n; i++) {
            res[i] = new ArrayList<int[]>();
        }
        // 正向为1，反向为0
        for (int[] e : connections) {
            res[e[0]].add(new int[]{e[1], 1});
            res[e[1]].add(new int[]{e[0], 0});

        }
        // DFS遍历，由于是从0往下遍历，需统计所有边为1的路径（边的值为1说明从0往下为正向，需要重新规划）
        return DFS(0, -1, res);
    }

    static int DFS(int cur, int fa, List<int[]>[] res) {
        int ans = 0;
        for (int[] e : res[cur]) {
            if (e[0] == fa) {
                continue;
            }
            ans += e[1] + DFS(e[0], cur, res);
        }
        return ans;
    }
}
