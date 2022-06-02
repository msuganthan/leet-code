package stack;

import java.util.Stack;

public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }

    static String removeDuplicateLetters(String str) {
        int[] result = new int[26]; //contains the number of occurences of character (i + 'a')
        boolean[] visited = new boolean[26]; // will contain if character (i + 'a') is prerent in current result
        char[] chars = str.toCharArray();

        for (char c : chars)
            result[c - 'a']++;

        Stack<Character> stack = new Stack<>();
        int index;
        for (char c : chars) {
            index = c - 'a';
            result[index]--;

            if (visited[index])
                continue;

            while (!stack.isEmpty() && c < stack.peek() && result[stack.peek() - 'a'] != 0)
                visited[stack.pop() - 'a'] = false;

            stack.push(c);
            visited[index] = true;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty())
            stringBuilder.insert(0, stack.pop());

        return stringBuilder.toString();
    }
}
