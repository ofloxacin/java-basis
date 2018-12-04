package com.ofloxacin.corejavaii.file;

import com.ofloxacin.util.PrintUtil;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author chens
 * @date 2018/11/30 17:39
 */
public class FileLockTest {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\Library\\Desktop\\t.txt");
        FileChannel channel = FileChannel.open(path, StandardOpenOption.READ, StandardOpenOption.WRITE);
        FileLock fileLock = channel.lock(0, channel.size(), true);
        PrintUtil.print(fileLock.isShared());
    }
}
