package com.ofloxacin.other;

import lombok.Getter;
import lombok.Setter;

/**
 * @author chens
 * @date 2019/5/10 16:05
 */

@Getter
@Setter
public class Node {

    private Object value;

    private Node pre;

    private Node next;

    public Node(Object value) {
        this.value = value;
    }
}
