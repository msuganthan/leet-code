package array;

public class MaxArea {

    public static void main(String[] args) {
        System.out.println(maxArea(5, 4, new int[] {1, 2, 4}, new int[] {1, 3}));
    }

    static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        return (int) ((maxArea(h, horizontalCuts) * maxArea(w, verticalCuts)) % 1_000_000_007);
    }

    static long maxArea(int max, int[] cuts) {
        int result = 0;
        int start = 0;
        for (int cut : cuts) {
            result = Math.max(result, cut - start);
            start = cut;
        }
        return Math.max(result, max - start);
    }
}
