package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {
    public static void main(String[] args) {
        minWindow("ADOBECODEBANC", "ABC");
    }

    static String minWindow(String s, String t) {
        int formed = 0;
        int[] ans = {-1, 0, 0}; //size, left, right
        int r = 0;
        int l = 0;
        Map<Character, Integer> dictT = new HashMap<>();
        char[] tChar = t.toCharArray();
        for (int i = 0; i < tChar.length; i++)
            dictT.put(tChar[i], dictT.getOrDefault(tChar[i], 0) + 1);

        Map<Character, Integer> windowCounts = new HashMap<>();
        int requiredSize = dictT.size();
        while (r < s.length()) {
            char c = s.charAt(r);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue())
                formed++;

            while (l <= r && formed == requiredSize) {
                c = s.charAt(l);
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue())
                    formed--;
                l++;
            }
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
