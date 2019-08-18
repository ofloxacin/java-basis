package com.ofloxacin;

import java.util.Stack;

/**
 * @author ChenShuai
 * @date 2018/6/12 9:26
 */
public class CustomQueue {

    private Stack<Object> s1 = new Stack<Object>();

    private Stack<Object> s2 = new Stack<Object>();

    public void add(Object o) {
        if (null != o) {
            s1.push(o);
        }
    }

    public Object pull() {
        if (s2.size() == 0) {
            while (s1.size() > 0) {
                s2.push(s1.pop());
            }
        }

        return s2.size() == 0 ? null : s2.pop();
    }

    public Object peek() {
        if (s2.size() == 0) {
            while (s1.size() > 0) {
                s2.push(s1.pop());
            }
        }

        return s2.size() == 0 ? null : s2.peek();
    }

    public int size() {
        return s1.size() + s2.size();
    }
}
