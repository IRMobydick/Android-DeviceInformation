package app.akeorcist.deviceinformation.application;

import android.app.Application;

import app.akeorcist.deviceinformation.Utilities.Preferences;

/**
 * Created by Ake on 2/25/2015.
 */
public class DDIApplication  extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Preferences.init(getApplicationContext());
    }
}
