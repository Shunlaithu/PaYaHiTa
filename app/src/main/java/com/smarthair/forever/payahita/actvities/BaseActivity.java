package com.smarthair.forever.payahita.actvities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Admin on 8/6/2017.
 */

public class BaseActivity extends AppCompatActivity {

    String callNumber=null;
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 100;
    protected void openMap(String map){
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(map));
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CALL_PHONE: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    makeCall(callNumber);

                } else {


                }
                return;
            }


        }
    }


    protected void makeCall(String numberToCall) {

        numberToCall.replaceAll(" ", "");


        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + numberToCall));

        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            this.callNumber = numberToCall;


            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    MY_PERMISSIONS_REQUEST_CALL_PHONE);
            return;
        }
        startActivity(intent);
    }


}