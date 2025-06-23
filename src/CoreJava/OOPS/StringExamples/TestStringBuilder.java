package CoreJava.OOPS.StringExamples;

public class TestStringBuilder {
    public static void main(String[] args) {
        /*StringBuilder str = new StringBuilder("Hello");
        str.append(" World");
        System.out.println(str.toString());*/

        /*StringBuilder sb=new StringBuilder();
        for(int i=1;i<=10;i++){
            sb.append(i);
        }
        System.out.println(sb.toString());*/


        StringBuilder sb1 = new StringBuilder("Hello");
        StringBuilder sb2 = new StringBuilder("Hello");
        // Using ==
        System.out.println(sb1 == sb2); // false (different objects)
        // Using .equals()
        System.out.println(sb1.equals(sb2)); // false (default implementation checks references)
        System.out.println(sb1.toString().equals(sb2.toString())); // true
        System.out.println(sb1.toString() == sb2.toString());
    }
}
