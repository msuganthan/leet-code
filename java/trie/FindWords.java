package trie;

import java.util.ArrayList;
import java.util.List;

public class FindWords {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, result, root);
            }
        }
        return result;
    }

    void dfs(char[][] board, int i, int j, List<String> result, TrieNode trieNode) {
        if(i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1) {
            return;
        }
        char c = board[i][j];
        if(c == '#' || trieNode.links[c - 'a'] == null) {
            return;
        }
        trieNode = trieNode.links[c - 'a'];
        if(trieNode.word != null) {
            result.add(trieNode.word);
            trieNode.word = null;
        }
        board[i][j] = '#';
        dfs(board, i - 1, j, result, trieNode);
        dfs(board, i + 1, j, result, trieNode);
        dfs(board, i, j - 1, result, trieNode);
        dfs(board, i, j + 1, result, trieNode);
        board[i][j] = c;
    }

    static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word: words) {
            TrieNode node = root;
            for(char c: word.toCharArray()) {
                if(node.links[c - 'a'] == null) {
                    node.links[c - 'a'] = new TrieNode();
                }
                node = node.links[c - 'a'];
            }
            node.word = word;
        }
        return root;
    }

    static class TrieNode {
        TrieNode[] links;
        String word;

        TrieNode() {
            links = new TrieNode[26];
        }
    }
}
