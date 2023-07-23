package stack;

import java.util.Stack;

/**
 * 2390. Removing Stars From a String
 *
 * You are given a string s, which contains stars *.
 *
 * In one operation, you can:
 *
 * Choose a star in s.
 * Remove the closest non-star character to its left, as well as remove the star itself.
 * Return the string after all stars have been removed.
 *
 * Note:
 *
 * The input will be generated such that the operation is always possible.
 * It can be shown that the resulting string will always be unique.
 */
public class RemoveStars {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '*') {
                stack.pop();
                continue;
            }
            stack.add(c);
        }
        int n = stack.size();
        char[] result = new char[n];
        while(n > 0) {
            result[--n] = stack.pop();
        }
        return new String(result);
    }

    /**
     * class Solution:
     *     def removeStars(self, s: str) -> str:
     *         stack = []
     *         for c in s:
     *             if c == '*':
     *                 stack.pop()
     *             else:
     *                 stack.append(c)
     *         return ''.join(stack)
     */

    /**
     * func removeStars(s string) string {
     *     stack := []rune{}
     *     for _, c := range s {
     *         if c == '*' {
     *             stack = stack[:len(stack) - 1]
     *         } else {
     *             stack = append(stack, c)
     *         }
     *     }
     *     return string(stack)
     * }
     */
}
