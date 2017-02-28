package project.baseproject.model.Operations;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import project.baseproject.common.Preferences;
import project.baseproject.model.Estautomaticas.A6;
import project.baseproject.model.StaticData;

/**
 * Created by susy on 20/02/17.
 */

public class A6Operations {

    static String TAG = "A6Operations";
    static String SPLIT_CSV = ";";


    static float PM2 = 0;
    static float PM1 = 0;
    static float SO2 = 0;
    static float CO = 0;
    static float NO = 0;
    static float NO2 = 0;
    static float PM10 = 0;
    static float NOx = 0;
    static float Ozono = 0;
    static float vel = 0;

    static int countSO2 = 0;
    static int countCO = 0;
    static int countOzono = 0;
    static int countNOx = 0;
    static int countNO = 0;
    static int countNO2 = 0;
    static int countPM10 = 0;
    static int countPM2 = 0;
    static int countPM1 = 0;
    static int countvel = 0;

    public static void getData(final Context context){
        Thread readThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{

                    ArrayList A6List = new ArrayList();
                    int count = 0;

                    URL url = new URL(StaticData.getUrl_dataA6());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
                    String line = reader.readLine();
                    while (line != null) {
                        count = count + 1;
                        line = reader.readLine();
                        //Exit when finish
                        if(line == null){
                            break;
                        }

                        line = line.replaceAll(",",".");
                        try{

                            if(line != null){

                                String [] lineCSV;
                                lineCSV =line.split(SPLIT_CSV);

                                //check empty values
                                for (int i = 0; i < lineCSV.length ; i++){
                                    if(lineCSV[i].isEmpty()){
                                        lineCSV[i] = "0";
                                    }
                                }

                                if (lineCSV.length > 1) PM2 = Float.parseFloat(lineCSV[1]) ; else PM2 = 0;
                                if (lineCSV.length > 2) PM1 = Float.parseFloat(lineCSV[2]) ; else PM1 = 0;
                                if (lineCSV.length > 3) SO2 = Float.parseFloat(lineCSV[3]) ; else SO2 = 0 ;
                                if (lineCSV.length > 4) CO = Float.parseFloat(lineCSV[4]) ; else CO = 0;
                                if (lineCSV.length > 5) NO = Float.parseFloat(lineCSV[5]) ; else NO = 0;
                                if (lineCSV.length > 6) NO2 = Float.parseFloat(lineCSV[6]) ; else NO2 = 0;
                                if (lineCSV.length > 7) PM10 = Float.parseFloat(lineCSV[7]) ; else PM10 = 0;
                                if (lineCSV.length > 8) NOx = Float.parseFloat(lineCSV[8]) ; else NOx = 0;
                                if (lineCSV.length > 9) Ozono = Float.parseFloat(lineCSV[9]) ; else Ozono = 0;
                                if (lineCSV.length > 10) vel = Float.parseFloat(lineCSV[10]) ; else vel = 0;

                                A6 a6 = new A6(lineCSV[0],PM2,PM1,SO2,CO,NO,NO2,PM10,NOx,Ozono,vel);
                                A6List.add(a6);
                            }

                        }catch (Exception e){
                            System.out.println("capturado error en el array A6 Operations");
                        }
                    }
                    reader.close();
                    //SaveList
                    Preferences.setA6List(context,A6List);

                }catch (Exception e){
                    Log.i(TAG,"Error en la lectura del archivo");
                }
            }
        });
        readThread.start();
    }

    public static A6 getMediaYear(final Context context, int YEAR){



        ArrayList<A6> A6List = Preferences.getA6List(context);

        for (int i = 0 ; i < A6List.size(); i++){
            String date[] =A6List.get(i).getDate().split("/");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);

            if(year == YEAR){
                //TODO ACTIUONS

                PM2 = PM2 + A6List.get(i).getPM2();
                if (A6List.get(i).getPM2() != 0) countPM2 ++;

                PM1 = PM1 + A6List.get(i).getPM1();
                if (A6List.get(i).getPM1() != 0) countPM1 ++;

                SO2 = SO2 + A6List.get(i).getS02();
                if (A6List.get(i).getS02() != 0) countSO2 ++;

                CO = CO + A6List.get(i).getCO();
                if (A6List.get(i).getCO() != 0) countCO ++;

                NO = NO + A6List.get(i).getNO();
                if (A6List.get(i).getNO() != 0) countNO ++;

                PM10 = PM10 + A6List.get(i).getPM10();
                if (A6List.get(i).getPM10() != 0) countPM10 ++;

                NOx = NOx + A6List.get(i).getNOx();
                if (A6List.get(i).getNOx() != 0) countNOx ++;

                NO2 = NO2 + A6List.get(i).getNO2();
                if (A6List.get(i).getNO2() != 0) countNO2 ++;

                Ozono = Ozono + A6List.get(i).getOzono();
                if (A6List.get(i).getOzono() != 0) countOzono ++;

                vel = vel + A6List.get(i).getVel();
                if (A6List.get(i).getVel() != 0) countvel ++;

            }

        }

        //Media
        A6 a6 = new A6(
                "A6MediaYear",
                PM2/countPM2,
                PM1/countPM1,
                SO2/countSO2,
                CO/countCO,
                NO/countNO,
                NO2/countNO2,
                PM10/countPM10,
                NOx/countNOx,
                Ozono/countOzono,
                vel/countvel);

        resetValues();
        return a6;
    }

    public static A6 getMediaMonth(final Context context,int MONTH, int YEAR){



        ArrayList<A6> A6List = Preferences.getA6List(context);

        for (int i = 0 ; i < A6List.size(); i++){
            String date[] =A6List.get(i).getDate().split("/");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);

            if(month == MONTH && year == YEAR){
                //TODO ACTIUONS

                PM2 = PM2 + A6List.get(i).getPM2();
                if (A6List.get(i).getPM2() != 0) countPM2 ++;

                PM1 = PM1 + A6List.get(i).getPM1();
                if (A6List.get(i).getPM1() != 0) countPM1 ++;

                SO2 = SO2 + A6List.get(i).getS02();
                if (A6List.get(i).getS02() != 0) countSO2 ++;

                CO = CO + A6List.get(i).getCO();
                if (A6List.get(i).getCO() != 0) countCO ++;

                NO = NO + A6List.get(i).getNO();
                if (A6List.get(i).getNO() != 0) countNO ++;

                PM10 = PM10 + A6List.get(i).getPM10();
                if (A6List.get(i).getPM10() != 0) countPM10 ++;

                NOx = NOx + A6List.get(i).getNOx();
                if (A6List.get(i).getNOx() != 0) countNOx ++;

                NO2 = NO2 + A6List.get(i).getNO2();
                if (A6List.get(i).getNO2() != 0) countNO2 ++;

                Ozono = Ozono + A6List.get(i).getOzono();
                if (A6List.get(i).getOzono() != 0) countOzono ++;

                vel = vel + A6List.get(i).getVel();
                if (A6List.get(i).getVel() != 0) countvel ++;

            }

        }

        //Media
        A6 a6 = new A6(
                "A6MediaMonth",
                PM2/countPM2,
                PM1/countPM1,
                SO2/countSO2,
                CO/countCO,
                NO/countNO,
                NO2/countNO2,
                PM10/countPM10,
                NOx/countNOx,
                Ozono/countOzono,
                vel/countvel);

        resetValues();
        return a6;
    }

    public static A6 getDay (final Context context,int DAY, int MONTH, int YEAR){



        ArrayList<A6> A6List = Preferences.getA6List(context);

        for (int i = 0 ; i < A6List.size(); i++){
            String date[] =A6List.get(i).getDate().split("/");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);

            if(day == DAY && month == MONTH && year == YEAR){
                //TODO ACTIUONS

                PM2 = PM2 + A6List.get(i).getPM2();
                PM1 = PM1 + A6List.get(i).getPM1();
                SO2 = SO2 + A6List.get(i).getS02();
                CO = CO + A6List.get(i).getCO();
                NO = NO + A6List.get(i).getNO();
                PM10 = PM10 + A6List.get(i).getPM10();
                NOx = NOx + A6List.get(i).getNOx();
                NO2 = NO2 + A6List.get(i).getNO2();
                Ozono = Ozono + A6List.get(i).getOzono();
                vel = vel + A6List.get(i).getVel();
            }

        }

        //Media
        A6 a6 = new A6(
                "A6Day",
                PM2,
                PM1,
                SO2,
                CO,
                NO,
                NO2,
                PM10,
                NOx,
                Ozono,
                vel);

        resetValues();
        return a6;
    }



    private static void resetValues(){
        PM2 = 0;
        PM1 = 0;
        SO2 = 0;
        CO = 0;
        NO = 0;
        NO2 = 0;
        PM10 = 0;
        NOx = 0;
        Ozono = 0;
        vel = 0;
    }
}
