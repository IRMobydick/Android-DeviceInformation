package app.akeorcist.deviceinformation.fragment.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;

import app.akeorcist.deviceinformation.R;
import app.akeorcist.deviceinformation.adapter.CameraPagerAdapter;
import app.akeorcist.deviceinformation.data.device.Camera2Manager;

public class CameraFragment extends Fragment {

	public static CameraFragment newInstance() {
		CameraFragment fragment = new CameraFragment();
		return fragment;
	}

	public CameraFragment() { }

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_viewpager_form, container, false);

        int cameraCount = Camera2Manager.getCameraCount();
        if(cameraCount > 0) {
            String[] strTitle = new String[cameraCount];
            for (int i = 0; i < cameraCount; i++) {
                strTitle[i] = "Camera " + i;
            }
            CameraPagerAdapter adapter = new CameraPagerAdapter(getFragmentManager(), strTitle);
            ViewPager vpContent = (ViewPager) rootView.findViewById(R.id.vp_content);
            vpContent.setAdapter(adapter);
            PagerSlidingTabStrip pagerTab = (PagerSlidingTabStrip) rootView.findViewById(R.id.pager_tab);
            pagerTab.setViewPager(vpContent);
        } else {
            rootView = inflater.inflate(R.layout.fragment_blank, container, false);
        }
/*


        RecyclerView.Adapter adapter = new HardwearCardAdapter(getActivity());
        RecyclerView rvHardwareCard = (RecyclerView) rootView.findViewById(R.id.rv_hardware_card);
        rvHardwareCard.setAdapter(adapter);
        rvHardwareCard.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
*/
		return rootView;
	}
}
