package slidingWindow;

public class LongestSubString {
    public static void main(String[] args) {
        System.out.println(longestSubstring("aaabb", 3));
    }

    static int longestSubstring(String s, int k) {
        return longestSubString(s, 0, s.length(), k);
    }

    static int longestSubString(String s, int start, int end, int K) {
        if(end < K) return 0;

        char[] chars = s.toCharArray();
        int[] countMap = new int[26];
        for(int i = start; i < end; i++)
            countMap[chars[i] - 'a']++;

        for(int mid = start; mid < end; mid++) {
            if(countMap[chars[mid] - 'a'] >= K) continue;

            int midNext = mid + 1;
            while(midNext < end && countMap[chars[midNext] - 'a'] < K)
                midNext++;

            return Math.max(longestSubString(s, start, mid, K), longestSubString(s, midNext, end, K));
        }
        return end - start;
    }
}
