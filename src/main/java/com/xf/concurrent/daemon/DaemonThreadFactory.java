package com.xf.concurrent.daemon;

import java.util.concurrent.ThreadFactory;

/**
 * 创建后台线程工厂
 */
public class DaemonThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread t = newThread(r);
        t.setDaemon(true);
        return t;
    }

}
