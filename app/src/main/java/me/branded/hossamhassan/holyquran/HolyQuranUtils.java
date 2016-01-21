package me.branded.hossamhassan.holyquran;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;

/**
 * Created by HossamHassan on 12/28/2015.
 */
public class HolyQuranUtils  extends Application{
    private final static String PREFS_NAME = "holyquran.Shared";
    private static SharedPreferences sharedPreference;
    public static  void initSharedPreferences(Context context)
    {
        sharedPreference = context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);

    }
    public static void clearData() {
        if (null != sharedPreference) {
            SharedPreferences.Editor editor = sharedPreference.edit();
            editor.clear();
            editor.commit();
        }
    }

    public static void removeData(String key) {
        if (null != sharedPreference) {
            SharedPreferences.Editor editor = sharedPreference.edit();
            editor.remove(key);
            editor.commit();
        }
    }
    public static int getInt(String key, int def) {
        if (key == null || key.equals("")) {
            return def;
        }
        return sharedPreference.getInt(key, def);
    }
    public static boolean getBoolean(String key, boolean def) {
        if (key == null || key.equals("")) {
            return def;
        }
        return sharedPreference.getBoolean(key, def);
    }

    public static String getString(String key, String def) {
        if (key == null || key.equals("")) {
            return def;
        }
        return sharedPreference.getString(key, def);
    }

    public static void setInt(String key, int value) {
        SharedPreferences.Editor editor = sharedPreference.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static void setString(String key, String value) {
        SharedPreferences.Editor editor = sharedPreference.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static void setBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = sharedPreference.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static void showSnackBar(String msg)
    {
        Snackbar sb=Snackbar.make(null, msg, Snackbar.LENGTH_SHORT);
        sb.show();
    }

}
