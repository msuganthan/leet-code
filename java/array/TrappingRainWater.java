package array;

/**
 * 42. Trapping Rain Water
 * <p>
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int leftMax = height[leftIndex];
        int rightMax = height[rightIndex];
        int surfaceArea = 0;
        while(leftIndex < rightIndex) {
            if(height[leftIndex] < height[rightIndex]) {
                leftIndex++;
                leftMax = Math.max(leftMax, height[leftIndex]);
                surfaceArea += leftMax - height[leftIndex];
            } else {
                rightIndex--;
                rightMax = Math.max(rightMax, height[rightIndex]);
                surfaceArea += rightMax - height[rightIndex];
            }
        }
        return surfaceArea;
    }
}
