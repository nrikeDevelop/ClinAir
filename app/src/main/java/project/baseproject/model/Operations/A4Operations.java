package project.baseproject.model.Operations;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import project.baseproject.common.Preferences;
import project.baseproject.model.Estautomaticas.A4;
import project.baseproject.model.Estautomaticas.A5;
import project.baseproject.model.StaticData;

/**
 * Created by susy on 20/02/17.
 */

public class A4Operations {

    static String TAG = "A4Operations";
    static String SPLIT_CSV = ";";

    static float light;
    static float PM2;
    static float PM1;
    static float Xileno;
    static float SO2;
    static float CO;
    static float NO;
    static float NO2;
    static float PM10;
    static float NOx;
    static float Ozono;
    static float Tolueno;
    static float Benzeno;
    static float Ruido;
    static float vel;
    static float temp;
    static float hreal;
    static float pres;

    static int countlight = 0;
    static int countPM2 = 0;
    static int countPM1 = 0;
    static int countXileno = 0;
    static int countSO2 = 0;
    static int countCO = 0;
    static int countNO = 0;
    static int countNO2 = 0;
    static int countPM10 = 0;
    static int countNOx = 0;
    static int countOzono = 0;
    static int countTolueno = 0;
    static int countBenzeno = 0;
    static int countRuido = 0;
    static int countVel = 0;
    static int countTemp = 0;
    static int countHreal = 0;

    public static void getData(final Context context){
        Thread readThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{

                    ArrayList A4List = new ArrayList();
                    int count = 0;

                    URL url = new URL(StaticData.getUrl_dataA4());
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

                                //Clean Line
                                line = line.replaceAll(" ","");
                                line = line.replaceAll(" ","");
                                line = line.replaceAll(" ","");

                                lineCSV =line.split(SPLIT_CSV);

                                //check empty values
                                for (int i = 0; i < lineCSV.length ; i++){
                                    if(lineCSV[i].isEmpty()){
                                        lineCSV[i] = "0";
                                    }
                                }

                                if (lineCSV.length > 1) light = Float.parseFloat(lineCSV[1]) ; else light = 0 ;
                                if (lineCSV.length > 2) PM2 = Float.parseFloat(lineCSV[2]) ; else PM2 = 0 ;
                                if (lineCSV.length > 3) PM1 = Float.parseFloat(lineCSV[3]) ; else PM1 = 0 ;
                                if (lineCSV.length > 4) Xileno = Float.parseFloat(lineCSV[4]) ; else Xileno = 0 ;
                                if (lineCSV.length > 5) SO2 = Float.parseFloat(lineCSV[5]) ; else SO2 = 0 ;
                                if (lineCSV.length > 6) CO = Float.parseFloat(lineCSV[6]) ; else CO = 0;
                                if (lineCSV.length > 7) NO = Float.parseFloat(lineCSV[7]) ; else NO = 0;
                                if (lineCSV.length > 8) NO2 = Float.parseFloat(lineCSV[8]) ; else NO2 = 0;
                                if (lineCSV.length > 9) PM10 = Float.parseFloat(lineCSV[9]) ; else PM10 = 0;
                                if (lineCSV.length > 10) NOx = Float.parseFloat(lineCSV[10]) ; else NOx = 0;
                                if (lineCSV.length > 11) Ozono = Float.parseFloat(lineCSV[11]) ; else Ozono = 0;
                                if (lineCSV.length > 12) Tolueno = Float.parseFloat(lineCSV[12]) ; else Tolueno = 0;
                                if (lineCSV.length > 13) Benzeno = Float.parseFloat(lineCSV[13]) ; else Benzeno = 0;
                                if (lineCSV.length > 14) Ruido = Float.parseFloat(lineCSV[14]) ; else Ruido = 0;
                                if (lineCSV.length > 15) vel = Float.parseFloat(lineCSV[15]) ; else vel = 0;
                                if (lineCSV.length > 16) temp = Float.parseFloat(lineCSV[16]) ; else temp = 0;
                                if (lineCSV.length > 17) hreal = Float.parseFloat(lineCSV[17]) ; else hreal = 0;
                                if (lineCSV.length > 18) pres = Float.parseFloat(lineCSV[18]) ; else pres = 0;

                                A4 a4 = new A4(lineCSV[0],
                                        light,
                                        PM2,
                                        PM1,
                                        Xileno,
                                        SO2,
                                        CO,
                                        NO,
                                        NO2,
                                        PM10,
                                        NOx,
                                        Ozono,
                                        Tolueno,
                                        Benzeno,
                                        Ruido,
                                        vel,
                                        temp,
                                        hreal,
                                        pres);

                                A4List.add(a4);

                            }

                        }catch (Exception e){
                            System.out.println("capturado error en el array A4 Operations");
                        }
                    }
                    reader.close();

                    //SaveList
                    Preferences.setA4List(context,A4List);

                }catch (Exception e){
                    Log.i(TAG,"Error en la lectura del archivo");
                }
            }
        });
        readThread.start();
    }


    public static A4 getMediaYear(final Context context, int YEAR){

        int countPres = 0;

        ArrayList<A4> A4List = Preferences.getA4List(context);

        for (int i = 0 ; i < A4List.size(); i++){
            String date[] =A4List.get(i).getDate().split("/");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);

            if(year == YEAR){
                //TODO ACTIUONS

                light = light + A4List.get(i).getLight();
                if (A4List.get(i).getLight() != 0) countlight ++;

                PM2 = PM2 + A4List.get(i).getPM2();
                if (A4List.get(i).getPM2() != 0) countPM2 ++;

                PM1 = PM1 + A4List.get(i).getPM1();
                if (A4List.get(i).getPM1() != 0) countPM1 ++;

                Xileno = Xileno + A4List.get(i).getXileno();
                if (A4List.get(i).getXileno() != 0) countXileno ++;

                SO2 = SO2 + A4List.get(i).getSO2();
                if (A4List.get(i).getSO2() != 0) countSO2 ++;

                CO = CO + A4List.get(i).getCO();
                if (A4List.get(i).getCO() != 0) countCO ++;

                NO = NO + A4List.get(i).getNO();
                if (A4List.get(i).getNO() != 0) countNO ++;

                NO2 = NO2 + A4List.get(i).getNO2();
                if (A4List.get(i).getNO2() != 0) countNO2 ++;

                PM10 = PM10 + A4List.get(i).getPM10();
                if (A4List.get(i).getPM10() != 0) countPM10 ++;

                NOx = NOx + A4List.get(i).getNOx();
                if (A4List.get(i).getNOx() != 0) countNOx ++;

                Ozono = Ozono + A4List.get(i).getOzono();
                if (A4List.get(i).getOzono() != 0) countOzono ++;

                Tolueno = Tolueno + A4List.get(i).getTolueno();
                if (A4List.get(i).getTolueno() != 0) countTolueno ++;

                Benzeno = Benzeno + A4List.get(i).getBenzeno();
                if (A4List.get(i).getBenzeno() != 0) countBenzeno ++;

                Ruido = Ruido + A4List.get(i).getRuido();
                if (A4List.get(i).getRuido() != 0) countRuido ++;

                vel = vel + A4List.get(i).getVel();
                if (A4List.get(i).getVel() != 0) countVel ++;

                temp = temp + A4List.get(i).getTemp();
                if (A4List.get(i).getTemp() != 0) countTemp ++;

                hreal = hreal + A4List.get(i).getHreal();
                if (A4List.get(i).getHreal() != 0) countHreal ++;

                pres = pres + A4List.get(i).getPres();
                if (A4List.get(i).getPres() != 0) countPres ++;

            }

        }

        A4 a4 = new A4("A4MediaYear",
                light/countlight,
                PM2/countPM2,
                PM1/countPM1,
                Xileno/countXileno,
                SO2/countSO2,
                CO/countCO,
                NO/countNO,
                NO2/countNO2,
                PM10/countPM10,
                NOx/countNOx,
                Ozono/countOzono,
                Tolueno/countTolueno,
                Benzeno/countBenzeno,
                Ruido/countRuido,
                vel/countVel,
                temp/countTemp,
                hreal/countHreal,
                pres/countPres);

        resetValues();
        return a4;
    }

    public static A4 getMediaMonth(final Context context, int MONTH, int YEAR){

        int countPres = 0;

        ArrayList<A4> A4List = Preferences.getA4List(context);

        for (int i = 0 ; i < A4List.size(); i++){
            String date[] =A4List.get(i).getDate().split("/");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);

            if(month == MONTH && year == YEAR){
                //TODO ACTIUONS

                light = light + A4List.get(i).getLight();
                if (A4List.get(i).getLight() != 0) countlight ++;

                PM2 = PM2 + A4List.get(i).getPM2();
                if (A4List.get(i).getPM2() != 0) countPM2 ++;

                PM1 = PM1 + A4List.get(i).getPM1();
                if (A4List.get(i).getPM1() != 0) countPM1 ++;

                Xileno = Xileno + A4List.get(i).getXileno();
                if (A4List.get(i).getXileno() != 0) countXileno ++;

                SO2 = SO2 + A4List.get(i).getSO2();
                if (A4List.get(i).getSO2() != 0) countSO2 ++;

                CO = CO + A4List.get(i).getCO();
                if (A4List.get(i).getCO() != 0) countCO ++;

                NO = NO + A4List.get(i).getNO();
                if (A4List.get(i).getNO() != 0) countNO ++;

                NO2 = NO2 + A4List.get(i).getNO2();
                if (A4List.get(i).getNO2() != 0) countNO2 ++;

                PM10 = PM10 + A4List.get(i).getPM10();
                if (A4List.get(i).getPM10() != 0) countPM10 ++;

                NOx = NOx + A4List.get(i).getNOx();
                if (A4List.get(i).getNOx() != 0) countNOx ++;

                Ozono = Ozono + A4List.get(i).getOzono();
                if (A4List.get(i).getOzono() != 0) countOzono ++;

                Tolueno = Tolueno + A4List.get(i).getTolueno();
                if (A4List.get(i).getTolueno() != 0) countTolueno ++;

                Benzeno = Benzeno + A4List.get(i).getBenzeno();
                if (A4List.get(i).getBenzeno() != 0) countBenzeno ++;

                Ruido = Ruido + A4List.get(i).getRuido();
                if (A4List.get(i).getRuido() != 0) countRuido ++;

                vel = vel + A4List.get(i).getVel();
                if (A4List.get(i).getVel() != 0) countVel ++;

                temp = temp + A4List.get(i).getTemp();
                if (A4List.get(i).getTemp() != 0) countTemp ++;

                hreal = hreal + A4List.get(i).getHreal();
                if (A4List.get(i).getHreal() != 0) countHreal ++;

                pres = pres + A4List.get(i).getPres();
                if (A4List.get(i).getPres() != 0) countPres ++;

            }

        }

        A4 a4 = new A4("A4MediaMonth",
                light/countlight,
                PM2/countPM2,
                PM1/countPM1,
                Xileno/countXileno,
                SO2/countSO2,
                CO/countCO,
                NO/countNO,
                NO2/countNO2,
                PM10/countPM10,
                NOx/countNOx,
                Ozono/countOzono,
                Tolueno/countTolueno,
                Benzeno/countBenzeno,
                Ruido/countRuido,
                vel/countVel,
                temp/countTemp,
                hreal/countHreal,
                pres/countPres);

        resetValues();
        return a4;
    }

    public static A4 getDay(final Context context, int DAY, int MONTH, int YEAR){

        int countPres = 0;

        ArrayList<A4> A4List = Preferences.getA4List(context);

        for (int i = 0 ; i < A4List.size(); i++){
            String date[] =A4List.get(i).getDate().split("/");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);

            if(day == DAY && month == MONTH && year == YEAR){
                //TODO ACTIUONS

                light = light + A4List.get(i).getLight();
                PM2 = PM2 + A4List.get(i).getPM2();
                PM1 = PM1 + A4List.get(i).getPM1();
                Xileno = Xileno + A4List.get(i).getXileno();
                SO2 = SO2 + A4List.get(i).getSO2();
                CO = CO + A4List.get(i).getCO();
                NO = NO + A4List.get(i).getNO();
                NO2 = NO2 + A4List.get(i).getNO2();
                PM10 = PM10 + A4List.get(i).getPM10();
                NOx = NOx + A4List.get(i).getNOx();
                Ozono = Ozono + A4List.get(i).getOzono();
                Tolueno = Tolueno + A4List.get(i).getTolueno();
                Benzeno = Benzeno + A4List.get(i).getBenzeno();
                Ruido = Ruido + A4List.get(i).getRuido();
                vel = vel + A4List.get(i).getVel();
                temp = temp + A4List.get(i).getTemp();
                hreal = hreal + A4List.get(i).getHreal();
                pres = pres + A4List.get(i).getPres();
            }

        }

        A4 a4 = new A4("A4Day",
                light,
                PM2,
                PM1,
                Xileno,
                SO2,
                CO,
                NO,
                NO2,
                PM10,
                NOx,
                Ozono,
                Tolueno,
                Benzeno,
                Ruido,
                vel,
                temp,
                hreal,
                pres);

        resetValues();
        return a4;
    }



    private static void resetValues(){
        light = 0;
        PM2 = 0;
        PM1 = 0;
        Xileno = 0;
        SO2 = 0;
        CO = 0;
        NO = 0;
        NO2 = 0;
        PM10 = 0;
        NOx = 0;
        Ozono = 0;
        Tolueno = 0;
        Benzeno = 0;
        Ruido = 0;
        vel = 0;
        temp = 0;
        hreal = 0;
        pres = 0;

        countlight = 0;
        countPM2 = 0;
        countPM1 = 0;
        countXileno = 0;
        countSO2 = 0;
        countCO = 0;
        countNO = 0;
        countNO2 = 0;
        countPM10 = 0;
        countNOx = 0;
        countOzono = 0;
        countTolueno = 0;
        countBenzeno = 0;
        countRuido = 0;
        countVel = 0;
        countTemp = 0;
        countHreal = 0;



    }


}
