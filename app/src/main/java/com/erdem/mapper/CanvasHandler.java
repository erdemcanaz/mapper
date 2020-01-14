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
import android.view.View;


public class CanvasHandler extends View {
    Paint paint;
    Path path;

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
        canvas.drawPath(path,paint);
        Bitmap b= BitmapFactory.decodeResource(getResources(), R.drawable.abc);
        canvas.drawBitmap(b, 0, 0, paint);
    }
    public void cleanCanvas(){
        path=new Path();
        invalidate();
    }
    public void line(float x1,float y1,float x2,float y2,int STROKE,int COLOR){
        paint.setStrokeWidth(STROKE);
        paint.setColor(COLOR);

        path = new Path();
        path.moveTo(x1, y1);
        path.lineTo(x2, y2);

        invalidate();
    }
}
