package eight.six;

/**
 * LeetCode 079. Word Search
 *
 * @author cheng
 *         2018/11/24 9:57
 */
public class Solution1 {

    // 偏移量，偏移顺序：上，右，下，左
    private final int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private boolean[][] visited;
    private int m, n;

    public boolean exist(char[][] board, String word) {

        m = board.length;
        if (m > 0) {
            n = board[0].length;
        }

        visited = new boolean[m][n];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (searchWorld(board, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 从 board[startX][startY] 开始，寻找 word[index...word.length - 1];
     */
    private boolean searchWorld(char[][] board, String word, int index, int startX, int startY) {

        if (index == word.length() - 1) {
            return board[startX][startY] == word.charAt(index);
        }

        if (board[startX][startY] == word.charAt(index)) {
            visited[startX][startY] = true;

            // 从 startX, startY 出发，向四个方向寻找
            for (int i = 0; i < 4; i++) {

                int newX = startX + d[i][0];
                int newY = startY + d[i][1];

                if (inArea(newX, newY) && !visited[newX][newY]) {
                    if (searchWorld(board, word, index + 1, newX, newY)) {
                        return true;
                    }
                }
            }
            visited[startX][startY] = false;
        }

        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 & y < n;
    }

    public static void main(String[] args) {

        char[][] board = {
                {'A', 'B', 'C', 'E' },
                {'S', 'F', 'C', 'S' },
                {'A', 'D', 'E', 'E' }
        };

        String word = "ABCCED";
        System.out.println(new Solution1().exist(board, word));

        word = "SEE";
        System.out.println(new Solution1().exist(board, word));

        word = "ABCB";
        System.out.println(new Solution1().exist(board, word));
    }
}