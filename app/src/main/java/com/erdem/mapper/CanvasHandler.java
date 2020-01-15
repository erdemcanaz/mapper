package com.erdem.mapper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


public class CanvasHandler extends View {
    Paint paint[]=new Paint[100];
    Path path[]=new Path[100];

    private float pushX=0;
    private float pushY=0;
    private float zoom=1;


    public CanvasHandler(Context context, AttributeSet attrs){
        super( context, attrs);
        paint[0] = new Paint();
        path[0] = new Path();
        paint[0].setStrokeWidth(5f);
        paint[0].setColor(Color.RED);
        paint[0].setStyle(Paint.Style.STROKE);

        path[1]= new Path();
        paint[1]=new Paint();
        paint[1].setStrokeWidth(12f);
        paint[1].setColor(Color.GRAY);
        paint[1].setStyle(Paint.Style.STROKE);

    }
    @Override
    protected  void onDraw(Canvas canvas){
        super.onDraw(canvas);
        defineSelectedButtons();

        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.loc_7);
        canvas.drawBitmap(b, 360, 520, paint[0]);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.button_46_2);
        canvas.drawBitmap(b, 10, 915, paint[0]);//menu
        canvas.drawPath(path[0], paint[0]);
        canvas.drawPath(path[1], paint[1]);


    }


    private boolean CLEAN=false;
    public void cleanCanvas(){
        CLEAN=true;
        invalidate();
    }
    public void redrawCanvas(){
            invalidate();
    }
    public void line(float x1,float y1,float x2,float y2,int STROKE,int COLOR){
        paint[0].setStrokeWidth(STROKE);
        paint[0].setColor(COLOR);

        path[0] = new Path();
        path[0].moveTo(x1+pushX, y1+pushY);
        path[0].lineTo(x2+pushX, y2+pushY);
        //path[0].addRect(495,50,500,250, Path.Direction.CCW);

        invalidate();
    }

    public void pushCanvas(float d_pushX,float d_pushY){
        this.pushX+=d_pushX;
        this.pushY+=d_pushY;
    }
    public void defineSelectedButtons(){
        path[1]=new Path();
        if(UI.plant_state==0)path[1].addRect(10,925,110,1020, Path.Direction.CCW);
        else if(UI.plant_state==1)path[1].addRect(110,925,210,1020, Path.Direction.CCW);
        else if(UI.plant_state==2)path[1].addRect(210,925,310,1020, Path.Direction.CCW);
        else if(UI.plant_state==3)path[1].addRect(310,925,410,1020, Path.Direction.CCW);

        if(UI.path_state==0)path[1].addRect(410,925,510,1020, Path.Direction.CCW);
        else if(UI.path_state==1)path[1].addRect(510,925,610,1020, Path.Direction.CCW);
        else if(UI.path_state==2)path[1].addRect(610,925,710,1020, Path.Direction.CCW);


    }
}

