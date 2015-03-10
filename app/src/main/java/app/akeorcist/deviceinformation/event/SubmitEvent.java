package app.akeorcist.deviceinformation.event;

/**
 * Created by Ake on 2/25/2015.
 */
public class SubmitEvent {
    public static final String EVENT_CLEAR_SUBMIT = "clear_submit";
    public static final String EVENT_CONNECTION_UNAVAILABLE = "connection_unavailable";

    private String event = "";

    public SubmitEvent(String event) {
        this.event = event;
    }

    public String getEvent() {
        return event;
    }
}
