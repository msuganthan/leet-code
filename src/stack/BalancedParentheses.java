package stack;

public class BalancedParentheses {

    public static void main(String[] args) {
        minInsertions("))())(");
    }

    static int minInsertions(String s) {
        int res = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (right % 2 > 0) {
                    right--;
                    res++;
                }
                right += 2;
            } else {
                right--;
                if (right < 0) {
                    right += 2;
                    res++;
                }
            }
        }
        return right + res;
    }
}
