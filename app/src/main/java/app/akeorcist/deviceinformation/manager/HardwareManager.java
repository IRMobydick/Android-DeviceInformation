package app.akeorcist.deviceinformation.manager;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLES11;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import app.akeorcist.deviceinformation.manager.hardware.AndroidManager;
import app.akeorcist.deviceinformation.manager.hardware.BuildManager;
import app.akeorcist.deviceinformation.manager.hardware.CommunicationManager;
import app.akeorcist.deviceinformation.manager.hardware.CpuManager;
import app.akeorcist.deviceinformation.manager.hardware.GpuManager;
import app.akeorcist.deviceinformation.manager.hardware.MemoryManager;
import app.akeorcist.deviceinformation.manager.hardware.StorageManager;
import app.akeorcist.deviceinformation.model.Data;

/**
 * Created by Akexorcist on 2/26/15 AD.
 */
public class HardwareManager {
    private static final int DATA_COUNT = 7;

    private static ArrayList<Data> androidDataList = new ArrayList<>();
    private static ArrayList<Data> buildDataList = new ArrayList<>();
    private static ArrayList<Data> communicationDataList = new ArrayList<>();
    private static ArrayList<Data> gpuDataList = new ArrayList<>();
    private static ArrayList<Data> memoryDataList = new ArrayList<>();
    private static ArrayList<Data> storageDataList = new ArrayList<>();
    private static ArrayList<Data> cpuDataList = new ArrayList<>();
    private static String cpuRawData;


    public static void initialData(Activity activity, GLSurfaceView glSurfaceView) {
        initialAndroidData();
        initialBuildData();
        initialCommunicationData(activity);
        initialCpuData();
        initialGpuData(glSurfaceView, activity);
        initialMemoryData();
        initialStorageData();
    }

    public static int getHardwareDataCount() {
        return DATA_COUNT;
    }

    private static void initialAndroidData() {
        androidDataList.add(new Data("System Type", AndroidManager.getSystemType()));
        androidDataList.add(new Data("Android Version", Build.VERSION.RELEASE));
        androidDataList.add(new Data("Version Code", AndroidManager.getVersionCode()));
        androidDataList.add(new Data("API Version", Build.VERSION.SDK_INT + ""));
        androidDataList.add(new Data("Incremental", Build.VERSION.INCREMENTAL));
        androidDataList.add(new Data("Codename", Build.VERSION.CODENAME));
    }

    @SuppressWarnings("deprecation")
    private static void initialBuildData() {
        buildDataList.add(new Data("Board", Build.BOARD));
        buildDataList.add(new Data("Bootloader", Build.BOOTLOADER));
        buildDataList.add(new Data("Brand", Build.BRAND));
        buildDataList.add(new Data("Characteristic", InfoManager.HardwareInfo.getChar()));
        buildDataList.add(new Data("CPU ABI", Build.CPU_ABI));
        buildDataList.add(new Data("CPU ABI 2", Build.CPU_ABI2));
        buildDataList.add(new Data("Device", Build.DEVICE));
        buildDataList.add(new Data("Display", Build.DISPLAY));
        buildDataList.add(new Data("Fingerprint", Build.FINGERPRINT));
        buildDataList.add(new Data("Hardware", Build.HARDWARE));
        buildDataList.add(new Data("Host", Build.HOST));
        buildDataList.add(new Data("ID", Build.ID));
        buildDataList.add(new Data("Manufacturer", Build.MANUFACTURER));
        buildDataList.add(new Data("Model", Build.MODEL));
        buildDataList.add(new Data("Product", Build.PRODUCT));
        buildDataList.add(new Data("Radio", BuildManager.getRadio()));
        buildDataList.add(new Data("Serial", BuildManager.getSerial()));
        buildDataList.add(new Data("Supported ABIS", BuildManager.getSupportABIS()));
        buildDataList.add(new Data("Supported 32-bit ABIS", BuildManager.getSupport32ABIS()));
        buildDataList.add(new Data("Supported 64-bit ABIS", BuildManager.getSupport64ABIS()));
        buildDataList.add(new Data("Tags", Build.TAGS));
        buildDataList.add(new Data("Time", Build.TIME + ""));
        buildDataList.add(new Data("Type", Build.TYPE));
        buildDataList.add(new Data("User", Build.USER));
    }

    private static void initialCpuData() {
        cpuRawData = CpuManager.getCpuInfo();
        if(!cpuRawData.equals("Unknown")) {
            String[] strCpuList = cpuRawData.trim().split("\n");
            for (int i = 0; i < strCpuList.length; i++) {
                if (!strCpuList[i].equals("")) {
                    try {
                        String[] strCpuRow = strCpuList[i].split(":");
                        String strTitle = strCpuRow[0].trim();
                        String strDetail = strCpuRow[1].trim();
                        cpuDataList.add(new Data(strTitle, strDetail));
                    } catch (IndexOutOfBoundsException e) { }
                }
            }
        }
    }

    private static void initialCommunicationData(Activity activity) {
        communicationDataList.add(new Data("Vibrate Motor", CommunicationManager.hasVibrate(activity)));
        communicationDataList.add(new Data("Microphone", CommunicationManager.hasMicrophone(activity)));
        communicationDataList.add(new Data("Telephony", CommunicationManager.hasTelephony(activity)));
        communicationDataList.add(new Data("Cellular", CommunicationManager.hasCellular(activity)));
        communicationDataList.add(new Data("GPS", CommunicationManager.hasGps(activity)));
        communicationDataList.add(new Data("Bluetooth", CommunicationManager.hasBluetooth(activity)));
        communicationDataList.add(new Data("Bluetooth LE", CommunicationManager.hasBluetoothLE(activity)));
        communicationDataList.add(new Data("WiFi", CommunicationManager.hasWiFi(activity)));
        communicationDataList.add(new Data("WiFi Direct", CommunicationManager.hasWiFiDirect(activity)));
        communicationDataList.add(new Data("Ethernet", CommunicationManager.hasEthernet(activity)));
        communicationDataList.add(new Data("WiMax", CommunicationManager.hasWiMax(activity)));
        communicationDataList.add(new Data("USB OTG", CommunicationManager.hasOTG(activity)));
        communicationDataList.add(new Data("USB Accessory", CommunicationManager.hasAOA(activity)));
        communicationDataList.add(new Data("NFC", CommunicationManager.hasNFC(activity)));
        communicationDataList.add(new Data("NFC HCE", CommunicationManager.hasNFCHost(activity)));
    }

    private static void initialGpuData(GLSurfaceView glSurfaceView, Activity activity) {
        glSurfaceView.setEGLContextClientVersion(2);
        glSurfaceView.setRenderer(new GpuManager.Renderer(new GpuManager.Renderer.SurfaceListener() {
            @Override
            public void onSurfaceCreated(GL10 gl, EGLConfig config) {
                gpuDataList.add(new Data("Renderer", gl.glGetString(GL10.GL_RENDERER)));
                gpuDataList.add(new Data("Vendor", gl.glGetString(GL10.GL_VENDOR)));
                gpuDataList.add(new Data("Version", gl.glGetString(GL10.GL_VERSION)));
                gpuDataList.add(new Data("Extensions", gl.glGetString(GL10.GL_EXTENSIONS).replace(" ", "\n")));
            }
        }));
        gpuDataList.add(new Data("OpenGL Supported", GpuManager.getOpenGLVersion(activity) + ""));
    }

    private static void initialMemoryData() {
        memoryDataList.add(new Data("Total Memory", MemoryManager.getMemory()));
        memoryDataList.add(new Data("Heap Size", MemoryManager.getHeapSize()));
        memoryDataList.add(new Data("Heap Start Size", MemoryManager.getHeapStartSize()));
        memoryDataList.add(new Data("Heap Growth Limit", MemoryManager.getHeapGrowthLimit()));
    }

    private static void initialStorageData() {
        storageDataList.add(new Data("Internal Storage", StorageManager.getTotalInternalStorage()));
        storageDataList.add(new Data("External Storage", StorageManager.getTotalExternalStorage()));
        storageDataList.add(new Data("SD Card Supported", StorageManager.isSDSupported()));
    }

    public static ArrayList<Data> getAndroidDataList() {
        return androidDataList;
    }

    public static ArrayList<Data> getBuildDataList() {
        return buildDataList;
    }

    public static ArrayList<Data> getCommunicationDataList() {
        return communicationDataList;
    }

    public static ArrayList<Data> getCpuDataList() {
        return cpuDataList;
    }

    public static ArrayList<Data> getGpuDataList() {
        return gpuDataList;
    }

    public static ArrayList<Data> getMemoryDataList() {
        return memoryDataList;
    }

    public static ArrayList<Data> getStorageDataList() {
        return storageDataList;
    }
}
