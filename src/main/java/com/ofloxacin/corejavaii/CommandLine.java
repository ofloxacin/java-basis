package com.ofloxacin.corejavaii;

import java.util.Scanner;

/**
 * @author chens
 * @date 2018/12/3 11:00
 */
public class CommandLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }
}
