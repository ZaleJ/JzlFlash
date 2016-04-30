package com.jzlclock.jzl.jzlflash;
import android.hardware.Camera.Parameters;
import android.app.Activity;
import android.hardware.Camera;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;


/**
 * Created by Administrator on 2016/4/30 0030.
 */
public class BaseActivity extends Activity{
    protected enum UIType{
        UI_TYPE_MAIN, UI_TYPE_FLASHLIGHT, UI_TYPE_WARNINGLIGHT, UI_TYPE_MORSE, UI_TYPE_BLUB, UI_TYPE_COLOR, UI_TYPE_POLICE, UI_TYPE_SETTINGS
    }
    protected ImageView mImageViewFlashlight;
    protected ImageView mImageViewFlashlightControl;
    protected Camera mCamera;
    protected Parameters mParameters;

    protected FrameLayout mUIFlashlight;
    protected LinearLayout mUIMain;

    protected UIType mCurrentUIType = UIType.UI_TYPE_FLASHLIGHT;
    protected UIType mLastUIType = UIType.UI_TYPE_FLASHLIGHT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUIFlashlight = (FrameLayout)findViewById(R.id.framelayout_flashlight);
        mUIMain = (LinearLayout)findViewById(R.id.linearlayout_main);

        mImageViewFlashlight = (ImageView) findViewById(R.id.im_FlashLight);
        mImageViewFlashlightControl = (ImageView) findViewById(R.id.im_FlashLight_control);
    }
    protected void hideAllUI(){
        mUIFlashlight.setVisibility(View.GONE);
        mUIMain.setVisibility(View.GONE);
    }
}


































