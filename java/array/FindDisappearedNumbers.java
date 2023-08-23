package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        List<Integer> answer = new ArrayList<>();
        for (int num : nums) {
            if (!set.contains(num)) {
                answer.add(num);
            }
        }
        return answer;
    }
}
