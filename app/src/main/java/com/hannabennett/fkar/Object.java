package com.hannabennett.fkar;

/**
 * Created by HannaBennett on 12/6/17.
 */

public class Object {
    private int mXCoordinate;
    private int mSpeed;

    public Object() {
        mXCoordinate = 200;
        mSpeed = 5;
    }

    public int getXCoordinate() {
        return mXCoordinate;
    }

    public void setXCoordinate(int xCoordinate) {
        mXCoordinate = xCoordinate;
    }


    public int getSpeed() {
        return mSpeed;
    }

    public void setSpeed(int speed) {
        mSpeed = speed;
    }

}
