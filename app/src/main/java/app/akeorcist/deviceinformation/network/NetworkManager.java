package app.akeorcist.deviceinformation.network;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import app.akeorcist.deviceinformation.manager.Camera2Manager;
import app.akeorcist.deviceinformation.manager.CameraManager;
import app.akeorcist.deviceinformation.manager.FeatureManager;
import app.akeorcist.deviceinformation.manager.HardwareManager;
import app.akeorcist.deviceinformation.manager.ScreenManager;
import app.akeorcist.deviceinformation.manager.SensorListManager;
import app.akeorcist.deviceinformation.model.Camera2Data;
import app.akeorcist.deviceinformation.model.CameraData;
import app.akeorcist.deviceinformation.model.FeatureData;
import app.akeorcist.deviceinformation.model.ScreenData;
import app.akeorcist.deviceinformation.model.SensorData;
import app.akeorcist.deviceinformation.model.TwoColumnData;

/**
 * Created by Ake on 3/2/2015.
 */
public class NetworkManager {

    public static void sentData(final OnParseSavedListener listener) {
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
            JSONObject sensorObject = new JSONObject();
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
            sensorObject.put("Sensor Info", sensorArray);


            // Screen Info
            ScreenData screenData = ScreenManager.getScreenData();
            JSONObject screenObject = new JSONObject();
            screenObject.put("Resolution (PX)", screenData.getResolutionPx());
            screenObject.put("Resolution (DP)", screenData.getResolutionDp());
            screenObject.put("DPI (X)", screenData.getDpiX());
            screenObject.put("DPI (Y)", screenData.getDpiY());
            screenObject.put("DPI", screenData.getDpi());
            screenObject.put("Size", screenData.getSize());
            screenObject.put("Density", screenData.getDensity());
            screenObject.put("Multitouch", screenData.getMultitouch());



            // Camera Info
            JSONObject cameraObject = new JSONObject();
            JSONArray cameraArray = new JSONArray();
            int cameraCount = CameraManager.getCameraCount();
            for(int i = 0 ; i < cameraCount ; i++) {
                CameraData cameraData = CameraManager.getCameraData(i);
                JSONObject cameraDataObject = new JSONObject();
                cameraDataObject.put("Camera ID", cameraData.getCameraId());
                cameraDataObject.put("Antibanding", cameraData.getAntibanding());
                cameraDataObject.put("Camera Facing", cameraData.getFacing());
                cameraDataObject.put("Color Effect", cameraData.getColorEffect());
                cameraDataObject.put("Can Disable Shutter Sound", cameraData.getShutterSound());
                cameraDataObject.put("Flash Mode", cameraData.getFlashMode());
                cameraDataObject.put("Focus Mode", cameraData.getFocusMode());
                cameraDataObject.put("JPEG Thumbnail Size (PX)", cameraData.getJpegThumbnailSize());
                cameraDataObject.put("Image Orientation", cameraData.getImageOrientation());
                cameraDataObject.put("Picture Format", cameraData.getPictureFormat());
                cameraDataObject.put("Preview Format", cameraData.getPreviewFormat());
                cameraDataObject.put("Picture Size (PX)", cameraData.getPictureSize());
                cameraDataObject.put("Preview Framerate (FPS)", cameraData.getPreviewFramerate());
                cameraDataObject.put("Preview Size (PX)", cameraData.getPreviewSize());
                cameraDataObject.put("Preview FPS Range", cameraData.getPreviewFpsRange());
                cameraDataObject.put("Scene Mode", cameraData.getSceneMode());
                cameraDataObject.put("Video Quality Profile (PX)", cameraData.getVideoQualityProfile());
                cameraDataObject.put("Timelapse Quality Profile (PX)", cameraData.getTimelapseQualityProfile());
                cameraDataObject.put("High Speed Quality Profile (PX)", cameraData.getHighSpeedQualityProfile());
                cameraDataObject.put("Video Size", cameraData.getVideoSize());
                cameraDataObject.put("White Balance", cameraData.getWhiteBalance());
                cameraDataObject.put("Auto Exposure Lock Supported", cameraData.getAutoExposure());
                cameraDataObject.put("Auto White Balance Lock Supported", cameraData.getAutoExposure());
                cameraDataObject.put("Smooth Zoom Supported", cameraData.getSmoothZoom());
                cameraDataObject.put("Video Snapshot Supported", cameraData.getVideoSnapshot());
                cameraDataObject.put("Video Stabilization Supported", cameraData.getVideoStabilization());
                cameraDataObject.put("Zoom Supported", cameraData.getZoom());
                cameraArray.put(cameraDataObject);
            }
            cameraObject.put("Camera Info", cameraArray);


            // Camera Info
            JSONObject camera2Object = new JSONObject();
            JSONArray camera2Array = new JSONArray();
            int camera2Count = Camera2Manager.getCameraCount();
            for(int i = 0 ; i < camera2Count ; i++) {
                Camera2Data camera2Data = Camera2Manager.getCameraData(i);
                JSONObject camera2DataObject = new JSONObject();
                camera2DataObject.put("Camera ID", camera2Data.getCameraId());
                camera2DataObject.put("Active Array Size", camera2Data.getActiveArraySize());
                camera2DataObject.put("AE Compensation Range", camera2Data.getAECompensationRange());
                camera2DataObject.put("AE Compensation Step", camera2Data.getAECompensationStep());
                camera2DataObject.put("Available AE Antibanding Mode", camera2Data.getAvailableAEAntibandingMode());
                camera2DataObject.put("Available AE Mode", camera2Data.getAvailableAEMode());
                camera2DataObject.put("Available AF Mode", camera2Data.getAvailableAFMode());
                camera2DataObject.put("Available Available AE Target FPS Range", camera2Data.getAvailableAETargetFpsRange());
                camera2DataObject.put("Available Aperture", camera2Data.getAvailableAperture());
                camera2DataObject.put("Available AWB Mode", camera2Data.getAvailableAWBMode());
                camera2DataObject.put("Available Edge Mode", camera2Data.getAvailableEdgeMode());
                camera2DataObject.put("Available Effect", camera2Data.getAvailableEffect());
                camera2DataObject.put("Available Face Detect Mode", camera2Data.getAvailableFaceDetectMode());
                camera2DataObject.put("Available Filter Density", camera2Data.getAvailableFilterDensity());
                camera2DataObject.put("Available Flash", camera2Data.getAvailableFlash());
                camera2DataObject.put("Available Focal Length", camera2Data.getAvailableFocalLength());
                camera2DataObject.put("Available Hot Pixel Map Mode", camera2Data.getAvailableHotPixelMapMode());
                camera2DataObject.put("Available Hot Pixel Mode", camera2Data.getAvailableHotPixelMode());
                camera2DataObject.put("Available JPEG Thumbnail Size", camera2Data.getAvailableJpegThumbnailSize());
                camera2DataObject.put("Available Max Digital Zoom", camera2Data.getAvailableMaxDigitalZoom());
                camera2DataObject.put("Available Noise Reduction Mode", camera2Data.getAvailableNoiseReductionMode());
                camera2DataObject.put("Available Optical Stabilization", camera2Data.getAvailableOpticalStabilization());
                camera2DataObject.put("Available Request Capability", camera2Data.getAvailableRequestCapability());
                camera2DataObject.put("Available Scene Mode", camera2Data.getAvailableSceneMode());
                camera2DataObject.put("Available Test Pattern Mode", camera2Data.getAvailableTestPartternMode());
                camera2DataObject.put("Available Tone Map Mode", camera2Data.getAvailableToneMapMode());
                camera2DataObject.put("Available Video Stabilization Mode", camera2Data.getAvailableVideoStabilizationMode());
                camera2DataObject.put("Color Filter Arrangement", camera2Data.getColorFilterArrangement());
                camera2DataObject.put("Exposure Time Range", camera2Data.getExposureTimeRange());
                camera2DataObject.put("Focus Distance Calibration", camera2Data.getFocusDistanceCalibration());
                camera2DataObject.put("Hyper Focal Distance Supported", camera2Data.getHyperfocalDistance());
                camera2DataObject.put("Lens Facing", camera2Data.getLensFacing());
                camera2DataObject.put("Max Analog Sensitivity", camera2Data.getMaxAnalogSensitivity());
                camera2DataObject.put("Max Face Count", camera2Data.getMaxFaceCount());
                camera2DataObject.put("Max Frame Duration", camera2Data.getMaxFrameDutaion());
                camera2DataObject.put("Max Number Output Proc", camera2Data.getMaxNumOutputProc());
                camera2DataObject.put("Max Number Output Proc Stall", camera2Data.getMaxNumOutputProcStall());
                camera2DataObject.put("Max Number Output RAW", camera2Data.getMaxNumOutputRaw());
                camera2DataObject.put("Max Region AE", camera2Data.getMaxRegionAE());
                camera2DataObject.put("Max Region AF", camera2Data.getMaxRegionAF());
                camera2DataObject.put("Max Region AWB", camera2Data.getMaxRegionAWB());
                camera2DataObject.put("Minimum Focus Distance", camera2Data.getMinimumFocusDistance());
                camera2DataObject.put("Partial Result Count", camera2Data.getPartialResultCount());
                camera2DataObject.put("Physical Size", camera2Data.getPhysicalSize());
                camera2DataObject.put("Pipeline Max Depth", camera2Data.getPipelineMaxDepth());
                camera2DataObject.put("Pixel Array Size", camera2Data.getPixelArraySize());
                camera2DataObject.put("Reference Illuminant 1", camera2Data.getReferenceIlluminant1());
                camera2DataObject.put("Reference Illuminant 2", camera2Data.getReferenceIlluminant2());
                camera2DataObject.put("Scale Cropping Type", camera2Data.getScaleCroppingType());
                camera2DataObject.put("Sensitivity Range", camera2Data.getSensitivityRange());
                camera2DataObject.put("Sensor Orientation", camera2Data.getSensorOrientation());
                camera2DataObject.put("Color Correction Aberration Mode", camera2Data.getColorCorrectionAberrationMode());
                camera2DataObject.put("Support Hardware Level", camera2Data.getSupportHardwareLevel());
                camera2DataObject.put("High Speed Video FPS Range", camera2Data.getHighSpeedVideoFpsRange());
                camera2DataObject.put("High Speed Video Size", camera2Data.getHighSpeedVideoSize());
                camera2DataObject.put("Support Image Format", camera2Data.getSupportImageFormat());
                camera2DataObject.put("Support Output Size", camera2Data.getSupportOutputSize());
                camera2DataObject.put("Sync Max Latency", camera2Data.getSyncMaxLatency());
                camera2DataObject.put("Timestamp Source", camera2Data.getTimestampSource());
                camera2DataObject.put("Tone Map Max Curve Point", camera2Data.getToneMapMaxCurvePoint());
                camera2DataObject.put("White level", camera2Data.getWhiteLevel());
                camera2Array.put(camera2DataObject);
            }
            camera2Object.put("Camera 2 Info", camera2Array);


            // Feature Info - Support Feature
            int supportFeatureCount = FeatureManager.getSupportFeatureCount();
            JSONArray supportFeatureObject = new JSONArray();
            for(int i = 0 ; i < supportFeatureCount ; i++) {
                FeatureData data = FeatureManager.getSupportFeature(i);
                supportFeatureObject.put(data.getName());
            }

            // Feature Info - Unsupport Feature
            int unsupportFeatureCount = FeatureManager.getUnsupportFeatureCount();
            JSONArray unsupportFeatureObject = new JSONArray();
            for(int i = 0 ; i < unsupportFeatureCount ; i++) {
                FeatureData data = FeatureManager.getUnsupportFeature(i);
                unsupportFeatureObject.put(data.getName());
            }

            // Feature Info
            JSONObject featureObject = new JSONObject();
            featureObject.put("Support Feature", supportFeatureObject);
            featureObject.put("Unsupport Feature", unsupportFeatureObject);

            ParseObject parseObject = new ParseObject("DevDeviceInfo");
            parseObject.put("HWSWInfo", hwswObject.toString());
            parseObject.put("SensorInfo", sensorObject.toString());
            parseObject.put("ScreenInfo", screenObject.toString());
            parseObject.put("CameraInfo", cameraObject.toString());
            parseObject.put("Camera2Info", camera2Object.toString());
            parseObject.put("FeatureInfo", featureObject.toString());
            parseObject.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    listener.onDone(e);
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public interface OnParseSavedListener {
        public void onDone(ParseException e);
    }
}
