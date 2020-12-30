package math.romanizer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Romanizer {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        romanizer(nums).stream().forEach(System.out::println);
    }

    public static List<String> romanizer(List<Integer> numbers) {
        // Write your code here
        String[] M = {"", "M", "MM", "MMM"};
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return numbers.stream()
                .map(num -> M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10])
                .map(num -> num)
                .collect(Collectors.toList());

    }
}
