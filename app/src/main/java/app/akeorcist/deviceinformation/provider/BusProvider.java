package app.akeorcist.deviceinformation.provider;

import com.squareup.otto.Bus;

/**
 * Created by Ake on 2/25/2015.
 */
public final class BusProvider {
    private static final Bus BUS_WELCOME = new Bus();
    private static final Bus BUS = new Bus();

    public static Bus getInstance() {
        return BUS;
    }
    public static Bus getWelcomeInstance() {
        return BUS_WELCOME;
    }

    private BusProvider() { }
}