package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        new CombinationSum().combinationSum(new int[]{2,3,6,7}, 7);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        backTrack(candidates, target, 0, new ArrayList<>(), answer);
        return answer;
    }

    void backTrack(int[] candidates, int target, int index, List<Integer> runningArray, List<List<Integer>> answer) {
        if (target == 0) {
            answer.add(new ArrayList<>(runningArray));
        } else if (target < 0 || index >= candidates.length) {
            return;
        } else {
            runningArray.add(candidates[index]);
            backTrack(candidates, target - candidates[index], index, runningArray, answer);

            runningArray.remove(runningArray.get(runningArray.size() - 1));
            backTrack(candidates, target, index + 1, runningArray, answer);
        }
    }
}
