package contest.biweekly.bw44;

public class LargestAltitude {
    public static void main(String[] args) {
        largestAltitude(new int[] {-5, 1, 5, 0, -7});
    }

    static int largestAltitude(int[] gain) {
        int firstPoint = 0;
        int maxPoint = Integer.MIN_VALUE;
        for (int i = 0; i < gain.length; i++) {
            int currentMax = firstPoint + gain[i];
            firstPoint = currentMax;
            if (maxPoint < currentMax)
                maxPoint = currentMax;
        }
        return maxPoint < 0 ? 0 : maxPoint;
    }
}
