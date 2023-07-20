package slidingwindow;

/**
 * 995. Minimum Number of K Consecutive Bit Flips
 * ToDo: Suganthan must get back to this question later.
 */

public class MinBitFlips {
    public static void main(String[] args) {
        minBitFlips(new int[] {0, 1, 0}, 1);
    }

    static int minBitFlips(int[] A, int K) {
        int N = A.length;
        int[] hint = new int[N];
        int ans = 0, flip = 0;

        for (int i = 0; i < N; i++) {
            flip ^= hint[i];
            if (A[i] == flip) {
                ans++;
                if (i + K > N) return -1;
                flip ^= 1;
                if (i + K < N) hint[i + K] ^= 1;
            }
        }
        return ans;
    }
}
