package array;

import java.util.ArrayList;
import java.util.List;

public class FindMatrix {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        int[] count = new int[nums.length + 1];
        for(int a: nums) {
            if(answer.size() < ++count[a]) {
                answer.add(new ArrayList<>());
            }
            answer.get(count[a] - 1).add(a);
        }
        return answer;
    }
}
