package com.app.football5star.Activities.Base;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.app.football5star.R;
import com.app.football5star.Util.CommonUtils;

import butterknife.Unbinder;

/**
 * Created by Shrikant on 9/11/2017.
 */

public abstract class BaseFragment extends Fragment {

    private BaseActivity mActivity;
    private Unbinder mUnBinder;
    private ProgressDialog mProgressDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUp(view);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
            activity.onFragmentAttached();
        }
    }


    public void showLoading() {
        hideLoading();
        mProgressDialog = CommonUtils.showLoadingDialog(this.getContext());
    }


    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }


    public void onError(String message) {
        if (mActivity != null) {
            mActivity.onError(message);
        }
    }


    public void onError(@StringRes int resId) {
        if (mActivity != null) {
            mActivity.onError(resId);
        }
    }


    public void showMessage(String message) {
        if (mActivity != null) {
            mActivity.showMessage(message);
        }
    }


    public void showMessage(@StringRes int resId) {
        if (mActivity != null) {
            mActivity.showMessage(resId);
        }
    }


    public boolean isNetworkConnected() {
        if (mActivity != null) {
            return mActivity.isNetworkConnected();
        }
        return false;
    }


    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }


    public void hideKeyboard() {
        if (mActivity != null) {
            mActivity.hideKeyboard();
        }
    }


    public void showSnackBar(String message) {
        hideKeyboard();
        Snackbar snackbar = Snackbar.make(getActivity().findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG);
        View view = snackbar.getView();
        view.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.red_color));
        TextView txtv = (TextView) view.findViewById(android.support.design.R.id.snackbar_text);
        txtv.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.snack_bar_text_size));
        Typeface face = Typeface.createFromAsset(mActivity.getAssets(), "Roboto-Regular.ttf");
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

    public void showSnackBar(String message, int colorCode) {
        hideKeyboard();
        Snackbar snackbar = Snackbar.make(getActivity().findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG);
        View view = snackbar.getView();
        view.setBackgroundColor(ContextCompat.getColor(getActivity(), colorCode));
        //view.setBackgroundColor(Color.parseColor(String.valueOf(colorCode)));
        TextView txtv = (TextView) view.findViewById(android.support.design.R.id.snackbar_text);
        txtv.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.snack_bar_text_size));
        Typeface face = Typeface.createFromAsset(mActivity.getAssets(), "Roboto-Regular.ttf");
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

    public BaseActivity getBaseActivity() {
        return mActivity;
    }

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    protected abstract void setUp(View view);

    @Override
    public void onDestroy() {
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }

    public interface Callback {

        void onFragmentAttached();

        void onFragmentDetached(String tag);
    }


    public void swapFragment(Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment, tag);
//        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
