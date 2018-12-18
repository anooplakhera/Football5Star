package com.app.football5star.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.app.football5star.Activities.Base.BaseActivity;
import com.app.football5star.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginSignupActivity extends BaseActivity {

    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.btnSignup)
    Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);
        setUnBinder(ButterKnife.bind(this));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.app_name));

    }

    @OnClick(R.id.btnLogin)
    public void btnLogin() {
        startActivity(new Intent(LoginSignupActivity.this, LoginActivity.class));
    }

    @OnClick(R.id.btnSignup)
    public void btnSignup() {
        startActivity(new Intent(LoginSignupActivity.this, SignUpActivity.class));
    }


}
