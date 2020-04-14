package com.zl.geekdesign.factory.simplefactoty;

import com.zl.geekdesign.factory.Animal;

/**
 * Create by zhanglong on 2020/4/13
 */
public class SimpleFactoryClient {

    public static void main(String[] args) {
        print("dog");
    }

    public static void print(String name) {
        Animal animal = SimpleFactoty.createAnimal(name);
        animal.print();
    }
}
