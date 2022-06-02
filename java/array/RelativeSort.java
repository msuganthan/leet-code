package array;

/**
 * Created by msuganthan on 6/9/20.
 */
public class RelativeSort {

    public static void main(String[] args) {

    }

    static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int k = 0;
        int[] count = new int[1001];
        int[] ans = new int[arr1.length];

        for (int i : arr1)
            ++count[i];

        for (int i : arr2)
            while (count[i]-- > 0)
                ans[k++] = i;

        for (int i = 0; i < 1001; i++)
            while (count[i]-- > 0)
                ans[k++] = i;

        return ans;
    }
}
