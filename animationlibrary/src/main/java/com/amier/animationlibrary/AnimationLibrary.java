package com.amier.animationlibrary;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
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

    public void AnimatedColorBG(View targetView, Color BL, Color TR, Color BR, Color TL){

        GradientDrawable gd1 = new GradientDrawable(
                GradientDrawable.Orientation.BL_TR,
                new int[] {Color.parseColor(BL.toString()),Color.parseColor(TR.toString())});
        GradientDrawable gd2 = new GradientDrawable(
                GradientDrawable.Orientation.BR_TL,
                new int[] {Color.parseColor(BR.toString()),Color.parseColor(TL.toString())});

        AnimationDrawable ad = new AnimationDrawable();
        ad.addFrame(gd1,2000);
        ad.addFrame(gd2,2000);
        ad.setOneShot(false);
        targetView.setBackground(ad);

        AnimationDrawable animationDrawable = (AnimationDrawable) targetView.getBackground();

        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();
    }
}
