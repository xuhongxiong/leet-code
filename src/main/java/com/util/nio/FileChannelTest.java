package com.util.nio;

import org.junit.Test;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * <p>Project: leet-code </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2023 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
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
