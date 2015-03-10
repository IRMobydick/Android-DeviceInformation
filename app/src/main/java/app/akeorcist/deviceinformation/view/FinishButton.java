package app.akeorcist.deviceinformation.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.CycleInterpolator;
import android.widget.ImageView;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;

import app.akeorcist.deviceinformation.R;

/**
 * Created by Akexorcist on 3/8/15 AD.
 */
public class FinishButton extends ImageView {
    private int srcResId = 0;
    private int bgResId = 0;

    public FinishButton(Context context) {
        super(context);
    }

    public FinishButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FinishButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setFinishImageResource(int srcResId) {
        this.srcResId = srcResId;
    }

    public void setFinishBackgroundResource(int bgResId) {
        this.bgResId = bgResId;
    }

    public void clear() {
        this.setBackgroundResource(R.drawable.shape_oval_light_gray);
        this.setImageResource(0);
    }

    public void finish() {
        pushAnimate();
    }

    private void pushAnimate() {
        AnimatorSet animSet = new AnimatorSet();
        ObjectAnimator animScaleX = ObjectAnimator.ofFloat(this, "scaleX", 1f, 0.7f);
        ObjectAnimator animScaleY = ObjectAnimator.ofFloat(this, "scaleY", 1f, 0.7f);
        animSet.playTogether(animScaleX, animScaleY);
        animSet.setDuration(300);
        animSet.setInterpolator(new CycleInterpolator(0.5f));
        animSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) { }

            @Override
            public void onAnimationEnd(Animator animation) {
                pullAnimate();
            }

            @Override
            public void onAnimationCancel(Animator animation) { }

            @Override
            public void onAnimationRepeat(Animator animation) { }
        });
        animSet.start();
    }

    private void pullAnimate() {
        this.setImageResource(srcResId);
        this.setBackgroundResource(bgResId);
        AnimatorSet animSet = new AnimatorSet();
        ObjectAnimator animScaleX = ObjectAnimator.ofFloat(this, "scaleX", 1f, 1.2f);
        ObjectAnimator animScaleY = ObjectAnimator.ofFloat(this, "scaleY", 1f, 1.2f);
        animSet.playTogether(animScaleX, animScaleY);
        animSet.setDuration(300);
        animSet.setInterpolator(new CycleInterpolator(0.5f));
        animSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) { }

            @Override
            public void onAnimationEnd(Animator animation) { }

            @Override
            public void onAnimationCancel(Animator animation) { }

            @Override
            public void onAnimationRepeat(Animator animation) { }
        });
        animSet.start();
    }

}
