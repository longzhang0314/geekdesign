package com.zl.geekdesign.factory.factotymethod;

/**
 * Create by zhanglong on 2020/4/13
 */
public class FactotyMethodClient1 {

    public static void main(String[] args) {
        print("dog");
    }

    private static void print(String name) {
        IAnimalFactoty animalFactoty = null;
        if ("dog".equals(name)) {
            animalFactoty = new DogFactoty();
        } else if ("cat".equals(name)) {
            animalFactoty = new CatFactoty();
        }
        animalFactoty.createAnimal().print();
    }
}
