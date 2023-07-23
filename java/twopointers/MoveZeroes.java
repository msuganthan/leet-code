package twopointers;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int lastNonZeroFound = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[lastNonZeroFound++] = nums[i];
            }
        }

        for(int i = lastNonZeroFound; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     *     def moveZeroes(self, nums: List[int]) -> None:
     *         """
     *         Do not return anything, modify nums in-place instead.
     *         """
     *         lastNonZeroFound = 0
     *         for n in nums:
     *             if n != 0:
     *                 nums[lastNonZeroFound] = n
     *                 lastNonZeroFound += 1
     *
     *         for i in range(lastNonZeroFound, len(nums)):
     *             nums[i] = 0
     */

    /**
     * func moveZeroes(nums []int)  {
     *     lastNonZeroFound := 0
     *     for i := 0; i < len(nums); i++ {
     *         if nums[i] != 0 {
     *             nums[lastNonZeroFound] = nums[i]
     *             lastNonZeroFound++
     *         }
     *     }
     *     for i := lastNonZeroFound; i < len(nums); i++ {
     *         nums[i] = 0
     *     }
     * }
     */
}
