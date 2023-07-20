package slidingwindow;

public class MaxConsective111s {

    public static void main(String[] args) {
        longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2);
    }

    static int longestOnes(int[] A, int K) {
        int i = 0;
        int j = 0;
        while (i < A.length) {
            if (A[i] == 0)
                K--;
            if (K < 0) {
                if (A[j] == 0)
                    K++;
                j++;
            }
            i++;
        }
        return i - j;
    }
}
