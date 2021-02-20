package com.xf.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) throws IOException {
        //创建Socket对象
        ServerSocket ss = new ServerSocket(10086);
        //监听（阻塞）
        Socket s = ss.accept();
        //获取输入流对象
        InputStream is = s.getInputStream();
        //获取数据
        byte[] bys = new byte[1024];
        int len;
        len = is.read(bys);
        //输出数据
        InetAddress address = s.getInetAddress();
        System.out.println("sender:" + address);
        System.out.println(new String(bys, 0, len));
        //释放
        s.close();
        /*
         * 说明：
         * 	当你访问百度的时候，退出了，它的服务就关了吗？   不关，还会继续监听
         */
    }

}