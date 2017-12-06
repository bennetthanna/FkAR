package com.hannabennett.fkar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by HannaBennett on 12/6/17.
 */

public class MainFragment extends Fragment {
    private Object mObject;
    private Button mLeftButton;
    private Button mRightButton;
    private Button mReportButton;
    private Button mFkitButton;
    private Button mSettingsButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mObject = new Object();

        mLeftButton = view.findViewById(R.id.left_button);
        mLeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveObject(-1);
            }
        });

        mRightButton = view.findViewById(R.id.right_button);
        mRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveObject(1);
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
                Intent intent = SettingsActivity.newIntent(getActivity(), mObject.getSpeed(), mObject.getXCoordinate());
                startActivity(intent);
            }
        });

        return view;
    }

    private void moveObject(int direction) {
        int speed = mObject.getSpeed();
        int currentX = mObject.getXCoordinate();
        if (direction == 1) {
            mObject.setXCoordinate(currentX + (speed * 10));
        } else {
            mObject.setXCoordinate(currentX - (speed * 10));
        }
    }
}
