package com.jzlclock.jzl.jzlflash;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/4/30 0030.
 */
public class BaseActivity extends Activity{

    protected ImageView mImageViewFlashlight;
    protected ImageView mImageViewFlashlightControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageViewFlashlight = (ImageView) findViewById(R.id.im_FlashLight);
        mImageViewFlashlightControl = (ImageView) findViewById(R.id.im_FlashLight_control);
    }
}
