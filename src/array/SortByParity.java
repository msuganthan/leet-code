package array;

public class SortByParity {
    public static void main(String[] args) {
        System.out.println(sortByParity(new int[] {1,3, 2,4}));
    }

    private static int[] sortByParity(int[] A) {
        int i = 0;
        int j = 0;
        while(i < A.length) {
            if (A[i] % 2 == 0) {
                int tmp = A[i]; //could be an even number
                A[i]    = A[j]; //placing an odd number in the place of even number.
                A[j++]  = tmp;
            }
            i++;
        }
        return A;
    }
}
