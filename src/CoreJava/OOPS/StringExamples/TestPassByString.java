package CoreJava.OOPS.StringExamples;

public class TestPassByString {
    public static void main(String[] args) {
        String str1 = "Hello!";
        StrConcat(str1);
        System.out.println("The final String is - " + str1);

        StringBuffer str2 = new StringBuffer("Hello!");
        StrBufConcat(str2);
        System.out.println("The final String is - " + str2);//Hello!Edureka

        StringBuilder str3 = new StringBuilder("Hello!");
        StrBuildConcat(str3);
        System.out.println("The final String is -" + str3);//Hello!Edureka

        String str4 = new String("Hello!");
        StrConcat(str4);
        System.out.println("The final String is -" + str4);//Hello!
    }

    public static void StrConcat(String str1) {
        str1 = str1 + "Edureka";
    }

    public static void StrBufConcat(StringBuffer str2) {
        str2.append("Edureka");
    }

    public static void StrBuildConcat(StringBuilder str3) {
        str3.append("Edureka");
    }
}
