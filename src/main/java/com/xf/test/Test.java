package com.xf.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by xf
 * 2019/4/1.
 */
public class Test {
    public String chz(int j,String i){
        return null;
    }

    public String chz(String j,int i){
        return "";
    }

    public static void main(String[] args) {
        //键盘输入
//        Scanner in = new Scanner(System.in);
//        String inStr = in.nextLine();
//        in.close();
//        System.out.println(inStr);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String bStr = bufferedReader.readLine();
            System.out.println(bStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
