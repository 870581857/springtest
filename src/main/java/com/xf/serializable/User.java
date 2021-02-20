package com.xf.serializable;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialversionUID = 123456L;
    private transient int age;
    private String name;
}
