package com.ofloxacin.temp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-09-02
 */
public class Test2 {

    public static void main(String[] args) {
        List<String> result = generate(3);
        result.forEach(System.out::println);
    }

    public static List<String> generate(int n) {
        List<String> result = new ArrayList<>();
        if (n > 0) {
            dfs("", 0, 0, 0, result);
        }
        return result;
    }

    public static void dfs(String str, int n, int l, int r, List<String> result) {
        if (l == n && r == n) {
            result.add(str);
            return;
        }
        if (l < r) {
            return;
        }
        if (l < n) {
            dfs(str + "(", n, l + 1, r, result);
        }
        if (r < n) {
            dfs(str + ")", n, l, r + 1, result);
        }
    }
}
