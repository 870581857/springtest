package com.xf.concurrent.resouce;

/**
 * Created by DCJS
 * 2019/7/10.
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
