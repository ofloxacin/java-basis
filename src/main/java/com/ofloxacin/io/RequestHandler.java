package com.ofloxacin.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-07-15
 */
public class RequestHandler implements Runnable {

    private Socket socket;

    RequestHandler(Socket client) {
        this.socket = client;
    }

    @Override
    public void run() {
        try {
            handle();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void handle() throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = reader.readLine();
        String path = getPath(line);
        for (; ; ) {
            line = reader.readLine();
            if (line.equals("")) {
                break;
            }
        }
        Thread.sleep(200);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String response;
        if (path.equals("/")) {
            response = welcome();
        } else {
            response = notFound();
        }
        writer.write(response);
        writer.flush();
        writer.close();
    }

    private String getMethod(String request) {
        return request.split(" ")[0];
    }

    private String getPath(String request) {
        return request.split(" ")[1];
    }

    private String welcome() {
        return "HTTP/1.1 200\n" +
                "Content-Type: application/json\n" +
                "\n" +
                "{ \"name\" : \"chenshuai\" }";
    }

    private String notFound() {
        return "HTTP/1.1 404\n";
    }
}
