package contest.weekly.w229;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Minimum Number of Operations to Move All Balls to Each Box
 * <p>
 * You have n boxes. You are given a binary string boxes of length n, where boxes[i] is '0' if the ith box is empty, and
 * '1' if it contains one ball.
 * <p>
 * In one operation, you can move one ball from a box to an adjacent box. Box i is adjacent to box j if abs(i - j) == 1.
 * Note that after doing so, there may be more than one ball in some boxes.
 * <p>
 * Return an array answer of size n, where answer[i] is the minimum number of operations needed to move all the balls to
 * the ith box.
 * <p>
 * Each answer[i] is calculated considering the initial state of the boxes.
 * <p>
 * Input: boxes = "110"
 * Output: [1,1,3]
 *
 * Input: boxes = "001011"
 * Output: [11,8,5,4,3,4]
 */
public class MinOperations {
    public static void main(String[] args) {
        minOperations("001011");
    }

    static int[] minOperations(String boxes) {
        char[] chars = boxes.toCharArray();
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1')
                indexes.add(i);
        }

        int[] answer = new int[chars.length];
        for (int i = 0; i < answer.length; i++) {
            int ans = 0;
            for (int j = 0; j < indexes.size(); j++)
                ans += Math.abs(indexes.get(j) - i);

            answer[i] = ans;
        }

        return answer;
    }
}
