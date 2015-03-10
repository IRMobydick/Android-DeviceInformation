package app.akeorcist.deviceinformation.fragment.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;

import com.dd.CircularProgressButton;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.otto.Subscribe;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import app.akeorcist.deviceinformation.R;
import app.akeorcist.deviceinformation.utility.AnimateUtils;
import app.akeorcist.deviceinformation.utility.Preferences;
import app.akeorcist.deviceinformation.event.SubmitEvent;
import app.akeorcist.deviceinformation.data.device.DataManager;
import app.akeorcist.deviceinformation.network.NetworkManager;
import app.akeorcist.deviceinformation.provider.BusProvider;
import app.akeorcist.deviceinformation.view.FinishButton;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubmitFragment extends Fragment implements View.OnClickListener {
    private CircularProgressButton btnSubmitInfo;
    private LinearLayout layoutValidated;
    private LinearLayout layoutSubmitStatus;
    private LinearLayout layoutExisting;
    private LinearLayout layoutConnectionUnavailable;
    private FinishButton btnFinish;
    private FinishButton btnConnectionAvailable;
    private FinishButton btnCollectDeviceInfo;
    private FinishButton btnSendDeviceInfo;

    private boolean isSubmitting = false;

    public static SubmitFragment newInstance() {
        SubmitFragment fragment = new SubmitFragment();
        return fragment;
    }

    public SubmitFragment() { }

    @Override
    public void onDestroy() {
        super.onDestroy();
        BusProvider.getNetworkInstance().unregister(this);
        Log.e("Check", "onDestroy");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        BusProvider.getNetworkInstance().register(this);

        BusProvider.getNetworkInstance().post(new SubmitEvent(SubmitEvent.EVENT_CLEAR_SUBMIT));

        View rootView = inflater.inflate(R.layout.fragment_submit, container, false);

        layoutValidated = (LinearLayout) rootView.findViewById(R.id.layout_validated);
        layoutSubmitStatus = (LinearLayout) rootView.findViewById(R.id.layout_submit_status);
        layoutExisting = (LinearLayout) rootView.findViewById(R.id.layout_existing);
        layoutConnectionUnavailable = (LinearLayout) rootView.findViewById(R.id.layout_connection_unavailable);

        if(Preferences.isValidated(getActivity())) {
            AnimateUtils.fadeInAnimate(layoutValidated);
            btnSubmitInfo = (CircularProgressButton) rootView.findViewById(R.id.btn_submit_info);
            simulateSuccessProgress(300);
        } else {
            AnimateUtils.fadeInAnimate(layoutSubmitStatus);

            btnSubmitInfo = (CircularProgressButton) rootView.findViewById(R.id.btn_submit_info);
            btnSubmitInfo.setOnTouchListener(AnimateUtils.touchAnimateListener);
            btnSubmitInfo.setOnClickListener(this);

            btnConnectionAvailable = (FinishButton) rootView.findViewById(R.id.iv_connection_available);
            btnConnectionAvailable.setFinishImageResource(R.drawable.ic_finish);
            btnConnectionAvailable.setFinishBackgroundResource(R.drawable.shape_oval_green);

            btnCollectDeviceInfo = (FinishButton) rootView.findViewById(R.id.iv_collect_device_info);
            btnCollectDeviceInfo.setFinishImageResource(R.drawable.ic_finish);
            btnCollectDeviceInfo.setFinishBackgroundResource(R.drawable.shape_oval_green);

            btnSendDeviceInfo = (FinishButton) rootView.findViewById(R.id.iv_send_device_info);
            btnSendDeviceInfo.setFinishImageResource(R.drawable.ic_finish);
            btnSendDeviceInfo.setFinishBackgroundResource(R.drawable.shape_oval_green);

            btnFinish = (FinishButton) rootView.findViewById(R.id.iv_finish);
            btnFinish.setFinishImageResource(R.drawable.ic_finish);
            btnFinish.setFinishBackgroundResource(R.drawable.shape_oval_green);
        }
        return rootView;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.btn_submit_info) {
            if(!isSubmitting && btnSubmitInfo.getProgress() != -1) {
                isSubmitting = true;
                simulateSuccessProgress(2);
                checkConnectionAvailable();
            } else if(!isSubmitting && btnSubmitInfo.getProgress() == -1) {
                isSubmitting = true;
                btnSubmitInfo.setProgress(0);
                simulateSuccessProgress(2);
                checkConnectionAvailable();
                animateProgressLayout();
            }
        }
    }

    private void simulateSuccessProgress(final int value) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ValueAnimator widthAnimation = ValueAnimator.ofInt(1, value);
                widthAnimation.setDuration(100);
                widthAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                widthAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        Integer value = (Integer) animation.getAnimatedValue();
                        btnSubmitInfo.setProgress(value);
                    }
                });
                widthAnimation.start();
            }
        });
    }

    private void checkConnectionAvailable() {
        NetworkManager.checkDeviceExist(getActivity(), new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Log.e("Check", "Connection Available Failed");
                //clearSubmitState();
                //connectionUnavailable();
                BusProvider.getNetworkInstance().post(new SubmitEvent(SubmitEvent.EVENT_CONNECTION_UNAVAILABLE));
            }

            @Override
            public void onResponse(Response response) throws IOException {
                try {
                    JSONObject jsonObject = new JSONObject(response.body().string());
                    boolean isExist = jsonObject.getBoolean("exist");
                    if (isExist) {
                        Log.e("Check", "Exist");
                        animateExistLayout();
                        Preferences.setValidated(getActivity());
                    } else {
                        Log.e("Check", "Not Exist");
                        collectDeviceInfo();
                        simulateSuccessProgress(25);
                        simulateFinishButton(btnConnectionAvailable);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void collectDeviceInfo() {
        simulateFinishButton(btnCollectDeviceInfo);
        simulateSuccessProgress(50);
        sendDeviceInfo();
    }

    private void sendDeviceInfo() {
        simulateSuccessProgress(75);
        NetworkManager.sendDeviceInfo(getActivity(), new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Log.e("Check", "Send Device Info Failed");
            }

            @Override
            public void onResponse(Response response) throws IOException {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        sendFinish();
                        simulateFinishButton(btnSendDeviceInfo);
                    }
                });
                Log.e("Check", response.body().string());
            }
        });
    }

    private void sendFinish() {
        simulateFinishButton(btnFinish);
        simulateSuccessProgress(100);
        Preferences.setValidated(getActivity());
    }

    private void simulateFinishButton(final FinishButton finishButton) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                finishButton.finish();
            }
        });
    }

    private void clearSubmitState() {
        isSubmitting = false;
        btnSubmitInfo.setProgress(0);
        btnFinish.clear();
        btnConnectionAvailable.clear();
        btnCollectDeviceInfo.clear();
        btnSendDeviceInfo.clear();
    }

    @Subscribe
    public void connectionUnavailable(SubmitEvent event) {
        if(event.getEvent().equals(SubmitEvent.EVENT_CONNECTION_UNAVAILABLE)) {
            Log.e("Check", "Event : " + event.getEvent());
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    btnSubmitInfo.setProgress(-1);
                    isSubmitting = false;
                    animateErrorLayout();
                }
            });
        }
    }

    private void animateErrorLayout() {
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(layoutConnectionUnavailable, "alpha", 1f);
        animator1.setDuration(300);
        animator1.start();
        layoutConnectionUnavailable.setVisibility(View.VISIBLE);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(layoutSubmitStatus, "alpha", 0f);
        animator2.setDuration(300);
        animator2.start();
    }

    private void animateExistLayout() {
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(layoutExisting, "alpha", 1f);
        animator1.setDuration(300);
        animator1.start();
        layoutExisting.setVisibility(View.VISIBLE);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(layoutSubmitStatus, "alpha", 0f);
        animator2.setDuration(300);
        animator2.start();
    }

    private void animateProgressLayout() {
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(layoutSubmitStatus, "alpha", 1f);
        animator1.setDuration(300);
        animator1.start();
        layoutSubmitStatus.setVisibility(View.VISIBLE);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(layoutConnectionUnavailable, "alpha", 0f);
        animator2.setDuration(300);
        animator2.start();
    }


    @Subscribe
    public void test(SubmitEvent event) {
    }

}
