package com.ofloxacin.interview.bytedance;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-04-20
 */
public class ByteDance_001 {

    private List<String> strings;

    @Before
    public void init() {
        strings = new ArrayList<String>() {{
            add("aadbbcc");
            add("abaca");
            add("aaabbccc");
        }};
    }

    /**
     * 简单版消消乐
     * aadbbcc="aadcc"
     * abaca="aa"
     * aabbccc=""
     */
    @Test
    public void test() {
        strings.forEach(s -> System.out.println(sub(s)));
    }

    private String sub(String str) {
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (cur == 'b') {
                continue;
            }
            if (cur != 'a' && cur != 'c') {
                characters.push(cur);
                continue;
            }
            if (valid(characters, cur)) {
                characters.push(cur);
            } else {
                characters.pop();
            }
        }
        return toStr(characters);
    }

    private boolean valid(Stack<Character> characters, char cur) {
        if (characters.isEmpty()) {
            return true;
        }
        Character peek = characters.peek();
        if (peek != 'a' && peek != 'c') {
            return true;
        }
        return peek == cur;
    }

    private String toStr(Stack<Character> characters) {
        StringBuilder sb = new StringBuilder();
        characters.forEach(sb::append);
        return sb.toString();
    }
}
