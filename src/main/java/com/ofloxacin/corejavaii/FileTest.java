package com.ofloxacin.corejavaii;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collections;

/**
 * @author chens
 * @date 2018/11/28 16:29
 */
public class FileTest {
    public static void main(String[] args) {
        try {
            Files.walkFileTree(Paths.get("D:\\"), Collections.singleton(FileVisitOption.FOLLOW_LINKS), 3, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    return super.preVisitDirectory(dir, attrs);
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    return super.postVisitDirectory(dir, exc);
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    String fileName = file.getFileName().toString();
                    int i = fileName.lastIndexOf('.');
                    if (i >= 0) {
                        String extension = fileName.substring(i);
                        if (".jpg".equalsIgnoreCase(extension)) {
                            System.out.println(file.toAbsolutePath());
                        }
                    }
                    return super.visitFile(file, attrs);
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {

        }
    }

    public static void visit(Path path, final String prefix) throws IOException {
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(path)) {
            for (Path p : paths) {
                System.out.println(prefix + p.getFileName());
                if (Files.isDirectory(p)) {
                    visit(p, prefix + prefix.substring(0, 2));
                }
            }
        }
    }
}
