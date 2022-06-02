package contest.weekly.w274;

public class NumberOfBeams {
    public static void main(String[] args) {
        numberOfBeams(new String[]{"011001","000000","010100","001000"});
    }
    static int numberOfBeams(String[] bank) {
        int cnt = 0, prev = 0;
        for (String devs: bank) {
            int current = 0;
            for (int i = 0; i < devs.length(); i++) {
                current += devs.charAt(i) == '1' ? 1 : 0;
            }
            cnt += prev * current;
            if (current > 0) {
                prev = current;
            }
        }
        return cnt;
    }
}
