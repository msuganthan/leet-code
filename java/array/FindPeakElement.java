package array;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;
        int l = 1;
        int r = nums.length - 2;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            int n = nums[mid];
            if(n > nums[mid - 1] && n > nums[mid + 1]) {
                return mid;
            } else if(nums[mid] < nums[mid-1]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
