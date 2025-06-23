package Leetcode.Auto.Premium;

import java.util.Stack;

public class DeleteMiddleElement {
    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        //stack1.push(5);

        System.out.println("Original Stack 1: " + stack1);
        deleteMiddle(stack1);
        System.out.println("Stack 1 after deleting middle: " + stack1);

    }

    private static void deleteMiddle(Stack<Integer> stack) {
        if(stack==null || stack.isEmpty()){
            return;
        }
        int size=stack.size();

        int midIndex=size/2;

        deleteMiddleRecur(stack, midIndex, 0);
    }

    private static void deleteMiddleRecur(Stack<Integer> stack, int midIndex, int ind) {
        if (stack.isEmpty()) {
            return;
        }
        int temp=stack.pop();

        if(ind==midIndex){
            return;
        }
        deleteMiddleRecur(stack, midIndex, ind+1);
        stack.push(temp);
    }

}
