package hashset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 2215. Find the Difference of Two Arrays
 *
 * Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
 *
 * answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
 * answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
 * Note that the integers in the lists may be returned in any order.
 */
public class FindDifference {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> firstSet = new HashSet<>();
        Set<Integer> secondSet = new HashSet<>();
        Set<Integer> answerSet1 = new HashSet<>();
        Set<Integer> answerSet2 = new HashSet<>();
        for (int n : nums1) {
            firstSet.add(n);
        }
        for (int n : nums2) {
            secondSet.add(n);
        }
        for (int n: nums1) {
            if (!secondSet.contains(n)) {
                answerSet1.add(n);
            }
        }
        for (int n: nums2) {
            if (!firstSet.contains(n)) {
                answerSet2.add(n);
            }
        }
        return List.of(new ArrayList<>(answerSet1), new ArrayList<>(answerSet2));
    }

    /**
     *     def findDifference(self, nums1: List[int], nums2: List[int]) -> List[List[int]]:
     *         first_set = set(nums1)
     *         second_set = set(nums2)
     *         answer_set1 = {n for n in nums1 if n not in second_set}
     *         answer_set2 = {n for n in nums2 if n not in first_set}
     *
     *         return [list(answer_set1), list(answer_set2)]
     */

    /**
     * func findDifference(nums1 []int, nums2 []int) [][]int {
     *     firstSet := make(map[int]bool)
     *     secondSet := make(map[int]bool)
     *     answerSet1 := make(map[int]bool)
     *     answerSet2 := make(map[int]bool)
     *
     *     for _,n := range nums1 {
     *         firstSet[n] = true
     *     }
     *
     *     for _, n := range nums2 {
     *         secondSet[n] = true
     *     }
     *
     *     for _, n := range nums1 {
     *         if _, exists := secondSet[n]; !exists {
     *             answerSet1[n] = true
     *         }
     *     }
     *
     *     for _, n := range nums2 {
     *         if _, exists := firstSet[n]; !exists {
     *             answerSet2[n] = true
     *         }
     *     }
     *
     *     return [][]int{keysToList(answerSet1), keysToList(answerSet2)}
     * }
     *
     * func keysToList(set map[int]bool) []int {
     * 	keys := make([]int, 0, len(set))
     * 	for k := range set {
     * 		keys = append(keys, k)
     *        }
     * 	return keys
     * }
     */
}
