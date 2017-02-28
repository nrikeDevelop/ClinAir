package clinair.clinair.model.Operations;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import clinair.clinair.common.Preferences;
import clinair.clinair.model.Estautomaticas.A1;
import clinair.clinair.model.StaticData;

/**
 * Created by susy on 20/02/17.
 */

public class A1Operations {

    static String TAG = "A1Operations";
    static String SPLIT_CSV = ";";

    static float PM2 = 0;
    static float PM1 = 0;
    static float SO2 = 0;
    static float NO = 0;
    static float NO2 = 0;
    static float PM10 = 0;
    static float NOx = 0;
    static float Ozono = 0;

    static int countPM2 = 0;
    static int countPM1 = 0;
    static int countSO2 = 0;
    static int countNO = 0;
    static int countNO2 = 0;
    static int countPM10 = 0;
    static int countNOx = 0;
    static int countOzono = 0;

    public static void getData(final Context context){
        Thread readThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{

                    ArrayList A1List = new ArrayList();
                    int count = 0;

                    URL url = new URL(StaticData.getUrl_dataA1());
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
                                if (lineCSV.length > 1) PM2 = Float.parseFloat(lineCSV[1]) ; else PM2 = 0 ;
                                if (lineCSV.length > 2) PM1 = Float.parseFloat(lineCSV[2]) ; else PM1 = 0 ;
                                if (lineCSV.length > 3) SO2 = Float.parseFloat(lineCSV[3]) ; else SO2 = 0 ;
                                if (lineCSV.length > 4) NO = Float.parseFloat(lineCSV[4]) ; else NO = 0;
                                if (lineCSV.length > 5) NO2 = Float.parseFloat(lineCSV[5]) ; else NO2 = 0;
                                if (lineCSV.length > 6) PM10 = Float.parseFloat(lineCSV[6]) ; else PM10 = 0;
                                if (lineCSV.length > 7) NOx = Float.parseFloat(lineCSV[7]) ; else NOx = 0;
                                if (lineCSV.length > 8) Ozono = Float.parseFloat(lineCSV[8]) ; else Ozono = 0;

                                A1 a1 = new A1(lineCSV[0],PM2,PM1,SO2,NO,NO2,PM10,NOx,Ozono);
                                A1List.add(a1);

                            }

                        }catch (Exception e){
                            System.out.println("capturado error en el array A1Operations");
                        }
                    }
                    reader.close();

                    //SaveList
                    Preferences.setA1List(context,A1List);

                }catch (Exception e){
                    Log.i(TAG,"Error en la lectura del archivo");
                }
            }
        });
        readThread.start();
    }


    public static A1 getMediaYear(final Context context, int YEAR) {

        ArrayList<A1> A1List = Preferences.getA1List(context);

        for (int i = 0; i < A1List.size(); i++) {
            String date[] = A1List.get(i).getDate().split("/");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);

            if (year == YEAR) {
                //TODO ACTIUONS
                PM2 = PM2 + A1List.get(i).getPM2();
                if (A1List.get(i).getPM2() != 0) countPM2 ++;

                PM1 = PM1 + A1List.get(i).getPM1();
                if (A1List.get(i).getPM1() != 0) countPM1 ++;

                SO2 = SO2 + A1List.get(i).getSO2();
                if (A1List.get(i).getSO2() != 0) countSO2 ++;

                NO = NO + A1List.get(i).getNO();
                if (A1List.get(i).getNO() != 0) countNO ++;

                NO2 = NO2 + A1List.get(i).getNO2();
                if (A1List.get(i).getNO2() != 0) countNO2 ++;

                PM10 = PM10 + A1List.get(i).getPM10();
                if (A1List.get(i).getPM10() != 0) countPM10 ++;

                NOx = NOx + A1List.get(i).getNOx();
                if (A1List.get(i).getNOx() != 0) countNOx ++;

                Ozono = Ozono + A1List.get(i).getOzono();
                if (A1List.get(i).getOzono() != 0) countOzono ++;
            }

        }
        //Media
        A1 a1 = new A1("A1MediaYear",
                PM2/countPM2,
                PM1/countPM2,
                SO2/countSO2,
                NO/countNO,
                NO2/countNO2,
                PM10/countPM10,
                NOx/countNOx,
                Ozono/countOzono);

        resetValues();
        return a1;
    }


    public static A1 getMediaMonth(final Context context,int MONTH,  int YEAR) {

        ArrayList<A1> A1List = Preferences.getA1List(context);

        for (int i = 0; i < A1List.size(); i++) {
            String date[] = A1List.get(i).getDate().split("/");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);

            if (year == YEAR && month == MONTH) {
                //TODO ACTIUONS
                PM2 = PM2 + A1List.get(i).getPM2();
                if (A1List.get(i).getPM2() != 0) countPM2 ++;

                PM1 = PM1 + A1List.get(i).getPM1();
                if (A1List.get(i).getPM1() != 0) countPM1 ++;

                SO2 = SO2 + A1List.get(i).getSO2();
                if (A1List.get(i).getSO2() != 0) countSO2 ++;

                NO = NO + A1List.get(i).getNO();
                if (A1List.get(i).getNO() != 0) countNO ++;

                NO2 = NO2 + A1List.get(i).getNO2();
                if (A1List.get(i).getNO2() != 0) countNO2 ++;

                PM10 = PM10 + A1List.get(i).getPM10();
                if (A1List.get(i).getPM10() != 0) countPM10 ++;

                NOx = NOx + A1List.get(i).getNOx();
                if (A1List.get(i).getNOx() != 0) countNOx ++;

                Ozono = Ozono + A1List.get(i).getOzono();
                if (A1List.get(i).getOzono() != 0) countOzono ++;
            }

        }
        //Media
        A1 a1 = new A1("A1MediaYear",
                PM2/countPM2,
                PM1/countPM2,
                SO2/countSO2,
                NO/countNO,
                NO2/countNO2,
                PM10/countPM10,
                NOx/countNOx,
                Ozono/countOzono);

        resetValues();
        return a1;
    }



    public static A1 getDay(final Context context,int DAY, int MONTH, int YEAR) {

        ArrayList<A1> A1List = Preferences.getA1List(context);

        for (int i = 0; i < A1List.size(); i++) {
            String date[] = A1List.get(i).getDate().split("/");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);

            if (day == DAY && month == MONTH && year == YEAR) {
                //TODO ACTIUONS
                PM2 = PM2 + A1List.get(i).getPM2();
                PM1 = PM1 + A1List.get(i).getPM1();
                SO2 = SO2 + A1List.get(i).getSO2();
                NO = NO + A1List.get(i).getNO();
                NO2 = NO2 + A1List.get(i).getNO2();
                PM10 = PM10 + A1List.get(i).getPM10();
                NOx = NOx + A1List.get(i).getNOx();
                Ozono = Ozono + A1List.get(i).getOzono();}

        }
        //Media
        A1 a1 = new A1("A1Day",
                PM2,
                PM1,
                SO2,
                NO,
                NO2,
                PM10,
                NOx,
                Ozono);

        resetValues();
        return a1;
    }

    private static void resetValues(){
        PM2 = 0;
        PM1 = 0;
        SO2 = 0;
        NO = 0;
        NO2 = 0;
        PM10 = 0;
        NOx = 0;
        Ozono = 0;

        countPM2 = 0;
        countPM1 = 0;
        countSO2 = 0;
        countNO = 0;
        countNO2 = 0;
        countPM10 = 0;
        countNOx = 0;
        countOzono = 0;
    }



}
