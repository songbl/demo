package com.example.demo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Apple {

    private int price;

    public int getPrice() {
        return price;
    }

//    public void setPrice(int price) {
//        this.price = price;
//    }


        public void anyMethod(int price) {
        this.price = price;
    }
    public static void main(String[] args) throws Exception{
        //正常的调用
//        Apple apple = new Apple();
//        apple.setPrice(5);
//        System.out.println("正常调用 Apple Price:" + apple.getPrice());
        //使用反射调用
        Class clz = Class.forName("com.example.demo.reflect.Apple");
//        Method setPriceMethod = clz.getMethod("setPrice", int.class);
        //方式一：这种通过method方法的赋值，确认了method即可
        Method setPriceMethod = clz.getMethod("anyMethod", int.class);
        Constructor appleConstructor = clz.getConstructor();
        Object appleObj = appleConstructor.newInstance();
        setPriceMethod.invoke(appleObj, 14);
        Method getPriceMethod = clz.getMethod("getPrice");
        System.out.println("使用反射调用 Apple Price:" + getPriceMethod.invoke(appleObj));

        //方式二（通过属性的set方法注入值）
        Apple t = new Apple();
        Field f = t.getClass().getDeclaredField("price");
        Class<?> type = f.getType(); //能拿到属性的类型
        f.setAccessible(true);
        f.set(t, 8);
        System.out.println("方式二 "+t.getPrice());


    }
}
