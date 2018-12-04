package com.ofloxacin.corejavaii.file;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author chens
 * @date 2018/11/28 17:57
 */
public class ZipTest {
    public static void main(String[] args) {
        try {
            FileSystem fileSystem = FileSystems.newFileSystem(Paths.get("D:\\_Setup\\Development\\apache-tomcat-8.5.32.zip"), null);
            Files.walkFileTree(fileSystem.getPath("/"), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    System.out.println(dir.toAbsolutePath());
                    return super.preVisitDirectory(dir, attrs);
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println(file.toAbsolutePath());
                    return super.visitFile(file, attrs);
                }
            });
            fileSystem.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
