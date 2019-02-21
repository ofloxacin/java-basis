package com.ofloxacin;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * @author chens
 * @date 2019/2/21 14:38
 */
public class SSLTest {
    public static void main(String[] args) throws IOException {
        //VM options, -Djavax.net.debug=all
        final String url = "https://www.baidu.com/";
        URL realUrl = new URL(url);
        URLConnection connection = realUrl.openConnection();
        InputStream inputStream = connection.getInputStream();
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }
}
