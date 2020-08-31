package com.ofloxacin.script;

import com.ofloxacin.util.TimeSpanUtil;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ChenShuai
 * @date 2018/7/9 17:45
 */
public class ScriptTest {

    private static final ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");

    private static final int MAX_COUNT = 10000;

    public static void main(String[] args) {
        TimeSpanUtil.init();
        Expression.Node length = new Expression.Node("length", "长", "300", null, null);
        Expression.Node width = new Expression.Node("width", "宽", "200", null, null);
        Expression.Node height = new Expression.Node("height", "高", "100", null, null);
        Expression.Node bolang = new Expression.Node("bolang", "波浪刀", null, "$[length]+$[width]", Arrays.asList(length, width));
        Expression.Node zhidao = new Expression.Node("zhidao", "直刀", null, "$[length]*$[height]", Arrays.asList(length, height));
        Expression.Node node = new Expression.Node("knife_fee", "刀版费", null, "$[bolang]+$[zhidao]", Arrays.asList(bolang, zhidao));

        Set<Expression.Node> result = new HashSet<>();
        //eval(node, result);
        System.out.println(eval(height, result));
        System.out.println(eval(bolang, result));

        TimeSpanUtil.printSpan();
    }

    public static String eval(Expression.Node node, Set<Expression.Node> result) {
        if (result.contains(node)) {
            return node.value;
        }

        if (node.subExp == null) {
            result.add(node);
            return node.value;
        }

        for (Expression.Node node1 : node.subExp) {
            node1.value = eval(node1, result);
        }

        String newExp = replaceSubExp(node);

        try {
            node.value = jse.eval(newExp).toString();
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        return node.value;
    }

    public static String replaceSubExp(Expression.Node node) {
        String exp = node.exp;
        for (Expression.Node subNode : node.subExp) {
            exp = exp.replace("$[" + subNode.code + "]", subNode.value);
        }
        return exp;
    }
}
