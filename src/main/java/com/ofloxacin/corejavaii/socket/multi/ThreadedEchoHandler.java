package com.ofloxacin.corejavaii.socket.multi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author chens
 * @date 2018/12/4 10:34
 */
public class ThreadedEchoHandler implements Runnable {

    private final Socket socket;

    public ThreadedEchoHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            try {
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                Scanner scanner = new Scanner(inputStream);
                PrintWriter printWriter = new PrintWriter(outputStream, true);
                printWriter.println("Hello! Enter BYE to exit.");
                boolean exit = false;
                while (!exit && scanner.hasNextLine()) {
                    String message = scanner.nextLine();
                    printWriter.println(message);
                    if (message.trim().equalsIgnoreCase("BYE")) {
                        exit = true;
                    }
                }
            } finally {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
