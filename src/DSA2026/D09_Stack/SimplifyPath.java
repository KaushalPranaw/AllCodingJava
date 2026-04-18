package DSA2026.D09_Stack;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        //Input: path = "/home/"
        //Output: "/home"

        //Input: path = "/home//foo/"
        //Output: "/home/foo"

        //Input: path = "/home/user/Documents/../Pictures"
        //Output: "/home/user/Pictures"

        //Input: path = "/../"
        //Output: "/"
        String[] testCases = {
                "/home/",
                "/home//foo/",
                "/home/user/Documents/../Pictures",
                "/../",
                "/a/./b/../../c/",
                "/a//b////c/d//././/.."
        };

        for (String path : testCases) {
            System.out.println("Input: " + path);
            System.out.println("Output: " + simplifyPath(path));
            System.out.println();
        }
    }

    public static String simplifyPath(String path) {
        String[] components = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String component : components) {
            if (component.isEmpty() || component.equals(".")) {
                continue;
            }

            if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(component);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/").append(s);
        }

        return !sb.isEmpty() ? sb.toString() : "/";

    }
}
