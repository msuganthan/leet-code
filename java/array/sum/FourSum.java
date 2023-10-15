package array.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(start == nums.length || nums[start] * k > target || target > nums[nums.length - 1] * k)
            return result;

        if(k == 2)
            return twoSums(nums, target, start);

        for(int i = start; i < nums.length; i++)
            if(i == start || nums[i - 1] != nums[i])
                for(var set: kSum(nums, target - nums[i], i + 1, k - 1)) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i])));
                    result.get(result.size() - 1).addAll(set);
                }

        return result;
    }

    public List<List<Integer>> twoSums(int[] nums, int target, int start) {
        List<List<Integer>> result = new ArrayList();
        int low = start;
        int high = nums.length - 1;
        while(low < high) {
            int sum = nums[low] + nums[high];
            if (sum < target || (low > start && nums[low] == nums[low - 1]))
                ++low;
            else if (sum > target || (high < nums.length - 1 && nums[high] == nums[high + 1]))
                --high;
            else
                result.add(Arrays.asList(nums[low++], nums[high--]));
        }
        return result;
    }
}
