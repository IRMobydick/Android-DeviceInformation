package app.akeorcist.deviceinformation.activity;

import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import java.util.ArrayList;

import app.akeorcist.deviceinformation.R;
import app.akeorcist.deviceinformation.manager.Camera2Manager;
import app.akeorcist.deviceinformation.manager.FeatureManager;
import app.akeorcist.deviceinformation.manager.HardwareManager;
import app.akeorcist.deviceinformation.manager.ScreenManager;
import app.akeorcist.deviceinformation.manager.SensorListManager;
import app.akeorcist.deviceinformation.model.TwoColumnData;

public class SplashscreenActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_slashscreen);

        GLSurfaceView glSurfaceView = (GLSurfaceView) findViewById(R.id.gl_surface_view);
        HardwareManager.initialData(this, glSurfaceView);
        SensorListManager.initialData(this);
        ScreenManager.initialData(this);
        FeatureManager.initialData(this);
        Camera2Manager.initialData(this);

        ArrayList<TwoColumnData> datas = HardwareManager.getAndroidDataList();
        ParseObject gameScore = new ParseObject("AndroidData");
        for(TwoColumnData data : datas) {
            gameScore.put(data.getTitle(), data.getDetail());
        }
        gameScore.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                Toast.makeText(SplashscreenActivity.this, "Data Saved", Toast.LENGTH_SHORT).show();
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1000);
    }
}
