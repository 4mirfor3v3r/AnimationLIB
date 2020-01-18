package com.amier.animationlibrary;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class AnimationLibrary {
    private Context mCtx;
    AnimationLibrary(Context context){
        mCtx = context;
    }
    public void BounceAnimation(View targetView, double amplitudo, double frequency){
        final Animation myAnim = AnimationUtils.loadAnimation(mCtx, R.anim.bounce);
        BounceInterpolator interpolator = new BounceInterpolator(amplitudo,frequency);
        myAnim.setInterpolator(interpolator);
        targetView.startAnimation(myAnim);
    }
}
