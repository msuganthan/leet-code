package biweek43;

import java.util.Stack;

public class MaximumGain {
    public static void main(String[] args) {
        maximumGain("cdbcbbaaabab", 4, 5);
    }

    static int maximumGain(String s, int x, int y) {
        Stack<Character> baStack = new Stack<>();
        Stack<Character> abStack = new Stack<>();

        int answer = 0;
        int N = s.length();
        int i = 0;

        while (i < N) {
            if (s.charAt(i) == 'b' & !baStack.isEmpty() && baStack.peek() == 'a') {
                i++;
                baStack.pop();
                answer += y;
                continue;
            }
            baStack.push(s.charAt(i++));
        }
        System.out.println("answer ==> "+answer);
        return answer;
    }
}
