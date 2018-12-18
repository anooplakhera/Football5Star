package com.app.football5star.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.football5star.Activities.Base.BaseActivity;
import com.app.football5star.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends BaseActivity {


    @BindView(R.id.et_username)
    EditText et_username;
    @BindView(R.id.et_password)
    EditText et_password;
    @BindView(R.id.et_confirm_password)
    EditText et_confirm_password;
    @BindView(R.id.bt_signin)
    Button bt_signin;

    String username = "", password = "", confirmPassword = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setUnBinder(ButterKnife.bind(this));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.signup_activity));

    }

    @OnClick(R.id.bt_signin)
    public void bt_signin() {
        validateFields();
    }

    public void validateFields() {
        if (et_username != null && et_password != null && et_confirm_password != null) {
            username = et_username.getText().toString().trim();
            password = et_password.getText().toString().trim();
            confirmPassword = et_confirm_password.getText().toString().trim();

            if (username.equalsIgnoreCase(""))
                showSnackBar(getString(R.string.username_blank_message));
            else if (username.length() < 2 || username.length() > 12)
                showSnackBar(getString(R.string.username_wrong_message));
            else if (password.equalsIgnoreCase(""))
                showSnackBar(getString(R.string.password_blank_message));
            else if (password.length() < 8 || password.length() > 16)
                showSnackBar(getString(R.string.password_wrong_message));
            else if (confirmPassword.equalsIgnoreCase(""))
                showSnackBar(getString(R.string.password_blank_message));
            else if (!confirmPassword.equalsIgnoreCase(password))
                showSnackBar(getString(R.string.password_wrong_message));
            else
                signIn();
        }
    }

    public void signIn() {
        Toast.makeText(this, "Validated Successfully", Toast.LENGTH_SHORT).show();
    }
}