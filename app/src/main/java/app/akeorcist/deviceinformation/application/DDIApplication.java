package app.akeorcist.deviceinformation.application;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseCrashReporting;

import app.akeorcist.deviceinformation.Utilities.Preferences;

/**
 * Created by Ake on 2/25/2015.
 */
public class DDIApplication  extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Preferences.init(getApplicationContext());
        ParseCrashReporting.enable(this);
        Parse.initialize(this, "NbdiZ4IoaaM4YAyh8y7pDtUdZigTbZfHVsSDz5uE", "ZNj0ILJqMwJNmyp7iIMABkqupvtbSkaBChwRmwOP");
    }
}
