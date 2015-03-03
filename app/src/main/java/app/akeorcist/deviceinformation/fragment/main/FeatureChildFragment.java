package app.akeorcist.deviceinformation.fragment.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.akeorcist.deviceinformation.R;
import app.akeorcist.deviceinformation.utilities.StringUtils;
import app.akeorcist.deviceinformation.adapter.FeatureCardAdapter;

public class FeatureChildFragment extends Fragment {
    private static final String SUPPORT_TYPE = "support_type";

	public static FeatureChildFragment newInstance(String supportType) {
		FeatureChildFragment fragment = new FeatureChildFragment();
        Bundle bundle = new Bundle();
        bundle.putString(SUPPORT_TYPE, supportType);
        fragment.setArguments(bundle);
		return fragment;
	}

	public FeatureChildFragment() { }

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_viewpager_child_from, container, false);

        String supportType = StringUtils.wrapBlank(getArguments().getString(SUPPORT_TYPE));
        RecyclerView.Adapter adapter = new FeatureCardAdapter(getActivity(), supportType);
        RecyclerView rvFeatureCard = (RecyclerView) rootView.findViewById(R.id.rv_feature_card);
        rvFeatureCard.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        rvFeatureCard.setAdapter(adapter);

		return rootView;
	}
}
