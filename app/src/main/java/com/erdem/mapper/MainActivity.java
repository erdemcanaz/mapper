package com.erdem.mapper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PermissionHandler.setup_checkPermissions(MainActivity.this,this);
        LocationHandler LOCATION_=new LocationHandler(MainActivity.this);

    }
    /*PERMISSIONS*/

    /**/

}
