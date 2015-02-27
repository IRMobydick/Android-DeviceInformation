package app.akeorcist.deviceinformation.fragment.main;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import app.akeorcist.deviceinformation.R;
import app.akeorcist.deviceinformation.Utilities.AnimateUtils;
import app.akeorcist.deviceinformation.activity.ScreenMeasureActivity;
import app.akeorcist.deviceinformation.fragment.ScreenSub1Fragment;
import app.akeorcist.deviceinformation.fragment.ScreenSub2Fragment;
import app.akeorcist.deviceinformation.manager.ScreenManager;
import app.akeorcist.deviceinformation.model.ScreenData;

public class ScreenFragment extends Fragment {
	private CardView cvScreenMeasure;

	public static ScreenFragment newInstance() {
		ScreenFragment fragment = new ScreenFragment();
		return fragment;
	}

	public ScreenFragment() { }

	@SuppressLint("NewApi")
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_screen, container, false);
        TextView tvResolutionPx = (TextView) rootView.findViewById(R.id.tv_resolution_px);
        TextView tvResolutionDp = (TextView) rootView.findViewById(R.id.tv_resolution_dp);
        TextView tvDpiX = (TextView) rootView.findViewById(R.id.tv_dpi_x);
        TextView tvDpiY = (TextView) rootView.findViewById(R.id.tv_dpi_y);
        TextView tvDpi = (TextView) rootView.findViewById(R.id.tv_dpi);
        TextView tvSize = (TextView) rootView.findViewById(R.id.tv_size);
        TextView tvDensity = (TextView) rootView.findViewById(R.id.tv_density);
        TextView tvMultitouch = (TextView) rootView.findViewById(R.id.tv_multitouch);
        cvScreenMeasure = (CardView) rootView.findViewById(R.id.cv_screen_measure);
        cvScreenMeasure.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if(action == MotionEvent.ACTION_DOWN) {
                    cvScreenMeasure.setCardBackgroundColor(getResources().getColor(R.color.red_pressed));
                    AnimateUtils.scaleAnimate(cvScreenMeasure, 0.9f);
                } else if(action == MotionEvent.ACTION_UP ||
                        action == MotionEvent.ACTION_CANCEL ||
                        action == MotionEvent.ACTION_OUTSIDE) {
                    cvScreenMeasure.setCardBackgroundColor(getResources().getColor(R.color.red));
                    AnimateUtils.scaleAnimate(cvScreenMeasure, 1f);
                }
                return false;
            }
        });
        cvScreenMeasure.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ScreenMeasureActivity.class);
                startActivity(intent);
            }
        });

        ScreenData screenData = ScreenManager.getScreenData();
        tvResolutionPx.setText(screenData.getResolutionPx());
        tvResolutionDp.setText(screenData.getResolutionDp());
        tvDpiX.setText(screenData.getDpiX());
        tvDpiY.setText(screenData.getDpiY());
        tvDpi.setText(screenData.getDpi());
        tvSize.setText(screenData.getSize());
        tvDensity.setText(screenData.getDensity());
        tvMultitouch.setText(screenData.getMultitouch());

		return rootView;
	}
}
