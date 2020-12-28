package trie;

public class ImplementTrie {
    public static void main(String[] args) {
        new ImplementTrie().test();
    }

    void test() {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.insert("appletree");
        System.out.println("Searching apple ==> "+ trie.search("apple"));   // returns true
        System.out.println("Searching appletree ==> "+ trie.search("appletree"));
        System.out.println("Searching app ==> "+ trie.search("app"));     // returns false
        System.out.println("Search starts with app ==> "+  trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println("Searching app ==> "+trie.search("app"));     // returns true
    }

    class Trie {

        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void insert(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char currentCharacter = word.charAt(i);
                if (!current.containsKey(currentCharacter))
                    current.put(currentCharacter, new TrieNode());
                current = current.get(currentCharacter);
            }
            current.setEnd(true);
        }

        TrieNode searchPrefix(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char currentCharacter = word.charAt(i);
                if (current.containsKey(currentCharacter))
                    current = current.get(currentCharacter);
                else
                    return null;
            }
            return current;
        }

        boolean search(String word) {
            TrieNode current = searchPrefix(word);
            return current != null && current.isEnd();
        }

        boolean startsWith(String word) {
            TrieNode current = searchPrefix(word);
            return current != null;
        }

    }

    class TrieNode {
        TrieNode[] links;
        final int R = 26;
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

        void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd(boolean end) {
            this.end = end;
        }

        public boolean isEnd() {
            return end;
        }
    }


}
