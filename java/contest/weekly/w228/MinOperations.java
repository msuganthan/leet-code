package contest.weekly.w228;

/**
 * Minimum Changes To Make Alternating Binary String
 */
public class MinOperations {
    public static void main(String[] args) {
        System.out.println(minOperations("10010100"));
    }
    static public int minOperations(String s) {
        char[] chars = s.toCharArray();
        char firstIndex = chars[0];
        int count0 = 0, count1 = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i % 2 != 0 && chars[i] == firstIndex)
                count0++;
            if (i % 2 == 0 && chars[i] != firstIndex)
                count0++;

            if (i % 2 != 0 && chars[i] != firstIndex)
                count1++;
            if (i % 2 == 0 && chars[i] == firstIndex)
                count1++;
        }

        return Math.min(count0, count1);
    }
}
