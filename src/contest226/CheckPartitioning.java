package contest226;

public class CheckPartitioning {
    //ToDo: Sugan, Comeback to this later
    public static void main(String[] args) {
        checkPartitioning("abcbdd");
    }

    static boolean checkPartitioning(String s) {
        char[] A = s.toCharArray();
        int N = s.length();
        boolean[][] dp = new boolean[N][N];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i; j < N; j++) {
                if (A[i] == A[j])
                    dp[i][j] = (i + 1 <= j - 1) ? dp[i + 1][j - 1] : true;
                else
                    dp[i][j] = false;
            }
        }
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (dp[0][i - 1] && dp[i][j] && dp[j + 1][N - 1])
                    return true;
            }
        }
        return false;
    }
}
