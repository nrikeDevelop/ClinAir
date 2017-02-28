package clinair.clinair.modules;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;

import clinair.clinair.R;
import clinair.clinair.model.Estautomaticas.A1;
import clinair.clinair.model.Estautomaticas.A3;
import clinair.clinair.model.Estautomaticas.A4;
import clinair.clinair.model.Estautomaticas.A5;
import clinair.clinair.model.Estautomaticas.A6;
import clinair.clinair.model.Estautomaticas.A7;

/**
 * Created by susy on 26/02/17.
 */

public class FragmentData extends Fragment {

    ArrayList<?> list;
    int TYPE_SEARCH = 2;
    String sensor;


    TextView pm2;
    TextView pm1;
    TextView pm10;
    TextView so2;
    TextView no2;
    TextView no;
    TextView nox;
    TextView ozono;

    Bundle mBundle;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data, container, false);

        mBundle = new Bundle();

        if(getArguments() != null) {

            mBundle = getArguments();
            this.TYPE_SEARCH = mBundle.getInt("TYPE_SEARCH");
            this.sensor = mBundle.getString("nearSensor");
            this.list = (ArrayList<?>) mBundle.getSerializable("list");

        }


        setUpViews(view);
        return  view;
    }

    public void setUpViews(View view){

        //load views
        pm2 = (TextView) view.findViewById(R.id.fragment_PM2_5);
        pm1 = (TextView) view.findViewById(R.id.fragment_PM1);
        pm10 = (TextView) view.findViewById(R.id.fragment_PM10);
        so2 = (TextView) view.findViewById(R.id.fragment_SO2);
        no2 = (TextView) view.findViewById(R.id.fragment_NO2);
        no = (TextView) view.findViewById(R.id.fragment_NO);
        nox = (TextView) view.findViewById(R.id.fragment_NOx);
        ozono = (TextView) view.findViewById(R.id.fragment_Ozono);

        //set Data


        switch (sensor){
            case "A1":
                sensorsA1();
                break;
            case "A3":
                sensorsA3();
                break;
            case "A4":
                sensorsA4();
                break;
            case "A5":
                sensorsA5();
                break;
            case "A6":
                sensorsA6();
                break;
            case "A7":
                sensorsA7();
                break;

        }
    }

    private void sensorsA1(){
        A1 sensorA1 = null;
        switch (TYPE_SEARCH){
            case 0:
                //GET DAY
                sensorA1 = (A1)list.get(0);
                break;
            case 1:
                //GET MONTH
                sensorA1 = (A1)list.get(1);
                break;
            case 2:
                //GET YEAR
                sensorA1 = (A1)list.get(2);
                break;
        }

        pm2.setText(round(sensorA1.getPM2(),2));
        pm1.setText(String.valueOf(round(sensorA1.getPM1(),2)));
        pm10.setText(String.valueOf(round(sensorA1.getPM10(),2)));
        so2.setText(String.valueOf(round(sensorA1.getSO2(),2)));
        no2.setText(String.valueOf(round(sensorA1.getNO2(),2)));
        no.setText(String.valueOf(round(sensorA1.getNO(),2)));
        nox.setText(String.valueOf(round(sensorA1.getNOx(),2)));
        ozono.setText(String.valueOf(round(sensorA1.getOzono(),2)));
    }

    private void sensorsA3(){
        A3 sensorA3 = null;
        switch (TYPE_SEARCH){
            case 0:
                //GET DAY
                sensorA3 = (A3)list.get(0);
                break;
            case 1:
                //GET MONTH
                sensorA3 = (A3)list.get(1);
                break;
            case 2:
                //GET YEAR
                sensorA3 = (A3)list.get(2);
                break;
        }

        pm2.setText(round(sensorA3.getPM2(),2));
        pm1.setText(String.valueOf(round(sensorA3.getPM1(),2)));
        pm10.setText(String.valueOf(round(sensorA3.getPM10(),2)));
        so2.setText(String.valueOf(round(sensorA3.getSO2(),2)));
        no2.setText(String.valueOf(round(sensorA3.getNO2(),2)));
        no.setText(String.valueOf(round(sensorA3.getNO(),2)));
        nox.setText(String.valueOf(round(sensorA3.getNOx(),2)));
        ozono.setText(String.valueOf(round(sensorA3.getOzono(),2)));
    }

    private void sensorsA4(){
        A4 sensorA4 = null;
        switch (TYPE_SEARCH){
            case 0:
                //GET DAY
                sensorA4 = (A4)list.get(0);
                break;
            case 1:
                //GET MONTH
                sensorA4 = (A4)list.get(1);
                break;
            case 2:
                //GET YEAR
                sensorA4 = (A4)list.get(2);
                break;
        }

        pm2.setText(round(sensorA4.getPM2(),2));
        pm1.setText(String.valueOf(round(sensorA4.getPM1(),2)));
        pm10.setText(String.valueOf(round(sensorA4.getPM10(),2)));
        so2.setText(String.valueOf(round(sensorA4.getSO2(),2)));
        no2.setText(String.valueOf(round(sensorA4.getNO2(),2)));
        no.setText(String.valueOf(round(sensorA4.getNO(),2)));
        nox.setText(String.valueOf(round(sensorA4.getNOx(),2)));
        ozono.setText(String.valueOf(round(sensorA4.getOzono(),2)));
    }

    private void sensorsA5(){
        A5 sensorA5 = null;
        switch (TYPE_SEARCH){
            case 0:
                //GET DAY
                sensorA5 = (A5)list.get(0);
                break;
            case 1:
                //GET MONTH
                sensorA5 = (A5)list.get(1);
                break;
            case 2:
                //GET YEAR
                sensorA5 = (A5)list.get(2);
                break;
        }

        pm2.setText(round(sensorA5.getPM2(),2));
        // pm1.setText(String.valueOf(round(sensorA5.getp(),2)));
        pm10.setText(String.valueOf(round(sensorA5.getPM10(),2)));
        so2.setText(String.valueOf(round(sensorA5.getSO2(),2)));
        no2.setText(String.valueOf(round(sensorA5.getNO2(),2)));
        no.setText(String.valueOf(round(sensorA5.getNO(),2)));
        nox.setText(String.valueOf(round(sensorA5.getNOx(),2)));
        ozono.setText(String.valueOf(round(sensorA5.getOzono(),2)));
    }

    private void sensorsA6(){
        A6 sensorA6 = null;
        switch (TYPE_SEARCH){
            case 0:
                //GET DAY
                sensorA6 = (A6)list.get(0);
                break;
            case 1:
                //GET MONTH
                sensorA6 = (A6)list.get(1);
                break;
            case 2:
                //GET YEAR
                sensorA6 = (A6)list.get(2);
                break;
        }

        pm2.setText(round(sensorA6.getPM2(),2));
        pm1.setText(String.valueOf(round(sensorA6.getPM1(),2)));
        pm10.setText(String.valueOf(round(sensorA6.getPM10(),2)));
        so2.setText(String.valueOf(round(sensorA6.getS02(),2)));
        no2.setText(String.valueOf(round(sensorA6.getNO2(),2)));
        no.setText(String.valueOf(round(sensorA6.getNO(),2)));
        nox.setText(String.valueOf(round(sensorA6.getNOx(),2)));
        ozono.setText(String.valueOf(round(sensorA6.getOzono(),2)));
    }

    private void sensorsA7(){
        A7 sensorA7 = null;
        switch (TYPE_SEARCH){
            case 0:
                //GET DAY
                sensorA7 = (A7)list.get(0);
                break;
            case 1:
                //GET MONTH
                sensorA7 = (A7)list.get(1);
                break;
            case 2:
                //GET YEAR
                sensorA7 = (A7)list.get(2);
                break;
        }

        //pm2.setText(round(sensorA7.getPM2(),2));
        //pm1.setText(String.valueOf(round(sensorA7.getP(),2)));
        pm10.setText(String.valueOf(round(sensorA7.getPM10(),2)));
        so2.setText(String.valueOf(round(sensorA7.getS02(),2)));
        no2.setText(String.valueOf(round(sensorA7.getNO2(),2)));
        no.setText(String.valueOf(round(sensorA7.getNO(),2)));
        nox.setText(String.valueOf(round(sensorA7.getNOx(),2)));
        ozono.setText(String.valueOf(round(sensorA7.getOzono(),2)));
    }



    public static String round(float d, int decimalPlace) {

        if(String.valueOf(d).equals("NaN") || String.valueOf(d).equals("Infinity")){
            return "0";
        }else{
            BigDecimal bd = new BigDecimal(Float.toString(d));
            bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
            return String.valueOf(bd.floatValue()) ;
        }

    }


}
