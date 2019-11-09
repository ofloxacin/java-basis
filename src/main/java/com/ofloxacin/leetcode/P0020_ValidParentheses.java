package com.ofloxacin.leetcode;

import java.util.Stack;

/**
 * @author chenshuai
 * @version 0.1
 * @name P0020_ValidParentheses
 * @description
 * @date 2019/11/9
 */
public class P0020_ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }

    public static boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid3(String s) {
        if (s.length() == 0) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            switch (array[i]) {
                case '(':
                case '{':
                case '[':
                    stack.push(array[i]);
                    if (stack.size() > array.length / 2) {
                        return false;
                    }
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        return stack.size() == 0;
    }

    public static boolean isValid2(String s) {
        if (s.length() == 0) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        do {
            int len = s.length();
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
            if (len == s.length()) {
                return false;
            }
        } while (s.length() != 0);
        return true;
    }
}
