package com.ofloxacin.temp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-09-02
 */
public class Test3 {

    public static void main(String[] args) {
        List<String> generate = generate(3);
        for (String str : generate) {
            System.out.println(str);
        }
    }

    public static List<String> generate(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        dfs(sb, n, n, result);
        return result;
    }

    private static void dfs(StringBuilder path, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(path.toString());
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            path.append('(');
            dfs(path, left - 1, right, result);
            path.deleteCharAt(path.length() - 1);
        }
        if (right > 0) {
            path.append(')');
            dfs(path, left, right - 1, result);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
