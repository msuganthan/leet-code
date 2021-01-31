package contest226;

import java.util.HashMap;
import java.util.Map;

public class CountBalls {
    //ToDo: Sugan, Comeback to this later
    public static void main(String[] args) {
        System.out.println(countBalls(4, 7));
    }

    static int countBalls(int lowLimit, int highLimit) {
        int ans = Integer.MIN_VALUE;
        Map<Integer, Integer> answer = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int runningSum = 0;
            int cal = i;
            while (cal != 0) {
                int rem = cal % 10;
                runningSum += rem;
                cal /= 10;
            }
            answer.put(runningSum - 1 , answer.getOrDefault(runningSum - 1, 0) + 1);
            ans = Math.max(ans, answer.get(runningSum - 1));
        }
        return ans;
    }
}
