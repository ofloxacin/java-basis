package com.ofloxacin.corejavaii.socket.channel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * @author chens
 * @date 2018/12/4 11:05
 */
public class InterruptibleSocketTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new InterruptibleSocketFrame();
            frame.setTitle("InterruptibleSocketTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setBounds(400, 200, 800, 600);
            frame.setVisible(true);
        });
    }
}

class InterruptibleSocketFrame extends JFrame {

    public static final int TEXT_ROWS = 20;

    public static final int TEXT_COLUMNS = 60;

    private Scanner in;

    private final JButton interruptibleButton;

    private final JButton blockingButton;

    private JButton cancelButton;

    private final JTextArea messages;

    private final TestServer server;

    private Thread connectThread;

    public InterruptibleSocketFrame() {
        JPanel northPanel = new JPanel();
        add(northPanel, BorderLayout.NORTH);

        messages = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
        add(new JScrollPane(messages));

        interruptibleButton = new JButton("Interruptible");
        blockingButton = new JButton("Blocking");
        northPanel.add(interruptibleButton);
        northPanel.add(blockingButton);

        interruptibleButton.addActionListener(e -> {
            interruptibleButton.setEnabled(false);
            blockingButton.setEnabled(false);
            cancelButton.setEnabled(true);
            connectThread = new Thread(() -> {
                try {
                    connectInterruptibly();
                } catch (IOException ex) {
                    messages.append("\nInterruptibleSocketTest.connectInterruptibly:" + ex);
                }
            });
            connectThread.start();
        });

        blockingButton.addActionListener(e -> {
            interruptibleButton.setEnabled(false);
            blockingButton.setEnabled(false);
            cancelButton.setEnabled(true);
            connectThread = new Thread(() -> {
                try {
                    connectBlocking();
                } catch (IOException ex) {
                    messages.append("\nInterruptibleSocketTest.connectBlocking:" + ex);
                }
            });
            connectThread.start();
        });

        cancelButton = new JButton("Cancel");
        cancelButton.setEnabled(false);
        northPanel.add(cancelButton);
        cancelButton.addActionListener(e -> {
            connectThread.interrupt();
            cancelButton.setEnabled(false);
        });
        server = new TestServer();
        new Thread(server).start();
    }

    public void connectInterruptibly() throws IOException {
        messages.append("Interruptible:\n");
        try (SocketChannel channel = SocketChannel.open(new InetSocketAddress("localhost", 8189))) {
            in = new Scanner(channel);
            while (!Thread.currentThread().isInterrupted()) {
                messages.append("Reading ");
                if (in.hasNextLine()) {
                    messages.append(in.nextLine() + "\n");
                }
            }
        } finally {
            EventQueue.invokeLater(() -> {
                messages.append("Channel closed\n");
                interruptibleButton.setEnabled(true);
                blockingButton.setEnabled(true);
            });
        }
    }

    public void connectBlocking() throws IOException {
        messages.append("Blocking:\n");
        try (Socket socket = new Socket("localhost", 8189)) {
            in = new Scanner(socket.getInputStream());
            while (!Thread.currentThread().isInterrupted()) {
                messages.append("Reading ");
                if (in.hasNextLine()) {
                    messages.append(in.nextLine() + "\n");
                }
            }
        } finally {
            EventQueue.invokeLater(() -> {
                messages.append("Socket closed\n");
                interruptibleButton.setEnabled(true);
                blockingButton.setEnabled(true);
            });
        }
    }

    class TestServer implements Runnable {

        @Override
        public void run() {
            try {
                ServerSocket serverSocket = new ServerSocket(8189);
                while (true) {
                    Socket incoming = serverSocket.accept();
                    Runnable r = new TestServerHandler(incoming);
                    new Thread(r).start();
                }
            } catch (IOException e) {
                messages.append("\nTestServer.run: " + e);
            }
        }
    }

    class TestServerHandler implements Runnable {

        private final Socket incoming;

        private int counter;

        public TestServerHandler(Socket incoming) {
            this.incoming = incoming;
        }

        @Override
        public void run() {
            try {
                try {
                    OutputStream outputStream = incoming.getOutputStream();
                    PrintWriter writer = new PrintWriter(outputStream, true);
                    while (counter < 100) {
                        counter++;
                        if (counter <= 10) writer.println(counter);
                        Thread.sleep(500);
                    }
                } finally {
                    incoming.close();
                    messages.append("Closing Server\n");
                }
            } catch (Exception e) {
                messages.append("\nTestServerHandler.run: " + e);
            }
        }
    }
}
