package CoreJava.CustomAnnotations;

import java.lang.reflect.Method;

public class Test {
    @MultiTargetAnnotation(description = "This is a field")
    private String name;

    @MultiTargetAnnotation(description = "This is a method")
    public void display() {
        // Code
    }

    public static void main(String[] args) {
        try {
            Class<MyClass> obj = MyClass.class;
            for (Method method : obj.getDeclaredMethods()) {
                if (method.isAnnotationPresent(MyAnnotation.class)) {
                    MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
                    System.out.println("method: " + method.getName());
                    System.out.println("annotation: " + annotation.value());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
