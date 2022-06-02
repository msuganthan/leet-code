package array;

/**
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 *
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two
 * endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most
 * water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 */
public class MaxArea1 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while(left < right) {
            int leftMax = height[left];
            int rightMax = height[right];

            int calculateArea = (right - left) * (Math.min(leftMax, rightMax));
            maxArea = Math.max(calculateArea, maxArea);

            if(height[left] <= height[right]) {
                while(left < right && height[left] <= leftMax) ++left;
            } else {
                while(right > left && height[right] <= rightMax) --right;
            }
        }
        return maxArea;
    }


    /**
     * public int maxArea(int[] height) {
     *         int maxArea = 0;
     *         int left = 0;
     *         int right = height.length - 1;
     *
     *         while(left < right) {
     *             int min = Math.min(height[left], height[right]);
     *             int currentArea = min * (right - left);
     *             maxArea = Math.max(maxArea, currentArea);
     *
     *             if(height[left] < height[right]) {
     *                 left++;
     *             } else {
     *                 right--;
     *             }
     *         }
     *
     *         return maxArea;
     *     }
     */
}
