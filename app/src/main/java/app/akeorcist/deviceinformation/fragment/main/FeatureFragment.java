package app.akeorcist.deviceinformation.fragment.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;

import app.akeorcist.deviceinformation.R;
import app.akeorcist.deviceinformation.adapter.FeaturePagerAdapter;

public class FeatureFragment extends Fragment {

	public static FeatureFragment newInstance() {
		FeatureFragment fragment = new FeatureFragment();
		return fragment;
	}

	public FeatureFragment() { }

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_viewpager_form, container, false);

        String[] strTitle = { "Support", "Unsupport" };
        FeaturePagerAdapter adapter = new FeaturePagerAdapter(getFragmentManager(), strTitle);
        ViewPager vpContent = (ViewPager) rootView.findViewById(R.id.vp_content);
        vpContent.setAdapter(adapter);
        PagerSlidingTabStrip pagerTab = (PagerSlidingTabStrip) rootView.findViewById(R.id.pager_tab);
        pagerTab.setViewPager(vpContent);
/*


        RecyclerView.Adapter adapter = new HardwearCardAdapter(getActivity());
        RecyclerView rvHardwareCard = (RecyclerView) rootView.findViewById(R.id.rv_hardware_card);
        rvHardwareCard.setAdapter(adapter);
        rvHardwareCard.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
*/
		return rootView;
	}
}
