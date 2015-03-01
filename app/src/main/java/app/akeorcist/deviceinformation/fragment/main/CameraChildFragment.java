package app.akeorcist.deviceinformation.fragment.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.akeorcist.deviceinformation.R;
import app.akeorcist.deviceinformation.Utilities.StringUtils;
import app.akeorcist.deviceinformation.adapter.FeatureCardAdapter;

public class CameraChildFragment extends Fragment {
	public static CameraChildFragment newInstance(String supportType) {
		CameraChildFragment fragment = new CameraChildFragment();
		return fragment;
	}

	public CameraChildFragment() { }

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_viewpager_child_from, container, false);

        RecyclerView.Adapter adapter = new FeatureCardAdapter(getActivity(), supportType);
        RecyclerView rvFeatureCard = (RecyclerView) rootView.findViewById(R.id.rv_feature_card);
        rvFeatureCard.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        rvFeatureCard.setAdapter(adapter);

		return rootView;
	}
}
