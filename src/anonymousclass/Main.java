package anonymousclass;

public class Main {

    public static void main(String[] args) {
        String var1 = "Implemented do1";
        String var2 = "Implemented do2";
        String var3 = "Implemented do3";
        ThreeMethodsInterface instance = new ThreeMethodsInterface() {
            @Override
            public void do1() {
                System.out.println(var1);
            }

            @Override
            public void do2() {
                System.out.println(var2);
            }

            @Override
            public void do3() {
                System.out.println(var3);
            }
        };
            /* create an instance of an anonymous class here,
                                            do not forget ; in the end */

        instance.do1();
        instance.do2();
        instance.do3();

    }
}

    interface ThreeMethodsInterface {

        void do1();

        void do2();

        void do3();
    }
