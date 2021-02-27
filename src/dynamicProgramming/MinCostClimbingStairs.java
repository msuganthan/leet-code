package dynamicProgramming;

public class MinCostClimbingStairs {
    public static void main(String[] args) {

    }

    public int minCostClimbingStairs(int[] costs) {
        int f1 = 0, f2 = 0;
        for (int i = costs.length - 1; i >= 0; i--) {
            int f0 = costs[i] + Math.min(f1, f2);
            f1 = f0;
            f2 = f1;
        }
        return Math.min(f1, f2);
    }
}
