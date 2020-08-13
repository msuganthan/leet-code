package array;

public class RemoveDuplicates {
    public static void main(String[] args) {
        removeDuplicates(new int[] {1,1,1, 1, 2, 2, 2} );
    }
    static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
