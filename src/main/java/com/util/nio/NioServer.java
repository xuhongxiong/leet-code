package com.util.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * <p>Project: leet-code </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2023 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class NioServer {

    private static Selector selector;

    public static void main(String[] args) {
        try {
            //创建选择器
            selector = Selector.open();
            //创建通道
            ServerSocketChannel channel = ServerSocketChannel.open();
            //将通道设为非阻塞（选择器前提）
            channel.configureBlocking(false);
            //绑到指定端口
            ServerSocket socket = channel.socket();
            socket.bind(new InetSocketAddress(8989));
            //将通道channel注册到选择器，并为该通道注册OP_ACCEPT事件，注册该事件后，当事件到达的时候，selector.select()会返回；事件没有到达的时候会一直阻塞
            channel.register(selector, SelectionKey.OP_ACCEPT);
            while (true){
                //当注册事件到达时，方法返回，否则该方法一直阻塞
                selector.select();
                //获取监听事件
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    //获取事件
                    SelectionKey key = iterator.next();
                    //移除事件，避免重复
                    iterator.remove();
                    //检查是否是一个就绪的可以被接受的客户端请求连接
                    if (key.isAcceptable()){
                        handleAccept(key);
                    }else if (key.isReadable()){//检查套接字是否准备好读取数据
                        handleRead(key);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //处理客户连接成功事件
    private static void handleAccept(SelectionKey key) throws IOException {
        //获取客户端连接通道
        ServerSocketChannel server = (ServerSocketChannel) key.channel();
        SocketChannel channel = server.accept();
        channel.configureBlocking(false);
        //信息通过管道发给客户端
        String msg = "hello client";
        channel.write(ByteBuffer.wrap(msg.getBytes()));
        //给通道设置读事件，客户端监听到读事件后进行读操作
        channel.register(selector,SelectionKey.OP_READ);
    }

    //监听到读事件，读取客户端发送过来的消息
    private static void handleRead(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        //从通道读取到缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(128);
        channel.read(buffer);
        //输出客户端发送过来的消息
        byte[] data = buffer.array();
        String msg = new String(data).trim();
        System.out.println("server received client"+msg);
    }
}
