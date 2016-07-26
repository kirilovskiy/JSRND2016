package com.sbt.lesson5;

/*import java.io.FileInputStream;
import java.io.IOException;

public class TestThrow {
    public static void main(String[] args) throws IOException {
        f();
    }

    private static void f() throws IOException {
        g();
    }
    private static void g() throws IOException {
        FileInputStream in = new FileInputStream("1.txt");
        in.close();
    }
}
*/

import java.io.FileNotFoundException;
import java.io.IOException;

class Parent {
    /**
     *
     * @throws FileNotFoundException
     */
    public void method() throws IOException{

    }
}

class Child extends Parent {
    @Override
    public void method() throws FileNotFoundException {

    }

    public void test(Parent a) throws IOException {
        a.method();
    }

    public static void main(String[] args) throws IOException {
        Parent a = new Parent();
        Child b = new Child();

        Child ch = new Child();
        ch.test(a);
        ch.test(b);
    }
}

public class TestThrow {}