package string;

/**
 * 2114. Maximum Number of Words Found in Sentences
 * https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/
 *
 * A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
 *
 * You are given an array of strings sentences, where each sentences[i] represents a single sentence.
 *
 * Return the maximum number of words that appear in a single sentence.
 */
public class MostWordsFound {
    public int mostWordsFound(String[] sentences) {
        int result = Integer.MIN_VALUE;
        for (String s: sentences) {
            result = Math.max(result, s.split(" ").length);
        }
        return result;
    }
}
