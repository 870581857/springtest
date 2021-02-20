package com.xf.annotion;

@aspect
public class TestAspectImpl implements TestAspect {
    @Override
    public String test(String sr) {
        System.out.println("run TestAspectImpl.test " + sr);
        return sr;
    }
}