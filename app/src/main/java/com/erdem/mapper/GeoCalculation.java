package com.erdem.mapper;

import android.util.Log;

public class GeoCalculation {

    static double EARTH_RADIUS_METER=6359000;
    static double DEGREE_TO_RADIAN_MULTIPLIER=0.01745329252f;
    static double DISTANCE_BETWEEN_LATITUDE_METER=110985;// lat1=39 lat2=45 d= 6* 110985
    static double DISTANCE_BETWEEN_LONGITUDE_METER; //lon1 = 150 lon2=152 d=2 x this;
    static void set_DISTANCE_BETWEEN_LONGITUDE_METER(double LATITUDE){
        DISTANCE_BETWEEN_LONGITUDE_METER=Math.cos(LATITUDE*DEGREE_TO_RADIAN_MULTIPLIER)*EARTH_RADIUS_METER*2*Math.PI/(360);
    }
    static void calcualteDistance(double lat1,double lon1,double lat2,double lon2){
        double d=Math.sqrt(Math.pow((lat1-lat2)*DISTANCE_BETWEEN_LATITUDE_METER,2)+Math.pow((lon1-lon2)*DISTANCE_BETWEEN_LONGITUDE_METER,2));
    }



}
