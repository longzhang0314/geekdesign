package com.zl.geekdesign.factory.sprintdi;


import java.util.ArrayList;
import java.util.List;

/**
 * Create by zhanglong on 2020/4/14
 */
public class BeanDefinition {
    private String id;
    private List<ConstructorArg> constructorArgs = new ArrayList<>();
    private Scope scope = Scope.SINGLETON;
    private boolean laztInit = false;
    private String className;

    public boolean isSingleton() {
        return scope.equals(Scope.SINGLETON);
    }

    public String getId() {
        return id;
    }

    public List<ConstructorArg> getConstructorArgs() {
        return constructorArgs;
    }

    public Scope getScope() {
        return scope;
    }

    public boolean isLaztInit() {
        return laztInit;
    }

    public String getClassName() {
        return className;
    }


    enum Scope {
        SINGLETON,
        PROTOTYPE
    }

    class ConstructorArg {
        private boolean isRef;
        private Class type;
        private Object args;

        public boolean isRef() {
            return isRef;
        }

        public Class getType() {
            return type;
        }

        public Object getArgs() {
            return args;
        }
    }

}
