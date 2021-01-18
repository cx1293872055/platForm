import java.io.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.util.Scanner;
import java.util.Vector;

import static java.lang.invoke.MethodHandles.lookup;

public class main {

    //
    static Vector<Integer> vector = new Vector<>();
    public static void main(String[] args) {
        String pattern = "我是你的%s老师";
        String result = String.format(pattern, "陈");
        System.out.println(pattern.intern());
        System.out.println(result);
    }

    interface AA{
        void print();
    }

    enum CC implements AA{
        AAA;

        @Override
        public void print() {
            System.out.println("我是AAA");
        }
    }
    abstract class BB implements AA {

        @Override
        public void print() {
            
        }
    }
    public void test() {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;

        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
    }

    static class C {
        public void think() {
            System.out.println("CCCCCCC");
        }
    }

    static class B extends C {
        Integer val;

        //   这是你的
        public B(Integer val) {
            this.val = val;
        }

        public void think() {
            System.out.println("BBBBBBB");
        }
    }

    static class A extends B {

        public A(Integer val) {
            super(val);
        }

        public void think() {
            MethodType mt = MethodType.methodType(void.class);
            try {
                MethodHandle mh = lookup().findSpecial(C.class, "think", mt, getClass());
                mh.invoke(this);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }
}
