package com.hannabennett.fkar;

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

        mRightButton = view.findViewById(R.id.right_button);

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

        return view;
    }
}
