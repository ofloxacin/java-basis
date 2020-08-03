package com.ofloxacin.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        ExecutorService executorService = Executors.newCachedThreadPool(r -> new Thread(group, r));
        while (true) {
            Socket socket = server.accept();
            executorService.submit(new RequestHandler(socket));
        }
    }
}
