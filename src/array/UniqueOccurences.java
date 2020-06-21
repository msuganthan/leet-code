package array;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given an array of integers {@code arr}`, write a function that returns {@code true} if and only if the number of
 * occurrences of each value in the array is unique.
 */
public class UniqueOccurences {
    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[] {1,2,2,1,1,3}));
    }

    static boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> values = new HashSet<>();
        for (int n: arr)
            map.put(n, map.getOrDefault(n, 0) + 1);

        for(int val: map.values()) {
            if (values.contains(val))
                return false;
            else
                values.add(val);
        }
        return true;
    }
}
