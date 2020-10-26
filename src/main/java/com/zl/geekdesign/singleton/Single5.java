package com.zl.geekdesign.singleton;

public enum Single5 {

    INSTANCE;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Single5 one = Single5.INSTANCE;
        one.setName("zhangsan");
        Single5 two = Single5.INSTANCE;
        two.setName("lisi");
        System.out.println(one.getName() + "---" + two.getName());


        //反射
        Single5[] enumConstants = Single5.class.getEnumConstants();
        for (Single5 single5 : enumConstants) {
            System.out.println(single5.getName());
        }
    }
}
