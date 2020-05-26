package com.zl.geekdesign.build;

/**
 * Create by zhanglong on 2020/4/14
 */
public class ConstructorArg {

    private boolean isRed;
    private Class type;
    private Object arg;

    private ConstructorArg(Builder builder) {
        this.isRed = builder.isRed;
        this.type = builder.type;
        this.arg = builder.arg;
    }

    public static class Builder {
        private boolean isRed;
        private Class type;
        private Object arg;

        public ConstructorArg build() {
            boolean flag1 = isRed && arg instanceof String && type == null;
            if (!flag1) throw new IllegalArgumentException("...");
            boolean flag2 = !isRed && (arg == null || type == null);
            if (!flag2) throw new IllegalArgumentException("...");
            return new ConstructorArg(this);
        }

        public Builder setIsRed(boolean isRed) {
            this.isRed = isRed;
            return this;
        }

        public Builder setType(Class type) {
            this.type = type;
            return this;
        }

        public Builder setArg(Object arg) {
            this.arg = arg;
            return this;
        }
    }
}
