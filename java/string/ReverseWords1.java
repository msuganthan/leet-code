package string;

/**
 * 557. Reverse Words in a String III
 *
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 */

public class ReverseWords1 {

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        for(int j = 0; j < chars.length - 1; j++) {
            if(chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            }
        }
        reverse(chars, i, chars.length - 1);
        return new String(chars);
    }

    void reverse(char[] chars, int i, int j) {
        while(i < j) {
            char c = chars[i];
            chars[i++] = chars[j];
            chars[j--] = c;
        }
    }
}
