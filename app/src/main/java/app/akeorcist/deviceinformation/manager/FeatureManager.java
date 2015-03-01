package app.akeorcist.deviceinformation.manager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.Log;

import java.util.ArrayList;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import app.akeorcist.deviceinformation.constants.Features;
import app.akeorcist.deviceinformation.manager.hardware.AndroidManager;
import app.akeorcist.deviceinformation.manager.hardware.BuildManager;
import app.akeorcist.deviceinformation.manager.hardware.CommunicationManager;
import app.akeorcist.deviceinformation.manager.hardware.CpuManager;
import app.akeorcist.deviceinformation.manager.hardware.GpuManager;
import app.akeorcist.deviceinformation.manager.hardware.MemoryManager;
import app.akeorcist.deviceinformation.manager.hardware.StorageManager;
import app.akeorcist.deviceinformation.model.FeatureData;
import app.akeorcist.deviceinformation.model.SingleData;
import app.akeorcist.deviceinformation.model.TwoColumnData;

/**
 * Created by Akexorcist on 2/26/15 AD.
 */
public class FeatureManager {
    private static ArrayList<FeatureData> supportFeatureDataList = new ArrayList<>();
    private static ArrayList<FeatureData> unsupportFeatureDataList = new ArrayList<>();

    public static void initialData(Activity activity) {
        supportFeatureDataList.clear();
        unsupportFeatureDataList.clear();
        getFeatureList(activity);
    }

    public static FeatureData getSupportFeature(int position) {
        return supportFeatureDataList.get(position);
    }

    public static int getSupportFeatureCount() {
        return supportFeatureDataList.size();
    }

    public static FeatureData getUnsupportFeature(int position) {
        return unsupportFeatureDataList.get(position);
    }

    public static int getUnsupportFeatureCount() {
        return unsupportFeatureDataList.size();
    }

    private static ArrayList<FeatureData> getSupportFeature(Activity activity) {
        return getFeatureList(activity);
    }

    private static ArrayList<FeatureData> getUnsupportFeature(Activity activity) {
        return getFeatureList(activity);
    }

    @SuppressWarnings("deprecation")
    @SuppressLint("InlinedApi")
    private static ArrayList<FeatureData> getFeatureList(Activity activity) {
        ArrayList<FeatureData> featureList = new ArrayList<>();
        for(FeatureData feature : Features.getFeatureList()) {
            if(hasFeature(activity, feature.getPackage(), feature.getMinSdk()).equals("Yes"))
                supportFeatureDataList.add(feature);
            else
                unsupportFeatureDataList.add(feature);
        }
        return featureList;
    }

    private static String isFeatureSupported(Activity activity, String feature) {
        if(activity.getPackageManager().hasSystemFeature(feature))
            return "Yes";
        else
            return "No";
    }

    private static String hasFeature(Activity activity, String feature, int minVersion) {
        int version = Build.VERSION.SDK_INT;
        if (version >= minVersion)
            return isFeatureSupported(activity, feature);
        else
            return "No";
    }
}

