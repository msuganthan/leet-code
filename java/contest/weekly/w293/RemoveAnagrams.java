package contest.weekly.w293;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find Resultant Array After Removing Anagrams
 *
 * You are given a 0-indexed string array words, where words[i] consists of lowercase English letters.
 *
 * In one operation, select any index i such that 0 < i < words.length and words[i - 1] and words[i] are anagrams, and delete words[i] from words. Keep performing this operation as long as you can select an index that satisfies the conditions.
 *
 * Return words after performing all operations. It can be shown that selecting the indices for each operation in any arbitrary order will lead to the same result.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase using all the original letters exactly once. For example, "dacb" is an anagram of "abdc".
 */
public class RemoveAnagrams {
    public static void main(String[] args) {
        System.out.println(removeAnagrams(new String[]{"abba","baba","bbaa","cd","cd"}));
    }

    public static List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length;) {
            String first = words[i];
            int j = i + 1;
            boolean hasAnagram = false;
            while (j < words.length && areAnagram(words[i].toCharArray(), words[j].toCharArray())) {
                j++;
                hasAnagram = true;
            }
            result.add(first);
            if (hasAnagram) {
                i = j;
            } else {
                i++;
            }
        }
        return result;
    }

    static boolean areAnagram(char[] str1, char[] str2)
    {
        int n1 = str1.length;
        int n2 = str2.length;

        if (n1 != n2)
            return false;

        Arrays.sort(str1);
        Arrays.sort(str2);

        for (int i = 0; i < n1; i++)
            if (str1[i] != str2[i])
                return false;

        return true;
    }
}
