package com.ofloxacin.corejavaii.socket.multi;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author chens
 * @date 2018/12/4 10:42
 */
public class MultiSocketServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            int i = 1;
            while (true) {
                try {
                    Socket incoming = serverSocket.accept();
                    System.out.println("Incoming " + i);
                    Runnable runnable = new ThreadedEchoHandler(incoming);
                    Thread thread = new Thread(runnable);
                    thread.start();
                    i++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
