package stack.monotonicstack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] answer = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int n: nums2) {
            while(!stack.isEmpty() && n > stack.peek()) {
                map.put(stack.pop(), n);
            }
            stack.push(n);
        }
        for(int i = 0; i < nums1.length; i++) {
            answer[i] = map.getOrDefault(nums1[i], -1);
        }
        return answer;
    }

    /**
     *     def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
     *         answer = [-1] * len(nums1)
     *         stack = []
     *         map = {}
     *
     *         for n in nums2:
     *             while stack and n > stack[-1]:
     *                 map[stack.pop()] = n
     *             stack.append(n)
     *
     *         for i in range(len(nums1)):
     *             answer[i] = map.get(nums1[i], -1)
     *
     *         return answer
     */

    /**
     * func nextGreaterElement(nums1 []int, nums2 []int) []int {
     *     answer := make([]int, len(nums1))
     *     stack := make([]int, 0)
     *     m := make(map[int]int)
     *
     *     for _, n := range nums2 {
     *         for len(stack) > 0 && n > stack[len(stack) - 1] {
     *             m[stack[len(stack) - 1]] = n
     *             stack = stack[:len(stack) - 1]
     *         }
     *         stack = append(stack, n)
     *     }
     *
     *     for i, num := range nums1 {
     *         if val, ok := m[num]; ok {
     *             answer[i] = val
     *         } else {
     *             answer[i] = -1
     *         }
     *     }
     *     return answer
     * }
     */
}
