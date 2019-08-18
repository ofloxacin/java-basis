package com.ofloxacin.script;

import java.util.List;

/**
 * @author ChenShuai
 * @date 2018/7/12 15:58
 */
public class Expression {

    public static class Node {

        public String code;

        public String name;

        public String value;

        public String exp;

        public List<Expression.Node> subExp;

        public Node(String code, String name, String value, String exp, List<Expression.Node> subExp) {
            this.code = code;
            this.name = name;
            this.value = value;
            this.exp = exp;
            this.subExp = subExp;
        }
    }
}