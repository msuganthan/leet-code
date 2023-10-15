package array.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int firstElement = nums[i];
            int firstPointer = i + 1;
            int secondPointer = nums.length - 1;

            while (firstPointer < secondPointer) {
                int firstPointerElement = nums[firstPointer];
                int secondPointerElement = nums[secondPointer];
                int totalSum = firstElement + firstPointerElement + secondPointerElement;
                if (totalSum == 0) {
                    result.add(Arrays.asList(firstElement, firstPointerElement, secondPointerElement));

                    while (firstPointer < secondPointer && nums[firstPointer] == nums[firstPointer + 1]) firstPointer++;
                    while (firstPointer < secondPointer && nums[secondPointer] == nums[secondPointer - 1])
                        secondPointer--;

                    firstPointer++;
                    secondPointer--;
                } else if (totalSum < 0)
                    firstPointer++;
                else
                    secondPointer--;
            }
        }
        return result;
    }

    /**
     *     def threeSum(self, nums: List[int]) -> List[List[int]]:
     *         nums.sort()
     *         answer = set()
     *
     *         for i in range(len(nums) - 2):
     *             j = i + 1
     *             k = len(nums) - 1
     *
     *             while j < k:
     *                 total = nums[i] + nums[j] + nums[k]
     *                 if total == 0:
     *                     answer.add(tuple([nums[i], nums[j], nums[k]]))
     *                     j += 1
     *                     k -= 1
     *                 elif total > 0:
     *                     k -= 1
     *                 else:
     *                     j += 1
     *
     *         return answer
     */

    /**
     * func threeSum(nums []int) [][]int {
     *     sort.Ints(nums)
     *     answerSet := make(map[[3]int]bool)
     *
     *     for i := 0; i < len(nums) - 2; i++ {
     *         j := i + 1
     *         k := len(nums) - 1
     *
     *         for j < k {
     *             total := nums[i] + nums[j] + nums[k]
     *             if total == 0 {
     *                 triplet := [3]int{nums[i], nums[j], nums[k]}
     *                 answerSet[triplet] = true
     *                 j++
     *                 k--
     *             } else if total > 0 {
     *                 k--
     *             } else {
     *                 j++
     *             }
     *         }
     *     }
     *     answer := make([][]int, 0, len(answerSet))
     *     for triplet := range answerSet {
     *         answer = append(answer, []int{triplet[0], triplet[1], triplet[2]})
     *     }
     *     return answer
     * }
     */
}
