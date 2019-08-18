package com.ofloxacin.corejavaii.file;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @author chens
 * @date 2018/12/3 14:13
 */
public class ZipFileTest {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Files.newInputStream(Paths.get("D:\\Library\\Desktop\\codemirror.zip"));
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        ZipEntry entry;
        while ((entry = zipInputStream.getNextEntry()) != null) {
            System.out.println(entry.getName() + " " + entry.getMethod());
            zipInputStream.closeEntry();
        }
        zipInputStream.close();
    }
}
