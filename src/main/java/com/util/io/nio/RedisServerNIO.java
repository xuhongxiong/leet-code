package com.util.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * NIO成功的解决了BIO需要开启多线程的问题，NIO中一个线程就能解决多个socket，但是还存在2个问题
 * 1、客户端很多的时候，会做很多次遍历的无用功
 * 2、遍历过程是在用户态进行的，用户态判断socket是否有数据还是调用内核的read()方法实现的，这就涉及到用户态和内核态的切换，开销很大。
 */
public class RedisServerNIO {
    static List<SocketChannel> socketList = new ArrayList<>();
    static ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
    public static void main(String[] args) throws IOException {
        System.out.println("---RedisServerNIO 启动等待中");
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.bind(new InetSocketAddress("127.0.0.1",6379));
        serverSocket.configureBlocking(false);//设置为非阻塞模式

        while (true){
            for (SocketChannel element : socketList) {
                int read = element.read(byteBuffer);
                if (read > 0){
                    System.out.println("---读取数据："+read);
                    byteBuffer.flip();
                    byte[] bytes = new byte[read];
                    byteBuffer.get(bytes);
                    System.out.println(new String(bytes));
                    byteBuffer.clear();
                }
            }

            SocketChannel socketChannel = serverSocket.accept();
            if (socketChannel != null){
                System.out.println("---成功连接");
                socketChannel.configureBlocking(false);
                socketList.add(socketChannel);
                System.out.println("---socketList size:"+socketList.size());
            }
        }
    }
}
