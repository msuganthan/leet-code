package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(list, new ArrayList<>(), nums, 0);
    }

    private static void backTrack(List<List<Integer>> list, List<Integer> current, int[] nums, int index) {
        list.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            backTrack(list, current, nums, i + 1);
            current.remove(current.size() - 1);
        }
    }
}
