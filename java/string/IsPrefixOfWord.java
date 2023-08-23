package string;

/**
 * 1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence
 *
 * Given a sentence that consists of some words separated by a single space, and a searchWord, check if searchWord is a prefix of any word in sentence.
 *
 * Return the index of the word in sentence (1-indexed) where searchWord is a prefix of this word. If searchWord is a prefix of more than one word, return the index of the first word (minimum index). If there is no such word return -1.
 *
 * A prefix of a string s is any leading contiguous substring of s.
 */
public class IsPrefixOfWord {

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] strings = sentence.split(" ");
        for (int index = 0; index < strings.length; index++) {
            int j = 0;
            int i = 0;
            while(j < searchWord.length()
                    && i < strings[index].length()
                    && searchWord.charAt(j) == strings[index].charAt(i)) {
                j++;
                i++;
            }
            if (j == searchWord.length()) {
                return index + 1;
            }
        }
        return -1;
    }

    /**
     *     def isPrefixOfWord(self, sentence: str, searchWord: str) -> int:
     *         strings = sentence.split(" ")
     *         for index in range(len(strings)):
     *             i = 0
     *             j = 0
     *             while j < len(searchWord) and i < len(strings[index]) and searchWord[j] == strings[index][i]:
     *                 j += 1
     *                 i += 1
     *
     *             if j == len(searchWord):
     *                 return index + 1
     *         return -1
     */

    /**
     * func isPrefixOfWord(sentence string, searchWord string) int {
     *     strings := strings.Split(sentence, " ")
     *     for index := 0; index < len(strings); index++ {
     *         i := 0
     *         j := 0
     *         for j < len(searchWord) && i < len(strings[index]) && searchWord[j] == strings[index][i] {
     *             j++
     *             i++
     *         }
     *         if j == len(searchWord) {
     *             return index + 1
     *         }
     *     }
     *     return -1
     * }
     */
}
