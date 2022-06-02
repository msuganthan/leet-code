package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    /**
     * When k = 2n + 1 then maxHeap is allowed to store n + 1 elements, while minHeap can hold n elements
     * When k = 2n then both heaps are balanced and hold n elements each.
     * @param num
     */
    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());

        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size())
            return (double) (maxHeap.peek() + minHeap.peek()) * 0.5;

        return (double) maxHeap.peek();
    }
}
