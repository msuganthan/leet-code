package array;

/**
 * 80. Remove Duplicates from Sorted Array II
 */
public class RemoveDuplicates1 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n: nums) {
            if (i < 2 || n != nums[i - 2]) {
                nums[i++] = n;
            }
        }
        return i;
    }
}
