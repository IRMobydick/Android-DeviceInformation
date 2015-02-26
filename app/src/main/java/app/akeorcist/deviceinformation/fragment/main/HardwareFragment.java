package app.akeorcist.deviceinformation.fragment.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.akeorcist.deviceinformation.R;
import app.akeorcist.deviceinformation.adapter.HardwearCardAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HardwareFragment extends Fragment {

    public static Fragment newInstance() {
        return new HardwareFragment();
    }

    public HardwareFragment() { }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_hardware, container, false);

        RecyclerView.Adapter adapter = new HardwearCardAdapter(getActivity());
        RecyclerView rvHardwareCard = (RecyclerView) rootView.findViewById(R.id.rv_hardware_card);
        rvHardwareCard.setAdapter(adapter);
        rvHardwareCard.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        
        return rootView;
    }


}
