package May2026.DSA.Day3.DSA.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class PS05_CountEqual0sAnd1s {
    public static void main(String[] args) {
        int[] arr={0, 0, 1, 0, 1, 1};//output: 5
        System.out.println(countEqual0sAnd1s(arr));
    }

    private static int countEqual0sAnd1s(int[] arr) {
        //sbse phle 0 ko -1 me convert krdo taki hume 0 aur 1 ke equal count mil jaye
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                arr[i]=-1;
            }
        }

        int count=0;
        int k=0;
        int currentPrefixSum=0;
        Map<Integer, Integer> map=new HashMap<>();
        map.put(0, 1);//prefix sum 0 ka count 1 se start hoga
        //ab prefix sum nikalte hue count karte jao ki kitne prefix sum
        for(int num: arr){
            currentPrefixSum+=num;

            int oldPrefixSum=currentPrefixSum-k;
            if(map.containsKey(oldPrefixSum)){
                count+=map.get(oldPrefixSum);
            }

            //update the count of current prefix sum in the map
            map.put(currentPrefixSum, map.getOrDefault(currentPrefixSum, 0)+1);
        }
        return count;
    }
}
