package slidingwindow;

/**
 * 978. Longest Turbulent Subarray
 */
public class MaxTurbulenceSize {
    public static void main(String[] args) {
        maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9});
    }

    static int maxTurbulenceSize(int[] A) {
        int answer = 1;
        int anchor = 0;
        int N = A.length;
        for (int i = 1; i < N; i++) {
            int c = Integer.compare(A[i - 1], A[i]);
            if (c == 0)
                anchor = i;
            else if (i == N - 1 || c * Integer.compare(A[i], A[i + 1]) != -1) {
                answer = Math.max(answer, i - anchor + 1);
                anchor = i;
            }
        }
        return answer;
    }
}
