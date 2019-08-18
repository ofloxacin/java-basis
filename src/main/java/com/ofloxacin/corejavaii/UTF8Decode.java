package com.ofloxacin.corejavaii;

import com.ofloxacin.util.PrintUtil;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chens
 * @date 2018/11/22 10:39
 */
public class UTF8Decode {

    public static void main(String[] args) {
        String path = "D:\\Library\\Desktop\\t.txt";
        PrintUtil.printJson(getCode(path));
    }

    private static List<Integer> getCode(String path) {
        File file = new File(path);
        List<Integer> results = new LinkedList<>();
        try {
            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            byte buffer[] = new byte[4];
            while (inputStream.read(buffer, 0, 1) > 0) {
                byte data = buffer[0];
                byte count = getCount(data);
                if (count == 0) {
                    results.add((int) data);
                    continue;
                }

                inputStream.mark(4);
                Integer temp = 0;
                if (inputStream.read(buffer, 1, count - 1) == count - 1) {
                    buffer[0] = (byte) (buffer[0] & (0b0111111 >> (count - 1)));
                    temp = temp | buffer[0];
                    for (int i = 1; i < count; i++) {
                        temp = temp << 6;
                        buffer[i] = (byte) (buffer[i] & 0b00111111);
                        temp = temp | buffer[i];
                    }
                } else {
                    //throw new IllegalArgumentException("不是标准的utf-8文件");
                    temp = (int) buffer[0];
                    inputStream.reset();
                }
                results.add(temp);
                buffer = new byte[4];
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }

    private static byte getCount(byte b) {
        byte result = 0;
        for (int i = 7; i > 0; i--) {
            if ((byte) (b >> i & 0x1) == 1) {
                result++;
            } else {
                return result;
            }
        }
        return result;
    }

    private static byte[] toBit(byte b) {
        byte result[] = new byte[8];
        for (int i = 0; i < 7; i++) {
            result[i] = (byte) (b & 1);
            b = (byte) (b >> 1);
        }
        return result;
    }
}
