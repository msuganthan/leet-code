package array;

public class SortByParity {
    public static void main(String[] args) {
        int[] ints = sortByParity(new int[]{1, 3, 2, 4});
        for (int i : ints)
            System.out.println(i);
    }

    private static int[] sortByParity(int[] A) {
        int i = 0;
        int j = 1;
        int n = A.length;
        while (i < n && j < n) {

            while (i < n && A[i] % 2 == 0) i += 2;

            while (j < n && A[j] % 2 != 0) j += 2;

            if (i < n && j < n)
                swap(i, j, A);

        }
        return A;
    }

    static void swap(int i, int j, int[] A) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
