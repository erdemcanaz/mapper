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

    static CanvasHandler myCanvas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**/
        PermissionHandler.setup_checkPermissions(MainActivity.this,this);
        LocationHandler LOCATION_=new LocationHandler(MainActivity.this);

        /**/

        myCanvas=new CanvasHandler(this,null);
        //myCanvas.cleanCanvas();

        setContentView(myCanvas);

    }
    //////////////////////////////
    static float touchX=0,touchY=0;
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float X = (int) event.getX();
        float Y = (int) event.getY();
        int eventaction = event.getAction();
        UI.buttonClicked(X,Y);
        switch (eventaction) {
            case MotionEvent.ACTION_DOWN:
                touchX=X;
                touchY=Y;
                Log.d("a", "onTouchEvent: "+touchX+" "+touchY);
                break;

            case MotionEvent.ACTION_MOVE:
                if(touchY<1030)myCanvas.pushCanvas(-(touchX-X),-(touchY-Y));
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
