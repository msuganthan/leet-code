package trie;

public class WordDictionary {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    void addWord(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!currentNode.containsKey(ch))
                currentNode.put(ch, new TrieNode());
            currentNode = currentNode.get(ch);
        }
        currentNode.setEnd(true);
    }

    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    boolean match(char[] chars, int k, TrieNode trieNode) {
        if (k == chars.length)
            return true;
        if (chars[k] == '.') {
            for (int i = 0; i < trieNode.links.length; i++) {
                if (trieNode.links[i] != null && match(chars, k + 1, trieNode.links[i]))
                    return true;
            }
        } else {
            return trieNode.get(chars[k]) != null && match(chars, k + 1, trieNode.get(chars[k]));
        }
        return false;
    }

    class TrieNode {
        TrieNode[] links;
        boolean end;

        TrieNode() {
            links = new TrieNode[26];
        }

        boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        void put(char ch, TrieNode trieNode) {
            links[ch - 'a'] = trieNode;
        }

        public void setEnd(boolean end) {
            this.end = end;
        }

        public boolean isEnd() {
            return end;
        }
    }
}
