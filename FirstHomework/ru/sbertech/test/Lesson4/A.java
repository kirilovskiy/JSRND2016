package ru.sbertech.test.Lesson4;

public class A<T> {

    T param;

    public A(T param) {
        this.param = param;
    }
    public A() {
    }

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }

    public String getType(){
        return param.getClass().getTypeName();
    }
}
