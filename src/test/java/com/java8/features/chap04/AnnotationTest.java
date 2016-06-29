package com.java8.features.chap04;

import org.junit.Test;

public class AnnotationTest{

    @TestCase(param=1,expected=false)
    @TestCase(param=3,expected=true)
    public boolean even(int param) {
        return param % 2 != 0;
    }
}
