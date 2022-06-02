package twoPointers;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {
        partitionLabels("ababcbacadefegdehijhklij")
                .forEach(System.out::println);
    }

    static List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        int[] lastOccurrences = new int[26];
        for (int i = 0; i < S.length(); i++)
            lastOccurrences[S.charAt(i) - 'a'] = i;

        int j = 0, anchor = 0;
        for (int i = 0; i < S.length(); i++) {
            j = Math.max(j, lastOccurrences[S.charAt(i) - 'a']);
            if(i == j) {
                result.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return result;
    }
}
