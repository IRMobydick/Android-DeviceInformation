package app.akeorcist.deviceinformation.fragment.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

        FeaturePagerAdapter adapter = new FeaturePagerAdapter(getFragmentManager());
        ViewPager vp_content = (ViewPager) rootView.findViewById(R.id.vp_content);
        vp_content.setAdapter(adapter);
/*


        RecyclerView.Adapter adapter = new HardwearCardAdapter(getActivity());
        RecyclerView rvHardwareCard = (RecyclerView) rootView.findViewById(R.id.rv_hardware_card);
        rvHardwareCard.setAdapter(adapter);
        rvHardwareCard.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
*/
		return rootView;
	}
}
