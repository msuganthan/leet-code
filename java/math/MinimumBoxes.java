package math;

public class MinimumBoxes {
    public static void main(String[] args) {

    }

    static int minimumBoxes(int n) {
        int sum = 0, currentLevel = 0, nextOutBound = 0;
        while(sum < n) {
            nextOutBound++;
            currentLevel += nextOutBound;
            sum += currentLevel;
        }
        if (sum == n) return currentLevel;

        sum -= currentLevel;
        currentLevel -= nextOutBound;
        nextOutBound = 0;
        while (sum < n) {
            nextOutBound++;
            sum += nextOutBound;
        }
        return currentLevel + nextOutBound;
    }
}
