package basics.priorityqueue;

import java.util.PriorityQueue;

public class PriorityQueueBasic {
    public static void main(String[] args) {
        /**
         * All the elements are ordered as per their natural ordering
         * or based on a customer Comparator
         */
        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        numbers.add(750);
        numbers.add(500);
        numbers.add(900);
        numbers.add(100);

        /**
         * Natural sorting
         * 100
         * 500
         * 750
         * 900
         */
        while (!numbers.isEmpty()) {
            System.out.println(numbers.poll());
        }

        PriorityQueue<String> namesPriorityQueue = new PriorityQueue<>();
        namesPriorityQueue.add("Lisa");
        namesPriorityQueue.add("Robert");
        namesPriorityQueue.add("John");
        namesPriorityQueue.add("Chris");
        namesPriorityQueue.add("Angelina");
        namesPriorityQueue.add("Joe");

        /**
         * Natural sorting
         * Angelina
         * Chris
         * Joe
         * John
         * Lisa
         * Robert
         */
        while (!namesPriorityQueue.isEmpty()) {
            System.out.println(namesPriorityQueue.poll());
        }
    }
}
