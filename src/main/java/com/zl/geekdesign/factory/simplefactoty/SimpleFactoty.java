package com.zl.geekdesign.factory.simplefactoty;

import com.zl.geekdesign.factory.Animal;
import com.zl.geekdesign.factory.Cat;
import com.zl.geekdesign.factory.Dog;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by zhanglong on 2020/4/13
 */
public class SimpleFactoty {

    private static final Map<String, Animal> map = new HashMap<>();

    static {
         map.put("dog", new Dog());
         map.put("cat", new Cat());
    }


    public static Animal createAnimal(String name) {
        return map.get(name);
    }
}
