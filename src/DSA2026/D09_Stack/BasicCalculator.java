package DSA2026.D09_Stack;

import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        System.out.println(calculate("1 + 1"));                  // 2
        System.out.println(calculate(" 2-1 + 2 "));              // 3
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));    // 23
    }

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        int result = 0;
        int sign = 1;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                //number banao
                number = number * 10 + (c - '0');//adding int digit to number
            } else if (c == '+') {
                //result me number add kro
                //number ko 0 kro
                //sign ko plus kro
                result += (number * sign);
                number = 0;
                sign = 1;
            } else if (c == '-') {
                // previous number ko result me add karo using sign
                // number reset karo
                // next operation ke liye sign update karo
                //means
                //result me number add kro
                //number ko 0 kro
                //sign ko minus kro
                result += (number * sign);
                number = 0;
                sign = -1;
            } else if (c == '(') {
                //mtlb ab hume naya number banana hai to purana save karna hai kahi pe to use stack
                //stack me result push kro
                //stack me sign push kro
                //result naya banana h to make it 0
                //naya number ayega to make it 0
                //naya sign ayega to make it +1
                //means
                // current result aur sign ko stack me store karo (context save)
                // ab new sub-expression start hoga, isliye reset:
                // result = 0, number = 0, sign = +1
                stack.push(result);
                stack.push(sign);
                result = 0;
                number = 0;
                sign = 1;
            } else if (c == ')') {
                //result me add kr do, jo avi calulate kia hai
                //fir result ka sign stack ke sign se multiply krege
                //fir hum stack wale result ko add kr dege cur_result se
                //fir number ko 0 and sign 1 kr do for further processing
                //means
                // current number ko result me add karo
                // stack se sign aur previous result nikalo
                // pehle current result ko stack wale sign se multiply karo
                // fir previous result me add karo (context restore)
                // number aur sign reset karo
                result += number * sign;
                int stack_sign = stack.pop();
                int stack_res = stack.pop();
                result = result * stack_sign;
                result += stack_res;
                number = 0;
                sign = 1;
            }
        }
        result += (number * sign);
        return result;
    }
}
