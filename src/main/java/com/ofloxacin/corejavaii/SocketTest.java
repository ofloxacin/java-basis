package com.ofloxacin.corejavaii;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author chens
 * @date 2018/12/3 18:38
 */
public class SocketTest {
    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = InetAddress.getByName("time-A.timefreq.bldrdoc.gov");
        System.out.println(inetAddress.getAddress()[0] & 0xff);

        try (Socket socket = new Socket("time-A.timefreq.bldrdoc.gov", 13)) {
            InputStream in = socket.getInputStream();
            Scanner scanner = new Scanner(in);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        }
    }
}
