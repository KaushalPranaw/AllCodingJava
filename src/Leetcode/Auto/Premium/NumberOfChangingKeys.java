package Leetcode.Auto.Premium;

public class NumberOfChangingKeys {
    public static void main(String[] args) {
        String s = "aAbBcC";
        System.out.println(new NumberOfChangingKeys().countKeyChanges(s));
    }
    public int countKeyChanges(String s) {
        char prev=Character.toLowerCase(s.charAt(0));
        int count=0;
        for(int i=1;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.toLowerCase(ch)!=prev){
                count++;
                prev=Character.toLowerCase(ch);
            }
        }
        return count;
    }
}
