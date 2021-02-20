package com.xf.reflex;

import java.util.List;

public class Test {
    public static <T> void show1(List<T> list){
        for (Object object : list) {
            System.out.println(object.toString());
        }
    }

    public static void show2(List<?> list) {
        for (Object object : list) {
            System.out.println(object);
        }
    }
}
