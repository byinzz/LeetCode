package Solution.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Byin
 * @Description: 1466. 重新规划路线 middle
 * @DateTime: 2023/12/7 9:12
 **/

public class Q1466 {

    public static void main(String[] args) {
        int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        int n = 6;
        int ans = minReorder(n, connections);
        System.out.println(ans);
    }

    public static int minReorder(int n, int[][] connections) {

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
        // dfs遍历统计所有正向为1的边（因为是从0往下遍历，答案需要的是其他顶点到0）
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
