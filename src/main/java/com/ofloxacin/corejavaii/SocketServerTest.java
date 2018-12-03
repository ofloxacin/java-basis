package com.ofloxacin.corejavaii;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author chens
 * @date 2018/12/3 19:05
 */
public class SocketServerTest {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8189);
             Socket socket = serverSocket.accept()) {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            try (Scanner scanner = new Scanner(inputStream);
                 PrintWriter printWriter = new PrintWriter(outputStream, true)) {
                String name = scanner.nextLine();
                printWriter.println("Welcome " + name);

                boolean exit = false;
                while (!exit && scanner.hasNextLine()) {
                    String message = scanner.nextLine();
                    printWriter.println("Echo:" + message);
                    if (message.trim().equalsIgnoreCase("BYE")) {
                        exit = true;
                    }
                }
            }
        }
    }
}
