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

    public Object(int speed, int xCoordinate) {
        mSpeed = speed;
        mXCoordinate = xCoordinate;
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

    public void moveRight() {
        setXCoordinate(mXCoordinate + (mSpeed * 10));
    }

    public void moveLeft() {
        setXCoordinate(mXCoordinate - (mSpeed * 10));
    }
}
