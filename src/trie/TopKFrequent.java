package trie;

import java.util.*;

public class TopKFrequent {
    public static void main(String[] args) {
        topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
    }

    /**
     * Answer should be sorted by frequency from highest to lowest.
     * If two words have the same frequency, then the word with the lower
     * alphabetical order comes first.
     */
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);

        //Put the strings in priorityQueue sorted by frequency from highest to lowest.
        //If two words have the same frequency, then the word with the lower alphabetical
        //order comes first.
        PriorityQueue<String> priorityQueue = new PriorityQueue<>((word1, word2) ->
                map.get(word1).equals(map.get(word2)) ? word2.compareTo(word1) //If the count is same compare the word
                        : map.get(word1) - map.get(word2) //else the number of frequency
        );

        for (String word : map.keySet()) {
            priorityQueue.offer(word);
            if (priorityQueue.size() > k)
                priorityQueue.poll();
        }
        List<String> answer = new ArrayList<>();
        while (!priorityQueue.isEmpty())
            answer.add(priorityQueue.poll());

        Collections.reverse(answer);
        return answer;
    }
}
