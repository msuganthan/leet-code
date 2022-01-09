package prefixSum;

public class LargestAltitude {
    public static void main(String[] args) {
        largestAltitude(new int[] {-5, 1, 5, 0, -7});
    }

    static int largestAltitude(int[] gain) {
        int firstPoint = 0;
        int maxPoint = Integer.MIN_VALUE;
        for (int i = 0; i < gain.length; i++) {
            int currentMax = firstPoint + gain[i];
            maxPoint = Math.max(maxPoint, currentMax);
            firstPoint = currentMax;
        }
        return maxPoint > 0 ? maxPoint : 0;
    }
}
