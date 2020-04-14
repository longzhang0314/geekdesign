package com.zl.geekdesign.factory.factotymethod;

/**
 * Create by zhanglong on 2020/4/13
 */
public class FactotyMethodClient2 {

    public static void main(String[] args) {
        print("dog");
    }

    private static void print(String name) {
        IAnimalFactoty animalFactoty = AnimalFactotyMap.createAnimalFactoty(name);
        animalFactoty.createAnimal().print();
    }
}
