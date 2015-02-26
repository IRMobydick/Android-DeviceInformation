package app.akeorcist.deviceinformation.fragment.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.dd.CircularProgressButton;
import com.nineoldandroids.animation.ValueAnimator;

import app.akeorcist.deviceinformation.R;
import app.akeorcist.deviceinformation.Utilities.AnimateUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubmitFragment extends Fragment implements View.OnClickListener {
    CircularProgressButton btnSubmitInfo;

    public static SubmitFragment newInstance() {
        SubmitFragment fragment = new SubmitFragment();
        return fragment;
    }

    public SubmitFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_submit, container, false);
        btnSubmitInfo = (CircularProgressButton) rootView.findViewById(R.id.btn_submit_info);
        btnSubmitInfo.setOnTouchListener(AnimateUtils.touchAnimateListener);
        btnSubmitInfo.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.btn_submit_info) {
            simulateSuccessProgress(btnSubmitInfo);
        }
    }

    private void simulateSuccessProgress(final CircularProgressButton button) {
        ValueAnimator widthAnimation = ValueAnimator.ofInt(1, 100);
        widthAnimation.setDuration(1500);
        widthAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        widthAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Integer value = (Integer) animation.getAnimatedValue();
                button.setProgress(value);
            }
        });
        widthAnimation.start();
    }
}
