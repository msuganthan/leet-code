package linkedlist;

import java.util.Arrays;

public class SpiralMatrix {

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] answer = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(answer[i], -1);
        }

        int i, j = 0, k = 0, l = 0;

        while (k < m && l < n) {
            for (i = l; i < n && head != null; ++i) {
                answer[k][i] = head.val;
                head = head.next;
            }
            k++;

            for (i = k; i < m && head != null; ++i) {
                answer[i][n - 1] = head.val;
                head = head.next;
            }
            n--;

            if (k < m) {
                for (i = n - 1; i >= l && head != null; --i) {
                    answer[m - 1][i] = head.val;
                    head = head.next;
                }
                m--;
            }

            if (l < n) {
                for (i = m - 1; i >= k && head != null; --i) {
                    answer[i][l] = head.val;
                    head = head.next;
                }
                l++;
            }
        }

        return answer;
    }
}
