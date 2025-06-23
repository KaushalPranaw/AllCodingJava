package Comp.EDJO;

import java.util.Optional;

public class MyOptional<T> {
    private final Optional<T> value;

    public MyOptional(T value) {
        this.value = Optional.of(value);
    }

    public boolean isPresent(){
        return value.isPresent();
    }

    public T get(){
        return value.get();
    }

    public static void main(String[] args) {
        MyOptional<String> optional=new MyOptional<>("pranaw");
        System.out.println(optional.isPresent());

    }
}
