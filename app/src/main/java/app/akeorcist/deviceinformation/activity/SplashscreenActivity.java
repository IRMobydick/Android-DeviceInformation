package app.akeorcist.deviceinformation.activity;

import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import app.akeorcist.deviceinformation.R;
import app.akeorcist.deviceinformation.manager.Camera2Manager;
import app.akeorcist.deviceinformation.manager.CameraManager;
import app.akeorcist.deviceinformation.manager.FeatureManager;
import app.akeorcist.deviceinformation.manager.HardwareManager;
import app.akeorcist.deviceinformation.manager.ScreenManager;
import app.akeorcist.deviceinformation.manager.SensorListManager;
import app.akeorcist.deviceinformation.model.SensorData;
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
        CameraManager.initialData(this);
        Camera2Manager.initialData(this);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                createJSON();
                //Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
                //startActivity(intent);
                //finish();
            }
        }, 2000);
/*
        ParseObject ahoy = new ParseObject("AhoyObject");
        ahoy.put("name", "Devahoy");
        ahoy.put("title", "Devahoy - Coding and Programming");
        ahoy.put("url", "http://devahoy.com");
        ahoy.put("value", 50000);
        ahoy.put("handsome", true);
        ahoy.saveInBackground();*/
    }

    public void createJSON() {
        try {
            // Hardware Info -- Android Info
            JSONObject androidObject = new JSONObject();
            ArrayList<TwoColumnData> androidData = HardwareManager.getAndroidDataList();
            for(TwoColumnData data : androidData) {
                androidObject.put(data.getTitle(), data.getDetail());
            }

            // Hardware Info -- Build Info
            JSONObject buildObject = new JSONObject();
            ArrayList<TwoColumnData> buildData = HardwareManager.getBuildDataList();
            for(TwoColumnData data : buildData) {
                buildObject.put(data.getTitle(), data.getDetail());
            }

            // Hardware Info -- Communication Info
            JSONObject commObject = new JSONObject();
            ArrayList<TwoColumnData> commData = HardwareManager.getCommunicationDataList();
            for(TwoColumnData data : commData) {
                commObject.put(data.getTitle(), data.getDetail());
            }

            // Hardware Info -- CPU Info
            JSONObject cpuObject = new JSONObject();
            ArrayList<TwoColumnData> cpuData = HardwareManager.getCpuDataList();
            for(TwoColumnData data : cpuData) {
                cpuObject.put(data.getTitle(), data.getDetail());
            }

            // Hardware Info -- GPU Info
            JSONObject gpuObject = new JSONObject();
            ArrayList<TwoColumnData> gpuData = HardwareManager.getGpuDataList();
            for(TwoColumnData data : gpuData) {
                gpuObject.put(data.getTitle(), data.getDetail());
            }

            // Hardware Info -- GPU Info
            JSONObject memoryObject = new JSONObject();
            ArrayList<TwoColumnData> memoryData = HardwareManager.getMemoryDataList();
            for(TwoColumnData data : memoryData) {
                memoryObject.put(data.getTitle(), data.getDetail());
            }

            // Hardware Info -- Storage Info
            JSONObject storageObject = new JSONObject();
            ArrayList<TwoColumnData> storageData = HardwareManager.getStorageDataList();
            for(TwoColumnData data : storageData) {
                storageObject.put(data.getTitle(), data.getDetail());
            }

            // Hardware Info
            JSONObject hwswObject = new JSONObject();
            hwswObject.put("Android Info", androidObject);
            hwswObject.put("Build Info", buildObject);
            hwswObject.put("Communication Info", commObject);
            hwswObject.put("CPU Info", cpuObject);
            hwswObject.put("GPU Info", gpuObject);
            hwswObject.put("Memory Info", memoryObject);
            hwswObject.put("Storage Info", storageObject);


            // Sensor Info
            JSONArray sensorObject = new JSONArray();
            JSONArray sensorArray = new JSONArray();
            int sensorCount = SensorListManager.getSensorDataCount();
            for(int i = 0 ; i < sensorCount ; i++) {
                SensorData sensorData = SensorListManager.getSensorData(i);
                JSONObject sensorDataObject = new JSONObject();
                sensorDataObject.put("Vendor", sensorData.getVendor());
                sensorDataObject.put("Type", sensorData.getType());
                sensorDataObject.put("Version", sensorData.getVersion());
                sensorDataObject.put("Power", sensorData.getPower());
                sensorDataObject.put("Max Range", sensorData.getMaxRange());
                sensorDataObject.put("Resolution", sensorData.getResolution());
                sensorDataObject.put("Min Delay", sensorData.getMinDelay());
                sensorDataObject.put("Max Delay", sensorData.getMaxDelay());
                sensorDataObject.put("FIFO Reserved", sensorData.getFifoReserved());
                sensorDataObject.put("FIFO Max", sensorData.getFifoMax());
                sensorArray.put(sensorDataObject);
            }
            sensorObject.put(sensorArray);



            JSONObject mainObject = new JSONObject();
            mainObject.put("HW/SW Info", hwswObject);
            mainObject.put("time", getTime());

            Log.e("Check", "JSON : " + sensorObject.toString());

            ParseObject parseObject = new ParseObject("DevDeviceInfo");
            parseObject.put("HWSWInfo", hwswObject.toString());
            parseObject.put("SensorInfo", sensorObject.toString());
            parseObject.put("ScreenInfo", "Screen");
            parseObject.put("CameraInfo", "Camera");
            parseObject.put("Camera2Info", "Camera2");
            parseObject.put("FeatureInfo", "Feature");
            parseObject.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    Toast.makeText(SplashscreenActivity.this, "Finish", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), WelcomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss yyyy.MM.dd");
        return sdf.format(new Date());
    }
}
