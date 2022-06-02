package contest.weekly.w274;

public class CheckString {
    public static void main(String[] args) {
        checkString("a");
    }
    static boolean checkString(String s) {
        int b = s.indexOf('b');
        if (b == -1)
            return true;
        for (int i = b; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                return false;
            }
        }
        return true;
    }
}
