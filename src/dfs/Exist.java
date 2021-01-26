package dfs;

public class Exist {
    public static void main(String[] args) {
        exist(new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        }, "ABCCED");
    }

    static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }

    static boolean exist(char[][] board, int i, int j, String word, int length) {
        if (length == word.length()) return true;

        if (i < 0 || j < 0 || i == board.length || j == board[0].length)
            return false;

        if (word.charAt(length) != board[i][j])
            return false;

        char temp = board[i][j];
        board[i][j] = ' ';

        boolean exists = exist(board, i + 1, j, word, length + 1)
                            || exist(board, i - 1, j, word, length + 1)
                            || exist(board, i, j + 1, word, length + 1)
                            || exist(board, i, j - 1, word, length + 1);
        board[i][j] = temp;
        return exists;
    }
}
