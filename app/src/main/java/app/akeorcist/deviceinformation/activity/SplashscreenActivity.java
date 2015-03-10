package app.akeorcist.deviceinformation.activity;

import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

import app.akeorcist.deviceinformation.R;
import app.akeorcist.deviceinformation.constants.Constants;
import app.akeorcist.deviceinformation.data.device.Camera2Manager;
import app.akeorcist.deviceinformation.data.device.CameraManager;
import app.akeorcist.deviceinformation.data.device.DataManager;
import app.akeorcist.deviceinformation.data.device.FeatureManager;
import app.akeorcist.deviceinformation.data.device.HardwareManager;
import app.akeorcist.deviceinformation.data.device.ScreenManager;
import app.akeorcist.deviceinformation.data.device.SensorListManager;
import app.akeorcist.deviceinformation.data.file.FileManager;

public class SplashscreenActivity extends ActionBarActivity {
    int loadTaskCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
            actionBar.hide();

        setContentView(R.layout.activity_splashscreen);

        initialData();
    }

    private void onDataLoaded() {
        if (loadTaskCount == 1) {
            FileManager.writeInternalFile(this, Constants.PATH_DEVICE_INFO, DataManager.createDataJson());
            //destroyData();
            goToWelcomeActivity();
        } else {
            loadTaskCount++;
        }
    }

    private void initialData() {
        DataManager.buildDeviceSpecific(this);
        CameraManager.initialData(this);
        Camera2Manager.initialData(this);
        FeatureManager.initialData(this);
        ScreenManager.initialData(this);
        SensorListManager.initialData(this);
        GLSurfaceView glSurfaceView = (GLSurfaceView) findViewById(R.id.gl_surface_view);
        HardwareManager.initialData(this, glSurfaceView, new HardwareManager.OnGLSurfaceViewLoadedListener() {
            @Override
            public void onLoaded() {
                onDataLoaded();
            }
        });
        onDataLoaded();
    }

    private void destroyData() {
        CameraManager.destroy();
        Camera2Manager.destroy();
        FeatureManager.destroy();
        HardwareManager.destroy();
        ScreenManager.destroy();
        SensorListManager.destroy();
    }

    private void goToWelcomeActivity() {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
        finish();
    }
}
