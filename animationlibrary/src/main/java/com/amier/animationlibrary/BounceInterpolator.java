package com.amier.animationlibrary;

import android.view.animation.Interpolator;

public class BounceInterpolator implements Interpolator {
    private double mAmplitudo;
    private double mFrequency;

    BounceInterpolator(double amplitudo, double frequency){
        mAmplitudo = amplitudo;
        mFrequency = frequency;
    }

    @Override
    public float getInterpolation(float time) {
        return (float) (-1* Math.pow(Math.E, -time/mAmplitudo) * Math.cos(mFrequency * time) + 1);
    }
}
