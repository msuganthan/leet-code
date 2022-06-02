package priorityQueue;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class LargestInteger {
    public int largestInteger(int num) {
        PriorityQueue<Integer> even = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> odd = new PriorityQueue<>((a, b) -> b - a);
        LinkedList<Integer> digits = new LinkedList<>();

        while(num > 0) {
            int d = num % 10;
            if(d % 2 == 0) {
                even.offer(d);
            } else {
                odd.offer(d);
            }
            num /= 10;
            digits.addFirst(d);
        }

        int result = 0;
        while(!digits.isEmpty()) {
            int d = digits.removeFirst();
            if(d % 2 == 0) {
                result = result * 10 + even.poll();
            } else {
                result = result * 10 + odd.poll();
            }
        }
        return result;
    }
}
