package com.app.football5star.AppModules.NavigationDrawer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.football5star.Activities.Base.BaseFragment;
import com.app.football5star.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingFragment extends BaseFragment {

    @BindView(R.id.rel_notifications)
    RelativeLayout rel_notifications;
    @BindView(R.id.rel_mute)
    RelativeLayout rel_mute;

    @BindView(R.id.rel_copyright)
    RelativeLayout rel_copyright;
    @BindView(R.id.rel_terms)
    RelativeLayout rel_terms;

    @BindView(R.id.rel_privacy)
    RelativeLayout rel_privacy;
    @BindView(R.id.tv_currentversion)
    TextView tv_currentversion;

    @BindView(R.id.cb_notifications)
    CheckBox cb_notifications;

    @BindView(R.id.cb_mute)
    CheckBox cb_mute;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        setUnBinder(ButterKnife.bind(this, view));

        return view;
    }

    @Override
    protected void setUp(View view) {

    }

    @OnClick(R.id.rel_notifications)
    public void rel_notifications() {

        if (cb_notifications.isChecked())
            cb_notifications.setChecked(false);
        else
            cb_notifications.setChecked(true);

    }

    @OnClick(R.id.rel_mute)
    public void rel_mute() {
        if (cb_mute.isChecked())
            cb_mute.setChecked(false);
        else
            cb_mute.setChecked(true);
    }

    @OnClick(R.id.rel_copyright)
    public void rel_copyright() {

    }

    @OnClick(R.id.rel_terms)
    public void rel_terms() {

    }

    @OnClick(R.id.rel_privacy)
    public void rel_privacy() {

    }

}