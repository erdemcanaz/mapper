package com.erdem.mapper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    CanvasHandler myCanvas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PermissionHandler.setup_checkPermissions(MainActivity.this,this);
        LocationHandler LOCATION_=new LocationHandler(MainActivity.this);

        myCanvas=new CanvasHandler(this,null);
        myCanvas.line(0,0,250,250,5, Color.YELLOW);
        myCanvas.line(300,250,250,300,5, Color.RED);
        setContentView(myCanvas);

    }
    /*PERMISSIONS*/

    /**/

}
