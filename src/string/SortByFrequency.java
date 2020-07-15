package string;

import com.sun.applet2.AppletParameters;

import java.util.*;
import java.util.stream.Collectors;

public class SortByFrequency {
    public static void main(String[] args) {
        System.out.println(sortByFrequency("Aabb"));
    }

    public static String sortByFrequency(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        Map<Integer, Set<Character>> frequencyMapper = new TreeMap<>(Collections.reverseOrder());
        for (char c : chars)
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (Character c: map.keySet()) {
            Set<Character> characters = frequencyMapper.get(map.get(c));
            if (characters == null)
                characters = new HashSet<>();
            characters.add(c);
            frequencyMapper.put(map.get(c), characters);
        }

        StringBuilder stringBuilder = new StringBuilder();
        frequencyMapper.keySet()
                .stream()
                .forEach(n -> {
                    int temp = n;
                    Set<Character> characters = frequencyMapper.get(n);
                    for (Character c: characters) {
                        while (n > 0) {
                            stringBuilder.append(c);
                            n--;
                        }
                        n = temp;
                    }
                });

        return stringBuilder.toString();
    }
}
