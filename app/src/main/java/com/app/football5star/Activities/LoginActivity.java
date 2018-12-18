package com.app.football5star.Activities;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.football5star.Activities.Base.BaseActivity;
import com.app.football5star.R;

import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.et_username)
    EditText et_username;
    @BindView(R.id.et_password)
    EditText et_password;
    @BindView(R.id.bt_signin)
    Button bt_signin;

    String username = "", password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setUnBinder(ButterKnife.bind(this));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.login_activity));

//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.white)));
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Window window = getWindow();
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(getResources().getColor(R.color.white));
//        }

    }

    @OnClick(R.id.bt_signin)
    public void btnLogin() {
        validateFields();
    }

    public void validateFields() {
        if (et_username != null && et_password != null) {
            username = et_username.getText().toString().trim();
            password = et_password.getText().toString().trim();

            if (username.equalsIgnoreCase(""))
                showSnackBar(getString(R.string.username_blank_message));
            else if (username.length() < 2 || username.length() > 16)
                showSnackBar(getString(R.string.username_wrong_message));
            else if (password.equalsIgnoreCase(""))
                showSnackBar(getString(R.string.password_blank_message));
            else if (password.length() < 8 || password.length() > 16)
                showSnackBar(getString(R.string.password_wrong_message));
            else
                login();
        }
    }

    public void login() {
        Toast.makeText(this, "Validated Successfully", Toast.LENGTH_SHORT).show();
    }
}