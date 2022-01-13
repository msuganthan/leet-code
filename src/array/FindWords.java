package array;

/**
 * 500. Keyboard Row
 * https://leetcode.com/problems/keyboard-row/
 *
 * Given an array of strings words, return the words that can be typed using letters of the alphabet on only
 * one row of American keyboard like the image below.
 *
 * In the American keyboard:
 *
 * the first row consists of the characters "qwertyuiop",
 * the second row consists of the characters "asdfghjkl", and
 * the third row consists of the characters "zxcvbnm".
 */
public class FindWords {
    public String[] findWords(String[] words) {
        Set<Character> row1 = "qwertyuiop".chars().mapToObj(c->(char)c).collect(Collectors.toSet());
        Set<Character> row2 = "asdfghjkl".chars().mapToObj(c->(char)c).collect(Collectors.toSet());
        Set<Character> row3 = "zxcvbnm".chars().mapToObj(c->(char)c).collect(Collectors.toSet());
        String[] result = new ;
        for(String word: words) {
            Set<Character> wordSet = word.toLowerCase().chars().mapToObj(c->(char)c).collect(Collectors.toSet());
            if (row1.containsAll(wordSet) || row2.containsAll(wordSet) || row3.containsAll(wordSet))
                result.add(word);
        }
        return result.toArray(new String[0]);
    }
}
