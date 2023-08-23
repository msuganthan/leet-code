package array;

/**
 * Created by msuganthan on 6/9/20.
 */
public class RelativeSort {

    int[] relativeSortArray(int[] arr1, int[] arr2) {
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

    /**
     *     def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
     *         k = 0
     *         count = [0] * 1001
     *         ans = [0] * len(arr1)
     *
     *         for i in arr1:
     *             count[i] += 1
     *
     *         for i in arr2:
     *             while count[i] > 0:
     *                 ans[k] = i
     *                 k += 1
     *                 count[i] -= 1
     *
     *         for i in range(0, 1001):
     *             while count[i] > 0:
     *                 ans[k] = i
     *                 k += 1
     *                 count[i] -= 1
     *
     *         return ans
     */

    /**
     *    k := 0
     *     count := make([]int, 1001)
     *     ans := make([]int, len(arr1))
     *     for _, i := range arr1 {
     *         count[i]++
     *     }
     *
     *     for _, i := range arr2 {
     *         for count[i] > 0 {
     *             ans[k] = i
     *             k++
     *             count[i]--
     *         }
     *     }
     *
     *     for i := 0; i < 1001; i++ {
     *         for count[i] > 0 {
     *             ans[k] = i
     *             k++
     *             count[i]--
     *         }
     *     }
     *     return ans
     */
}
