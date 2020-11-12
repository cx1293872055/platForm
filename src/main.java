import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

public class main{

    //
    public static void main(String[] args)   {
        B b = new B(1);
        b.think();

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
