package com.amier.animationlibrary;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LayoutAnimationController;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AnimationLibrary {
    private Context mCtx;
    AnimationLibrary(Context context){
        mCtx = context;
    }

    public static int RecyclerItemAnimation_FADE_UP = 1;
    public static int RecyclerItemAnimation_FADE_DOWN = 2;
    public static int RecyclerItemAnimation_LEFT_TO_RIGHT = 3;
    public static int RecyclerItemAnimation_RIGHT_TO_LEFT = 4;

    public static int DelayedFadeAnimation_FADE_UP = 1;
    public static int DelayedFadeAnimation_FADE_DOWN = 2;
    public static int DelayedFadeAnimation_LEFT_TO_RIGHT = 3;
    public static int DelayedFadeAnimation_RIGHT_TO_LEFT = 4;

    public void BounceAnimation(@NotNull View targetView, double amplitudo, double frequency){
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
                break;
            }
        }
    }

    public Bundle IntentTransition(Activity activity, @NotNull View startView, @NotNull View targetView, String transitionName){
        targetView.setTransitionName(transitionName);
        startView.setTransitionName(transitionName);
        return ActivityOptions.makeSceneTransitionAnimation(activity,Pair.create(startView,transitionName)).toBundle();
    }

    public void DelayedFadeAnimation(View targetView, int animation, int startOffsetMillis, int animDuration){
        int anim;
        switch (animation){
            case 1: {anim = R.anim.delayed_fade_up; break;}
            case 2: {anim = R.anim.delayed_fade_down; break;}
            case 3: {anim = R.anim.delayed_slide_right; break;}
            case 4: {anim = R.anim.delayed_slide_left; break;}
            default: anim = R.anim.delayed_fade_up;
        }

        Animation animate = AnimationUtils.loadAnimation(mCtx, anim);
         animate.setDuration(animDuration);
         animate.setStartOffset(startOffsetMillis);

         targetView.startAnimation(animate);
    }
    public void DelayedFadeAnimation(View targetView, int animation, int startOffsetMillis, int animDuration, Interpolator interpolator){
        int anim;
        switch (animation){
            case 1: {anim = R.anim.delayed_fade_up; break;}
            case 2: {anim = R.anim.delayed_fade_down; break;}
            case 3: {anim = R.anim.delayed_slide_right; break;}
            case 4: {anim = R.anim.delayed_slide_left; break;}
            default: anim = R.anim.delayed_fade_up;
        }

        Animation animate = AnimationUtils.loadAnimation(mCtx, anim);
        animate.setDuration(animDuration);
        animate.setStartOffset(startOffsetMillis);
        animate.setInterpolator(interpolator);

        targetView.startAnimation(animate);
    }
}
