package app.akeorcist.deviceinformation.data.device.hardware;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;

import java.util.Locale;

/**
 * Created by Akexorcist on 2/27/15 AD.
 */
public class StorageManager {
    @SuppressLint("NewApi")
    public static String isSDSupported() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            if(Environment.isExternalStorageRemovable())
                return "yes";
            else
                return "no";
        } else {
            return "unknown";
        }
    }

    @SuppressWarnings("deprecation")
    public static String getTotalInternalStorage() {
        StatFs stat = new StatFs(Environment.getDataDirectory().getPath());
        long bytesAvailable = (long)stat.getBlockSize() *(long)stat.getBlockCount();
        float megAvailable = bytesAvailable / 1048576000f;
        return String.format(Locale.getDefault(), "%.3f GB", megAvailable);
    }

    @SuppressWarnings("deprecation")
    public static String getTotalExternalStorage() {
        StatFs stat = new StatFs(Environment.getDataDirectory().getPath());
        long bytesAvailable = (long)stat.getBlockSize() *(long)stat.getBlockCount();
        float megAvailable = bytesAvailable / 1048576000f;

        float internal = megAvailable;

        stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
        bytesAvailable = (long)stat.getBlockSize() *(long)stat.getBlockCount();
        megAvailable = bytesAvailable / 1048576000f;

        float external = megAvailable;
        if(internal != external && Math.abs(internal - external) != 0.1 && external != 0)
            return String.format(Locale.getDefault(), "%.3f GB", megAvailable);
        return "not available";
    }
}
