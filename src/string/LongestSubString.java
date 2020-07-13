package string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {

    public static void main(String[] args) {
        System.out.println(longestSubString("pwwke"));
    }

    static int longestSubString(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> characters = new HashSet<>();

        while (i < s.length()) {

            if (!characters.contains(s.charAt(i))) {
                characters.add(s.charAt(i++));
                max = Math.max(max, characters.size());
            } else
                /**
                 * delete from the head by using a slow pointer i until we can put character j to the hash set
                 */
                characters.remove(s.charAt(j++));


        }
        return max;
    }
}
