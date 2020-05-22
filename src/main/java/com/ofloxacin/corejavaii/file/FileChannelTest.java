package com.ofloxacin.corejavaii.file;

import com.ofloxacin.TimeSpanUtil;
import com.ofloxacin.util.PrintUtil;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.zip.CRC32;

/**
 * @author chens
 * @date 2018/11/28 18:17
 */
public class FileChannelTest {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Program Files\\Java\\jdk1.8.0_191\\jre\\lib\\charsets.jar");
        TimeSpanUtil.init();

        PrintUtil.println(Long.toHexString(checksumInputSteam(path)));
        TimeSpanUtil.printSpan("input stream");

        PrintUtil.printString(Long.toHexString(checksumBuffedInputSteam(path)));
        TimeSpanUtil.printSpan("buffed input stream");

        PrintUtil.printString(Long.toHexString(checksumRandomAccessFile(path)));
        TimeSpanUtil.printSpan("random access file");

        PrintUtil.printString(Long.toHexString(checksumMappedFile(path)));
        TimeSpanUtil.printSpan("mapped file");
    }

    public static long checksumInputSteam(Path path) throws IOException {
        try (InputStream in = Files.newInputStream(path, StandardOpenOption.READ)) {
            CRC32 crc32 = new CRC32();
            int c;
            while ((c = in.read()) != -1) {
                crc32.update(c);
            }
            return crc32.getValue();
        }
    }

    public static long checksumRandomAccessFile(Path path) throws IOException {
        try (RandomAccessFile file = new RandomAccessFile(path.toFile(), "r")) {
            CRC32 crc32 = new CRC32();
            for (int i = 0; i < file.length(); i++) {
                file.seek(i);
                int c = file.readByte();
                crc32.update(c);
            }
            return crc32.getValue();
        }
    }

    public static long checksumBuffedInputSteam(Path path) throws IOException {
        try (InputStream in = new BufferedInputStream(Files.newInputStream(path))) {
            CRC32 crc32 = new CRC32();
            int c;
            while ((c = in.read()) != -1) {
                crc32.update(c);
            }
            return crc32.getValue();
        }
    }

    public static long checksumMappedFile(Path path) throws IOException {
        try (FileChannel channel = FileChannel.open(path, StandardOpenOption.READ)) {
            MappedByteBuffer byteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
            CRC32 crc32 = new CRC32();
            int c;
            while (byteBuffer.hasRemaining()) {
                c = byteBuffer.get();
                crc32.update(c);
            }
            return crc32.getValue();
        }
    }
}
