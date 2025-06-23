package CoreJava.ClassLoader;

import java.io.FileInputStream;
import java.io.IOException;

class HelloWorld {
}


public class CustomClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        try {
            String fileName = name.replace('.', '/') + ".class";
            FileInputStream fis = new FileInputStream(fileName);
            byte[] classBytes = fis.readAllBytes();
            fis.close();
            return defineClass(name, classBytes, 0, classBytes.length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws ClassNotFoundException {
        CustomClassLoader loader = new CustomClassLoader();
        Class<?> cls = loader.loadClass("HelloWorld");
        System.out.println("Class loaded: " + cls.getName());
    }
}
