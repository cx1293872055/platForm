
public class main {
    //
    public static void main(String[] args) {
        A temp = new A(new A(null, 3), 2);
        test(temp);
    }
    public static void test(A temp) {
        switch (temp.val) {
            case 1:
                System.out.println(temp.val);
                temp = temp.next;
            case 2:
                System.out.println(temp.val);
                temp = temp.next;
            case 3:
                System.out.println(temp.val);
        }
    }

        static class A {
            A next;
            Integer val;

            //   这是你的
            public A(A next, Integer val) {
                this.next = next;
                this.val = val;
            }
        }
}
