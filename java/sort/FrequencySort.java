package sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencySort {

    public String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        List<Character> sortedChars = new ArrayList<>(frequencyMap.keySet());
        sortedChars.sort((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));

        StringBuilder builder = new StringBuilder();
        for (char c : sortedChars) {
            int frequency = frequencyMap.get(c);
            builder.append(String.valueOf(c).repeat(frequency));
        }
        return builder.toString();
    }
}
