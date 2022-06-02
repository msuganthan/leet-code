package contest.biweekly.bw48;

import com.sun.source.doctree.SeeTree;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Second Largest Digit in a String
 *
 * Given an alphanumeric string s, return the second largest numerical digit that appears in s, or -1 if it does not exist.
 *
 * An alphanumeric string is a string consisting of lowercase English letters and digits.
 */
public class SecondHighest {
    public static void main(String[] args) {
        System.out.println(new SecondHighest().secondHighest("ck077"));
    }

    public int secondHighest(String s) {
        TreeSet<Integer> set = new TreeSet<>(Comparator.reverseOrder());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c))
                set.add(c - '0');
        }
        if (set.size() <= 1) return -1;
        set.pollFirst();
        return set.pollFirst();
    }
}
