package Leetcode.Trie;

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        // Insert words
        trie.insert("apple");
        trie.insert("app");
        trie.insert("banana");

        // Search for words
        System.out.println("Search 'apple': " + trie.search("apple"));   // true
        System.out.println("Search 'app': " + trie.search("app"));       // true
        System.out.println("Search 'orange': " + trie.search("orange")); // false

        // Check prefixes
        System.out.println("Starts with 'app': " + trie.startsWith("app"));  // true
        System.out.println("Starts with 'ban': " + trie.startsWith("ban"));  // true
        System.out.println("Starts with 'ora': " + trie.startsWith("ora"));  // false

        // Edge cases
        System.out.println("Search empty string: " + trie.search(""));      // false
        System.out.println("Starts with empty string: " + trie.startsWith("")); // true
    }
}
