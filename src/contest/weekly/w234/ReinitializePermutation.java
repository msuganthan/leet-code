package contest.weekly.w234;

import java.util.Arrays;

/**
 * 5715. Minimum Number of Operations to Reinitialize a Permutation
 *
 * You are given an even integer n. You initially have a permutation perm of size n where perm[i] == i (0-indexed).
 *
 * In one operation, you will create a new array arr, and for each i:
 *
 *  If i % 2 == 0, then arr[i] = perm[i / 2].
 *  If i % 2 == 1, then arr[i] = perm[n / 2 + (i - 1) / 2].
 *
 *  You will then assign arr to perm.
 *
 *  Return the minimum non-zero number of operations you need to perform on perm to return the permutation to its initial value.
 */
public class ReinitializePermutation {
    public static void main(String[] args) {
        System.out.println(new ReinitializePermutation().reinitializePermutation(6));
    }

    public int reinitializePermutation(int n) {
        int[] initialArr = new int[n];
        for (int i = 0; i < n; i++)
            initialArr[i] = i;

        int[] premutation = initialArr;
        int count = 0;
        while (true) {
            int[] newPerm = new int[n];
            count++;
            for (int i = 0; i < n; i++) {
                int num;
                if (i % 2 == 0)
                    num = premutation[i / 2];
                else
                    num = premutation[n / 2 + (i - 1) / 2];
                newPerm[i] = num;
                if (Arrays.equals(newPerm, initialArr))
                    return count;
            }
            premutation = newPerm;
        }
    }
}
