package com.hannabennett.fkar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.UUID;

/**
 * Created by HannaBennett on 12/6/17.
 */

public class SettingsFragment extends Fragment {
    private TextView mSpeedText;
    private SeekBar mSpeedSeekBar;
    private Object mObject;

    private static final String ARG_SPEED = "speed";
    private static final String ARG_X_COORDINATE = "xCoordinate";
    public static final String EXTRA_SPEED = "com.hannabennett.fkar.speed";

    private static final String TAG = "settingsfragment";

    public static SettingsFragment newInstance(int objectSpeed, int objectXCoordinate) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_SPEED, objectSpeed);
        args.putSerializable(ARG_X_COORDINATE, objectXCoordinate);

        SettingsFragment fragment = new SettingsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int objectSpeed = (int) getArguments().getSerializable(ARG_SPEED);
        int objectXCoordinate = (int) getArguments().getSerializable(ARG_X_COORDINATE);
        mObject = new Object(objectSpeed, objectXCoordinate);
    }

    @Override
    public void onDetach() {
        Log.i(TAG, "on detach");
        super.onDetach();
        Log.i(TAG, "speed " + mObject.getSpeed());
        sendResult(Activity.RESULT_OK, mObject.getSpeed());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        mSpeedText = view.findViewById(R.id.speed_text);
        mSpeedText.setText(getString(R.string.speed_format, mObject.getSpeed()));

        mSpeedSeekBar = view.findViewById(R.id.speed_seek_bar);
        mSpeedSeekBar.setProgress(mObject.getSpeed());
        mSpeedSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mObject.setSpeed(i);
                mSpeedText.setText(getString(R.string.speed_format, i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return view;
    }

    private void sendResult(int resultCode, int objectSpeed) {
        if (getTargetFragment() == null) {
            Log.i(TAG, "get target fragment null");
            return;
        }

        Intent intent = new Intent();
        intent.putExtra(EXTRA_SPEED, objectSpeed);

        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);
    }
}
