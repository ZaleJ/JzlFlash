package com.jzlclock.jzl.jzlflash;
import android.hardware.Camera.Parameters;
import android.content.pm.PackageManager;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.graphics.Point;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/4/30 0030.
 */
public class Flashlight extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImageViewFlashlight.setTag(false);
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
        if(((boolean)mImageViewFlashlight.getTag()) == false){
            openFlashlignt();
        }else{
            closeFlashlight();
        }
    }

    // open Flashlight
    protected void openFlashlignt(){
        TransitionDrawable drawable = (TransitionDrawable) mImageViewFlashlight.getDrawable();
        drawable.startTransition(200);
        mImageViewFlashlight.setTag(true);

        try {
            mCamera = Camera.open();
            int textureId = 0;
            mCamera.setPreviewTexture(new SurfaceTexture(textureId));
            mCamera.startPreview();

            mParameters = mCamera.getParameters();

            mParameters.setFlashMode(mParameters.FLASH_MODE_TORCH);
            mCamera.setParameters(mParameters);
        } catch (Exception e){
        }
    }

    // close the Flashlight
    protected void closeFlashlight(){
        TransitionDrawable drawable = (TransitionDrawable) mImageViewFlashlight.getDrawable();
        if(((Boolean)mImageViewFlashlight.getTag())){
            drawable.reverseTransition(200);
            mImageViewFlashlight.setTag(false);
            if(mCamera != null){
                mParameters = mCamera.getParameters();
                mParameters.setFlashMode(Parameters.FLASH_MODE_OFF);
                mCamera.setParameters(mParameters);
                mCamera.stopPreview();
                mCamera.release();
                mCamera = null;
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeFlashlight();
    }
}
