package app.akeorcist.deviceinformation.fragment.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;

import app.akeorcist.deviceinformation.R;
import app.akeorcist.deviceinformation.adapter.Camera2PagerAdapter;
import app.akeorcist.deviceinformation.data.device.Camera2Manager;

public class Camera2Fragment extends Fragment {

	public static Camera2Fragment newInstance() {
		Camera2Fragment fragment = new Camera2Fragment();
		return fragment;
	}

	public Camera2Fragment() { }

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
        View rootView = null;

        if(Camera2Manager.getCameraCount() > 0) {
            rootView = inflater.inflate(R.layout.fragment_viewpager_form, container, false);
            int cameraCount = Camera2Manager.getCameraCount();
            String[] strTitle = new String[cameraCount];
            for(int i = 0 ; i < cameraCount ; i++) {
                strTitle[i] = "Camera " + i;
            }
            Camera2PagerAdapter adapter = new Camera2PagerAdapter(getFragmentManager(), strTitle);
            ViewPager vpContent = (ViewPager) rootView.findViewById(R.id.vp_content);
            vpContent.setAdapter(adapter);
            PagerSlidingTabStrip pagerTab = (PagerSlidingTabStrip) rootView.findViewById(R.id.pager_tab);
            pagerTab.setViewPager(vpContent);
        } else {
            rootView = inflater.inflate(R.layout.fragment_blank, container, false);
        }
		return rootView;
	}
}
