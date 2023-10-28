package string;

/**
 * https://leetcode.com/problems/length-of-last-word/description/
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int count = 0;
        boolean foundWord = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && foundWord) {
                break;
            }
            if (s.charAt(i) == ' ') {
                continue;
            }
            foundWord = true;
            count++;
        }
        return count;
    }
}
