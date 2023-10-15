package priorityqueue;

import java.util.PriorityQueue;

public class KthLargestNumber {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.length() == o2.length()) { // If the same length then compare by their string
                return o1.compareTo(o2);
            }
            return Integer.compare(o1.length(), o2.length()); // Compare by their length
        });
        for(String n: nums) {
            queue.add(n);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }
}
