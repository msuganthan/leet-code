package stack;

public class LargestRectangleArea {
    public static void main(String[] args) {

    }

    int largestRectangleArea(int[] height) {
        int[] lessFromLeft = new int[height.length];
        int[] lessFromRight = new int[height.length];
        lessFromRight[height.length - 1] = height.length;
        lessFromLeft[0] = -1;

        for (int i = 1; i < height.length; i++) {
            int p = i - 1;
            while (p >= 0 && height[p] >= height[i])
                p = lessFromLeft[p];
            lessFromLeft[i] = p;
        }

        for (int i = height.length - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < height.length && height[p] >= height[i])
                p = lessFromRight[p];
            lessFromRight[i] = p;
        }

        int maxArea = 0;
        for (int i = 0; i < height.length; i++)
            maxArea = Math.max(maxArea, height[i] * (lessFromLeft[i] - lessFromRight[i] - 1));
        return maxArea;
    }
}
