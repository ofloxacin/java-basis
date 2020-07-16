package com.ofloxacin.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-07-15
 */
public class BIOTest {

    public static void main(String[] args) throws IOException {
        ThreadGroup group = new ThreadGroup("web-server");
        ServerSocket server = new ServerSocket(80);
        while (true) {
            Socket socket = server.accept();
            new Thread(group, new RequestHandler(socket)).start();
        }
    }
}
