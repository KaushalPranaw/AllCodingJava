package Leetcode.Graph.G02_Problem_On_BFS_DFS;

import java.util.*;

public class G11_WordLadderI {
    public static void main(String[] args) {
        String startWord = "der", targetWord = "dfs";
        String[] wordList = {
                "des",
                "der",
                "dfr",
                "dgt",
                "dfs"
        };

        G11_WordLadderI obj = new G11_WordLadderI();
        int ans = obj.wordLadderLength(startWord, targetWord, wordList);

        System.out.print(ans);
    }

    private int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(wordList));
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startWord, 1));
        wordSet.remove(startWord);

        while (!queue.isEmpty()) {
            String word = queue.peek().word;
            int steps = queue.peek().steps;
            queue.poll();
            if (word.equals(targetWord)) {
                return steps;
            }

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    //char[] ra = word.toCharArray();
                    //ra[i] = ch;
                    //String replaced = new String(ra);
                    //or
                    String replaced = word.substring(0, i) + ch + word.substring(i + 1);
                    if (wordSet.contains(replaced)) {
                        wordSet.remove(replaced);
                        queue.add(new Node(replaced, steps + 1));
                    }
                }
            }
        }

        return 0;
    }

    record Node(String word, int steps) {
    }
}
