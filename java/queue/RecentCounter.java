package queue;

import java.util.LinkedList;

/**
 * Number of Recent Calls
 *
 * You have a RecentCounter class which counts the number of recent requests within a certain time frame.
 *
 * Implement the RecentCounter class:
 *
 * RecentCounter() Initializes the counter with zero recent requests.
 */
public class RecentCounter {
    LinkedList<Integer> slideWindow;

    public RecentCounter() {
        this.slideWindow = new LinkedList<>();
    }

    public int ping(int t) {
        this.slideWindow.addLast(t);

        while (this.slideWindow.getFirst() < t - 3000)
            this.slideWindow.removeFirst();

        return this.slideWindow.size();
    }
}
