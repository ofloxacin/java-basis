package com.ofloxacin.tools;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @author chens
 **/
public class IdeaKeyDownloader {

    public static void main(String[] args) {
        try {
            URLConnection connection = new URL("http://idea.medeming.com/jihuo/images/jihuoma.zip").openConnection();
            try (ZipInputStream zipInputStream = new ZipInputStream(connection.getInputStream())) {
                ZipEntry zipEntry;
                while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                    try {
                        if (zipEntry.getName().contains("2018")) {
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(zipInputStream));
                            String content = bufferedReader.readLine();
                            setSystemClipboard(content);
                            System.out.println(content);
                        }
                    } finally {
                        zipInputStream.closeEntry();
                    }
                }
            }
        } catch (MalformedURLException e) {
            System.out.println("URL地址不正确");
        } catch (IOException e) {
            System.out.println("网络连接失败");
        }
    }

    private static void setSystemClipboard(String str) {
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(str), null);
    }
}
