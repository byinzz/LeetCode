package Solution.daily;

/**
 * @Author: Byin
 * @Description: 1631. 最小体力消耗路径 medium
 * @DateTime: 2023/12/11 9:19
 **/

public class Q1631 {
    public static void main(String[] args) {
        int[][] heights = {{1, 100000}};
        int ans = minimumEffortPath(heights);
        System.out.println(ans);

    }

    //二分查找+DFS
    public static int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] visited = new boolean[m][n];

        int left = 0, right = (int) Math.pow(10, 6); // 设置初始二分搜索边界

        while (left < right) {
            int mid = left + (right - left) / 2;
            // 查询每条路径的最大体力值，二分查找逐渐逼近最小的体力消耗值
            if (canReach(heights, visited, 0, 0, m, n, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
            // 重置visited数组
            visited = new boolean[m][n];
        }

        return left;
    }

    static boolean canReach(int[][] heights, boolean[][] visited, int i, int j, int m, int n, int maxEffort) {
        if (i == m - 1 && j == n - 1) {
            return true;
        }
        visited[i][j] = true;

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj]) {
                int effort = Math.abs(heights[i][j] - heights[ni][nj]);
                if (effort <= maxEffort) {
                    if (canReach(heights, visited, ni, nj, m, n, maxEffort)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
