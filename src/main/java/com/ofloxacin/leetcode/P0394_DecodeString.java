package com.ofloxacin.leetcode;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-28
 */
public class P0394_DecodeString {

    @Test
    public void test() {
        Solution solution = new Solution3();
        //System.out.println(solution.decodeString("3[a]2[bc]"));
        System.out.println(solution.decodeString("3[a2[c]]"));
        System.out.println(solution.decodeString("2[abc]3[cd]ef"));
        System.out.println(solution.decodeString("15[a]"));
        System.out.println(solution.decodeString("abc3[a2[bc]]"));
        System.out.println(solution.decodeString("aaaaaa2[b]"));
        System.out.println(solution.decodeString("100[leetcode]"));
    }

    /**
     * 栈
     */
    class Solution1 implements Solution {

        @Override
        public String decodeString(String s) {
            LinkedList<Character> stack = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != ']') {
                    stack.push(s.charAt(i));
                    continue;
                }
                StringBuilder text = new StringBuilder();
                char c;
                while ((c = stack.pop()) != '[') {
                    text.append(c);
                }
                int num = 0, pow = 0;
                while (stack.peek() != null && (stack.peek() >= '0' && stack.peek() <= '9')) {
                    num += (stack.pop() - '0') * Math.pow(10, pow++);
                }
                text.reverse();
                for (int j = 0; j < num; j++) {
                    for (int k = 0; k < text.length(); k++) {
                        stack.push(text.charAt(k));
                    }
                }
            }
            StringBuilder text = new StringBuilder();
            while (!stack.isEmpty()) {
                text.append(stack.pop());
            }
            return text.reverse().toString();
        }
    }

    /**
     * 递归
     */
    class Solution2 implements Solution {

        @Override
        public String decodeString(String s) {
            return decode("1[" + s + "]", 2, 1);
        }

        private String decode(String s, int pos, int n) {
            StringBuilder context = new StringBuilder();
            int sub = 0;
            for (int i = pos; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ']') {
                    break;
                } else if (c == '[') {
                    context.append(decode(s, i + 1, sub));
                    sub = 0;
                    i = skipPair(s, i);
                } else if (c >= '0' && c <= '9') {
                    sub = sub * 10 + (c - '0');
                } else {
                    context.append(c);
                }
            }
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < n; i++) {
                result.append(context.toString());
            }
            return result.toString();
        }

        private int skipPair(String s, int i) {
            int count = 1;
            while (true) {
                i++;
                if (s.charAt(i) == '[') {
                    count++;
                } else if (s.charAt(i) == ']') {
                    count--;
                    if (count == 0) {
                        break;
                    }
                }
            }
            return i;
        }
    }

    /**
     * 递归
     */
    class Solution3 implements Solution {

        int i = 2;

        @Override
        public String decodeString(String s) {
            i = 2;
            return decode("1[" + s + "]", 1);
        }

        private String decode(String s, int n) {
            StringBuilder context = new StringBuilder();
            int sub = 0;
            for (; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ']') {
                    break;
                } else if (c == '[') {
                    i++;
                    context.append(decode(s, sub));
                    sub = 0;
                } else if (c >= '0' && c <= '9') {
                    sub = sub * 10 + (c - '0');
                } else {
                    context.append(c);
                }
            }
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < n; i++) {
                result.append(context.toString());
            }
            return result.toString();
        }
    }

    /**
     * 递归 leetcode
     */
    class Solution4 implements Solution {

        @Override
        public String decodeString(String s) {
            return null;
        }
    }

    interface Solution {

        String decodeString(String s);
    }
}
