package app.akeorcist.deviceinformation.utilities;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Ake on 2/25/2015.
 */
public class Preferences {
    private final static String APP_PREFERENCE = "app_pref";

    private final static String KEY_FIRST_RUN = "first_run";

    private static SharedPreferences preferences;

    public static void init(Context context) {
        if (preferences == null && context != null) {
            preferences = context.getSharedPreferences(APP_PREFERENCE, Activity.MODE_PRIVATE);
        }
    }

    public static boolean isFirstRun() {
        boolean firstRun = preferences.getBoolean(KEY_FIRST_RUN, true);
        if(firstRun)
            setPreference(KEY_FIRST_RUN, false);
        return firstRun;
    }

    private static void setPreference(String key, String value) {
        SharedPreferences.Editor editor =  preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    private static void setPreference(String key, int value) {
        SharedPreferences.Editor editor =  preferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    private static void setPreference(String key, boolean value) {
        SharedPreferences.Editor editor =  preferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

}

