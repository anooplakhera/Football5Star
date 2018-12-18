package com.app.football5star.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.app.football5star.Activities.Base.BaseActivity;
import com.app.football5star.AppModules.Match.MatchFragment;
import com.app.football5star.AppModules.NavigationDrawer.SettingFragment;
import com.app.football5star.AppModules.News.NewsFragment;
import com.app.football5star.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    @BindView(R.id.nav_view)
    NavigationView nav_view;

    @BindView(R.id.content_frame)
    FrameLayout content_frame;
    Fragment fragment;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer_layout;

    TextView txtLoginBtn;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
//    final static String urlAddress = "http://10.0.2.2/galacticnews/index.php/feed/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUnBinder(ButterKnife.bind(this));
        setSupportActionBar(toolbar);


        if (savedInstanceState == null) {
            fragment = new NewsFragment();
            loadFragment(fragment);
        }

        ImageButton imageButton = (ImageButton) toolbar.findViewById(R.id.actionBarProfileImg);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer_layout.openDrawer(nav_view);
            }
        });

        View headerView = nav_view.getHeaderView(0);
        txtLoginBtn = (TextView) headerView.findViewById(R.id.txtLoginBtn);
        txtLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LoginSignupActivity.class));
            }
        });

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_news:
                    fragment = new NewsFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_match:
                    fragment = new MatchFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }

    };

    public void beginTransationForDrawer(Fragment fragment, String tag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_NONE);
        ft.replace(R.id.content_frame, fragment, tag).addToBackStack(tag).commit();
    }

    public void loadFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment, "Home");
            ft.addToBackStack(null);
            ft.commit();
        }
    }

    @Override
    public void onBackPressed() {
        Fragment home = getSupportFragmentManager().findFragmentByTag("Home");
        Fragment first = getSupportFragmentManager().findFragmentByTag("First");
        if (home instanceof NewsFragment && home.isVisible()) {
            finish();
        } else if (first instanceof MatchFragment && first.isVisible()) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, new NewsFragment(), "Home");
            ft.setTransition(FragmentTransaction.TRANSIT_EXIT_MASK);
            ft.commit();
        } else if (home.isVisible()) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, new NewsFragment(), "Home");
            ft.commit();
        } else {
            super.onBackPressed();
        }

    }

}