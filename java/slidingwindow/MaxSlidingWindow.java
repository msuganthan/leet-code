package slidingwindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }

    static int[] maxSlidingWindow(int[] nums, int K) {
        int N = nums.length;
        int[] answer = new int[N - K + 1];
        int answerIndex = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {

            //remove numbers out of range
            while (!deque.isEmpty() && deque.peek() < i - K + 1)
                deque.poll();

            //remove the smaller numbers in k range
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();

            deque.offer(i);
            if (i - K + 1 >= 0)
                answer[answerIndex++] = nums[deque.peek()];
        }
        return answer;
    }
}
