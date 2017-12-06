package com.hannabennett.fkar;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by HannaBennett on 12/6/17.
 */
public class ObjectTest {
    private Object mObject;

    @Before
    public void setUp() throws Exception {
        mObject = new Object();
    }

    @Test
    public void overrideConstructorToSetSpeedAndCoordinate() {
        Object test = new Object(100, 500);
        assertThat(test.getSpeed(), is(100));
        assertThat(test.getXCoordinate(), is(500));
    }
}