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

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int N = s.length();
        int i = 0;
        int j = i;
        for(; i < N; i++) {
            if (s.charAt(i) == ' ') {
                sb.append(reverseWords(s, j, i - 1));
                sb.append(' ');
                j = i + 1;
            }
        }
        sb.append(reverseWords(s, j, i - 1));
        return sb.toString();
    }

    public static String reverseWords(String s, int first, int last) {
        StringBuilder sb = new StringBuilder();
        while (first <= last) {
            sb.append(s.charAt(last--));
        }
        return sb.toString();
    }

    /**
     * This is extremely fast
     */
    public String reverseWordsImpr(String s) {
        int len = s.length();
        char[] chArray = s.toCharArray();
        int lastSpaceIndex = -1;
        for (int strIndex = 0; strIndex <= len; strIndex++) {
            if (strIndex == len || chArray[strIndex] == ' ') {
                int startIndex = lastSpaceIndex + 1;
                int endIndex = strIndex - 1;
                while(startIndex < endIndex) {
                    char temp = chArray[startIndex];
                    chArray[startIndex] = chArray[endIndex];
                    chArray[endIndex] = temp;
                    startIndex++;
                    endIndex--;
                }
                lastSpaceIndex = strIndex;
            }
        }
        return new String(chArray);
    }
}
