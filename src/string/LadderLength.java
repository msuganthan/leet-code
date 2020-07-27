package string;

import java.util.*;

public class LadderLength {
    public static void main(String[] args) {
        ladderLength("hot", "dog", Arrays.asList("hot","dog"));
    }

    static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for (String word: wordList)
            set.add(word);

        if (!set.contains(endWord))
            return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                char[] word_chars = currentWord.toCharArray();
                for (int j = 0; j < word_chars.length; j++) {
                    char original_char = word_chars[j];
                    for (char c = 'a'; c < 'z'; c++) {
                        if (word_chars[j] == c) continue;

                        word_chars[j] = c;
                        String newWord = String.valueOf(word_chars);
                        if (newWord.equals(endWord)) return level + 1;
                        if (wordList.contains(newWord)) {
                            queue.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                    word_chars[j] = original_char;
                }
            }
            level++;
        }
        return 0;

    }
}
