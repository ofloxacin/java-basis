package com.ofloxacin.corejavaii.socket.uri;

import com.ofloxacin.util.PrintUtil;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * @author chens
 * @date 2018/12/4 14:27
 */
public class URLConnectionTest {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://localhost:8080");
        URLConnection connection = url.openConnection();
        connection.setUseCaches(false);
        String encoding = base64Encode("admin:admin");
        connection.setRequestProperty("Authorization", "Basic " + encoding);
        connection.connect();

        PrintUtil.println(connection.getContentEncoding());
        PrintUtil.println(connection.getContentType());
        PrintUtil.println(connection.getContentLength());
        PrintUtil.println(connection.getExpiration());

        PrintUtil.printJson(connection.getPermission());
        PrintUtil.printJson(connection.getHeaderFields());

        Scanner scanner = new Scanner(connection.getInputStream());
        while (scanner.hasNextLine()) {
            PrintUtil.println(scanner.nextLine());
        }
    }

    private static String base64Encode(String s) {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        Base64OutputStream out = new Base64OutputStream(bOut);
        try {
            out.write(s.getBytes());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bOut.toString();
    }
}

class Base64OutputStream extends FilterOutputStream {

    private static final char[] toBase64 = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
    };

    private int col = 0;

    private int i = 0;

    private int[] inbuf = new int[3];

    public Base64OutputStream(OutputStream out) {
        super(out);
    }

    @Override
    public void write(int b) throws IOException {
        inbuf[i] = b;
        i++;
        if (i == 3) {
            if (col >= 76) {
                super.write('\n');
                col = 0;
            }
            super.write(toBase64[(inbuf[0] & 0xFC) >> 2]);
            super.write(toBase64[((inbuf[0] & 0x03) << 4) | ((inbuf[1] & 0xF0) >> 4)]);
            super.write(toBase64[(((inbuf[1] & 0x0F) << 2) | (inbuf[2] & 0xC0) >> 6)]);
            super.write(toBase64[(inbuf[2] & 0x3F)]);
            col += 4;
            i = 0;
        }
    }

    @Override
    public void flush() throws IOException {
        if (i > 0 && col >= 76) {
            super.write('\n');
            col = 0;
        }
        if (i == 1) {
            super.write(toBase64[(inbuf[0] & 0xFC) >> 2]);
            super.write(toBase64[(inbuf[0] & 0x03) << 4]);
            super.write('=');
            super.write('=');
        }
        if (i == 2) {
            super.write(toBase64[(inbuf[0] & 0xFC) >> 2]);
            super.write(toBase64[((inbuf[0] & 0x03) << 4) | ((inbuf[1] & 0xF0) >> 4)]);
            super.write(toBase64[(inbuf[1] & 0x0F) << 2]);
            super.write('=');
        }
    }
}
