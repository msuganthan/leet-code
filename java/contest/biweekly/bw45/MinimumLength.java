package contest.biweekly.bw45;

public class MinimumLength {

    public static void main(String[] args) {
        System.out.println(minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb"));
    }

    static int minimumLength(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r && s.charAt(l) == s.charAt(r)) {
            char ch = s.charAt(l);
            while(l <= r && s.charAt(l) == ch)
                l++;
            while(r >= l && s.charAt(r) == ch)
                r--;
        }

        return l > r ? 0 : r - l + 1;
    }
}
