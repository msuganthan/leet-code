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
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right) {
            int leftMax = height[left];
            int rightMax = height[right];

            int candidate = (right - left) * (leftMax < rightMax ? leftMax : rightMax);
            max = candidate > max ? candidate : max;

            if (height[left] <= height[right])
                while (left < right && height[left] <= leftMax) ++left;
            else
                while (right > left && height[right] <= rightMax) --right;
        }
        return max;
    }
}
