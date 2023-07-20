package binarysearch;

import java.util.Arrays;

public class AnswerQueries {
    public int[] answerQueries(int[] nums, int[] queries) {

        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        int n = queries.length;
        int[] answer = new int[n];
        for(int i = 0; i < n; i++) {
            int index = binarySearch(nums, queries[i]);
            answer[i] = index;
        }
        return answer;

    }

    int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while(left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid + 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return nums[left] > target ? left : left + 1;
    }

    /**
     *     def answerQueries(self, nums: List[int], queries: List[int]) -> List[int]:
     *         nums.sort()
     *         for i in range(1, len(nums)):
     *             nums[i] += nums[i - 1]
     *
     *         answer = []
     *         for query in queries:
     *             index = bisect.bisect_right(nums, query)
     *             answer.append(index)
     *
     *         return answer
     */

    /**
     * func answerQueries(nums []int, queries []int) []int {
     *     sort.Ints(nums)
     *
     *     for i := 1; i < len(nums); i++ {
     *         nums[i] += nums[i - 1]
     *     }
     *
     *     n := len(queries)
     *     answer := make([]int, n)
     *
     *     for i := 0; i < n; i++ {
     *         index := binarySearch(nums, queries[i])
     *         answer[i] = index
     *     }
     *
     *     return answer
     *
     * }
     *
     * func binarySearch(nums[] int, target int) int {
     *
     *   left, right := 0, len(nums) - 1
     *
     *   for left < right {
     *     mid := (left + right) / 2
     *
     *     if nums[mid] == target {
     *       return mid + 1;
     *     }
     *
     *     if nums[mid] < target {
     *       left = mid + 1
     *     } else {
     *       right = mid - 1
     *     }
     *   }
     *
     *
     *   if nums[left] > target {
     *     return left
     *   }
     *
     *   return left + 1
     * }
     */
}
