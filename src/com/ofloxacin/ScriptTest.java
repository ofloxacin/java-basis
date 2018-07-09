package com.ofloxacin;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author ChenShuai
 * @date 2018/7/9 17:45
 */
public class ScriptTest {
    private static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");
    public static void main(String[] args) {
        try {
            System.out.println(jse.eval("if (1==1){Math.pow(2, 3)}else{2}"));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
