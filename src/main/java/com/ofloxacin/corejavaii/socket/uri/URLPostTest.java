package com.ofloxacin.corejavaii.socket.uri;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author chens
 * @date 2018/12/4 20:00
 */
public class URLPostTest {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = Object.class.getResourceAsStream("/setting.properties");
        properties.load(inputStream);
        String url = properties.remove("url").toString();
        String result = doPost(url, properties);
        System.out.println(result);
    }

    private static String doPost(String urlString, Map<Object, Object> nameValuePairs) throws IOException {
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);

        boolean first = true;
        try (PrintWriter printWriter = new PrintWriter(connection.getOutputStream())) {
            for (Map.Entry<Object, Object> entry : nameValuePairs.entrySet()) {
                if (first) {
                    first = false;
                } else {
                    printWriter.write('&');
                }
                printWriter.write(entry.getKey().toString());
                printWriter.write('=');
                printWriter.write(URLEncoder.encode(entry.getValue().toString(), "UTF-8"));
            }
            printWriter.flush();
        }

        StringBuilder response = new StringBuilder();
        try (Scanner scanner = new Scanner(connection.getInputStream())) {
            while (scanner.hasNextLine()) {
                response.append(scanner.nextLine());
                response.append("\n");
            }
        } catch (IOException e) {
            if (!(connection instanceof HttpURLConnection)) throw e;
            InputStream err = ((HttpURLConnection) connection).getErrorStream();
            if (err == null) throw e;
            Scanner in = new Scanner(err);
            response.append(in.nextLine());
            response.append('\n');
        }
        return response.toString();
    }
}
