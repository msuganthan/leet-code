package linkedlist;

import java.util.Arrays;

public class SpiralMatrix {

    public int[][] spiralMatrix(int height, int breadth, ListNode head) {
        int[][] answer = new int[height][breadth];
        for(int i = 0; i < height; i++) {
            Arrays.fill(answer[i], -1);
        }

        int i, j = 0, breadthStart = 0, heightStart = 0;

        while (breadthStart < height && heightStart < breadth) {
            for (i = heightStart; i < breadth && head != null; ++i) {
                answer[breadthStart][i] = head.val;
                head = head.next;
            }
            breadthStart++;

            for (i = breadthStart; i < height && head != null; ++i) {
                answer[i][breadth - 1] = head.val;
                head = head.next;
            }
            breadth--;

            if (breadthStart < height) {
                for (i = breadth - 1; i >= heightStart && head != null; --i) {
                    answer[height - 1][i] = head.val;
                    head = head.next;
                }
                height--;
            }

            if (heightStart < breadth) {
                for (i = height - 1; i >= breadthStart && head != null; --i) {
                    answer[i][heightStart] = head.val;
                    head = head.next;
                }
                heightStart++;
            }
        }

        return answer;
    }
}
