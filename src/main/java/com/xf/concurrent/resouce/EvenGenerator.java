package com.xf.concurrent.resouce;

/**
 * Created by DCJS
 * 2019/7/10.
 */
public class EvenGenerator extends IntGenerator{
    private int currentEvenValue = 0;
    @Override
    public int next() {
        ++currentEvenValue;
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
