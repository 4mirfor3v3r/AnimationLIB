package com.amier.animationlibrary;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import androidx.recyclerview.widget.RecyclerView;

public class AnimationLibrary {
    private Context mCtx;
    AnimationLibrary(Context context){
        mCtx = context;
    }

    public static int FADE_UP = 1;
    public static int FADE_DOWN = 2;
    public static int LEFT_TO_RIGHT = 3;
    public static int RIGHT_TO_LEFT = 4;

    public void BounceAnimation(View targetView, double amplitudo, double frequency){
        final Animation myAnim = AnimationUtils.loadAnimation(mCtx, R.anim.bounce);
        BounceInterpolator interpolator = new BounceInterpolator(amplitudo,frequency);
        myAnim.setInterpolator(interpolator);
        targetView.startAnimation(myAnim);
    }

    public void RecyclerItemAnimation(RecyclerView recyclerView, int animation){
        switch (animation){
            case 1:{
                recyclerView.setLayoutAnimation(new LayoutAnimationController(AnimationUtils.loadAnimation(mCtx,R.anim.recycler_fade_up)));
                break;
            }
            case 2:{
                recyclerView.setLayoutAnimation(new LayoutAnimationController(AnimationUtils.loadAnimation(mCtx,R.anim.recycler_fade_down)));
                break;
            }
            case 3:{
                recyclerView.setLayoutAnimation(new LayoutAnimationController(AnimationUtils.loadAnimation(mCtx,R.anim.recycler_slide_right)));
                break;
            }
            case 4:{
                recyclerView.setLayoutAnimation(new LayoutAnimationController(AnimationUtils.loadAnimation(mCtx,R.anim.recycler_slide_left)));
            }
        }
    }
    public ActivityOptions IntentTransition(Activity activity, View startView, View targetView, String transitionName){
        targetView.setTransitionName(transitionName);
        startView.setTransitionName(transitionName);
        return ActivityOptions.makeSceneTransitionAnimation(activity,Pair.create(startView,transitionName));
    }

}
