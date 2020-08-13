package array;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {

    public static void main(String[] args) {
        longestSubString("pwwkew");
    }

    static int longestSubString(String s) {
        int i = 0;
        int j = 0;
        int max = 0;

        Set<Character> characters = new HashSet<>();
        while (i < s.length()) {
            if(!characters.contains(s.charAt(i))) {
                characters.add(s.charAt(i++));
                max = Math.max(max, characters.size());
            } else
                characters.remove(s.charAt(j++));
        }
        return max;
    }
}
