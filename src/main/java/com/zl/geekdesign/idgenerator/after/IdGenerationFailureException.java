package com.zl.geekdesign.idgenerator.after;

/**
 * Create by zhanglong on 2020/3/26
 */
public class IdGenerationFailureException extends RuntimeException {

    public IdGenerationFailureException() {
        super();
    }

    public IdGenerationFailureException(String message) {
        super(message);
    }
}
