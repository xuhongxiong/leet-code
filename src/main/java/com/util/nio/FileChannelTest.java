package com.util.nio;

import org.junit.Test;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Java NIO（New I/O，新输入/输出）是Java 1.4引入的一组API，用于提供更快、更灵活的非阻塞I/O操作。
 * 相比传统的I/O，Java NIO提供了更高的性能和可扩展性，特别适用于处理高并发的网络通信和文件操作。
 *
 * Java NIO的核心组件包括以下几个关键部分：
 *
 * 通道（Channel）：通道是NIO中的核心概念，它代表了一个可以进行读取和写入操作的开放连接，可以与文件、套接字等交互。通道提供了非阻塞I/O的能力。
 *
 * 缓冲区（Buffer）：缓冲区是数据的容器，数据在通道和缓冲区之间传输。缓冲区可以读取数据和写入数据，并提供了对数据的操作方法，如put、get等。
 *
 * 选择器（Selector）：选择器是用于多路复用的关键组件，它允许一个线程同时监听多个通道的事件。当某个通道有数据准备就绪时，选择器会通知相关的线程处理数据。
 *
 * 通道和缓冲区的类型：Java NIO提供了多种类型的通道和缓冲区，包括FileChannel、SocketChannel、ServerSocketChannel、DatagramChannel等，
 * 以及ByteBuffer、CharBuffer、IntBuffer等不同类型的缓冲区，用于处理不同类型的数据。
 */
public class FileChannelTest {

    @Test
    public void test(){
        read();
        //write();
    }

    private void read(){
        //读数据
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\aaaa.txt","rw");
            FileChannel channel = randomAccessFile.getChannel();
            ByteBuffer allocate = ByteBuffer.allocate(48);
            int read = channel.read(allocate);
            while (read != -1){
                System.out.println("read"+read);
                allocate.flip();
                while (allocate.hasRemaining()){
                    System.out.println((char)allocate.get());
                }
                allocate.clear();
                read = channel.read(allocate);
            }
            randomAccessFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //写数据
    private void write(){
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\xhx\\nio_write.txt","rw");
            FileChannel channel = randomAccessFile.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1048);
            buffer.put("hello nio".getBytes());
            //数据写入通道
            buffer.flip();
            channel.write(buffer);
            channel.write(buffer); //写文件
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
