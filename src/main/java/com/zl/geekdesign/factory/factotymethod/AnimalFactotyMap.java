package com.zl.geekdesign.factory.factotymethod;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by zhanglong on 2020/4/13
 */
public class AnimalFactotyMap {

    private static final Map<String, IAnimalFactoty> map = new HashMap<>();

    static {
        map.put("dog", new DogFactoty());
        map.put("cat", new CatFactoty());
    }

    public static IAnimalFactoty createAnimalFactoty(String name) {
        return map.get(name);
    }
}
