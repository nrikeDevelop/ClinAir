package project.baseproject.model.Operations;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import project.baseproject.common.Preferences;
import project.baseproject.model.Estautomaticas.A7;
import project.baseproject.model.StaticData;

/**
 * Created by susy on 20/02/17.
 */

public class A7Operations {

    static String TAG = "A7Operations";
    static String SPLIT_CSV = ";";

    static float SO2 = 0;
    static float NO = 0;
    static float NO2 = 0;
    static float PM10 = 0;
    static float Ni = 0;
    static float NOx = 0;
    static float Ozono = 0;
    static float As = 0;
    static float Pb = 0;
    static float BaP = 0;
    static float Cd = 0;

    static int countSO2 = 0;
    static int countNO = 0;
    static int countNO2 = 0;
    static int countPM10 = 0;
    static int countNi = 0;
    static int countNOx = 0;
    static int countOzono = 0;
    static int countAs = 0;
    static int countPb = 0;
    static int countBaP = 0;
    static int countCd = 0;


    public static void getData(final Context context){
        Thread readThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{

                    ArrayList A7List = new ArrayList();
                    int count = 0;

                    URL url = new URL(StaticData.getUrl_dataA7());
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

                                if (lineCSV.length > 1) SO2 = Float.parseFloat(lineCSV[1]) ; else SO2 = 0 ;
                                if (lineCSV.length > 2) NO = Float.parseFloat(lineCSV[2]) ; else NO = 0;
                                if (lineCSV.length > 3) NO2 = Float.parseFloat(lineCSV[3]) ; else NO2 = 0;
                                if (lineCSV.length > 4) PM10 = Float.parseFloat(lineCSV[4]) ; else PM10 = 0;
                                if (lineCSV.length > 5) Ni = Float.parseFloat(lineCSV[5]) ; else Ni = 0;
                                if (lineCSV.length > 6) NOx = Float.parseFloat(lineCSV[6]) ; else NOx = 0;
                                if (lineCSV.length > 7) Ozono = Float.parseFloat(lineCSV[7]) ; else Ozono = 0;
                                if (lineCSV.length > 8) As = Float.parseFloat(lineCSV[8]) ; else As = 0;
                                if (lineCSV.length > 9) Pb = Float.parseFloat(lineCSV[9]) ; else Pb = 0;
                                if (lineCSV.length > 10) BaP = Float.parseFloat(lineCSV[10]) ; else BaP = 0;
                                if (lineCSV.length > 11) Cd = Float.parseFloat(lineCSV[11]) ; else Cd = 0;

                                A7 a7 = new A7(lineCSV[0],SO2,NO,NO2,PM10,Ni,NOx,Ozono,As,Pb,BaP,Cd);
                                A7List.add(a7);
                            }

                        }catch (Exception e){
                            System.out.println("capturado error en el array A7 Operations");
                        }
                    }
                    reader.close();
                    //SaveList
                    Preferences.setA7List(context,A7List);

                }catch (Exception e){
                    Log.i(TAG,"Error en la lectura del archivo");
                }
            }
        });
        readThread.start();
    }

    public static A7 getMediaYear(final Context context, int YEAR){


        ArrayList<A7> A7List = Preferences.getA7List(context);

        for (int i = 0 ; i < A7List.size(); i++){
            String date[] =A7List.get(i).getDate().split("/");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);

            if(year == YEAR){
                //TODO ACTIUONS
                SO2 = SO2 + A7List.get(i).getS02();
                if (A7List.get(i).getS02() != 0) countSO2 ++;

                NO = NO + A7List.get(i).getNO();
                if (A7List.get(i).getNO() != 0) countNO ++;

                NO2 = NO2 + A7List.get(i).getNO2();
                if (A7List.get(i).getNO2() != 0) countNO2 ++;

                PM10 = PM10 + A7List.get(i).getPM10();
                if (A7List.get(i).getPM10() != 0) countPM10 ++;

                Ni = Ni + A7List.get(i).getNi();
                if (A7List.get(i).getNi() != 0) countNi ++;

                NOx = NOx + A7List.get(i).getNOx();
                if (A7List.get(i).getNOx() != 0) countNOx ++;

                Ozono = Ozono + A7List.get(i).getOzono();
                if (A7List.get(i).getOzono() != 0) countOzono ++;

                As = As + A7List.get(i).getAs();
                if (A7List.get(i).getAs() != 0) countAs ++;

                Pb = Pb + A7List.get(i).getPb();
                if (A7List.get(i).getPb() != 0) countPb ++;

                BaP = BaP + A7List.get(i).getBaP();
                if (A7List.get(i).getBaP() != 0) countBaP ++;

                Cd = Cd + A7List.get(i).getCd();
                if (A7List.get(i).getCd() != 0) countCd ++;
            }
        }

        //Media
        A7 a7 = new A7("A7MediaYear",
                SO2/countSO2,
                NO/countNO,
                NO2/countNO2,
                PM10/countPM10,
                Ni/countNi,
                NOx/countNOx,
                Ozono/countOzono,
                As/countAs,
                Pb/countPb,
                BaP/countBaP,
                Cd/countCd);
        resetValues();
        return a7;
    }

    public static A7 getMediaMonth(final Context context, int MONTH, int YEAR){


        ArrayList<A7> A7List = Preferences.getA7List(context);

        for (int i = 0 ; i < A7List.size(); i++){
            String date[] =A7List.get(i).getDate().split("/");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);

            if(month == MONTH && year == YEAR){
                //TODO ACTIUONS
                SO2 = SO2 + A7List.get(i).getS02();
                if (A7List.get(i).getS02() != 0) countSO2 ++;

                NO = NO + A7List.get(i).getNO();
                if (A7List.get(i).getNO() != 0) countNO ++;

                NO2 = NO2 + A7List.get(i).getNO2();
                if (A7List.get(i).getNO2() != 0) countNO2 ++;

                PM10 = PM10 + A7List.get(i).getPM10();
                if (A7List.get(i).getPM10() != 0) countPM10 ++;

                Ni = Ni + A7List.get(i).getNi();
                if (A7List.get(i).getNi() != 0) countNi ++;

                NOx = NOx + A7List.get(i).getNOx();
                if (A7List.get(i).getNOx() != 0) countNOx ++;

                Ozono = Ozono + A7List.get(i).getOzono();
                if (A7List.get(i).getOzono() != 0) countOzono ++;

                As = As + A7List.get(i).getAs();
                if (A7List.get(i).getAs() != 0) countAs ++;

                Pb = Pb + A7List.get(i).getPb();
                if (A7List.get(i).getPb() != 0) countPb ++;

                BaP = BaP + A7List.get(i).getBaP();
                if (A7List.get(i).getBaP() != 0) countBaP ++;

                Cd = Cd + A7List.get(i).getCd();
                if (A7List.get(i).getCd() != 0) countCd ++;
            }
        }

        //Media
        A7 a7 = new A7("A7MontMedia",
                SO2/countSO2,
                NO/countNO,
                NO2/countNO2,
                PM10/countPM10,
                Ni/countNi,
                NOx/countNOx,
                Ozono/countOzono,
                As/countAs,
                Pb/countPb,
                BaP/countBaP,
                Cd/countCd);
        resetValues();
        return a7;
    }

    public static A7 getDay(final Context context,int DAY, int MONTH, int YEAR){


        ArrayList<A7> A7List = Preferences.getA7List(context);

        for (int i = 0 ; i < A7List.size(); i++){
            String date[] =A7List.get(i).getDate().split("/");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);

            if(day == DAY && month == MONTH && year == YEAR){
                //TODO ACTIUONS
                SO2 = SO2 + A7List.get(i).getS02();
                NO = NO + A7List.get(i).getNO();
                NO2 = NO2 + A7List.get(i).getNO2();
                PM10 = PM10 + A7List.get(i).getPM10();
                Ni = Ni + A7List.get(i).getNi();
                NOx = NOx + A7List.get(i).getNOx();
                Ozono = Ozono + A7List.get(i).getOzono();
                As = As + A7List.get(i).getAs();
                Pb = Pb + A7List.get(i).getPb();
                BaP = BaP + A7List.get(i).getBaP();
                Cd = Cd + A7List.get(i).getCd();}
        }

        //Media
        A7 a7 = new A7("media",
                SO2,
                NO,
                NO2,
                PM10,
                Ni,
                NOx,
                Ozono,
                As,
                Pb,
                BaP,
                Cd);
        resetValues();
        return a7;
    }



    private static void resetValues(){
        SO2 = 0;
        NO = 0;
        NO2 = 0;
        PM10 = 0;
        Ni = 0;
        NOx = 0;
        Ozono = 0;
        As = 0;
        Pb = 0;
        BaP = 0;
        Cd = 0;
    }

}
