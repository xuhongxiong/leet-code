package com.util.io.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class InterfaceClient01 {
    public static void main(String[] args) throws IOException {
        {
            Socket socket = new Socket("192.168.3.193",9090);
            OutputStream outputStream = socket.getOutputStream();
            //socket.getOutputStream().write("RedisClient01".getBytes());

            String string = "MSH|^~\\&|HIS^1|MediInfo|MediII^1|MediInfo|20180****52317||MFN^Z2B^MFN_Z2B|39a3d175f5034a2a9d41d35c911d0562|P|2.4\n" +
                    "MFI|Z2B||UPD|||AL\n" +
                    "MFE|MAD|9a3b31292e3a47e1b59f63ba15c47f94||0|ST\n" +
                    "Z2B|10741|2|名中医VIP门诊(庆)||||||||1|0|0|0|^MZYVIPMZQ~^QKAVIPUYY~^QKAVIPUYY|9999|20180****53203|21||0|110000********000000000000";

            socket.getOutputStream().write(string.getBytes());
            System.out.println("------input quit keyword to finish......");
            outputStream.close();
            socket.close();
        }

    }
}
