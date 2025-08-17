package array.sum;

import java.util.*;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 *
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 *
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
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
        return new ArrayList<>(result);
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
