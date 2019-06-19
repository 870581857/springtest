package com.xf.concurrent.callable;

import java.util.concurrent.Callable;

/**
 * Created by DCJS
 * 2019/6/19.
 */
public class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }

}
