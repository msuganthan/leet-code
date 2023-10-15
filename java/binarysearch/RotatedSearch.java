package binarysearch;

public class RotatedSearch {

    public static void main(String[] args) {
        System.out.println(new RotatedSearch().search(new int[]{1,3}, 3));
    }
    public int search(int[] nums, int target) {
        int mid = findMid(nums, nums[nums.length - 1]);
        System.out.println("mid => "+mid);
        if (nums[mid] == target) {
            return mid;
        }
        int l, r;
        if (target <= nums[nums.length - 1]) {
            l = mid;
            r = nums.length - 1;
        } else {
            l = 0;
            r = mid - 1;
        }

        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    int findMid(int[] nums, int rightMost) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (mid - 1 >= 0
                && mid + 1 < nums.length - 1
                && nums[mid - 1] > nums[mid]  && nums[mid] < nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > rightMost) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
