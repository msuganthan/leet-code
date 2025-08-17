package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, HashSet<Character>> rowMap = new HashMap<>();
        Map<Integer, HashSet<Character>> colMap = new HashMap<>();
        Map<String, HashSet<Character>> squareMap = new HashMap<>();

        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) {
                if (board[r][c] == '.') {
                    continue;
                }

                String squareKey = r / 3 + "," + c / 3;

                rowMap.computeIfAbsent(r, k -> new HashSet<>());
                colMap.computeIfAbsent(c, k -> new HashSet<>());
                squareMap.computeIfAbsent(squareKey, k -> new HashSet<>());

                if(rowMap.get(r).contains(board[r][c])
                        || colMap.get(c).contains(board[r][c])
                        || squareMap.get(squareKey).contains(board[r][c])) {
                    return false;
                }

                rowMap.get(r).add(board[r][c]);
                colMap.get(c).add(board[r][c]);
                squareMap.get(squareKey).add(board[r][c]);
            }
        }
        return true;
    }
}
