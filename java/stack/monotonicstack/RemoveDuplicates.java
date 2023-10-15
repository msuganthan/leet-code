package stack.monotonicstack;

import java.util.Stack;

public class RemoveDuplicates {

    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        boolean[] visited = new boolean[26];
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for(char c: chars) {
            count[c - 'a']++;
        }
        for(char c: chars) {
            int index = c - 'a';
            count[index]--;
            if(visited[index]) {
                continue;
            }
            while(!stack.isEmpty() && count[stack.peek() - 'a'] > 0 && c < stack.peek()) {
                visited[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            visited[index] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
