package contest.weekly.w227;

public class LargestMerge {
    public static void main(String[] args) {

    }

    static String largestMerge(String word1, String word2) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() && j < word2.length()) {
            if (word1.charAt(i) > word2.charAt(j))
                stringBuilder.append(word1.charAt(i++));
            else if (word2.charAt(j) > word1.charAt(i)) {
                stringBuilder.append(word2.charAt(j++));
            } else {
                if (word1.substring(i).compareTo(word2.substring(j)) > 0)
                    stringBuilder.append(word1.charAt(i++));
                else
                    stringBuilder.append(word2.charAt(j++));
            }
        }
        while (i < word1.length())
            stringBuilder.append(word1.charAt(i++));
        while (j < word2.length())
            stringBuilder.append(word2.charAt(j++));
        return stringBuilder.toString();
    }
}
