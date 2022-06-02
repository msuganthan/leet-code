package array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numbers = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int lookFor = target - nums[i];
            if(numbers.containsKey(lookFor)) {
                return new int[]{numbers.get(lookFor), i};
            }
            numbers.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }

    /**
     *     def twoSum(self, nums: List[int], target: int) -> List[int]:
     *         numbers = {}
     *         for i in range(len(nums)):
     *             lookFor = target - nums[i]
     *             if lookFor in numbers:
     *                 return [numbers[lookFor], i]
     *             numbers[nums[i]] = i
     *         return [-1, -1]
     */

    /**
     * func twoSum(nums []int, target int) []int {
     *     numbers := make(map[int]int)
     *     for i := 0; i < len(nums); i++ {
     *         lookFor := target - nums[i]
     *         if val, ok := numbers[lookFor]; ok {
     *             return []int{val, i}
     *         }
     *         numbers[nums[i]] = i
     *     }
     *     return []int{-1, -1}
     * }
     */
}
