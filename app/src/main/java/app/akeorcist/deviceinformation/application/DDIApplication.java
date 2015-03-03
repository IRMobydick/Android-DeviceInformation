package app.akeorcist.deviceinformation.application;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseCrashReporting;

import app.akeorcist.deviceinformation.utilities.Preferences;
import app.akeorcist.deviceinformation.constants.Key;

/**
 * Created by Ake on 2/25/2015.
 */
public class DDIApplication  extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Preferences.init(getApplicationContext());
        ParseCrashReporting.enable(this);
        Parse.initialize(this, Key.PARSE_APP_ID, Key.PARSE_CLIENT_ID);
        //Master
    }
}
