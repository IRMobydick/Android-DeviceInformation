package app.akeorcist.deviceinformation.manager;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Build;

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
import app.akeorcist.deviceinformation.model.TwoColumnData;

/**
 * Created by Akexorcist on 2/26/15 AD.
 */
public class HardwareManager {
    private static final int DATA_COUNT = 7;

    private static ArrayList<TwoColumnData> androidDataList = new ArrayList<>();
    private static ArrayList<TwoColumnData> buildDataList = new ArrayList<>();
    private static ArrayList<TwoColumnData> communicationDataList = new ArrayList<>();
    private static ArrayList<TwoColumnData> gpuDataList = new ArrayList<>();
    private static ArrayList<TwoColumnData> memoryDataList = new ArrayList<>();
    private static ArrayList<TwoColumnData> storageDataList = new ArrayList<>();
    private static ArrayList<TwoColumnData> cpuDataList = new ArrayList<>();
    private static String cpuRawData;

    public static void initialData(Activity activity, GLSurfaceView glSurfaceView) {
        androidDataList.clear();
        buildDataList.clear();
        communicationDataList.clear();
        gpuDataList.clear();
        memoryDataList.clear();
        storageDataList.clear();
        cpuDataList.clear();

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
        androidDataList.add(new TwoColumnData("System Type", AndroidManager.getSystemType()));
        androidDataList.add(new TwoColumnData("Android Version", Build.VERSION.RELEASE));
        androidDataList.add(new TwoColumnData("Version Code", AndroidManager.getVersionCode()));
        androidDataList.add(new TwoColumnData("API Version", Build.VERSION.SDK_INT + ""));
        androidDataList.add(new TwoColumnData("Incremental", Build.VERSION.INCREMENTAL));
        androidDataList.add(new TwoColumnData("Codename", Build.VERSION.CODENAME));
    }

    @SuppressWarnings("deprecation")
    private static void initialBuildData() {
        buildDataList.add(new TwoColumnData("Board", Build.BOARD));
        buildDataList.add(new TwoColumnData("Bootloader", Build.BOOTLOADER));
        buildDataList.add(new TwoColumnData("Brand", Build.BRAND));
        buildDataList.add(new TwoColumnData("Characteristic", InfoManager.HardwareInfo.getChar()));
        buildDataList.add(new TwoColumnData("CPU ABI", Build.CPU_ABI));
        buildDataList.add(new TwoColumnData("CPU ABI 2", Build.CPU_ABI2));
        buildDataList.add(new TwoColumnData("Device", Build.DEVICE));
        buildDataList.add(new TwoColumnData("Display", Build.DISPLAY));
        buildDataList.add(new TwoColumnData("Fingerprint", Build.FINGERPRINT));
        buildDataList.add(new TwoColumnData("Hardware", Build.HARDWARE));
        buildDataList.add(new TwoColumnData("Host", Build.HOST));
        buildDataList.add(new TwoColumnData("ID", Build.ID));
        buildDataList.add(new TwoColumnData("Manufacturer", Build.MANUFACTURER));
        buildDataList.add(new TwoColumnData("Model", Build.MODEL));
        buildDataList.add(new TwoColumnData("Product", Build.PRODUCT));
        buildDataList.add(new TwoColumnData("Radio", BuildManager.getRadio()));
        buildDataList.add(new TwoColumnData("Serial", BuildManager.getSerial()));
        buildDataList.add(new TwoColumnData("Supported ABIS", BuildManager.getSupportABIS()));
        buildDataList.add(new TwoColumnData("Supported 32-bit ABIS", BuildManager.getSupport32ABIS()));
        buildDataList.add(new TwoColumnData("Supported 64-bit ABIS", BuildManager.getSupport64ABIS()));
        buildDataList.add(new TwoColumnData("Tags", Build.TAGS));
        buildDataList.add(new TwoColumnData("Time", Build.TIME + ""));
        buildDataList.add(new TwoColumnData("Type", Build.TYPE));
        buildDataList.add(new TwoColumnData("User", Build.USER));
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
                        cpuDataList.add(new TwoColumnData(strTitle, strDetail));
                    } catch (IndexOutOfBoundsException e) { }
                }
            }
        }
    }

    private static void initialCommunicationData(Activity activity) {
        communicationDataList.add(new TwoColumnData("Vibrate Motor", CommunicationManager.hasVibrate(activity)));
        communicationDataList.add(new TwoColumnData("Microphone", CommunicationManager.hasMicrophone(activity)));
        communicationDataList.add(new TwoColumnData("Telephony", CommunicationManager.hasTelephony(activity)));
        communicationDataList.add(new TwoColumnData("Cellular", CommunicationManager.hasCellular(activity)));
        communicationDataList.add(new TwoColumnData("GPS", CommunicationManager.hasGps(activity)));
        communicationDataList.add(new TwoColumnData("Bluetooth", CommunicationManager.hasBluetooth(activity)));
        communicationDataList.add(new TwoColumnData("Bluetooth LE", CommunicationManager.hasBluetoothLE(activity)));
        communicationDataList.add(new TwoColumnData("WiFi", CommunicationManager.hasWiFi(activity)));
        communicationDataList.add(new TwoColumnData("WiFi Direct", CommunicationManager.hasWiFiDirect(activity)));
        communicationDataList.add(new TwoColumnData("Ethernet", CommunicationManager.hasEthernet(activity)));
        communicationDataList.add(new TwoColumnData("WiMax", CommunicationManager.hasWiMax(activity)));
        communicationDataList.add(new TwoColumnData("USB OTG", CommunicationManager.hasOTG(activity)));
        communicationDataList.add(new TwoColumnData("USB Accessory", CommunicationManager.hasAOA(activity)));
        communicationDataList.add(new TwoColumnData("NFC", CommunicationManager.hasNFC(activity)));
        communicationDataList.add(new TwoColumnData("NFC HCE", CommunicationManager.hasNFCHost(activity)));
    }

    private static void initialGpuData(GLSurfaceView glSurfaceView, Activity activity) {
        glSurfaceView.setEGLContextClientVersion(2);
        glSurfaceView.setRenderer(new GpuManager.Renderer(new GpuManager.Renderer.SurfaceListener() {
            @Override
            public void onSurfaceCreated(GL10 gl, EGLConfig config) {
                gpuDataList.add(new TwoColumnData("Renderer", gl.glGetString(GL10.GL_RENDERER)));
                gpuDataList.add(new TwoColumnData("Vendor", gl.glGetString(GL10.GL_VENDOR)));
                gpuDataList.add(new TwoColumnData("Version", gl.glGetString(GL10.GL_VERSION)));
                gpuDataList.add(new TwoColumnData("Extensions", gl.glGetString(GL10.GL_EXTENSIONS)));
            }
        }));
        gpuDataList.add(new TwoColumnData("OpenGL Supported", GpuManager.getOpenGLVersion(activity) + ""));
    }

    private static void initialMemoryData() {
        memoryDataList.add(new TwoColumnData("Total Memory", MemoryManager.getMemory()));
        memoryDataList.add(new TwoColumnData("Heap Size", MemoryManager.getHeapSize()));
        memoryDataList.add(new TwoColumnData("Heap Start Size", MemoryManager.getHeapStartSize()));
        memoryDataList.add(new TwoColumnData("Heap Growth Limit", MemoryManager.getHeapGrowthLimit()));
    }

    private static void initialStorageData() {
        storageDataList.add(new TwoColumnData("Internal Storage", StorageManager.getTotalInternalStorage()));
        storageDataList.add(new TwoColumnData("External Storage", StorageManager.getTotalExternalStorage()));
        storageDataList.add(new TwoColumnData("SD Card Supported", StorageManager.isSDSupported()));
    }

    public static ArrayList<TwoColumnData> getAndroidDataList() {
        return androidDataList;
    }

    public static ArrayList<TwoColumnData> getBuildDataList() {
        return buildDataList;
    }

    public static ArrayList<TwoColumnData> getCommunicationDataList() {
        return communicationDataList;
    }

    public static ArrayList<TwoColumnData> getCpuDataList() {
        return cpuDataList;
    }

    public static ArrayList<TwoColumnData> getGpuDataList() {
        return gpuDataList;
    }

    public static ArrayList<TwoColumnData> getMemoryDataList() {
        return memoryDataList;
    }

    public static ArrayList<TwoColumnData> getStorageDataList() {
        return storageDataList;
    }
}
