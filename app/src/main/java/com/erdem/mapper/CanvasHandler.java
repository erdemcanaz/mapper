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

    static float pushX=0;
    static float pushY=0;
    static int zoom=1;
    // half_width, half_height;
    static int zoomParameters[][]={{10,20},{40,60},{100,150},{200,300},{800,1200}};


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
        paint[1].setColor(Color.GREEN);
        paint[1].setStyle(Paint.Style.STROKE);

    }
    static Bitmap b;
    @Override
    protected  void onDraw(Canvas canvas){
        super.onDraw(canvas);
        defineSelectedButtons();

        ////TEXTURE
        double dLan,dLon,x,y;
        for(int i=0;i<DataHandler.data.length-6;i+=6){
             dLan=DataHandler.data[i]-LocationHandler.GEO[0];
             dLon=LocationHandler.GEO[1]-DataHandler.data[i+1];
            x=GeoCalculation.dLon_to_pix(zoomParameters[zoom][0],UI.origin[0],dLon)+UI.origin[0];
            y=GeoCalculation.dLat_to_pix(zoomParameters[zoom][1],UI.origin[1],dLan)+UI.origin[1];
            Log.d("CanvasHandler",i+":"+dLan+" "+dLon+" "+DataHandler.data[i+2]+" "+DataHandler.data[i+3]+" "+DataHandler.data[i+4]+" "+DataHandler.data[i+5]);
           if(DataHandler.data[i+3]==0){
               b= BitmapFactory.decodeResource(getResources(), R.drawable.half_open_land);
               canvas.drawBitmap(b,(int)(x+pushX), (int)(y+pushY), paint[0]);
           }else if(DataHandler.data[i+3]==1){
               b= BitmapFactory.decodeResource(getResources(), R.drawable.forest);
               canvas.drawBitmap(b,(int)(x+pushX), (int)(y+pushY), paint[0]);
           }else if(DataHandler.data[i+3]==2){
               b= BitmapFactory.decodeResource(getResources(), R.drawable.bush);
               canvas.drawBitmap(b,(int)(x+pushX), (int)(y+pushY), paint[0]);
           }else if(DataHandler.data[i+3]==3){
               b= BitmapFactory.decodeResource(getResources(), R.drawable.open_land);
               canvas.drawBitmap(b,(int)(x+pushX), (int)(y+pushY), paint[0]);
           }
            //////////
            if(DataHandler.data[i+4]==0){
                b= BitmapFactory.decodeResource(getResources(), R.drawable.road);
                canvas.drawBitmap(b,(int)(x+pushX), (int)(y+pushY), paint[0]);
            }else if(DataHandler.data[i+4]==1){
                b= BitmapFactory.decodeResource(getResources(), R.drawable.fence);
                canvas.drawBitmap(b,(int)(x+pushX), (int)(y+pushY), paint[0]);
            }else if(DataHandler.data[i+4]==2){
                b= BitmapFactory.decodeResource(getResources(), R.drawable.path);
                canvas.drawBitmap(b,(int)(x+pushX), (int)(y+pushY), paint[0]);
            }
            //////////////
            if(DataHandler.data[i+5]==0){
                b= BitmapFactory.decodeResource(getResources(), R.drawable.pit);
                canvas.drawBitmap(b,(int)(x+pushX), (int)(y+pushY), paint[0]);
            }else if(DataHandler.data[i+5]==1){
                b= BitmapFactory.decodeResource(getResources(), R.drawable.cave);
                canvas.drawBitmap(b,(int)(x+pushX), (int)(y+pushY), paint[0]);
            }else if(DataHandler.data[i+5]==2){
                b= BitmapFactory.decodeResource(getResources(), R.drawable.stone);
                canvas.drawBitmap(b,(int)(x+pushX), (int)(y+pushY), paint[0]);
            }else if(DataHandler.data[i+5]==3){
                b= BitmapFactory.decodeResource(getResources(), R.drawable.root);
                canvas.drawBitmap(b,(int)(x+pushX), (int)(y+pushY), paint[0]);
            }else if(DataHandler.data[i+5]==4){
                b= BitmapFactory.decodeResource(getResources(), R.drawable.soil);
                canvas.drawBitmap(b,(int)(x+pushX), (int)(y+pushY), paint[0]);
            }

        }//FOR


        b= BitmapFactory.decodeResource(getResources(), R.drawable.loc_7);
        //canvas.drawBitmap(b, (int)UI.origin[0]+pushX, (int)UI.origin[1]+pushY, paint[0]);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.button_46_3);
        canvas.drawBitmap(b, 10, 915, paint[0]);//menu
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
        Log.d("canvas", "pushCanvas: "+pushX+" : "+pushY);
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

        if(UI.object_state==0)path[1].addRect(10,1010,110,1110, Path.Direction.CCW);
        else if(UI.object_state==1)path[1].addRect(110,1010,210,1110, Path.Direction.CCW);
        else if(UI.object_state==2)path[1].addRect(210,1010,310,1110, Path.Direction.CCW);
        else if(UI.object_state==3)path[1].addRect(310,1010,410,1110, Path.Direction.CCW);
        else if(UI.object_state==4)path[1].addRect(410,1010,510,1110, Path.Direction.CCW);

    }
}

