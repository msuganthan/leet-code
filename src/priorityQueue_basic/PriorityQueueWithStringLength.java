package priorityQueue_basic;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueWithStringLength {
    public static void main(String[] args) {
        PriorityQueue<String> namesPriorityQueue = new PriorityQueue<>(Comparator.comparingInt(String::length));
        namesPriorityQueue.add("Lisa");
        namesPriorityQueue.add("Robert");
        namesPriorityQueue.add("John");
        namesPriorityQueue.add("Chris");
        namesPriorityQueue.add("Angelina");
        namesPriorityQueue.add("Joe");

        /**
         * Output based on string length
         * Joe
         * John
         * Lisa
         * Chris
         * Robert
         * Angelina
         */
        while (!namesPriorityQueue.isEmpty()) {
            System.out.println(namesPriorityQueue.poll());
        }
    }
}
