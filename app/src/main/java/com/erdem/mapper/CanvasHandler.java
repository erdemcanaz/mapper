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
    Paint paint;
    Path path;
    private float pushX=0;
    private float pushY=0;
    private float zoom=1;


    public CanvasHandler(Context context, AttributeSet attrs){
        super( context, attrs);
        paint = new Paint();
        path = new Path();
        paint.setStrokeWidth(5f);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);

    }
    @Override
    protected  void onDraw(Canvas canvas){
        super.onDraw(canvas);
        if(!CLEAN) {
           // canvas.drawPath(path, paint);
            Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.abc);
            canvas.drawBitmap(b, 50+pushX, 50+pushY, paint);
        }else{CLEAN=!CLEAN;}

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
        paint.setStrokeWidth(STROKE);
        paint.setColor(COLOR);

        path = new Path();
        path.moveTo(x1+pushX, y1+pushY);
        path.lineTo(x2+pushX, y2+pushY);

        invalidate();
    }
    public void pushCanvas(float d_pushX,float d_pushY){
        this.pushX+=d_pushX;
        this.pushY+=d_pushY;
    }


}

