package app.akeorcist.deviceinformation.adapter;

/**
 * Created by Ake on 2/28/2015.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import app.akeorcist.deviceinformation.constants.Features;
import app.akeorcist.deviceinformation.fragment.main.FeatureChildFragment;

public class FeaturePagerAdapter extends FragmentStatePagerAdapter {
    private static final int PAGE_COUNT = 2;
    private String[] strTitle;

    public FeaturePagerAdapter(FragmentManager fm, String[] strTitle) {
        super(fm);
        this.strTitle = strTitle;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            return FeatureChildFragment.newInstance(Features.SUPPORTED_FEATURES);
        } else if(position == 1) {
            return FeatureChildFragment.newInstance(Features.UNSUPPORTED_FEATURES);
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strTitle[position];
    }
}