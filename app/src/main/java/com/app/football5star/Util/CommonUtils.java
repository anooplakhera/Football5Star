package com.app.football5star.Util;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.app.football5star.R;

public class CommonUtils {

    private static final String TAG = "CommonUtils";
    // Device model

    public static String androidModel = android.os.Build.MODEL;

    // Android version
    public static String androidVersion = android.os.Build.VERSION.RELEASE;

    // Android version
    public static String androidManufacturer = android.os.Build.MANUFACTURER;


    private CommonUtils() {
        // This utility class is not publicly instantiable
    }

    public static ProgressDialog showLoadingDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.show();
        if (progressDialog.getWindow() != null) {
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        progressDialog.setContentView(R.layout.progress_layout);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }

}
