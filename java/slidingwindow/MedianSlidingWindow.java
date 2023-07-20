package slidingwindow;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Supplier;

/**
 * 480. Sliding Window Median
 */
public class MedianSlidingWindow {
    public static void main(String[] args) {
        medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }

    static double[] medianSlidingWindow(int[] nums, int K) {
        Comparator<Integer> comparator = (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b;
        TreeSet<Integer> left = new TreeSet<>(comparator.reversed());//ASC
        TreeSet<Integer> right = new TreeSet<>(comparator);//DESC
        Supplier<Double> median = (K % 2 == 0) ?
                () -> ((double) nums[left.first()] + nums[right.first()]) / 2 :
                () -> (double) nums[right.first()];


        Runnable balance = () -> { while (left.size() > right.size()) right.add(left.pollFirst()); };

        int N = nums.length;
        double[] result = new double[N - K + 1];

        for (int i = 0; i < K; i++)
            left.add(i);
        balance.run();
        result[0] = median.get();
        int resultIndex = 1;
        for (int i = K; i < N; i++) {
            if (!left.remove(i - K))
                right.remove(i - K);

            right.add(i);
            left.add(right.pollFirst());

            balance.run();
            result[resultIndex++] = median.get();
        }
        return result;
    }
}
