package Leetcode.Trie;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    public static void main(String[] args) {
        WordSearchII solution = new WordSearchII();

        // Example 1
        char[][] board1 = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words1 = {"oath", "pea", "eat", "rain"};
        List<String> result1 = solution.findWords(board1, words1);
        System.out.println("Example 1 Output: " + result1); // Expected: ["eat","oath"]

        // Example 2
        char[][] board2 = {
                {'a', 'b'},
                {'c', 'd'}
        };
        String[] words2 = {"abcb"};
        List<String> result2 = solution.findWords(board2, words2);
        System.out.println("Example 2 Output: " + result2); // Expected: []

        // Example 3
        char[][] board3 = {
                {'a', 'a'}
        };
        String[] words3 = {"aaa"};
        List<String> result3 = solution.findWords(board3, words3);
        System.out.println("Example 3 Output: " + result3); // Expected: []
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
        char c = board[i][j];
        if (c == '#' || node.children[c - 'a'] == null) return;

        node = node.children[c - 'a'];

        if (node.word != null) {
            result.add(node.word);
            node.word = null; // Avoid duplicate entries
        }

        board[i][j] = '#'; // Mark as visited

        if (i > 0) dfs(board, i - 1, j, node, result);
        if (j > 0) dfs(board, i, j - 1, node, result);
        if (i < board.length - 1) dfs(board, i + 1, j, node, result);
        if (j < board[0].length - 1) dfs(board, i, j + 1, node, result);

        board[i][j] = c; // Backtrack
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = word;
        }
        return root;
    }

}
