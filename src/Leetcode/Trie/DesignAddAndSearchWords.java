package Leetcode.Trie;

class WordDictionary {
    private WordDictionary[] children;
    boolean isEndOfWord;

    public WordDictionary() {
        children = new WordDictionary[26];
        isEndOfWord = false;
    }

    public void addWord(String word) {
        WordDictionary cur = this;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new WordDictionary();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isEndOfWord = true;
    }

    public boolean search(String word) {
        WordDictionary cur = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (WordDictionary ch : cur.children) {
                    if (ch != null && ch.search(word.substring(i + 1))) {
                        return true;
                    }
                }
                return false;
            }
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return cur != null && cur.isEndOfWord;
    }
}

public class DesignAddAndSearchWords {
    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();

        // Adding words to the dictionary
        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");

        // Searching for exact words
        System.out.println(dictionary.search("pad")); // false
        System.out.println(dictionary.search("bad")); // true

        // Searching with '.' wildcard
        System.out.println(dictionary.search(".ad")); // true
        System.out.println(dictionary.search("b..")); // true
        System.out.println(dictionary.search("...")); // true
        System.out.println(dictionary.search(".."));  // false
    }
}

