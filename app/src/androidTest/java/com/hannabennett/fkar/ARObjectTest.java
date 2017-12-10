package com.hannabennett.fkar;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by HannaBennett on 12/6/17.
 */
public class ARObjectTest {
    private ARObject mARObject;

    @Before
    public void setUp() throws Exception {
        mARObject = new ARObject();
    }

    @Test
    public void overrideConstructorToSetSpeedAndCoordinate() {
        ARObject test = new ARObject(100, 500);
        assertThat(test.getSpeed(), is(100));
        assertThat(test.getXCoordinate(), is(500));
    }
}