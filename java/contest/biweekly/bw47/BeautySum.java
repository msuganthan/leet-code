package contest.biweekly.bw47;

/**
 * Sum of Beauty of All Substrings
 * <p>
 * The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.
 * <p>
 * For example, the beauty of "abaacc" is 3 - 1 = 2.
 * Given a string s, return the sum of beauty of all of its substrings.
 * <p>
 * Input: s = "aabcb"
 * Output: 5
 * Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.
 */
public class BeautySum {
    public static void main(String[] args) {

    }

    public int beautySum(String s) {
        int answer = 0;
        char[] chars = s.toCharArray();
        int N = s.length();
        int[] count = new int[26];

        for (int i = N - 1; i >= 0; i--) {
            if (N - 1 - i == 2) continue;
            for (int j = i; j < N; j++) {
                count[chars[j] - 'a']++;
                if (j - i >= 2)
                    answer += beautyCount(count);
            }
            count = new int[26];
        }
        return answer;
    }

    int beautyCount(int[] count) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int c : count) {
            if (c == 0) continue; // skip 0s
            min = Math.min(min, c);
            max = Math.max(max, c);
        }

        return max - min;
    }
}
