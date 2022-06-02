package contest.weekly.w234;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 5713. Number of Different Integers in a String
 *
 * You are given a string word that consists of digits and lowercase English letters.
 *
 * You will replace every non-digit character with a space. For example, "a123bc34d8ef34" will become " 123  34 8  34".
 * Notice that you are left with some integers that are separated by at least one space: "123", "34", "8", and "34".
 *
 * Return the number of different integers after performing the replacement operations on word.
 *
 * Two integers are considered different if their decimal representations without any leading zeros are different.
 */
public class NumDifferentIntegers {
    public static void main(String[] args) {
        System.out.println(new NumDifferentIntegers().numDifferentIntegers("gi851a851q8510v"));
    }

    public int numDifferentIntegers(String word) {
        List<String> list = Arrays.asList(word.replaceAll("[a-z]", " ").split(" "));
        Set<String> numbers = new HashSet<>();
        for (int i = 0; i < list.size(); i++)
            if (!list.get(i).isEmpty())
                numbers.add(list.get(i).replaceFirst("^0+(?!$)", ""));

        return numbers.size();
    }
}
