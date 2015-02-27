package app.akeorcist.deviceinformation.fragment.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.akeorcist.deviceinformation.R;
import app.akeorcist.deviceinformation.adapter.SensorCardAdapter;

public class SensorFragment extends Fragment {

	public static SensorFragment newInstance() {
		SensorFragment fragment = new SensorFragment();
		return fragment;
	}

	public SensorFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sensor, container, false);

        RecyclerView.Adapter adapter = new SensorCardAdapter(getActivity());
        RecyclerView rvSensorCard = (RecyclerView) rootView.findViewById(R.id.rv_sensor_card);
        rvSensorCard.setAdapter(adapter);
        rvSensorCard.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));

        return rootView;
    }
}
