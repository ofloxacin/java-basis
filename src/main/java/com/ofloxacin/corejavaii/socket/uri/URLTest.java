package com.ofloxacin.corejavaii.socket.uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

/**
 * @author chens
 * @date 2018/12/4 13:59
 */
public class URLTest {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.baidu.com/");
        System.out.println(url.getAuthority());
        System.out.println(url.getUserInfo());
        System.out.println(url.getContent());
        System.out.println(url.getPath());

        InputStream inputStream = url.openStream();
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }
}
