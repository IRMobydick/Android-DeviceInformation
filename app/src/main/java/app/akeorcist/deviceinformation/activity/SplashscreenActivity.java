package app.akeorcist.deviceinformation.activity;

import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import com.parse.ParseException;

import app.akeorcist.deviceinformation.R;
import app.akeorcist.deviceinformation.manager.Camera2Manager;
import app.akeorcist.deviceinformation.manager.CameraManager;
import app.akeorcist.deviceinformation.manager.FeatureManager;
import app.akeorcist.deviceinformation.manager.HardwareManager;
import app.akeorcist.deviceinformation.manager.ScreenManager;
import app.akeorcist.deviceinformation.manager.SensorListManager;
import app.akeorcist.deviceinformation.network.NetworkManager;

public class SplashscreenActivity extends ActionBarActivity {
    int loadTaskCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
            actionBar.hide();

        setContentView(R.layout.activity_splashscreen);

        GLSurfaceView glSurfaceView = (GLSurfaceView) findViewById(R.id.gl_surface_view);
        HardwareManager.initialData(this, glSurfaceView, new HardwareManager.OnGLSurfaceViewLoadedListener() {
            @Override
            public void onLoaded() {
                onDataLoaded();
            }
        });

        SensorListManager.initialData(this);
        ScreenManager.initialData(this);
        FeatureManager.initialData(this);
        CameraManager.initialData(this);
        Camera2Manager.initialData(this);
        onDataLoaded();
    }

    public void onDataLoaded() {
        if(loadTaskCount == 1) {
            NetworkManager.sentData(new NetworkManager.OnParseSavedListener() {
                @Override
                public void onDone(ParseException e) {
                    if(e == null)
                        Toast.makeText(SplashscreenActivity.this, "ส่งข้อมูลเสร็จ!", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(SplashscreenActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        } else {
            loadTaskCount++;
        }
    }
}
