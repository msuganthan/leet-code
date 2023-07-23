package twopointers;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i;
        int j;
        for(i = 0, j = 0; i < s.length() && j < t.length(); ) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    /**
     *     def isSubsequence(self, s: str, t: str) -> bool:
     *         i, j = 0, 0
     *         while i < len(s) and j < len(t):
     *             if s[i] == t[j]:
     *                 i += 1
     *             j += 1
     *         return i == len(s)
     */

    /**
     * func isSubsequence(s string, t string) bool {
     *     i, j := 0, 0
     *     for i < len(s) && j < len(t) {
     *         if s[i] == t[j] {
     *             i++;
     *         }
     *         j++;
     *     }
     *     return i == len(s)
     * }
     */
}
