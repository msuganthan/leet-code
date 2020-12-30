package math.removeElements;

/**
 * Created by msuganthan on 10/3/20.
 */
public class RemoveElements {
    public static void main(String[] args) {
        removeElements(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);
    }

    static int removeElements(int[] A, int elem) {
        int l = A.length;
        for (int i = 0; i < l; i++) {
            if (A[i] == elem)
                A[i--] = A[l-- - 1];
        }
        return l;
    }
}
