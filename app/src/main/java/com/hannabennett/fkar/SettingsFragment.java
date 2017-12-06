package com.hannabennett.fkar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        mSpeedText = view.findViewById(R.id.speed_text);
//         get object from bundle
//         mSpeed.setText(getString(R.string.speed_format, object.getSpeed()));

        mSpeedSeekBar = view.findViewById(R.id.speed_seek_bar);
//        mSpeedSeekBar.setProgress(object.getSpeed());
        mSpeedSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                object.setSpeed(i);
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
}
