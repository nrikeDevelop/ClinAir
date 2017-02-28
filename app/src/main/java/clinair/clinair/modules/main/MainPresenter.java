package clinair.clinair.modules.main;

import android.content.Context;
import android.location.Location;
import android.os.Handler;

import com.google.android.gms.location.places.Place;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import nucleus.presenter.Presenter;
import clinair.clinair.common.Preferences;
import clinair.clinair.model.Estautomaticas.A1;
import clinair.clinair.model.Estautomaticas.A3;
import clinair.clinair.model.Estautomaticas.A4;
import clinair.clinair.model.Estautomaticas.A5;
import clinair.clinair.model.Estautomaticas.A6;
import clinair.clinair.model.Estautomaticas.A7;
import clinair.clinair.model.LatLong;
import clinair.clinair.model.Operations.A1Operations;
import clinair.clinair.model.Operations.A3Operations;
import clinair.clinair.model.Operations.A4Operations;
import clinair.clinair.model.Operations.A5Operations;
import clinair.clinair.model.Operations.A6Operations;
import clinair.clinair.model.Operations.A7Operations;

/**
 * Created by susy on 20/12/16.
 */

public class MainPresenter extends Presenter<MainActivity> {

    private static String SPLIT_CSV = ";";
    private static String TAG = "main presenter";


    public String getNearSensor(Context context, Place place){

        Map<String, Double> sensorDistanceMap = new HashMap<String, Double>();

        //LatLong
        LatLong latLongA1 = getLatLong(Preferences.getA1List(context).get(1).getPlace());
        LatLong latLongA3 = getLatLong(Preferences.getA3List(context).get(1).getPlace());
        LatLong latLongA4 = getLatLong(Preferences.getA4List(context).get(1).getPlace());
        LatLong latLongA5 = getLatLong(Preferences.getA5List(context).get(1).getPlace());
        LatLong latLongA6 = getLatLong(Preferences.getA6List(context).get(1).getPlace());
        LatLong latLongA7 = getLatLong(Preferences.getA7List(context).get(1).getPlace());

        //Add distances
        sensorDistanceMap.put("distanceToA1",getDistanceTo(place,latLongA1));
        sensorDistanceMap.put("distanceToA3",getDistanceTo(place,latLongA3));
        sensorDistanceMap.put("distanceToA4",getDistanceTo(place,latLongA4));
        sensorDistanceMap.put("distanceToA5",getDistanceTo(place,latLongA5));
        sensorDistanceMap.put("distanceToA6",getDistanceTo(place,latLongA6));
        sensorDistanceMap.put("distanceToA7",getDistanceTo(place,latLongA7));

        //Get minor distance
        double minorDistance = 20000.0;
        String typeSensor ="";
        for(int i = 1; i <= sensorDistanceMap.size()+1; i++){
            if(sensorDistanceMap.get("distanceToA"+i) != null){
                System.out.println(i+" > "+sensorDistanceMap.get("distanceToA"+i));

                if(sensorDistanceMap.get("distanceToA"+i) < minorDistance){
                    minorDistance = sensorDistanceMap.get("distanceToA"+i);
                    typeSensor = "A"+i;
                }
            }
        }
        return typeSensor;
    }

    private double getDistanceTo (Place place, LatLong sensorLatLong){

        Location placeLocation=new Location("placeLocation");
        placeLocation.setLatitude(place.getLatLng().latitude);
        placeLocation.setLongitude(place.getLatLng().longitude);

        Location sensorsLocation=new Location("senSorLocation");
        sensorsLocation.setLatitude(sensorLatLong.getLatitude());
        sensorsLocation.setLongitude(sensorLatLong.getLongitude());

        return placeLocation.distanceTo(sensorsLocation);

    }

    private LatLong getLatLong( String place ){

        String [] LatitudeLongitude = place.split(";");
        return new LatLong(Double.parseDouble(LatitudeLongitude[0]),
                Double.parseDouble(LatitudeLongitude[1]));


    }

    int TIME_TO_WAIT = 500;

    //Sensor context date
    public void requestData(String sensor,Context context, String date ){

        /*
        0 > DAY
        1 > MONTH
        2 > YEAR
        */

        String getDate [] = date.split("/");

        int year = Integer.parseInt(getDate[2]);
        int month = Integer.parseInt(getDate[1]);;
        int day = Integer.parseInt(getDate[0]);;


        Handler handler = new Handler();
        switch (sensor){
            case "A1":
                final ArrayList<A1> returnListA1 = new ArrayList<>();
                returnListA1.add(A1Operations.getDay(context,day,month,year));
                returnListA1.add(A1Operations.getMediaMonth(context,month,year));
                returnListA1.add(A1Operations.getMediaYear(context,year));
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getView().onSuccess(returnListA1);
                    }
                },TIME_TO_WAIT);
                break;
            case "A3":
                final ArrayList<A3> returnListA3 = new ArrayList<>();
                returnListA3.add(A3Operations.getDay(context,day,month,year));
                returnListA3.add(A3Operations.getMediaMonth(context,month,year));
                returnListA3.add(A3Operations.getMediaYear(context,year));
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getView().onSuccess(returnListA3);
                    }
                },TIME_TO_WAIT);
                break;
            case "A4":
                final ArrayList<A4> returnListA4 = new ArrayList<>();
                returnListA4.add(A4Operations.getDay(context,day,month,year));
                returnListA4.add(A4Operations.getMediaMonth(context,month,year));
                returnListA4.add(A4Operations.getMediaYear(context,year));
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getView().onSuccess(returnListA4);
                    }
                },TIME_TO_WAIT );
                break;
            case "A5":

                final ArrayList<A5> returnListA5 = new ArrayList<>();
                returnListA5.add(A5Operations.getDay(context,day,month,year));
                returnListA5.add(A5Operations.getMediaMonth(context,month,year));
                returnListA5.add(A5Operations.getMediaYear(context,year));
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getView().onSuccess(returnListA5);
                    }
                },TIME_TO_WAIT);

                break;
            case "A6":
                final ArrayList<A6> returnListA6 = new ArrayList<>();
                returnListA6.add(A6Operations.getDay(context,day,month,year));
                returnListA6.add(A6Operations.getMediaMonth(context,month,year));
                returnListA6.add(A6Operations.getMediaYear(context,year));
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getView().onSuccess(returnListA6);
                    }
                },TIME_TO_WAIT);

                break;
            case "A7":
                final ArrayList<A7> returnListA7 = new ArrayList<>();
                returnListA7.add(A7Operations.getDay(context,day,month,year));
                returnListA7.add(A7Operations.getMediaMonth(context,month,year));
                returnListA7.add(A7Operations.getMediaYear(context,year));
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getView().onSuccess(returnListA7);
                    }
                },TIME_TO_WAIT);
                break;


        }

    }


}


