package com.ss.securedetails.preferance;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class Shareprefrance {

    private static final String KEY_PREF = "DESITOK_PREFE";

    private static final String KEY_ID = "key_id";
    private static final String KEY_NAME = "key_name";
    private static final String KEY_EMAIl = "key_email";
    private static final String KEY_PHONE = "key_phone";
    private static final String KEY_LOCATION_ID = "key_location_id";
    private static final String KEY_USER_TYPE = "key_user_type";
    private static final String KEY_ISLOGIN = "key_islogin";
    private static final String KEY_SERVER_URL = "key_server_url";
    private static final String FCM_TOKEN = "fcm_token";

    public void loginUser(Context context, String name, String email, String phone, String user_id, String user_type, boolean isLogin) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(KEY_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_EMAIl, email);
        editor.putString(KEY_ID, user_id);
        editor.putString(KEY_USER_TYPE, user_type);
        editor.putString(KEY_PHONE, phone);
        editor.putBoolean(KEY_ISLOGIN, isLogin);
        editor.apply();
    }

    public void setServerURL(Context context, String url) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(KEY_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_SERVER_URL, url);
        editor.apply();
    }

    public String getServerURL(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(KEY_PREF, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_SERVER_URL, "192.168.1.7:8082");
    }

    public void clear(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(KEY_PREF, Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().commit();
    }

    public boolean isLOgin(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(KEY_PREF, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(KEY_ISLOGIN, false);
    }

    public String getName(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(KEY_PREF, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_NAME, "");
    }

    public int getLocationId(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(KEY_PREF, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(KEY_LOCATION_ID, 0);
    }

    public String getEmail(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(KEY_PREF, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_EMAIl, "");
    }

    public String getPhone(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(KEY_PREF, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_PHONE, "");
    }

    public String getUserType(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(KEY_PREF, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_TYPE, "");
    }

    public String getUserID(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(KEY_PREF, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_ID, "");
    }

    public void setFcmToken(Context context, String token) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(KEY_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(FCM_TOKEN, token);
        editor.apply();
    }

    public String getFcmToken(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(KEY_PREF, Context.MODE_PRIVATE);
        Log.e("####", " FCM Token in shared preference " + sharedPreferences.getString(FCM_TOKEN, ""));
        return sharedPreferences.getString(FCM_TOKEN, "");
    }

}
