package Leetcode.Graph.G02_Problem_On_BFS_DFS;

import java.util.*;
//https://takeuforward.org/graph/g-30-word-ladder-ii/
public class G12_WordLadderII {
    public static void main(String[] args) {
        String startWord = "der", targetWord = "dfs";
        String[] wordList = {
                "des",
                "der",
                "dfr",
                "dgt",
                "dfs"
        };

        G12_WordLadderII obj = new G12_WordLadderII();
        List<List<String>> ans = obj.findSequences(startWord, targetWord, wordList);

        // If no transformation sequence is possible.
        if (ans.size() == 0)
            System.out.println(-1);
        else {
            for (int i = 0; i < ans.size(); i++) {
                for (int j = 0; j < ans.get(i).size(); j++) {
                    System.out.print(ans.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }

    private List<List<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        List<String> list = new ArrayList<>(List.of(wordList));

        // Creating a queue ds which stores the words in a sequence which is
        // required to reach the targetWord after successive transformations
        Queue<List<String>> queue = new LinkedList<>();
        List<String> ls = new ArrayList<>();
        ls.add(startWord);
        queue.add(ls);

        List<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);
        int level = 0;


        List<List<String>> ans = new ArrayList<>();
        int count = 0;

        // BFS traversal with pushing the new formed sequence in queue
        // when after a transformation, a word is found in wordList.
        while (!queue.isEmpty()) {
            count++;
            List<String> vec = queue.poll();

            // Now, erase all words that have been
            // used in the previous levels to transform
            if (vec.size() > level) {
                level++;
                for (String it : usedOnLevel) {
                    list.remove(it);
                }
            }

            String word = vec.get(vec.size() - 1);

            // store the answers if the end word matches with targetWord.
            if (word.equals(targetWord)) {
                // the first sequence where we reached the end.
                if (ans.size() == 0) {
                    ans.add(vec);
                } else if (ans.get(0).size() == vec.size()) {
                    ans.add(vec);
                }
            }

            for (int i = 0; i < word.length(); i++) {
                // Now, replace each character of ‘word’ with char
                // from a-z then check if ‘word’ exists in wordList
                for (char c = 'a'; c <= 'z'; c++) {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = c;
                    String replacedWord = new String(replacedCharArray);
                    if (list.contains(replacedWord)) {
                        vec.add(replacedWord);
                        // Java works by reference, so enter the copy of vec
                        // otherwise if you remove word from vec in next lines, it will
                        // remove from everywhere
                        List<String> temp = new ArrayList<>(vec);
                        queue.add(temp);
                        // mark as visited on the level
                        usedOnLevel.add(replacedWord);
                        vec.remove(vec.size() - 1);
                    }
                }
            }
        }
        return ans;


    }

}
