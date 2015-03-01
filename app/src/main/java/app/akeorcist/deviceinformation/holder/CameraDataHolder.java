package app.akeorcist.deviceinformation.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import app.akeorcist.deviceinformation.R;

/**
 * Created by Akexorcist on 2/27/15 AD.
 */
public class CameraDataHolder extends RecyclerView.ViewHolder {
    public TextView tvCameraId;
    public TextView tvAntibanding;
    public TextView tvShutterSound;
    public TextView tvColorEffect;
    public TextView tvFacing;
    public TextView tvFlashMode;
    public TextView tvFocusMode;
    public TextView tvJpegThumbnail;
    public TextView tvImageOrientation;
    public TextView tvPictureFormat;
    public TextView tvPreviewFormat;
    public TextView tvPreviewFramerate;
    public TextView tvPictureSize;
    public TextView tvPreviewSize;
    public TextView tvPreviewFpsRange;
    public TextView tvSceneMode;
    public TextView tvVideoQualityProfile;
    public TextView tvTimelapseQualityProfile;
    public TextView tvVideoSize;
    public TextView tvWhiteBalance;
    public TextView tvAutoExposure;
    public TextView tvAutoWhiteBalance;
    public TextView tvSmoothZoom;
    public TextView tvVideoSnapshot;
    public TextView tvVideoStabilization;
    public TextView tvZoomSupported;

    public CameraDataHolder(View view) {
        super(view);
        tvCameraId = (TextView) view.findViewById(R.id.tv_camera_id);
        tvAntibanding = (TextView) view.findViewById(R.id.tv_antibanding);
        tvShutterSound = (TextView) view.findViewById(R.id.tv_shutter_sound);
        tvColorEffect = (TextView) view.findViewById(R.id.tv_color_effect);
        tvFacing = (TextView) view.findViewById(R.id.tv_facing);
        tvFlashMode = (TextView) view.findViewById(R.id.tv_flash_mode);
        tvFocusMode = (TextView) view.findViewById(R.id.tv_focus_mode);
        tvJpegThumbnail = (TextView) view.findViewById(R.id.tv_jpeg_thumbnail);
        tvImageOrientation = (TextView) view.findViewById(R.id.tv_image_orientation);
        tvPictureFormat = (TextView) view.findViewById(R.id.tv_picture_format);
        tvPreviewFormat = (TextView) view.findViewById(R.id.tv_preview_format);
        tvPreviewFramerate = (TextView) view.findViewById(R.id.tv_preview_framerate);
        tvPictureSize = (TextView) view.findViewById(R.id.tv_picture_size);
        tvPreviewSize = (TextView) view.findViewById(R.id.tv_preview_size);
        tvPreviewFpsRange = (TextView) view.findViewById(R.id.tv_preview_fps_range);
        tvSceneMode = (TextView) view.findViewById(R.id.tv_scene_mode);
        tvVideoQualityProfile = (TextView) view.findViewById(R.id.tv_video_quality_profile);
        tvTimelapseQualityProfile = (TextView) view.findViewById(R.id.tv_timelapse_quality_profile);
        tvVideoSize = (TextView) view.findViewById(R.id.tv_video_size);
        tvWhiteBalance = (TextView) view.findViewById(R.id.tv_white_balance);
        tvAutoExposure = (TextView) view.findViewById(R.id.tv_auto_exposure);
        tvAutoWhiteBalance = (TextView) view.findViewById(R.id.tv_auto_white_balance);
        tvSmoothZoom = (TextView) view.findViewById(R.id.tv_smooth_zoom);
        tvVideoSnapshot = (TextView) view.findViewById(R.id.tv_video_snapshot);
        tvVideoStabilization = (TextView) view.findViewById(R.id.tv_video_stabilizatioin);
        tvZoomSupported = (TextView) view.findViewById(R.id.tv_zoom_supported);
    }
}
