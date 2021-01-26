package trie;

import java.util.ArrayList;
import java.util.List;

public class FindWords {
    public static void main(String[] args) {

    }

    static List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }

    static void dfs(char[][] board, int i, int j, TrieNode trieNode, List<String> result) {
        char c = board[i][j];
        if (c == '#' || trieNode.next[c - 'a'] == null)
            return;
        trieNode = trieNode.next[c - 'a'];
        if (trieNode.word != null) {
            result.add(trieNode.word);
            trieNode.word = null;
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j, trieNode, result);
        if (j > 0) dfs(board, i, j - 1, trieNode, result);
        if (i < board.length - 1) dfs(board, i + 1, j, trieNode, result);
        if (j < board[0].length - 1) dfs(board, i, j + 1, trieNode, result);
        board[i][j] = c;
    }

    static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (node.next[i] == null)
                    node.next[i] = new TrieNode();
                node = node.next[i];
            }
            node.word = word;
        }

        return root;
    }

    static class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
