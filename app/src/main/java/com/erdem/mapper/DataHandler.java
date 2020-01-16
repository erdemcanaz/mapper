package com.erdem.mapper;

import android.util.Log;

public class DataHandler {
    //
    static double data[]=new double [6];

    public DataHandler(){}
    public void addNewData(double lat,double lon, double alt, double plant_state, double path_state, double object_state){
        if(plant_state<-0.5&&path_state<-0.5&&object_state<-0.5)return;
        //0 langitude, 1 longitude, 2 altitude ,3 plant state,4 path state,5 object state
        int startInd= data.length-6;
        data[startInd]=lat;
        data[startInd+1]=lon;
        data[startInd+2]=alt;
        data[startInd+3]=plant_state;
        data[startInd+4]=path_state;
        data[startInd+5]=object_state;
        logOutRecentData();
        data=expandArray(data,6);
        //
        UI.object_state=-1;
        int k=startInd;


    }
    private static double[] expandArray(double [] array,int howManyNeeded){
        double temp[]= new double[data.length+6];
        for(int i=0;i<data.length;i++)temp[i]=data[i];
        return temp;
    }
    private void logOutRecentData(){
        int k= data.length-6;
       // Log.d("DATAHANDLER","len:"+data.length+ " " +data[k]+" "+data[k+1]+" "+data[k+2]+" "+data[k+3]+" "+data[k+4]+" "+data[k+5] );
    }
}
