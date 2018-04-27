package com.forqhever.learnjava.webserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestWebServer {

    public static ServerSocket serverSocket;

    public static void doStartServer() throws IOException {
        serverSocket = new ServerSocket(1234);
        int i = 0;
        while (i++ < Integer.MAX_VALUE) {
            Socket socket = serverSocket.accept();

            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            inputStream.read(bytes, 0, 1024);
            System.out.println(new String(bytes));

            FileInputStream fileInputStream = new FileInputStream("index.txt");
            fileInputStream.read(bytes, 0, 1024);

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(new String(bytes));
            printWriter.close();
            fileInputStream.close();
        }
    }

    public static void startServer() {
        try {
            doStartServer();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                serverSocket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        startServer();
    }
}
