package com.hannabennett.fkar;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Created by HannaBennett on 12/6/17.
 */

public class SettingsActivity extends SingleFragmentActivity {

    private static final String EXTRA_SPEED = "com.hannabennett.fkar.object_speed";
    private static final String EXTRA_X_COORDINATE = "com.hannabennett.fkar.object_x_coordinate";

    public static Intent newIntent(Context packageContext, int objectSpeed, int objectXCoordinate) {
        Intent intent = new Intent(packageContext, SettingsActivity.class);
        intent.putExtra(EXTRA_SPEED, objectSpeed);
        intent.putExtra(EXTRA_X_COORDINATE, objectXCoordinate);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        int objectSpeed = (int) getIntent().getSerializableExtra(EXTRA_SPEED);
        int objectXCoordinate = (int) getIntent().getSerializableExtra(EXTRA_X_COORDINATE);
        return SettingsFragment.newInstance(objectSpeed, objectXCoordinate);
    }
}
