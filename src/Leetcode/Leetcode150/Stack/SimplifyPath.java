package Leetcode.Leetcode150.Stack;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        String path = "/home/";// "/home"
        String path2 = "/home//foo/";// "/home/foo"
        String path3 = "/home/user/Documents/../Pictures";// "/home/user/Pictures"
        String path4 = "/../";// "/"
        SimplifyPath o = new SimplifyPath();
        System.out.println(o.simplifyPath(path));
        System.out.println(o.simplifyPath(path2));
        System.out.println(o.simplifyPath(path3));
        System.out.println(o.simplifyPath(path4));

    }

    public String simplifyPath(String path) {
        String[] components = path.split("/");

        Stack<String> stack = new Stack<>();

        for (String component : components) {
            if (component.isEmpty() || component.equals(".")) {
                continue;
            } else {
                if (component.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(component);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/").append(s);
        }
        return !sb.isEmpty() ? sb.toString() : "/";

    }
}
