package contest.weekly.w232;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Maximum Average Pass Ratio
 * <p>
 * There is a school that has classes of students and each class will be having a final exam. You are given a 2D integer
 * array classes, where classes[i] = [passi, totali]. You know beforehand that in the ith class, there are totali total
 * students, but only passi number of students will pass the exam.
 * <p>
 * You are also given an integer extraStudents. There are another extraStudents brilliant students that are guaranteed
 * to pass the exam of any class they are assigned to. You want to assign each of the extraStudents students to a class
 * in a way that maximizes the average pass ratio across all the classes.
 * <p>
 * The pass ratio of a class is equal to the number of students of the class that will pass the exam divided by the total
 * number of students of the class. The average pass ratio is the sum of pass ratios of all the classes divided by the
 * number of the classes.
 * <p>
 * Return the maximum possible average pass ratio after assigning the extraStudents students. Answers within 10-5 of the
 * actual answer will be accepted.
 * <p>
 * Input: classes = [[1,2],[3,5],[2,2]], extraStudents = 2
 * Output: 0.78333
 * Explanation: You can assign the two extra students to the first class.
 * The average pass ratio will be equal to (3/4 + 3/5 + 2/2) / 3 = 0.78333.
 * <p>
 * Input: classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4
 * Output: 0.53485
 */
public class MaxAverageRatio {

    public static void main(String[] args) {
        System.out.println(new MaxAverageRatio().maxAverageRatio(new int[][]{{1,2}, {3,5}, {2,2}}, 2));
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(o -> o[0]));
        for (int[] c: classes) {
            double a = c[0];
            double b = c[1];
            priorityQueue.offer(new double[] {-delta(a, b), a, b});
        }

        while (extraStudents-- > 0) {
            double[] top = priorityQueue.poll();
            double a = top[1], b = top[2];
            priorityQueue.offer(new double[]{-delta(a+1, b+1), a+1, b+1});
        }

        double ans = 0.0d;
        while (!priorityQueue.isEmpty()) {
            double[] top = priorityQueue.poll();
            double a = top[1], b = top[2];
            ans += a/b;
        }
        return ans / classes.length;
    }

    double delta(double a, double b) {
        return (a + 1) / (b + 1) - a / b;
    }
}
