package com.ofloxacin.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author chens
 * @date 2018/11/9 14:02
 */
public class P003_LongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring3("abcabcbb"));
        System.out.println(lengthOfLongestSubstring3("bbbbb"));
        System.out.println(lengthOfLongestSubstring3("pwwkew"));
        System.out.println(lengthOfLongestSubstring3("pq"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Set<Character> container = new LinkedHashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (container.contains(c)) {
                if (maxLength < container.size()) {
                    maxLength = container.size();
                }
                if (maxLength + i > s.length() - 1) {
                    return maxLength;
                }
                Iterator<Character> iterator = container.iterator();
                while (iterator.hasNext()) {
                    char current = iterator.next();
                    iterator.remove();
                    if (current == c) {
                        break;
                    }
                }
            }
            container.add(c);
        }
        return maxLength > container.size() ? maxLength : container.size();
    }

    public static int lengthOfLongestSubstring2(String s) {
        int maxLen = 0, n = s.length();
        int i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxLen = Math.max(maxLen, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return maxLen;
    }

    public static int lengthOfLongestSubstring3(String s) {
        int maxLen = 0, n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                i = Math.max(i, map.get(c) + 1);
            }
            maxLen = Math.max(maxLen, j - i + 1);
            map.put(c, j);
        }
        return maxLen;
    }
}
