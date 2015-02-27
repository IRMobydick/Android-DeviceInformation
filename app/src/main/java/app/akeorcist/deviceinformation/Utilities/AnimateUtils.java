package app.akeorcist.deviceinformation.Utilities;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.OvershootInterpolator;

import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;

import app.akeorcist.deviceinformation.R;

/**
 * Created by Akexorcist on 2/26/15 AD.
 */
public class AnimateUtils {

    public static View.OnTouchListener touchAnimateListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int action = event.getAction();
            if(action == MotionEvent.ACTION_DOWN) {
                AnimateUtils.scaleAnimate(v, 0.7f);
            } else if(action == MotionEvent.ACTION_UP ||
                    action == MotionEvent.ACTION_CANCEL ||
                    action == MotionEvent.ACTION_OUTSIDE) {
                AnimateUtils.scaleAnimate(v, 1f);
            }
            return false;
        }
    };

    public static void scaleAnimate(View v, float scale) {
        ObjectAnimator animatorScaleX = ObjectAnimator.ofFloat(v, "scaleX", scale);
        animatorScaleX.setInterpolator(new OvershootInterpolator());
        ObjectAnimator animatorScaleY = ObjectAnimator.ofFloat(v, "scaleY", scale);
        animatorScaleY.setInterpolator(new OvershootInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500);
        animatorSet.playTogether(animatorScaleX, animatorScaleY);
        animatorSet.start();
    }
}
