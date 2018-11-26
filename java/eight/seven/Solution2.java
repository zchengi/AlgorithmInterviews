package eight.seven;

/**
 * LeetCode 200. Number of Islands
 *
 * @author cheng
 *         2018/11/26 21:29
 */
public class Solution2 {
    public int numIslands(char[][] grid) {

        int n = grid.length;
        if (n == 0) {
            return 0;
        }
        int m = grid[0].length;
        int isLandCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    isLandCount++;
                    expandIsland(grid, i, j, n, m);
                }
            }
        }

        return isLandCount;
    }

    private void expandIsland(char[][] grid, int i, int j, int n, int m) {

        if (i < 0 || j < 0 || i > n - 1 || j > m - 1 || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        expandIsland(grid, i + 1, j, n, m);
        expandIsland(grid, i, j + 1, n, m);
        expandIsland(grid, i - 1, j, n, m);
        expandIsland(grid, i, j - 1, n, m);
    }

    public static void main(String[] args) {

        char grid1[][] = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println((new Solution2()).numIslands(grid1));


        char grid2[][] = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println((new Solution2()).numIslands(grid2));
    }
}
