package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class Permute {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> list = new ArrayList<>();
        backTrack(list, new ArrayList<>(), nums);
        /*for (List<Integer> integers : list) {
            System.out.println();
            for (Integer integer: integers) {
                System.out.print(integer + ", ");
            }
        }*/
    }


    static void backTrack(List<List<Integer>> list, List<Integer> current, int[] nums) {
        if (current.size() == nums.length)
            list.add(new ArrayList<>(current));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (current.contains(nums[i])) continue;
                current.add(nums[i]);
                backTrack(list, current, nums);
                current.remove(current.size() - 1);
            }
        }
    }
}
