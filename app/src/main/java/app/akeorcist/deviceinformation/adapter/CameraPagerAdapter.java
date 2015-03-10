package app.akeorcist.deviceinformation.adapter;

/**
 * Created by Ake on 2/28/2015.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import app.akeorcist.deviceinformation.fragment.main.CameraChildFragment;
import app.akeorcist.deviceinformation.data.device.CameraManager;

public class CameraPagerAdapter extends FragmentStatePagerAdapter {
    private static int PAGE_COUNT = 0;
    private String[] strTitle;

    public CameraPagerAdapter(FragmentManager fm, String[] strTitle) {
        super(fm);
        this.strTitle = strTitle;
        PAGE_COUNT = CameraManager.getCameraCount();
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        return CameraChildFragment.newInstance(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strTitle[position];
    }
}