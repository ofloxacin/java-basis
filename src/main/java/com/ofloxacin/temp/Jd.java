package com.ofloxacin.temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenshuai
 * @date 2020/08/30
 */
public class Jd {

    private static int max = 0;

    private static int n;

    private static List<List<Integer>> data = new ArrayList<>();

    static {
        data.add(Arrays.asList(1));
        data.add(Arrays.asList(2, 4, 3));
        data.add(Arrays.asList(1, 3, 2, 4, 9));
        n = 3;
    }

    public static void main(String[] args) {
        dfs(data.get(0).get(0), 0, 0);
        System.out.println(max);
        System.out.println(dfs2(data, 0, 0));
    }

    static void dfs(int grade, int i, int heigh) {
        if (heigh == n - 1) {
            max = Math.max(grade, max);
            return;
        }
        dfs(grade + data.get(heigh + 1).get(i), i, heigh + 1);
        dfs(grade + data.get(heigh + 1).get(i + 1), i + 1, heigh + 1);
        dfs(grade + data.get(heigh + 1).get(i + 2), i + 2, heigh + 1);
    }

    static int dfs2(List<List<Integer>> data, int i, int j) {
        if (i == data.size()) {
            return 0;
        }
        int num = data.get(i).get(j);
        int l = dfs2(data, i + 1, j);
        int m = dfs2(data, i + 1, j + 1);
        int r = dfs2(data, i + 1, j + 2);
        return num + Math.max(Math.max(l, m), r);
    }
}
