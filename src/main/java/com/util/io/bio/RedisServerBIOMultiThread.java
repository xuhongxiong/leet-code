package com.util.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class RedisServerBIOMultiThread {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6379);
        while (true){
            Socket socket = serverSocket.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        InputStream inputStream = socket.getInputStream();
                        int length = -1;
                        byte[] bytes = new byte[1024];
                        System.out.println("---333 等待读取");
                        while ((length = inputStream.read(bytes)) != -1){
                            System.out.println("---444 成功读取："+new String(bytes,0,length));
                        }
                        inputStream.close();
                        socket.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            },Thread.currentThread().getName()).start();
            System.out.println(Thread.currentThread().getName());
        }
    }
}
