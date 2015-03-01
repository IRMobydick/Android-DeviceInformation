package app.akeorcist.deviceinformation.fragment.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import app.akeorcist.deviceinformation.R;
import app.akeorcist.deviceinformation.manager.CameraManager;
import app.akeorcist.deviceinformation.model.CameraData;

public class Camera2ChildFragment extends Fragment {
    private static final String CAMERA_ID = "camera_id";

	public static Camera2ChildFragment newInstance(int cameraId) {
		Camera2ChildFragment fragment = new Camera2ChildFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(CAMERA_ID, cameraId);
        fragment.setArguments(bundle);
		return fragment;
	}

	public Camera2ChildFragment() { }

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.view_row_camera_card, container, false);

        int cameraId = getArguments().getInt(CAMERA_ID);


        TextView tvCameraId = (TextView) rootView.findViewById(R.id.tv_camera_id);
        TextView tvAntibanding = (TextView) rootView.findViewById(R.id.tv_active_array_size);
        TextView tvShutterSound = (TextView) rootView.findViewById(R.id.tv_ae_compensation_range);
        TextView tvColorEffect = (TextView) rootView.findViewById(R.id.tv_ae_compensation_step);
        TextView tvFacing = (TextView) rootView.findViewById(R.id.tv_available_ae_antibanding_mode);
        TextView tvFlashMode = (TextView) rootView.findViewById(R.id.tv_available_ae_mode);
        TextView tvFocusMode = (TextView) rootView.findViewById(R.id.tv_available_af_mode);
        TextView tvJpegThumbnail = (TextView) rootView.findViewById(R.id.tv_available_ae_target_fps_range);
        TextView tvImageOrientation = (TextView) rootView.findViewById(R.id.tv_available_aperture);
        TextView tvPictureFormat = (TextView) rootView.findViewById(R.id.tv_available_awb_mode);
        TextView tvPreviewFormat = (TextView) rootView.findViewById(R.id.tv_available_edge_mode);
        TextView tvPreviewFramerate = (TextView) rootView.findViewById(R.id.tv_available_effect);
        TextView tvPictureSize = (TextView) rootView.findViewById(R.id.tv_available_face_detect_mode);
        TextView tvPreviewSize = (TextView) rootView.findViewById(R.id.tv_available_filter_density);
        TextView tvPreviewFpsRange = (TextView) rootView.findViewById(R.id.tv_available_flash);
        TextView tvSceneMode = (TextView) rootView.findViewById(R.id.tv_available_focal_length);
        TextView tvVideoQualityProfile = (TextView) rootView.findViewById(R.id.tv_available_hot_pixel_map_mode);
        TextView tvTimelapseQualityProfile = (TextView) rootView.findViewById(R.id.tv_available_hot_pixel_mode);
        TextView tvHighSpeedQualityProfile = (TextView) rootView.findViewById(R.id.tv_available_jpeg_thumbnail_size);
        TextView tvVideoSize = (TextView) rootView.findViewById(R.id.tv_available_max_digital_zoom);
        TextView tvWhiteBalance = (TextView) rootView.findViewById(R.id.tv_available_noise_reduction_mode);
        TextView tvAutoExposure = (TextView) rootView.findViewById(R.id.tv_available_optical_stabilization);
        TextView tvAutoWhiteBalance = (TextView) rootView.findViewById(R.id.tv_available_request_capability);
        TextView tvSmoothZoom = (TextView) rootView.findViewById(R.id.tv_available_scene_mode);
        TextView tvVideoSnapshot = (TextView) rootView.findViewById(R.id.tv_available_test_pattern_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvZoomSupported = (TextView) rootView.findViewById(R.id.tv_available_video_stabilization_mode);




        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);
        TextView tvVideoStabilization = (TextView) rootView.findViewById(R.id.tv_available_tone_map_mode);

        CameraData data = CameraManager.getCameraData(cameraId);
        tvAntibanding.setText(data.getAntibanding());
        tvAutoExposure.setText(data.getAutoExposure());
        tvAutoWhiteBalance.setText(data.getAutoWhiteBalance());
        tvCameraId.setText(data.getCameraId());
        tvColorEffect.setText(data.getColorEffect());
        tvFacing.setText(data.getFacing());
        tvFlashMode.setText(data.getFlashMode());
        tvFocusMode.setText(data.getFocusMode());
        tvHighSpeedQualityProfile.setText(data.getHighSpeedQualityProfile());
        tvImageOrientation.setText(data.getImageOrientation());
        tvJpegThumbnail.setText(data.getJpegThumbnailSize());
        tvPictureFormat.setText(data.getPictureFormat());
        tvPreviewFormat.setText(data.getPreviewFormat());
        tvPictureSize.setText(data.getPictureSize());
        tvPreviewSize.setText(data.getPreviewSize());
        tvPreviewFpsRange.setText(data.getPreviewFpsRange());
        tvPreviewFramerate.setText(data.getPreviewFramerate());
        tvSceneMode.setText(data.getSceneMode());
        tvShutterSound.setText(data.getShutterSound());
        tvSmoothZoom.setText(data.getSmoothZoom());
        tvTimelapseQualityProfile.setText(data.getTimelapseQualityProfile());
        tvVideoQualityProfile.setText(data.getVideoQualityProfile());
        tvVideoSize.setText(data.getVideoSize());
        tvVideoSnapshot.setText(data.getVideoSnapshot());
        tvVideoStabilization.setText(data.getVideoStabilization());
        tvWhiteBalance.setText(data.getWhiteBalance());
        tvZoomSupported.setText(data.getZoom());
        
		return rootView;
	}
}
