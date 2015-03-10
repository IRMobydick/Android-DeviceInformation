package app.akeorcist.deviceinformation.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import com.squareup.otto.Subscribe;

import app.akeorcist.deviceinformation.R;
import app.akeorcist.deviceinformation.utility.Preferences;
import app.akeorcist.deviceinformation.adapter.WelcomePagerAdapter;
import app.akeorcist.deviceinformation.event.WelcomeEvent;
import app.akeorcist.deviceinformation.provider.BusProvider;

public class WelcomeActivity extends ActionBarActivity {
    ViewPager pagerWelcome;
    WelcomePagerAdapter adapterWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(!Preferences.isFirstRun(this)) {
            handleButtonPress(new WelcomeEvent(WelcomeEvent.EVENT_SKIP));
        }

        setContentView(R.layout.activity_welcome);

        BusProvider.getInstance().register(this);

        adapterWelcome = new WelcomePagerAdapter(getSupportFragmentManager());
        pagerWelcome = (ViewPager) findViewById(R.id.pager_welcome);
        pagerWelcome.setAdapter(adapterWelcome);

    }

    @Subscribe
    public void handleButtonPress(WelcomeEvent event) {
        if(event.getEvent().equals(WelcomeEvent.EVENT_SKIP)) {
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else if(event.getEvent().equals(WelcomeEvent.EVENT_NEXT)) {
            pagerWelcome.setCurrentItem(pagerWelcome.getCurrentItem() + 1, true);
        }
    }
}
