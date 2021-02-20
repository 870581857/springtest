package com.xf.annotion;

public class Test {
    public static TestAspect testAspect = new TestAspectImpl();
    public static TestAspect testAspectA = new TestAspectImplA();;

    public static void main(String []args) {
        MyAspect.init();
        testAspect.test("I'm TestAspectImpl");
        testAspectA.test("I'm TestAspectImplA");
    }
}
