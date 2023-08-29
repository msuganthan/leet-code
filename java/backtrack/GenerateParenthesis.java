package backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        backTrack(answer, "", 0, 0, n);
        return answer;
    }

    void backTrack(List<String> list, String str, int open, int close, int max) {
        if (str.length() == max) {
            list.add(str);
            return;
        }
        if (open < max) {
            backTrack(list, str+"(", open + 1, close, max);
        }
        if (close < open) {
            backTrack(list, str+")", open, close + 1, max);
        }
    }
}
