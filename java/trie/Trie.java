package trie;

class Trie {

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(current.links[c - 'a'] == null) {
                current.links[c - 'a'] = new TrieNode();
            }
            current = current.links[c - 'a'];
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(current.links[c - 'a'] != null) {
                current = current.links[c - 'a'];
            } else {
                return false;
            }
        }
        return current != null && current.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(current.links[c - 'a'] != null) {
                current = current.links[c - 'a'];
            } else {
                return false;
            }
        }
        return current != null;
    }

    static class TrieNode {
        TrieNode[] links;
        boolean isWord;

        TrieNode() {
            links = new TrieNode[26];
        }
    }
}
