package org.zzy.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleTest {
    @Test
    public void simplePassedTest() {
        Assert.assertEquals(2 + 2, 4, "Sum isn't equal to expected");
    }

    @Test
    public void simpleFailedTest() {
        Assert.assertEquals(2 + 2, 3, "Sum isn't equal to expected");
    }
}
