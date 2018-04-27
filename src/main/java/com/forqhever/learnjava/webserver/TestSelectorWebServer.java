package com.forqhever.learnjava.webserver;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class TestSelectorWebServer {

    public static void doStartServer() throws IOException {
        int i = 0;
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try (Selector selector = Selector.open();
             SelectableChannel channel = ServerSocketChannel.open()) {

            channel.configureBlocking(false);
            ((ServerSocketChannel) channel).socket().bind(new InetSocketAddress(8888));
            channel.register(selector, SelectionKey.OP_ACCEPT);

            while (i++ < Integer.MAX_VALUE) {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();

                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while(iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    if((selectionKey.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {
                        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                        iterator.remove();
                    } else if((selectionKey.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {
                        SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
                        while (true) {
                            buffer.clear();
                            int n = socketChannel.read(buffer);
                            if(n <= 0) {
                                break;
                            }
                            buffer.flip();
                            System.out.println(new String(buffer.array()));
                        }
                        RandomAccessFile file = new RandomAccessFile("index.txt", "r");
                        FileChannel fileChannel = file.getChannel();
                        buffer.clear();
                        fileChannel.read(buffer);
                        buffer.flip();

                        System.out.println(new String(buffer.array()));

                        socketChannel.write(buffer);

                        file.close();
                        socketChannel.close();
                        iterator.remove();
                    }
                }
            }
        }
    }

    public static void startServer() {
        try {
            doStartServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        startServer();
    }
}
