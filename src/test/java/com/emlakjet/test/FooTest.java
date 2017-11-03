package com.emlakjet.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class FooTest {
    @Test
    public void foo_1equals1_shouldBeTrue() {
        Assert.assertEquals(1, 1);
    }
}
