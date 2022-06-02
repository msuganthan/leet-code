package evertz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FilterAndSort {
    public static void main(String[] args) {
        /**
         * ["Uday", "Kumar", "Madhav", "Madhav", "Hema", "Uday", "Hema", "Madhav" ] --> ["Madhav", "Uday", "Hema", "Kumar"]
         */

        new FilterAndSort().filter(Arrays.asList("Uday", "Kumar", "Madhav", "Madhav", "Hema", "Uday", "Hema", "Madhav"))
                .stream()
                .forEach(System.out::println);

    }

    public List<String> filter(List<String> names) {
        Map<String, Integer> namesMap = new HashMap<>();
        for (String name : names) namesMap.put(name, namesMap.getOrDefault(name, 0) + 1);
        return namesMap.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
