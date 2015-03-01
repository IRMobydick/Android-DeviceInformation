package app.akeorcist.deviceinformation.manager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import app.akeorcist.deviceinformation.Utilities.StringUtils;
import app.akeorcist.deviceinformation.model.CameraData;
import app.akeorcist.deviceinformation.model.TwoColumnData;

/**
 * Created by Ake on 3/1/2015.
 */
public class CameraManager {
    private static ArrayList<ArrayList<CameraData>> cameraDataList = new ArrayList<>();

    public static void initialData(Activity activity) {
        int cameraCount = 0;

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            cameraCount = Camera.getNumberOfCameras();
        } else {
            Camera cam = Camera.open();
            if(cam == null)
                cameraCount = 0;
            else
                cameraCount = 1;
        }

        for(int i = 0 ; i < cameraCount ; i++) {
            CameraData data = new CameraData();
            Camera.Parameters params;
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                Camera.CameraInfo ci = new Camera.CameraInfo();
                Camera.getCameraInfo(i, ci);
                Camera mCamera = Camera.open(i);
                params = mCamera.getParameters();
                mCamera.release();
                data.setShutterSound(canDisableShutterSound(ci));
                data.setImageOrientation(getImageOrientation(ci));
                data.setFacing(getCameraFacing(ci));

            } else {
                Camera mCamera = Camera.open();
                params = mCamera.getParameters();
                mCamera.release();
                data.setShutterSound("unknown");
                data.setImageOrientation("unknown");
                data.setFacing("unknown");
            }

            data.setCameraId(i + "");
            data.setAntibanding(getSupportedAntibanding(params));
        }

        //Log.e("Check", getSupportedJpegThumbnailSizes();
        //data.setCameraId(getCamer);
    }

    public static int getCameraCount() {
        return cameraDataList.size();
    }

    public static int getCameraDataCount(int position) {
        return cameraDataList.get(position).size();
    }

    public static ArrayList<CameraData> getCameraData(int position) {
        return cameraDataList.get(position);
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



    @SuppressWarnings("deprecation")
    @SuppressLint("NewApi")
    public static String getCameraFacing(Camera.CameraInfo ci) {
        int facing = ci.facing;
        if(facing == Camera.CameraInfo.CAMERA_FACING_BACK)
            return "back";
        else if(facing == Camera.CameraInfo.CAMERA_FACING_FRONT)
            return "front";
        return "unknown";
    }

    @SuppressWarnings("deprecation")
    @SuppressLint("NewApi")
    public static String getImageOrientation(Camera.CameraInfo ci) {
        return StringUtils.wrapUnknownLower(ci.orientation + "");
    }

    @SuppressWarnings("deprecation")
    @SuppressLint("NewApi")
    public static String canDisableShutterSound(Camera.CameraInfo ci) {
        return StringUtils.wrapUnknownLower(ci.canDisableShutterSound + "");
    }
}
