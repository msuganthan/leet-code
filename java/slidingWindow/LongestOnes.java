package slidingWindow;

/**
 * 1004. Max Consecutive Ones III
 */
public class LongestOnes {
    public static void main(String[] args) {

    }

    static int longestOnes(int[] A, int K) {
        int answer = 0;
        int zeroCount = 0;
        int start = 0;
        int N = A.length;

        for (int end = 0; end < N; end++) {
            if (A[0] == 0)
                zeroCount++;

            if (zeroCount > K) {
                if (A[start] == 0)
                    zeroCount--;
                start++;
            }
            answer = Math.max(answer, end - start + 1);
        }
        return answer;
    }
}
