package com.zl.geekdesign.factory.factotymethod;

import com.zl.geekdesign.factory.Animal;
import com.zl.geekdesign.factory.Dog;

/**
 * Create by zhanglong on 2020/4/13
 */
public class DogFactoty implements IAnimalFactoty {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}
