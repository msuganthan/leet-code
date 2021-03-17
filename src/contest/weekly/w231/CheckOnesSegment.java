package contest.weekly.w231;

/**
 * Check if Binary String Has at Most One Segment of Ones
 *
 * Given a binary string s without leading zeros, return true if s contains at most
 * one contiguous segment of ones. Otherwise, return false.
 *
 * Input: s = "1001"
 * Output: false
 * Explanation: The ones do not form a contiguous segment.
 */
public class CheckOnesSegment {
    public static void main(String[] args) {
        System.out.println(Integer.parseInt("11", 2));
        new CheckOnesSegment().checkOnesSegment("1001");
    }

    public boolean checkOnesSegment(String s) {
        for (int i = 1, cnt10 = 0, cnt01 = 0; i < s.length(); i++) {
            if (s.charAt(i - 1) == '1' && s.charAt(i) == '0')
                cnt10 = 1;
            else if (cnt10 == 1 && s.charAt(i - 1) == '0' && s.charAt(i) == '1')
                return false;
        }
        return true;
    }
}
