package trie;

import java.util.List;

/**
 * 139. Word Break
 *
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        var trie = new Trie();
        for (String w: wordDict) {
            trie.addWord(w);
        }
        return hasWord(0, s, trie, new Boolean[s.length()]);
    }

    boolean hasWord(int start, String word, Trie trie, Boolean[] memo) {
        if (start == word.length()) {
            return true;
        }
        if (memo[start] == null) {
            var idx = start;
            var child = trie;
            while (idx < word.length()) {
                child = child.getChild(word.charAt(idx));
                if (child == null) {
                    break;
                }
                if (child.terminal && hasWord(idx + 1, word, trie, memo)) {
                    return true;
                }
                idx++;
            }
            memo[start] = false;
        }
        return memo[start];
    }

    static final class Trie {
        Trie[] children;
        boolean terminal;

        void addWord(String word) {
            var parent = this;
            for (int i = 0; i < word.length(); i++) {
                parent = parent.addChild(word.charAt(i));
            }
            parent.terminal = true;
        }

        Trie addChild(char ch) {
            if (children == null) {
                children = new Trie[26];
            }

            var idx = ch - 'a';
            if (children[idx] == null) {
                children[idx] = new Trie();
            }
            return children[idx];
        }

        Trie getChild(char ch) {
            if (children == null) {
                return null;
            }
            return children[ch - 'a'];
        }
    }
}
