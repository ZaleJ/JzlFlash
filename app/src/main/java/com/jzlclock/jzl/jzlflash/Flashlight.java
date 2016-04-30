package com.jzlclock.jzl.jzlflash;

import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/4/30 0030.
 */
public class Flashlight extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Point point = new Point();

        getWindowManager().getDefaultDisplay().getSize(point);

        LayoutParams laParams = (LayoutParams) mImageViewFlashlightControl.getLayoutParams();
        laParams.height = point.y*3/4;
        laParams.width = point.x/3;

        mImageViewFlashlightControl.setLayoutParams(laParams);
       }

    public void onClick_Flashlight(View view){
        if(!getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)){
            Toast.makeText(this, "no flashlight!!!",Toast.LENGTH_LONG).show();
            return;
        }
    }
}
