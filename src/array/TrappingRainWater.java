package array;

public class TrappingRainWater {

    public static void main(String[] args) {
        trap(new int[]{0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3});
    }

    static int trap(int[] height) {
        if (height.length == 0) return 0;
        int surfaceArea = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int leftMax = height[leftIndex];
        int rightMax = height[rightIndex];

        while (leftIndex < rightIndex) {
            if (height[leftIndex] < height[rightIndex]) {
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
