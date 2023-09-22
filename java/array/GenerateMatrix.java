package array;

public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int breadthStart = 0, heightStart = 0;
        int height = n;
        int breadth = n;
        int[][] matrix = new int[height][breadth];
        int j = 1;
        while(breadthStart < breadth && heightStart < height) {
            for (int i = breadthStart; i < breadth; i++) {
                matrix[breadthStart][i] = j++;
            }
            breadthStart++;

            for (int i = breadthStart; i < height; i++) {
                matrix[i][breadth - 1] = j++;
            }
            breadth--;

            if (breadthStart < height) {
                for (int i = breadth - 1; i >= heightStart; i--) {
                    matrix[height - 1][i] = j++;
                }
                height--;
            }

            if (heightStart < breadth) {
                for (int i = height - 1; i >= breadthStart; i--) {
                    matrix[i][heightStart] = j++;
                }
                heightStart++;
            }
        }
        return matrix;
    }
}
