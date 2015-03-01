package app.akeorcist.deviceinformation.manager;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;

import java.util.List;

import app.akeorcist.deviceinformation.Utilities.StringUtils;

/**
 * Created by Ake on 3/1/2015.
 */
public class CameraManager {

    public static void initialData(Activity activity) {
        //Log.e("Check", getSupportedJpegThumbnailSizes();
    }

    @SuppressWarnings("deprecation")
    private static String isAutoExposureLockSupported(Camera.Parameters params) {
        try {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                if(params.isAutoExposureLockSupported()) {
                    return "yes";
                } else {
                    return "no";
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "unknown";
    }

    @SuppressWarnings("deprecation")
    private static String isAutoWhiteBalanceLockSupported(Camera.Parameters params) {
        try {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                if(params.isAutoWhiteBalanceLockSupported()) {
                    return "yes";
                } else {
                    return "no";
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return "unknown";
    }
    @SuppressWarnings("deprecation")
    private static String isSmoothZoomSupported(Camera.Parameters params) {
        try {
            if(params.isSmoothZoomSupported()) {
                return "yes";
            } else {
                return "no";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "unknown";
    }

    @SuppressWarnings("deprecation")
    private static String isVideoSnapshotSupported(Camera.Parameters params) {
        try {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                if(params.isVideoSnapshotSupported()) {
                    return "yes";
                } else {
                    return "no";
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "unknown";
    }

    @SuppressWarnings("deprecation")
    private static String isVideoStabilizationSupported(Camera.Parameters params) {
        try {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
                if(params.isVideoStabilizationSupported()) {
                    return "yes";
                } else {
                    return "no";
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "unknown";
    }

    @SuppressWarnings("deprecation")
    private static String isZoomSupported(Camera.Parameters params) {
        try {
            if(params.isZoomSupported()) {
                return "yes";
            } else {
                return "no";
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "unknown";
    }

    @SuppressWarnings("deprecation")
    private static String getSupportedAntibanding(Camera.Parameters params) {
        List<String> values = params.getSupportedAntibanding();
        if(values != null) {
            String str = "";
            for(String value : values) {
                str += value + " ";
            }
            return StringUtils.wrapUnknownLower(str).trim();
        }
        return "unknown";
    }

    @SuppressWarnings("deprecation")
    private static String getSupportedColorEffects(Camera.Parameters params) {
        List<String> effects = params.getSupportedColorEffects();
        if(effects != null) {
            String str = "";
            for(String effect : effects) {
                str += effect + " ";
            }
            return StringUtils.wrapUnknownLower(str).trim();
        }
        return "unknown";
    }

    @SuppressWarnings("deprecation")
    private static String getSupportedFlashModes(Camera.Parameters params) {
        List<String> modes = params.getSupportedFlashModes();
        if(modes != null) {
            String str = "";
            for(String mode : modes) {
                str += mode + " ";
            }
            return StringUtils.wrapUnknownLower(str).trim();
        }
        return "unknown";
    }

    @SuppressWarnings("deprecation")
    private static String getSupportedFocusModes(Camera.Parameters params) {
        List<String> modes = params.getSupportedFocusModes();
        if(modes != null) {
            String str = "";
            for(String mode : modes) {
                str += mode + " ";
            }
            return StringUtils.wrapUnknownLower(str).trim();
        }
        return "unknown";
    }

    @SuppressWarnings("deprecation")
    private static String getSupportedJpegThumbnailSizes(Camera.Parameters params) {
        List<Camera.Size> sizes = params.getSupportedJpegThumbnailSizes();
        if(sizes != null) {
            String str = "";
            for(Camera.Size size : sizes) {
                str += size + " ";
            }
            return StringUtils.wrapUnknownLower(str).trim();
        }
        return "unknown";
/*
        String str = "";
        List<Camera.Size> jpegThumbnailSizes = params.getSupportedJpegThumbnailSizes();
        if(jpegThumbnailSizes != null) {
            for(int i = 0 ; i < jpegThumbnailSizes.size() ; i++)
                str += (i < jpegThumbnailSizes.size() - 1)
                        ? jpegThumbnailSizes.get(i).width + "x" + jpegThumbnailSizes.get(i).height + " "
                        : jpegThumbnailSizes.get(i).width + "x" + jpegThumbnailSizes.get(i).height;
            return str;
        } else {
            return "null";
        }*/
    }
}
