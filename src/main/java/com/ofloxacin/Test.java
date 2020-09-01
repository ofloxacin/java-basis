package com.ofloxacin;

/**
 * @author chens
 **/
public class Test {

    public static void main(String[] args) {
        new StringBuilder("adf").reverse().toString();
        System.out.println(shortestPalindrome("abcd"));
    }

    public static String shortestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        char[] charArray = s.toCharArray();
        for (int i = (len - 1) / 2; i >= 0; i--) {
            if (isPal(charArray, i, i + 1)) {
                return toResult(charArray, i * 2 + 1);
            }
            if (isPal(charArray, i, i)) {
                return toResult(charArray, i * 2);
            }
        }
        return toResult(charArray, 0);
    }

    private static boolean isPal(char[] charArray, int i, int j) {
        while (i >= 0) {
            if (j >= charArray.length) {
                return false;
            }
            if (charArray[i--] != charArray[j++]) {
                return false;
            }
        }
        return true;
    }

    private static String toResult(char[] charArray, int begin) {
        StringBuilder sb = new StringBuilder();
        for (int i = charArray.length - 1; i > begin; i--) {
            sb.append(charArray[i]);
        }
        sb.append(charArray);
        return sb.toString();
    }
}
