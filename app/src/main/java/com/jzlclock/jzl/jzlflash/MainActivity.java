package com.jzlclock.jzl.jzlflash;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends WarningLight {

    public void onClick_ToFlashlight(View view) {
        hideAllUI();
        mUIFlashlight.setVisibility(View.VISIBLE);
        mLastUIType = UIType.UI_TYPE_FLASHLIGHT;
        mCurrentUIType = UIType.UI_TYPE_FLASHLIGHT;
    }

    public void onClick_ToWarmingLight(View view) {
        hideAllUI();
        mUIWarningLight.setVisibility(View.VISIBLE);
        mLastUIType = UIType.UI_TYPE_WARNINGLIGHT;
        mCurrentUIType = mLastUIType;
        new WarningLightThread().start();
    }


    public void onClick_Control(View view){
        hideAllUI();
        if(mCurrentUIType != UIType.UI_TYPE_MAIN){
            mUIMain.setVisibility(View.VISIBLE);
            mCurrentUIType = UIType.UI_TYPE_MAIN;
            mWarningLightFlicker = false;
        } else {
            switch (mLastUIType) {
                case UI_TYPE_FLASHLIGHT:
                    mUIFlashlight.setVisibility(View.VISIBLE);
                    mCurrentUIType = UIType.UI_TYPE_FLASHLIGHT;
                    break;
                case UI_TYPE_WARNINGLIGHT:
                    mUIWarningLight.setVisibility(View.VISIBLE);
                    mCurrentUIType = UIType.UI_TYPE_WARNINGLIGHT;
                    new WarningLightThread().start();
                    break;
                default:
                    break;
            }
        }
    }
}










