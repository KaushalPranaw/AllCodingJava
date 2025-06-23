package CoreJava.OOPS.StringExamples;

public class TestString {
    public static void main(String[] args) {
        /*String str = "Hello";
        str = str + " World";
        System.out.println(str);*/

        //Immutability
        /*String s1 = "Hello";
        String s2 = s1;
        s1 = s1 + " World";
        System.out.println(s1);
        System.out.println(s2);*/

        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println();
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println();

        s3 = s3.intern();
        System.out.println(s1 == s3);

    }
}
