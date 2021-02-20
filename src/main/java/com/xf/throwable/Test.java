package com.xf.throwable;

import java.io.File;
import java.util.List;

public class Test {


//    public static void main(String[] args) {
//        try{
//            System.out.println("测试异常");
//            List list = null;
//            list.add(1);
//            throw new RuntimeException("运行时异常");
////            File file = new File("d://133333.txt");
////            file.getName();
//        } catch (Exception e){
//            System.out.println("1111");
//        }
//    }


    public static void main(String[] args) {

        B b = new B();
        A a = new A();
        C c = new C();
        A ba = new B();
        A ca = new C();
        B bb = new C();

        System.out.println("1------------");
        System.out.println(b instanceof B);
        System.out.println(c instanceof B);
        System.out.println(b instanceof A);
        System.out.println(c instanceof A);
        System.out.println(b instanceof Object);
        System.out.println(null instanceof Object);
        System.out.println("2------------");
        System.out.println(b.getClass().isInstance(b));
        System.out.println(c.getClass().isInstance(b));
        System.out.println(b.getClass().isInstance(a));
        System.out.println("3------------");
        System.out.println(a.getClass().isInstance(ba));
        System.out.println(b.getClass().isInstance(ca));
        System.out.println(b.getClass().isInstance(null));
        System.out.println("4------------");
        System.out.println(A.class.isInstance(a));
        System.out.println(A.class.isInstance(b));
        System.out.println(A.class.isInstance(ba));
        System.out.println("5------------");
        System.out.println(B.class.isInstance(a));
        System.out.println(B.class.isInstance(b));
        System.out.println(B.class.isInstance(ba));
        System.out.println("6------------");
        System.out.println(Object.class.isInstance(b));
        System.out.println(Object.class.isInstance(null));
    }

}
