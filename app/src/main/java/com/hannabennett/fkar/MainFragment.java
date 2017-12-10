package com.hannabennett.fkar;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by HannaBennett on 12/6/17.
 */

public class MainFragment extends Fragment {
    private Object mObject;
    private ImageButton mLeftButton;
    private ImageButton mRightButton;
    private Button mReportButton;
    private Button mFkitButton;
    private Button mSettingsButton;

    private static final int REQUEST_SPEED = 0;
    private static final String TAG = "main fragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "on create view");
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mObject = new Object();

        mLeftButton = view.findViewById(R.id.left_button);
        mLeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mObject.moveLeft();
            }
        });

        mRightButton = view.findViewById(R.id.right_button);
        mRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mObject.moveRight();
            }
        });

        mReportButton = view.findViewById(R.id.report_button);
        mReportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reportToast = getResources().getString(R.string.report_format,
                        mObject.getXCoordinate(), mObject.getSpeed());
                Toast.makeText(getActivity(), reportToast, Toast.LENGTH_SHORT).show();
            }
        });

        mFkitButton = view.findViewById(R.id.fkit_button);

        mSettingsButton = view.findViewById(R.id.settings_button);
        mSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                SettingsFragment fragment = SettingsFragment.newInstance(mObject.getSpeed(), mObject.getXCoordinate());
                fragment.setTargetFragment(MainFragment.this, REQUEST_SPEED);

                Intent intent = SettingsActivity.newIntent(getActivity(), mObject.getSpeed(), mObject.getXCoordinate());
                startActivity(intent);
                // startActivityForResult(intent, REQUEST_SPEED);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i(TAG, "on activity result");
        if (requestCode == REQUEST_SPEED) {
            Log.i(TAG, "on activity result");
            int speed = (int) data.getSerializableExtra(SettingsFragment.EXTRA_SPEED);
            Log.i(TAG, "speed " + speed);
            mObject.setSpeed(speed);
        }
    }
}
