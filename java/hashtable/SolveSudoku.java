package hashtable;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * A sudoku solution must satisfy all of the following rules:
 *  Each of the digits 1-9 must occur exactly once in each row.
 *  Each of the digits 1-9 must occur exactly once in each column.
 *  Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 *
 *  The '.' character indicates empty cells.
 */
public class SolveSudoku {
    public static void main(String[] args) {

    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board) {
        int M = board.length;
        int N = board[0].length;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if (board[i][j] != '.')
                    continue;
                for(char c = '1'; c <= '9'; c++) {
                    if(isValid(board, i, j, c)) {
                        board[i][j] = c;

                        if(solve(board))
                            return true;
                        board[i][j] = '.';
                    }
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        int blkrow = (row / 3) * 3, blkcol = (col / 3) * 3; // Block no. is i/3, first element is i/3*3
        for (int i = 0; i < 9; i++)
            if (board[i][col] == num || board[row][i] == num ||
                    board[blkrow + i / 3][blkcol + i % 3] == num)
                return false;
        return true;
    }
}
