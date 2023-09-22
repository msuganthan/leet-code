package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public static void main(String[] args) {
        System.out.println(new SpiralOrder().spiralOrder(new int[][]{
                {3},
                {2}}));
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        int breadthStart = 0, heightStart = 0;
        int height = matrix.length;
        int breadth = matrix[0].length;

        List<Integer> answer = new ArrayList<>();
        while(breadthStart < breadth && heightStart < height) {
            for (int i = breadthStart; i < breadth; i++) {
                answer.add(matrix[breadthStart][i]);
            }
            breadthStart++;

            for (int i = breadthStart; i < height; i++) {
                answer.add(matrix[i][breadth - 1]);
            }
            breadth--;

            if (breadthStart < height) {
                for (int i = breadth - 1; i >= heightStart; i--) {
                    answer.add(matrix[height - 1][i]);
                }
                height--;
            }

            if (heightStart < breadth) {
                for (int i = height - 1; i >= breadthStart; i--) {
                    answer.add(matrix[i][heightStart]);
                }
                heightStart++;
            }
        }
        return answer;
    }
}
