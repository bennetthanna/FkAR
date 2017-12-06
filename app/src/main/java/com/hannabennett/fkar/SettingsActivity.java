package com.hannabennett.fkar;

import android.support.v4.app.Fragment;

/**
 * Created by HannaBennett on 12/6/17.
 */

public class SettingsActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new SettingsFragment();
    }
}
