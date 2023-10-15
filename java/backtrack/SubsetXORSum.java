package backtrack;

public class SubsetXORSum {

    public static void main(String[] args) {
        new SubsetXORSum().subsetXORSum(new int[]{5,1,6});
    }

    public int subsetXORSum(int[] nums) {
        return helper(nums, 0, 0);
    }

    int helper(int[] nums, int index, int currentXor) {
        if(index == nums.length) return currentXor;
        int with = helper(nums, index + 1, currentXor ^ nums[index]);
        int without = helper(nums, index + 1, currentXor);
        return with + without;
    }
}
