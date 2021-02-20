package com.xf.reflex;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReflexDemo<T> {

    public static<T> void reflex(List<T> list){
        for(T o : list){
            Class c = o.getClass();
            String name = c.getSimpleName();
            System.out.println(name);

            Field[] field = c.getDeclaredFields();
            for(Field f : field){
                System.out.println(f.getName());
            }

            Method[] method = c.getDeclaredMethods();
            for(Method m : method){
                System.out.println(m.getName());
            }

        }
    }

    public static void main(String[] args) {
//        List list = new ArrayList<>();
//
//        Person person = new Person();
//        person.setName("xiefei");
//        person.setAge(18);
//
//        Dog dog = new Dog();
//        dog.setName("dawang");
//        dog.setAge(3);
//
//        list.add(person);
//        list.add(dog);
//
//        reflex(list);
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        System.out.println(list.contains("1"));

        String[] s = {"1","2"};
        System.out.println(Arrays.toString(s));
    }

}
