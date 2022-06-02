package array;

import java.util.Arrays;

public class LargestTriangle {
    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[]{2, 1, 2}));
    }

    public static int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int n = A.length - 1;
        //For a >= b >= c, a,b,c can form a triangle if a < b + c.
        for (int i = n; i > 0; i--)
            if (A[i] < A[i - 1] + A[i - 2])
                return A[i] + A[i - 1] + A[i - 2];
        return 0;
    }
}
