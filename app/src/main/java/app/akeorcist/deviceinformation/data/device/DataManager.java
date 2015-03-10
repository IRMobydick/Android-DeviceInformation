package app.akeorcist.deviceinformation.data.device;

import android.content.Context;
import android.os.Build;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import app.akeorcist.deviceinformation.model.Camera2Data;
import app.akeorcist.deviceinformation.model.CameraData;
import app.akeorcist.deviceinformation.model.FeatureData;
import app.akeorcist.deviceinformation.model.ScreenData;
import app.akeorcist.deviceinformation.model.SensorData;
import app.akeorcist.deviceinformation.model.SimpleData;
import app.akeorcist.deviceinformation.utility.Preferences;

/**
 * Created by Akexorcist on 3/6/15 AD.
 */
public class DataManager {
    public static void buildDeviceSpecific(Context context) {
        Preferences.setDeviceBrand(context, Build.BRAND);
        Preferences.setDeviceModel(context, Build.MODEL);
        Preferences.setDeviceVersion(context, Build.VERSION.RELEASE);
        Preferences.setDeviceFingerprint(context, Build.FINGERPRINT);
    }

    public static String createDataJson() {
        try {
            // Hardware Info -- Android Info
            JSONObject androidObject = new JSONObject();
            ArrayList<SimpleData> androidData = HardwareManager.getAndroidDataList();
            for(SimpleData data : androidData) {
                androidObject.put(data.getTitle(), data.getDetail());
            }

            // Hardware Info -- Build Info
            JSONObject buildObject = new JSONObject();
            ArrayList<SimpleData> buildData = HardwareManager.getBuildDataList();
            for(SimpleData data : buildData) {
                buildObject.put(data.getTitle(), data.getDetail());
            }

            // Hardware Info -- Communication Info
            JSONObject commObject = new JSONObject();
            ArrayList<SimpleData> commData = HardwareManager.getCommunicationDataList();
            for(SimpleData data : commData) {
                commObject.put(data.getTitle(), data.getDetail());
            }

            // Hardware Info -- CPU Info
            JSONObject cpuObject = new JSONObject();
            ArrayList<SimpleData> cpuData = HardwareManager.getCpuDataList();
            for(SimpleData data : cpuData) {
                cpuObject.put(data.getTitle(), data.getDetail());
            }

            // Hardware Info -- GPU Info
            JSONObject gpuObject = new JSONObject();
            ArrayList<SimpleData> gpuData = HardwareManager.getGpuDataList();
            for(SimpleData data : gpuData) {
                gpuObject.put(data.getTitle(), data.getDetail());
            }

            // Hardware Info -- GPU Info
            JSONObject memoryObject = new JSONObject();
            ArrayList<SimpleData> memoryData = HardwareManager.getMemoryDataList();
            for(SimpleData data : memoryData) {
                memoryObject.put(data.getTitle(), data.getDetail());
            }

            // Hardware Info -- Storage Info
            JSONObject storageObject = new JSONObject();
            ArrayList<SimpleData> storageData = HardwareManager.getStorageDataList();
            for(SimpleData data : storageData) {
                storageObject.put(data.getTitle(), data.getDetail());
            }

            // Hardware Info
            JSONObject hwswObject = new JSONObject();
            /*
            hwswObject.put("android_info", androidObject);
            hwswObject.put("build_info", buildObject);
            hwswObject.put("communication_info", commObject);
            hwswObject.put("cpu_info", cpuObject);
            hwswObject.put("gpu_info", gpuObject);
            hwswObject.put("memory_info", memoryObject);
            hwswObject.put("storage_info", storageObject);
            */
            hwswObject.put("Android Info", androidObject);
            hwswObject.put("Build Info", buildObject);
            hwswObject.put("Communication Info", commObject);
            hwswObject.put("CPU Info", cpuObject);
            hwswObject.put("GPU Info", gpuObject);
            hwswObject.put("Memory Info", memoryObject);
            hwswObject.put("Storage Info", storageObject);

            // Sensor Info
            JSONArray sensorArray = new JSONArray();
            int sensorCount = SensorListManager.getSensorDataCount();
            /*
            for(int i = 0 ; i < sensorCount ; i++) {
                SensorData sensorData = SensorListManager.getSensorData(i);
                JSONObject sensorDataObject = new JSONObject();
                sensorDataObject.put("name", sensorData.getName());
                sensorDataObject.put("vendor", sensorData.getVendor());
                sensorDataObject.put("type", sensorData.getType());
                sensorDataObject.put("version", sensorData.getVersion());
                sensorDataObject.put("power", sensorData.getPower());
                sensorDataObject.put("max_range", sensorData.getMaxRange());
                sensorDataObject.put("resolution", sensorData.getResolution());
                sensorDataObject.put("min_delay", sensorData.getMinDelay());
                sensorDataObject.put("max_delay", sensorData.getMaxDelay());
                sensorDataObject.put("fifo_reserved", sensorData.getFifoReserved());
                sensorDataObject.put("fifo_max", sensorData.getFifoMax());
                sensorArray.put(sensorDataObject);
            }*/
            for(int i = 0 ; i < sensorCount ; i++) {
                SensorData sensorData = SensorListManager.getSensorData(i);
                JSONObject sensorDataObject = new JSONObject();
                sensorDataObject.put("Name", sensorData.getName());
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


            // Screen Info
            ScreenData screenData = ScreenManager.getScreenData();
            JSONObject screenObject = new JSONObject();
            /*
            screenObject.put("resolution_px", screenData.getResolutionPx());
            screenObject.put("resolution_dp", screenData.getResolutionDp());
            screenObject.put("dpi_x", screenData.getDpiX());
            screenObject.put("dpi_y", screenData.getDpiY());
            screenObject.put("dpi", screenData.getDpi());
            screenObject.put("size", screenData.getSize());
            screenObject.put("density", screenData.getDensity());
            screenObject.put("multitouch", screenData.getMultitouch());
            */
            screenObject.put("Resolution (PX)", screenData.getResolutionPx());
            screenObject.put("Resolution (DP)", screenData.getResolutionDp());
            screenObject.put("DPI (X)", screenData.getDpiX());
            screenObject.put("DPI (Y)", screenData.getDpiY());
            screenObject.put("DPI", screenData.getDpi());
            screenObject.put("Size", screenData.getSize());
            screenObject.put("Density", screenData.getDensity());
            screenObject.put("Multitouch", screenData.getMultitouch());


            // Camera Info
            JSONArray cameraArray = new JSONArray();
            int cameraCount = CameraManager.getCameraCount();
            /*
            for(int i = 0 ; i < cameraCount ; i++) {
                CameraData cameraData = CameraManager.getCameraData(i);
                JSONObject cameraDataObject = new JSONObject();
                cameraDataObject.put("camera_id", cameraData.getCameraId());
                cameraDataObject.put("antibanding", cameraData.getAntibanding());
                cameraDataObject.put("camera_facing", cameraData.getFacing());
                cameraDataObject.put("color_effect", cameraData.getColorEffect());
                cameraDataObject.put("can_disable_shutter_sound", cameraData.getShutterSound());
                cameraDataObject.put("flash_mode", cameraData.getFlashMode());
                cameraDataObject.put("focus_mode", cameraData.getFocusMode());
                cameraDataObject.put("jpeg_thumbnail_size_px", cameraData.getJpegThumbnailSize());
                cameraDataObject.put("image_orientation", cameraData.getImageOrientation());
                cameraDataObject.put("picture_format", cameraData.getPictureFormat());
                cameraDataObject.put("preview_format", cameraData.getPreviewFormat());
                cameraDataObject.put("picture_size_px", cameraData.getPictureSize());
                cameraDataObject.put("preview_framerate_fps", cameraData.getPreviewFramerate());
                cameraDataObject.put("preview_size_px", cameraData.getPreviewSize());
                cameraDataObject.put("preview_fps_range", cameraData.getPreviewFpsRange());
                cameraDataObject.put("scene_mode", cameraData.getSceneMode());
                cameraDataObject.put("video_quality_profile_px", cameraData.getVideoQualityProfile());
                cameraDataObject.put("timelapse_quality_profile_px", cameraData.getTimelapseQualityProfile());
                cameraDataObject.put("high_speed_quality_profile_px", cameraData.getHighSpeedQualityProfile());
                cameraDataObject.put("video_size", cameraData.getVideoSize());
                cameraDataObject.put("white_balance", cameraData.getWhiteBalance());
                cameraDataObject.put("auto_exposure_lock_supported", cameraData.getAutoExposure());
                cameraDataObject.put("auto_white_balance_lock_supported", cameraData.getAutoExposure());
                cameraDataObject.put("smooth_zoom_supported", cameraData.getSmoothZoom());
                cameraDataObject.put("video_snapshot_supported", cameraData.getVideoSnapshot());
                cameraDataObject.put("video_stabilization_supported", cameraData.getVideoStabilization());
                cameraDataObject.put("zoom_supported", cameraData.getZoom());
                cameraArray.put(cameraDataObject);
            }*/
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


            // Camera Info
            JSONArray camera2Array = new JSONArray();
            int camera2Count = Camera2Manager.getCameraCount();
            /*for(int i = 0 ; i < camera2Count ; i++) {
                Camera2Data camera2Data = Camera2Manager.getCameraData(i);
                JSONObject camera2DataObject = new JSONObject();
                camera2DataObject.put("camera_id", camera2Data.getCameraId());
                camera2DataObject.put("active_array_size", camera2Data.getActiveArraySize());
                camera2DataObject.put("ae_compensation_range", camera2Data.getAECompensationRange());
                camera2DataObject.put("ae_compensation_step", camera2Data.getAECompensationStep());
                camera2DataObject.put("available_ae_antibanding_mode", camera2Data.getAvailableAEAntibandingMode());
                camera2DataObject.put("available_ae_mode", camera2Data.getAvailableAEMode());
                camera2DataObject.put("available_af_mode", camera2Data.getAvailableAFMode());
                camera2DataObject.put("available_ae_target_fps_range", camera2Data.getAvailableAETargetFpsRange());
                camera2DataObject.put("available_aperture", camera2Data.getAvailableAperture());
                camera2DataObject.put("available_awb_mode", camera2Data.getAvailableAWBMode());
                camera2DataObject.put("available_edge_mode", camera2Data.getAvailableEdgeMode());
                camera2DataObject.put("available_effect", camera2Data.getAvailableEffect());
                camera2DataObject.put("available_face_detect_mode", camera2Data.getAvailableFaceDetectMode());
                camera2DataObject.put("available_filter_density", camera2Data.getAvailableFilterDensity());
                camera2DataObject.put("available_flash", camera2Data.getAvailableFlash());
                camera2DataObject.put("available_focal_length", camera2Data.getAvailableFocalLength());
                camera2DataObject.put("available_hot_pixel_map_mode", camera2Data.getAvailableHotPixelMapMode());
                camera2DataObject.put("available_hot_pixel_mode", camera2Data.getAvailableHotPixelMode());
                camera2DataObject.put("available_jpeg_thumbnail_size", camera2Data.getAvailableJpegThumbnailSize());
                camera2DataObject.put("available_max_digital_zoom", camera2Data.getAvailableMaxDigitalZoom());
                camera2DataObject.put("available_noise_reduction_mode", camera2Data.getAvailableNoiseReductionMode());
                camera2DataObject.put("available_optical_stabilization", camera2Data.getAvailableOpticalStabilization());
                camera2DataObject.put("available_request_capability", camera2Data.getAvailableRequestCapability());
                camera2DataObject.put("available_scene_mode", camera2Data.getAvailableSceneMode());
                camera2DataObject.put("available_test_pattern_mode", camera2Data.getAvailableTestPartternMode());
                camera2DataObject.put("available_tone_map_mode", camera2Data.getAvailableToneMapMode());
                camera2DataObject.put("available_video_stabilization_mode", camera2Data.getAvailableVideoStabilizationMode());
                camera2DataObject.put("color_filter_arrangement", camera2Data.getColorFilterArrangement());
                camera2DataObject.put("exposure_time_range", camera2Data.getExposureTimeRange());
                camera2DataObject.put("focus_distance_calibration", camera2Data.getFocusDistanceCalibration());
                camera2DataObject.put("hyper_focal_distance_supported", camera2Data.getHyperfocalDistance());
                camera2DataObject.put("lens_facing", camera2Data.getLensFacing());
                camera2DataObject.put("max_analog_sensitivity", camera2Data.getMaxAnalogSensitivity());
                camera2DataObject.put("max_face_count", camera2Data.getMaxFaceCount());
                camera2DataObject.put("max_frame_duration", camera2Data.getMaxFrameDutaion());
                camera2DataObject.put("max_number_output_proc", camera2Data.getMaxNumOutputProc());
                camera2DataObject.put("max_number_output_proc_stall", camera2Data.getMaxNumOutputProcStall());
                camera2DataObject.put("max_number_output_raw", camera2Data.getMaxNumOutputRaw());
                camera2DataObject.put("max_region_ae", camera2Data.getMaxRegionAE());
                camera2DataObject.put("max_region_af", camera2Data.getMaxRegionAF());
                camera2DataObject.put("max_region_awb", camera2Data.getMaxRegionAWB());
                camera2DataObject.put("minimum_focus_distance", camera2Data.getMinimumFocusDistance());
                camera2DataObject.put("partial_result_count", camera2Data.getPartialResultCount());
                camera2DataObject.put("physical_size", camera2Data.getPhysicalSize());
                camera2DataObject.put("pipeline_max_depth", camera2Data.getPipelineMaxDepth());
                camera2DataObject.put("pixel_array_size", camera2Data.getPixelArraySize());
                camera2DataObject.put("reference_illuminant_1", camera2Data.getReferenceIlluminant1());
                camera2DataObject.put("reference_illuminant_2", camera2Data.getReferenceIlluminant2());
                camera2DataObject.put("scale_cropping_type", camera2Data.getScaleCroppingType());
                camera2DataObject.put("sensitivity_range", camera2Data.getSensitivityRange());
                camera2DataObject.put("sensor_orientation", camera2Data.getSensorOrientation());
                camera2DataObject.put("color_correction_aberration_mode", camera2Data.getColorCorrectionAberrationMode());
                camera2DataObject.put("support_hardware_level", camera2Data.getSupportHardwareLevel());
                camera2DataObject.put("high_speed_video_fps_range", camera2Data.getHighSpeedVideoFpsRange());
                camera2DataObject.put("high_speed_video_size", camera2Data.getHighSpeedVideoSize());
                camera2DataObject.put("support_image_format", camera2Data.getSupportImageFormat());
                camera2DataObject.put("support_output_size", camera2Data.getSupportOutputSize());
                camera2DataObject.put("sync_max_latency", camera2Data.getSyncMaxLatency());
                camera2DataObject.put("timestamp_source", camera2Data.getTimestampSource());
                camera2DataObject.put("tone_map_max_curve_point", camera2Data.getToneMapMaxCurvePoint());
                camera2DataObject.put("white_level", camera2Data.getWhiteLevel());
                camera2Array.put(camera2DataObject);
            }*/
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


            // Feature Info - Supported Feature
            int supportFeatureCount = FeatureManager.getSupportFeatureCount();
            JSONArray supportFeatureObject = new JSONArray();
            for(int i = 0 ; i < supportFeatureCount ; i++) {
                FeatureData data = FeatureManager.getSupportFeature(i);
                supportFeatureObject.put(data.getName());
            }

            // Feature Info - Unsupported Feature
            int unsupportFeatureCount = FeatureManager.getUnsupportFeatureCount();
            JSONArray unsupportFeatureObject = new JSONArray();
            for(int i = 0 ; i < unsupportFeatureCount ; i++) {
                FeatureData data = FeatureManager.getUnsupportFeature(i);
                unsupportFeatureObject.put(data.getName());
            }

            // Feature Info
            JSONObject featureObject = new JSONObject();
            featureObject.put("Supported", supportFeatureObject);
            featureObject.put("Unsupported", unsupportFeatureObject);

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Hardware Info", hwswObject);
            jsonObject.put("Sensor Info", sensorArray);
            jsonObject.put("Screen Info", screenObject);
            jsonObject.put("Camera Info", cameraArray);
            jsonObject.put("Camera 2 Info", camera2Array);
            jsonObject.put("Feature Info", featureObject);

            return jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
