package com.erdem.mapper;

import android.util.Log;

public class UI {
    static int plant_state=-1;
    static int path_state=-1;
    static int object_state=-1;
    static double origin[]={335,475};

    public UI(){}

    static long lastTime=0;
    static void buttonClicked(float x,float y){
        if(System.currentTimeMillis()-lastTime>250) {
            if (y > 1030 && y < 1179) {
                if (in(x, 0, 100)) {
                    if (plant_state == 0) plant_state = -1;
                    else plant_state = 0;
                } else if (in(x, 100, 200)) {
                    if (plant_state == 1) plant_state = -1;
                    else plant_state = 1;
                } else if (in(x, 200, 300)) {
                    if (plant_state == 2) plant_state = -1;
                    else plant_state = 2;
                } else if (in(x, 300, 400)) {
                    if (plant_state == 3) plant_state = -1;
                    else plant_state = 3;

                } else if (in(x, 400, 500)) {
                    if (path_state == 0) path_state = -1;
                    else path_state = 0;
                } else if (in(x, 500, 600)) {
                    if (path_state == 1) path_state = -1;
                    else path_state = 1;
                } else if (in(x, 600, 700)) {
                    if (path_state == 2) path_state = -1;
                    else path_state = 2;
                }
            } else if (y > 1179) {
                if (in(x, 0, 100)) {
                    if(object_state==0)object_state = -1;
                    object_state = 0;
                } else if (in(x, 100, 200)) {
                    if(object_state==1)object_state = -1;
                    object_state = 1;
                } else if (in(x, 200, 300)) {
                    if(object_state==2)object_state = -1;
                    object_state = 2;
                } else if (in(x, 300, 400)) {
                    if(object_state==3)object_state = -1;
                    object_state = 3;
                } else if (in(x, 400, 500)) {
                    if(object_state==4)object_state = -1;
                    object_state = 4;
                } else if (in(x, 500, 600)) {
                    CanvasHandler.zoom=(CanvasHandler.zoom+1)%CanvasHandler.zoomParameters.length;
                } else if (in(x, 600, 700)) {
                    CanvasHandler.pushY=0;
                    CanvasHandler.pushX=0;
                }
            }
            //Log.d("button", plant_state + " " + path_state + " " + object_state);
            lastTime=System.currentTimeMillis();
            MainActivity.myCanvas.redrawCanvas();
        }
    }
        static boolean in(float k,float a,float b){
        if(a<=k&&k<=b)return true;
        return false;
        }

}
