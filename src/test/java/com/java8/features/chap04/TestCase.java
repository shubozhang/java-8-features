package com.java8.features.chap04;

import java.lang.annotation.Repeatable;

@Repeatable(TestCases.class)
@interface TestCase {
    int param();

    boolean expected();
}
