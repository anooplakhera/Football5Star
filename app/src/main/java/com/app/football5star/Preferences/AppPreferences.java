package com.app.football5star.Preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class AppPreferences {

    private static AppPreferences theInstance = null;

    private static final String PREFS_FILE_NAME = "Football5StarApp";
    private static final String USERNAME = "username";
    private static final String USERID = "userid";
    private static final String USERDETAILS = "userdetails";
    private static final String PASSWORD = "password";
    private static final String SESSIONID = "sessionId";
    private static final String USER_COLOR_NAME = "colorName";

    private static final String REGISTRATION_DATE = "registrationdate";
    private static final String LAST_LOGIN_DATE = "lastlogindate";
    private static final String SKEY = "skey";
    private static final String gPrefKeyRegId = "gPrefKeyRegId";


    //Socket Data
    private static final String SOCKET_MESSAGE = "message";
    private static final String APP_PACKAGE_NAME = "package_name";
    private static final String APP_VERSION_NAME = "package_version";

    //Time in ms
    private static final String TIME = "time_ms";

    private AppPreferences() {
    }

    public static AppPreferences getInstance() {
        if (theInstance == null)
            theInstance = new AppPreferences();

        return theInstance;
    }


    public String getRegId(Context context) {
        String bret = "";
        SharedPreferences prefs = context.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
        if (prefs != null) {
            bret = prefs.getString(gPrefKeyRegId, "");
        }

        return bret;
    }

    public void setRegId(Context context, String regId) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(gPrefKeyRegId, regId);
        editor.commit();
    }


    public void logOut(Context c) {
        final SharedPreferences prefs = c.getSharedPreferences(PREFS_FILE_NAME,
                Context.MODE_PRIVATE);
        prefs.edit().putBoolean("LOGIN", false).commit();
    }

    public void setLogin(Context c) {
        final SharedPreferences prefs = c.getSharedPreferences(PREFS_FILE_NAME,
                Context.MODE_PRIVATE);
        prefs.edit().putBoolean("LOGIN", true).commit();
    }

    public boolean isLogged(Context c) {
        final SharedPreferences prefs = c.getSharedPreferences(PREFS_FILE_NAME,
                Context.MODE_PRIVATE);
        return prefs.getBoolean("LOGIN", false);
    }

    public String getUserName(final Context ctx) {
        return ctx.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
                .getString(USERNAME, "");
    }

    public void setUserName(final Context ctx, final String data) {
        final SharedPreferences prefs = ctx.getSharedPreferences(
                PREFS_FILE_NAME, Context.MODE_PRIVATE);
        final Editor editor = prefs.edit();
        editor.putString(USERNAME, data);
        editor.commit();
    }

    public String getSessionid(final Context ctx) {
        return ctx.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
                .getString(SESSIONID, "");
    }

    public void setSessionid(final Context ctx, final String data) {
        final SharedPreferences prefs = ctx.getSharedPreferences(
                PREFS_FILE_NAME, Context.MODE_PRIVATE);
        final Editor editor = prefs.edit();
        editor.putString(SESSIONID, data);
        editor.commit();
    }

    public void setPassword(final Context ctx, final String data) {
        final SharedPreferences prefs = ctx.getSharedPreferences(
                PREFS_FILE_NAME, Context.MODE_PRIVATE);
        final Editor editor = prefs.edit();
        editor.putString(PASSWORD, data);
        editor.commit();
    }

    public String getPassword(final Context ctx) {
        return ctx.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
                .getString(PASSWORD, "");
    }

    public String getRegistrationDate(final Context ctx) {
        return ctx.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
                .getString(REGISTRATION_DATE, "");
    }

    public void setRegistrationDate(final Context ctx, final String data) {
        final SharedPreferences prefs = ctx.getSharedPreferences(
                PREFS_FILE_NAME, Context.MODE_PRIVATE);
        final Editor editor = prefs.edit();
        editor.putString(REGISTRATION_DATE, data);
        editor.commit();
    }

    public String getLastLoginDate(final Context ctx) {
        return ctx.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
                .getString(LAST_LOGIN_DATE, "");
    }

    public void setLastLoginDate(final Context ctx, final String data) {
        final SharedPreferences prefs = ctx.getSharedPreferences(
                PREFS_FILE_NAME, Context.MODE_PRIVATE);
        final Editor editor = prefs.edit();
        editor.putString(LAST_LOGIN_DATE, data);
        editor.commit();
    }


    public String getSkey(final Context ctx) {
        return ctx.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
                .getString(SKEY, "");
    }

    public void setSkey(final Context ctx, final String data) {
        final SharedPreferences prefs = ctx.getSharedPreferences(
                PREFS_FILE_NAME, Context.MODE_PRIVATE);
        final Editor editor = prefs.edit();
        editor.putString(SKEY, data);
        editor.commit();
    }

    public String getSocketMessage(final Context ctx) {
        return ctx.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
                .getString(SOCKET_MESSAGE, "");
    }

    public void setSocketMessage(final Context ctx, final String data) {
        final SharedPreferences prefs = ctx.getSharedPreferences(
                PREFS_FILE_NAME, Context.MODE_PRIVATE);
        final Editor editor = prefs.edit();
        editor.putString(SOCKET_MESSAGE, data);
        editor.commit();
    }

    public String getAppPackageName(final Context ctx) {
        return ctx.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
                .getString(APP_PACKAGE_NAME, "");
    }

    public void setAppPackageName(final Context ctx, final String data) {
        final SharedPreferences prefs = ctx.getSharedPreferences(
                PREFS_FILE_NAME, Context.MODE_PRIVATE);
        final Editor editor = prefs.edit();
        editor.putString(APP_PACKAGE_NAME, data);
        editor.commit();
    }

    public String getAppVersionName(final Context ctx) {
        return ctx.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
                .getString(APP_VERSION_NAME, "");
    }

    public void setAppVersionName(final Context ctx, final String data) {
        final SharedPreferences prefs = ctx.getSharedPreferences(
                PREFS_FILE_NAME, Context.MODE_PRIVATE);
        final Editor editor = prefs.edit();
        editor.putString(APP_VERSION_NAME, data);
        editor.commit();
    }


}