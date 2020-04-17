package com.zl.geekdesign.clone;

import java.io.*;
import java.util.HashMap;

/**
 * Create by zhanglong on 2020/4/17
 */
public class Demo2 {

    private HashMap<String, Search> currentKeyWords = new HashMap<>();
    private long lastUpdateTime = -1;

    public void refresh() {

    }

    public static void main(String[] args) {
        String s = new String();

    }


    public <T> Object deepCopy(T obj) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(obj);

        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        return oi.readObject();
    }
}
