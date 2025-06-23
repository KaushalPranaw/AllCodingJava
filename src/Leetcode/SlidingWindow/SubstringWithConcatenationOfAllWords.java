package Leetcode.SlidingWindow;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        String s = "barfoofoobarthefoobarman", words[] = {"bar", "foo", "the"};
        System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring(s, words));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Long> count= Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Integer> indexes=new ArrayList<>();
        int sLength=s.length();
        int wordsLength=words.length;
        int oneWordLength=words[0].length();

        for(int i=0;i<sLength-(wordsLength*oneWordLength)+1;i++){
            Map<String, Integer> map=new HashMap<>();
            int j=0;
            while (j<wordsLength){
                String word=s.substring(i+j*oneWordLength, i+(j+1)*oneWordLength);
                if(count.containsKey(word)){
                    map.put(word, map.getOrDefault(word, 0)+1);
                    if(map.get(word)>count.getOrDefault(word, 0l)){
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if(j==wordsLength){
                indexes.add(i);
            }

        }
        return indexes;



    }
}
