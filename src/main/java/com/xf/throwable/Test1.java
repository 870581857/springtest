package com.xf.throwable;

import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        try{
//            List list = null;
//            list.add(1);
            throw new RuntimeException("运行时异常");
//            File file = new File("d://133333.txt");
//            file.getName();
        } catch (Exception e){
            if(e.getClass().isInstance(new RuntimeException())){
                System.out.println(e.getMessage());
                e.printStackTrace();
            }else{
                System.out.println("程序异常");
                e.printStackTrace();
            }

        }
    }

}


