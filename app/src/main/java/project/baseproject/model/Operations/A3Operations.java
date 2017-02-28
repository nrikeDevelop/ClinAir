package project.baseproject.model.Operations;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import project.baseproject.common.Preferences;
import project.baseproject.model.Estautomaticas.A3;
import project.baseproject.model.Estautomaticas.A5;
import project.baseproject.model.StaticData;

/**
 * Created by susy on 21/02/17.
 */

public class A3Operations {


    static String TAG = "A3Operations";
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

    static int countPM2 = 0;
    static int countPM1 = 0;
    static int countSO2 = 0;
    static int countCO = 0;
    static int countNO = 0;
    static int countNO2 = 0;
    static int countPM10 = 0;
    static int countNOx = 0;
    static int countOzono = 0;



    public static void getData(final Context context) {
        Thread readThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    ArrayList A3List = new ArrayList();
                    int count = 0;

                    URL url = new URL(StaticData.getUrl_dataA3());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
                    String line = reader.readLine();
                    while (line != null) {
                        count = count + 1;
                        line = reader.readLine();
                        //Exit when finish
                        if (line == null) {
                            break;
                        }

                        line = line.replaceAll(",", ".");
                        try {

                            if (line != null) {

                                String[] lineCSV;
                                lineCSV = line.split(SPLIT_CSV);

                                //check empty values
                                for (int i = 0; i < lineCSV.length; i++) {
                                    if (lineCSV[i].isEmpty()) {
                                        lineCSV[i] = "0";
                                    }
                                }
                                if (lineCSV.length > 1) PM2 = Float.parseFloat(lineCSV[1]);
                                else PM2 = 0;
                                if (lineCSV.length > 2) PM1 = Float.parseFloat(lineCSV[2]);
                                else PM1 = 0;
                                if (lineCSV.length > 3) SO2 = Float.parseFloat(lineCSV[3]);
                                else SO2 = 0;
                                if (lineCSV.length > 4) CO = Float.parseFloat(lineCSV[4]);
                                else CO = 0;
                                if (lineCSV.length > 5) NO = Float.parseFloat(lineCSV[5]);
                                else NO = 0;
                                if (lineCSV.length > 6) NO2 = Float.parseFloat(lineCSV[6]);
                                else NO2 = 0;
                                if (lineCSV.length > 7) PM10 = Float.parseFloat(lineCSV[7]);
                                else PM10 = 0;
                                if (lineCSV.length > 8) NOx = Float.parseFloat(lineCSV[8]);
                                else NOx = 0;
                                if (lineCSV.length > 9) Ozono = Float.parseFloat(lineCSV[9]);
                                else Ozono = 0;

                                A3 a3 = new A3(lineCSV[0], PM2, PM1, SO2, CO, NO, NO2, PM10, NOx, Ozono);
                                A3List.add(a3);

                            }

                        } catch (Exception e) {
                            System.out.println("capturado error en el array A3Operations");
                        }
                    }
                    reader.close();

                    //SaveList
                    Preferences.setA3List(context, A3List);

                } catch (Exception e) {
                    Log.i(TAG, "Error en la lectura del archivo");
                }
            }
        });
        readThread.start();
    }

    public static A3 getMediaYear(final Context context, int YEAR){
        ArrayList<A3> A3List = Preferences.getA3List(context);

        for (int i = 0 ; i < A3List.size(); i++){
            String date[] =A3List.get(i).getDate().split("/");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);

            if(year == YEAR){
                //TODO ACTIUONS
                PM2 = PM2 + A3List.get(i).getPM2();
                if (A3List.get(i).getPM2() != 0) countPM2 ++;

                PM1 = PM1 + A3List.get(i).getPM1();
                if (A3List.get(i).getPM1() != 0) countPM1 ++;

                SO2 = SO2 + A3List.get(i).getSO2();
                if (A3List.get(i).getSO2() != 0) countSO2 ++;

                CO = CO + A3List.get(i).getCO();
                if (A3List.get(i).getCO() != 0) countCO ++;

                NO = NO + A3List.get(i).getNO();
                if (A3List.get(i).getNO() != 0) countNO ++;

                NO2 = NO2 + A3List.get(i).getNO2();
                if (A3List.get(i).getNO2() != 0) countNO2 ++;

                PM10 = PM10 + A3List.get(i).getPM10();
                if (A3List.get(i).getPM10() != 0) countPM10 ++;

                NOx = NOx + A3List.get(i).getNOx();
                if (A3List.get(i).getNOx() != 0) countNOx ++;

                Ozono = Ozono + A3List.get(i).getOzono();
                if (A3List.get(i).getOzono() != 0) countOzono ++;

            }

        }

        //Media
        A3 a3 = new A3("A3Media",
                PM2/countPM2,
                PM1/countPM1,
                SO2/countSO2,
                CO/countCO,
                NO/countNO,
                NO2/countNO2,
                PM10/countPM10,
                NOx/countNOx,
                Ozono/countOzono);


        resetValues();
        return a3;
    }

    public static A3 getMediaMonth(final Context context, int MONTH, int YEAR){
        ArrayList<A3> A3List = Preferences.getA3List(context);

        for (int i = 0 ; i < A3List.size(); i++){
            String date[] =A3List.get(i).getDate().split("/");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);

            if(month == MONTH && year == YEAR){
                //TODO ACTIUONS
                PM2 = PM2 + A3List.get(i).getPM2();
                if (A3List.get(i).getPM2() != 0) countPM2 ++;

                PM1 = PM1 + A3List.get(i).getPM1();
                if (A3List.get(i).getPM1() != 0) countPM1 ++;

                SO2 = SO2 + A3List.get(i).getSO2();
                if (A3List.get(i).getSO2() != 0) countSO2 ++;

                CO = CO + A3List.get(i).getCO();
                if (A3List.get(i).getCO() != 0) countCO ++;

                NO = NO + A3List.get(i).getNO();
                if (A3List.get(i).getNO() != 0) countNO ++;

                NO2 = NO2 + A3List.get(i).getNO2();
                if (A3List.get(i).getNO2() != 0) countNO2 ++;

                PM10 = PM10 + A3List.get(i).getPM10();
                if (A3List.get(i).getPM10() != 0) countPM10 ++;

                NOx = NOx + A3List.get(i).getNOx();
                if (A3List.get(i).getNOx() != 0) countNOx ++;

                Ozono = Ozono + A3List.get(i).getOzono();
                if (A3List.get(i).getOzono() != 0) countOzono ++;

            }

        }

        //Media
        A3 a3 = new A3("A3MediaMonth",
                PM2/countPM2,
                PM1/countPM1,
                SO2/countSO2,
                CO/countCO,
                NO/countNO,
                NO2/countNO2,
                PM10/countPM10,
                NOx/countNOx,
                Ozono/countOzono);


        resetValues();
        return a3;
    }

    public static A3 getDay(final Context context,int DAY, int MONTH, int YEAR){
        ArrayList<A3> A3List = Preferences.getA3List(context);

        for (int i = 0 ; i < A3List.size(); i++){
            String date[] =A3List.get(i).getDate().split("/");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);

            if(day == DAY &&month == MONTH && year == YEAR){
                //TODO ACTIUONS
                PM2 = PM2 + A3List.get(i).getPM2();
                PM1 = PM1 + A3List.get(i).getPM1();
                SO2 = SO2 + A3List.get(i).getSO2();
                CO = CO + A3List.get(i).getCO();
                NO = NO + A3List.get(i).getNO();
                NO2 = NO2 + A3List.get(i).getNO2();
                PM10 = PM10 + A3List.get(i).getPM10();
                NOx = NOx + A3List.get(i).getNOx();
                Ozono = Ozono + A3List.get(i).getOzono();
            }

        }

        //Media
        A3 a3 = new A3("A3Day",
                PM2,
                PM1,
                SO2,
                CO,
                NO,
                NO2,
                PM10,
                NOx,
                Ozono);


        resetValues();
        return a3;
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

        countPM2 = 0;
        countPM1 = 0;
        countSO2 = 0;
        countCO = 0;
        countNO = 0;
        countNO2 = 0;
        countPM10 = 0;
        countNOx = 0;
        countOzono = 0;


    }

}
