package com.ofloxacin.corejavaii.file;

import com.ofloxacin.util.PrintUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author chens
 * @date 2018/11/26 14:24
 */
public class PathTest {

    public static void main(String[] args) {
        Path path = Paths.get("D:\\temp\\weather\\summer");
        PrintUtil.print(path.resolve("session"));
        PrintUtil.print(path.resolveSibling("winter"));
        PrintUtil.print(path.relativize(Paths.get("D:\\temp\\weather\\spring")));
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
