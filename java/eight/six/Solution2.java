package eight.six;

/**
 * LeetCode 079. Word Search
 *
 * @author cheng
 *         2018/11/24 10:34
 */
public class Solution2 {

    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {

        visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j] && searchWord(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean searchWord(char[][] board, String word, int i, int j, int index) {

        if (index == word.length()) {
            return true;
        }

        if (i >= board.length || i < 0 || j >= board[i].length || j < 0
                || board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;
        if (searchWord(board, word, i + 1, j, index + 1)
                || searchWord(board, word, i - 1, j, index + 1)
                || searchWord(board, word, i, j + 1, index + 1)
                || searchWord(board, word, i, j - 1, index + 1)) {
            return true;
        }

        visited[i][j] = false;
        return false;
    }


    public static void main(String[] args) {

        char[][] board = {
                {'A', 'B', 'C', 'E' },
                {'S', 'F', 'C', 'S' },
                {'A', 'D', 'E', 'E' }
        };

        String word = "ABCCED";
        System.out.println(new Solution2().exist(board, word));

        word = "SEE";
        System.out.println(new Solution2().exist(board, word));

        word = "ABCB";
        System.out.println(new Solution2().exist(board, word));
    }
}