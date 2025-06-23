package Comp.ReaIndia;

import java.util.Stack;

public class First {
    public static void main(String[] args) {
        String[] ops = {"15", "2", "C", "D", "+"};
        System.out.println(getScore(ops));
        //An integer x.
        //Record a new score of x.
        //'+'.
        //Record a new score that is the sum of the previous two scores.
        //'D'.
        //Record a new score that is the double of the previous score.
        //'C'.
        //Invalidate the previous score, removing it from the record.
    }

    private static int getScore(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            if (getNumberFromString(op)) {
                //if (Character.isDigit(op.charAt(0))) {
                stack.push(Integer.parseInt(op));
            } else if (Character.isLetter(op.charAt(0))) {
                if (op.charAt(0) == 'C') {
                    if (!stack.isEmpty())
                        stack.pop();
                }
                if (op.charAt(0) == 'D') {
                    if (!stack.isEmpty()) {
                        int num = stack.peek();
                        stack.push(num * 2);
                    }
                }
            } else {
                int num2 = stack.pop();
                int num1 = stack.peek();
                stack.push(num2);
                stack.push(num1 + num2);
            }
        }

        return stack.stream().mapToInt(num -> (int) num).sum();
    }

    private static boolean getNumberFromString(String op) {
        return Character.isDigit(op.charAt(0));
    }

}
