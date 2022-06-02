package priorityQueue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 451. Sort Characters By Frequency
 *
 * Given a string s, sort it in decreasing order based on the frequency of the characters.
 * The frequency of a character is the number of times it appears in the string.
 *
 * Return the sorted string. If there are multiple answers, return any of them.
 */
public class FrequencySort {
    /**
     * Find the count of every character.
     * Based the count put it queue.
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        Map<Character, Integer> cnt = new HashMap<>();
        for (char c: s.toCharArray()) {
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        priorityQueue.addAll(cnt.entrySet());

        StringBuilder stringBuilder = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            Map.Entry<Character, Integer> poll = priorityQueue.poll();
            for (int i = 0; i < poll.getValue(); i++) {
                stringBuilder.append(poll.getKey());
            }
        }
        return stringBuilder.toString();
    }
}
