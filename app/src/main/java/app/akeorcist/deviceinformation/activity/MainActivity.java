package app.akeorcist.deviceinformation.activity;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.widget.DrawerLayout;

import app.akeorcist.deviceinformation.fragment.NavigationDrawerFragment;
import app.akeorcist.deviceinformation.R;
import app.akeorcist.deviceinformation.fragment.AppListFragment;
import app.akeorcist.deviceinformation.fragment.main.Camera2Fragment;
import app.akeorcist.deviceinformation.fragment.main.CameraFragment;
import app.akeorcist.deviceinformation.fragment.main.FeatureFragment;
import app.akeorcist.deviceinformation.fragment.main.ScreenFragment;
import app.akeorcist.deviceinformation.fragment.main.SensorFragment;
import app.akeorcist.deviceinformation.fragment.main.HardwareFragment;
import app.akeorcist.deviceinformation.fragment.main.SubmitFragment;

public class MainActivity extends ActionBarActivity implements
        NavigationDrawerFragment.NavigationDrawerCallbacks {

	private final String PREFERENCE_NAME = "Preference";
	private final String KEYWORD_NAME = "isFirstRun131";
	
	private NavigationDrawerFragment mNavigationDrawerFragment;

	private CharSequence mTitle;
	
	private int current_position = 0;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ActionBar ab = getSupportActionBar();
        if(ab != null)
            ab.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.blue)));

		mNavigationDrawerFragment = (NavigationDrawerFragment)getSupportFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));

        Fragment fragment = SubmitFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
		onSectionAttached(0);
		//mNavigationDrawerFragment.showNavigationDrawer();
	}

	@SuppressLint("InlinedApi")
	public void onNavigationDrawerItemSelected(int position) {
		Fragment fragment = null;
		if(current_position != position) {
            if(position == 0) {
                fragment = SubmitFragment.newInstance();
            } else if(position == 1) {
                fragment = HardwareFragment.newInstance();
            } else if(position == 2) {
                fragment = SensorFragment.newInstance();
            } else if(position == 3) {
                fragment = ScreenFragment.newInstance();
            } else if(position == 4) {
                fragment = CameraFragment.newInstance();
            } else if(position == 5) {
                fragment = Camera2Fragment.newInstance();
            } else if(position == 6) {
                fragment = FeatureFragment.newInstance();
            } else if(position == 7) {
                fragment = AppListFragment.newInstance();
            }

            if(!getSupportActionBar().isShowing())
                getSupportActionBar().show();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
            current_position = position;
            onSectionAttached(position);
		}
	}

	public void onSectionAttached(int number) {
        switch (number) {
            case 0: mTitle = getString(R.string.menu_submit); break;
            case 1: mTitle = getString(R.string.menu_hardware); break;
            case 2: mTitle = getString(R.string.menu_sensor); break;
            case 3: mTitle = getString(R.string.menu_screen); break;
            case 4: mTitle = getString(R.string.menu_camera); break;
            case 5: mTitle = getString(R.string.menu_features); break;
            case 6: mTitle = getString(R.string.menu_applist); break;
            case 7: mTitle = getString(R.string.menu_camera2); break;
        }
	}

	public void restoreActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
		int color = getResources().getColor(R.color.action_bar_bg);
		ColorDrawable colorDrawable = new ColorDrawable(color);
		actionBar.setBackgroundDrawable(colorDrawable);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		return super.onOptionsItemSelected(item);
	}
	
	public void onBackPressed() {		
		if(mNavigationDrawerFragment.isVisible()) {
			mNavigationDrawerFragment.hideNavigationDrawer();   
		} else {
			super.onBackPressed();
		}
	}
}
