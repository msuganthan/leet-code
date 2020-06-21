package array;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UniqueOccurences {
    public static void main(String[] args) {
        Map<int[], Long> collect = Arrays.asList(new int[]{1,2,2,1,1,3}).stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
    }
}
