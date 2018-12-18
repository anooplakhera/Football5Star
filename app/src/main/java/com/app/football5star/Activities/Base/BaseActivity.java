package com.app.football5star.Activities.Base;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.football5star.R;
import com.app.football5star.Util.CommonUtils;
import com.app.football5star.Util.NetworkUtils;

import butterknife.Unbinder;


/**
 * Created by Shrikant on 9/11/2017.
 */

public abstract class BaseActivity extends AppCompatActivity
        implements BaseFragment.Callback {

    private ProgressDialog mProgressDialog;
    private Unbinder mUnBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @TargetApi(Build.VERSION_CODES.M)
    public void requestPermissionsSafely(String[] permissions, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean hasPermission(String permission) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }

    public void showLoading() {
        hideLoading();
        mProgressDialog = CommonUtils.showLoadingDialog(this);
    }


    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }


    public void showSnackBar(String message, int colorCode) {
        hideKeyboard();
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG);
        View view = snackbar.getView();
        view.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), colorCode));
        //view.setBackgroundColor(Color.parseColor(String.valueOf(colorCode)));
        TextView txtv = (TextView) view.findViewById(android.support.design.R.id.snackbar_text);
        txtv.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.snack_bar_text_size));
        Typeface face = Typeface.createFromAsset(getAssets(), "Roboto-Regular.ttf");
//        txtv.setCompoundDrawablesWithIntrinsicBounds(drawable,0, 0, 0);
        txtv.setTypeface(face);
        txtv.setTextColor(Color.WHITE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            txtv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        } else {
            txtv.setGravity(Gravity.CENTER_HORIZONTAL);
        }
        snackbar.setDuration(Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    public void showSnackBar(String message) {
        hideKeyboard();
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG);
        View view = snackbar.getView();
        view.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.red_color));
        TextView txtv = (TextView) view.findViewById(android.support.design.R.id.snackbar_text);
        txtv.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.snack_bar_text_size));
        Typeface face = Typeface.createFromAsset(getAssets(), "Roboto-Regular.ttf");
//        txtv.setCompoundDrawablesWithIntrinsicBounds(drawable,0, 0, 0);
        txtv.setTypeface(face);
        txtv.setTextColor(Color.WHITE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            txtv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        } else {
            txtv.setGravity(Gravity.CENTER_HORIZONTAL);
        }
        snackbar.setDuration(Snackbar.LENGTH_LONG);
        snackbar.show();
    }


    public void onError(String message) {
        if (message != null) {
            showSnackBar(message, R.color.red_snackbar);
        } else {
            showSnackBar(getString(R.string.some_error), R.color.red_snackbar);
        }
    }


    public void onError(@StringRes int resId) {
        onError(getString(resId));
    }


    public void showMessage(String message) {
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.some_error), Toast.LENGTH_SHORT).show();
        }
    }

    public void showMessage(@StringRes int resId) {
        showMessage(getString(resId));
    }


    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

//    public void openActivityOnTokenExpire() {
//        startActivity(LoginActivity.getStartIntent(this));
//        finish();
//    }

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    protected void onDestroy() {

        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View view = getCurrentFocus();

        if (view != null && (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() ==
                MotionEvent.ACTION_MOVE) && view instanceof EditText &&
                !view.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            view.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + view.getLeft() - scrcoords[0];
            float y = ev.getRawY() + view.getTop() - scrcoords[1];
            if (x < view.getLeft() || x > view.getRight() || y < view.getTop() || y > view.getBottom())

                ((InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow((
                        this.getWindow().getDecorView().getApplicationWindowToken()), 0);
        }
        return super.dispatchTouchEvent(ev);
    }


}
