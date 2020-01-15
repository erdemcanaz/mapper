package com.erdem.mapper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CanvasHandler myCanvas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**/
        PermissionHandler.setup_checkPermissions(MainActivity.this,this);
        LocationHandler LOCATION_=new LocationHandler(MainActivity.this);

        /**/

        myCanvas=new CanvasHandler(this,null);
        myCanvas.pushCanvas(0,600);
        myCanvas.line(300,250,250,300,5, Color.RED);
        //myCanvas.cleanCanvas();

        setContentView(myCanvas);

    }
    //////////////////////////////
    float touchX,touchY;
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float X = (int) event.getX();
        float Y = (int) event.getY();
        int eventaction = event.getAction();

        switch (eventaction) {
            case MotionEvent.ACTION_DOWN:
                touchX=X;
                touchY=Y;
                break;

            case MotionEvent.ACTION_MOVE:
                myCanvas.pushCanvas(-(touchX-X),-(touchY-Y));
                touchX=X;
                touchY=Y;
                myCanvas.redrawCanvas();
                break;

            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }
}
