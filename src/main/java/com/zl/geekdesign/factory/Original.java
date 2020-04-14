package com.zl.geekdesign.factory;

/**
 * Create by zhanglong on 2020/4/13
 */
public class Original {

    public static void main(String[] args) {
        print("dog");
    }

    public static void print(String name) {
        Animal animal = null;
        if ("dog".equals(name)) {
            animal = new Dog();
        } else if ("cat".equals(name)) {
            animal = new Cat();
        }
        animal.print();
    }
}
