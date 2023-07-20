package stack;

public class MaxDepth {
    public int maxDepth(String s) {
        int res = 0, cur = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                cur++;
                res = Math.max(res, cur);
            }
            if(s.charAt(i) == ')') {
                cur--;
            }
        }
        return res;
    }

    /**
     *     def maxDepth(self, s: str) -> int:
     *         res = cur = 0
     *
     *         for c in s:
     *             if c == '(':
     *                 cur += 1
     *                 res = max(res, cur)
     *             if c == ')':
     *                 cur -= 1
     *
     *         return res
     */

    /**
     * func maxDepth(str string) int {
     *     res := 0
     *     cur := 0
     *     for _, c := range str {
     *         if c == '(' {
     *             cur++;
     *             if (cur > res) {
     *                 res = cur;
     *             }
     *         }
     *         if c == ')' {
     *             cur--;
     *         }
     *     }
     *     return res
     * }
     */
}
