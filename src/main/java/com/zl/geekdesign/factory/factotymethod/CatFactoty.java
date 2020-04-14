package com.zl.geekdesign.factory.factotymethod;

import com.zl.geekdesign.factory.Animal;
import com.zl.geekdesign.factory.Cat;

/**
 * Create by zhanglong on 2020/4/13
 */
public class CatFactoty implements IAnimalFactoty {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}
