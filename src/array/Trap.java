package array;

public class Trap {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    static int trap(int[] height) {
        int surfaceArea = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int leftMax = height[leftIndex];
        int rightMax = height[rightIndex];

        while (leftIndex < rightIndex) {
            if (height[leftIndex] < height[rightIndex]) {
                leftMax = Math.max(leftMax, height[++leftIndex]);
                surfaceArea += leftMax - height[leftIndex];
            } else {
                rightMax = Math.max(rightMax, height[--rightIndex]);
                surfaceArea += rightMax - height[rightIndex];
            }
        }
        return surfaceArea;
    }
}
