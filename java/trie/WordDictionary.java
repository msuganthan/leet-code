package trie;

public class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(current.links[c - 'a'] == null) {
                current.links[c - 'a'] = new TrieNode();
            }
            current = current.links[c - 'a'];
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        return search(word, root, 0);
    }

    boolean search(String word, TrieNode current, int index) {
        for(int i = index; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c == '.') {
                for(TrieNode node: current.links) {
                    if(node != null && search(word, node, i + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                if(current.links[c - 'a'] != null) {
                    current = current.links[c - 'a'];
                } else {
                    return false;
                }
            }
        }
        return current.isEnd;
    }

    static class TrieNode {
        TrieNode[] links;
        boolean isEnd;
        TrieNode() {
            links = new TrieNode[26];
        }
    }
}
