package app.akeorcist.deviceinformation.fragment.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.lang.reflect.Array;

import app.akeorcist.deviceinformation.R;
import app.akeorcist.deviceinformation.adapter.HardwareCardAdapter;

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

        HardwareCardAdapter hardwareCardAdapter = new HardwareCardAdapter(getActivity());
        ListView lvHardwareCard = (ListView) rootView.findViewById(R.id.lv_hardware_card);
        lvHardwareCard.setAdapter(hardwareCardAdapter);
        
        return rootView;
    }


}
