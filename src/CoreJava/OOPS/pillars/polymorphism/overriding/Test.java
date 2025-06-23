package CoreJava.OOPS.pillars.polymorphism.overriding;

class Person{
    Person print(){
        return new Person();
    }
}

class Emp extends Person{
    @Override
    Emp print(){
        return new Emp();
    }
}
public class Test {
}
