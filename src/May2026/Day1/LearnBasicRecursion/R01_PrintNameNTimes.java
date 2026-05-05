package May2026.Day1.LearnBasicRecursion;

public class R01_PrintNameNTimes {
    public static void main(String[] args) {
        String name = "pranaw";
        int N = 5;
        printNTime(name, 0, N);
    }

    private static void printNTime(String name, int count, int n) {
        if (count == n) {
            return;
        }
        System.out.println(name);
        printNTime(name, count + 1, n);
    }
}
