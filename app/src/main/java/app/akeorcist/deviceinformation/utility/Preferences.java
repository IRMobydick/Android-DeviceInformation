package app.akeorcist.deviceinformation.utility;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Ake on 2/25/2015.
 */
public class Preferences {
    private final static String PREFERENCE_APP = "app_pref";
    private final static String PREFERENCE_DEVICE = "app_pref";

    private final static String KEY_APP_FIRST_RUN = "first_run";
    private final static String KEY_APP_VALIDATED = "is_validated";

    private final static String KEY_DEVICE_BRAND = "brand";
    private final static String KEY_DEVICE_MODEL = "model";
    private final static String KEY_DEVICE_VERSION = "version";
    private final static String KEY_DEVICE_FINGERPRINT = "fingerprint";

    private static SharedPreferences appPreferences;
    private static SharedPreferences devicePreferences;

    private static void setAppPreference(Context context, String key, String value) {
        SharedPreferences.Editor editor =  getAppPreference(context).edit();
        editor.putString(key, value);
        editor.commit();
    }

    private static void setAppPreference(Context context, String key, int value) {
        SharedPreferences.Editor editor =  getAppPreference(context).edit();
        editor.putInt(key, value);
        editor.commit();
    }

    private static void setAppPreference(Context context, String key, boolean value) {
        SharedPreferences.Editor editor =  getAppPreference(context).edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    private static void setDevicePreference(Context context, String key, String value) {
        SharedPreferences.Editor editor =  getDevicePreference(context).edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static SharedPreferences getAppPreference(Context context) {
        return context.getSharedPreferences(PREFERENCE_APP, Activity.MODE_PRIVATE);
    }

    public static SharedPreferences getDevicePreference(Context context) {
        return context.getSharedPreferences(PREFERENCE_DEVICE, Activity.MODE_PRIVATE);
    }

    public static boolean isFirstRun(Context context) {
        boolean firstRun = getAppPreference(context).getBoolean(KEY_APP_FIRST_RUN, true);
        if(firstRun)
            setAppPreference(context, KEY_APP_FIRST_RUN, false);
        return firstRun;
    }

    public static boolean isValidated(Context context) {
        return getAppPreference(context).getBoolean(KEY_APP_VALIDATED, false);
    }

    public static void setValidated(Context context) {
        setAppPreference(context, KEY_APP_VALIDATED, true);
    }

    public static void setDeviceBrand(Context context, String brand) {
        setDevicePreference(context, KEY_DEVICE_BRAND, brand);
    }

    public static String getDeviceBrand(Context context) {
        return getDevicePreference(context).getString(KEY_DEVICE_BRAND, "");
    }

    public static void setDeviceModel(Context context, String model) {
        setDevicePreference(context, KEY_DEVICE_MODEL, model);
    }

    public static String getDeviceModel(Context context) {
        return getDevicePreference(context).getString(KEY_DEVICE_MODEL, "");
    }

    public static void setDeviceVersion(Context context, String model) {
        setDevicePreference(context, KEY_DEVICE_VERSION, model);
    }

    public static String getDeviceVersion(Context context) {
        return getDevicePreference(context).getString(KEY_DEVICE_VERSION, "");
    }

    public static void setDeviceFingerprint(Context context, String model) {
        setDevicePreference(context, KEY_DEVICE_FINGERPRINT, model);
    }

    public static String getDeviceFingerprint(Context context) {
        return getDevicePreference(context).getString(KEY_DEVICE_FINGERPRINT, "");
    }

}

