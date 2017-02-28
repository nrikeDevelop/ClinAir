package project.baseproject.model.Operations;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import project.baseproject.common.Preferences;
import project.baseproject.model.Estautomaticas.A5;
import project.baseproject.model.StaticData;

/**
 * Created by susy on 20/02/17.
 */

public class A5Operations {

    static String TAG = "A5Operations";
    static String SPLIT_CSV = ";";

    static float PM2 = 0;
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
    static float Ruido = 0;


    static int countPM2 = 0;
    static int countSO2 = 0;
    static int countN0 = 0;
    static int countN02 = 0;
    static int countPM10 = 0;
    static int countNi = 0;
    static int countNOx = 0;
    static int countOzono = 0;
    static int countAs = 0;
    static int countPb = 0;
    static int countBaP = 0;
    static int countCd = 0;
    static int countRuido = 0;


    public static void getData(final Context context){
        Thread readThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{

                    ArrayList A5List = new ArrayList();
                    int count = 0;

                    URL url = new URL(StaticData.getUrl_dataA5());
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
                                if (lineCSV.length > 2) SO2 = Float.parseFloat(lineCSV[2]) ; else SO2 = 0 ;
                                if (lineCSV.length > 3) NO = Float.parseFloat(lineCSV[3]) ; else NO = 0;
                                if (lineCSV.length > 4) NO2 = Float.parseFloat(lineCSV[4]) ; else NO2 = 0;
                                if (lineCSV.length > 5) PM10 = Float.parseFloat(lineCSV[5]) ; else PM10 = 0;
                                if (lineCSV.length > 6) Ni = Float.parseFloat(lineCSV[6]) ; else Ni = 0;
                                if (lineCSV.length > 7) NOx = Float.parseFloat(lineCSV[7]) ; else NOx = 0;
                                if (lineCSV.length > 8) Ozono = Float.parseFloat(lineCSV[8]) ; else Ozono = 0;
                                if (lineCSV.length > 9) As = Float.parseFloat(lineCSV[9]) ; else As = 0;
                                if (lineCSV.length > 10) Pb = Float.parseFloat(lineCSV[10]) ; else Pb = 0;
                                if (lineCSV.length > 11) BaP = Float.parseFloat(lineCSV[11]) ; else BaP = 0;
                                if (lineCSV.length > 12) Cd = Float.parseFloat(lineCSV[12]); else Cd = 0;
                                if (lineCSV.length > 13) Ruido = Float.parseFloat(lineCSV[13]); else Ruido = 0;

                                A5 a5 = new A5(lineCSV[0],PM2,SO2,NO,NO2,PM10,Ni,NOx,Ozono,As,Pb,BaP,Cd,Ruido);
                                A5List.add(a5);

                            }

                        }catch (Exception e){
                            System.out.println("capturado error en el array A5 Operations");
                        }
                    }
                    reader.close();

                    //SaveList
                    Preferences.setA5List(context,A5List);

                }catch (Exception e){
                    Log.i(TAG,"Error en la lectura del archivo");
                }
            }
        });
        readThread.start();
    }

    public static A5 getMediaYear(final Context context, int YEAR) {

        ArrayList<A5> A5List = Preferences.getA5List(context);

        for (int i = 0; i < A5List.size(); i++) {
            String date[] = A5List.get(i).getDate().split("/");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);

            if (year == YEAR) {
                //TODO ACTIUONS
                PM2 = PM2 + A5List.get(i).getPM2();
                if (A5List.get(i).getPM2() != 0) countPM2++;

                SO2 = SO2 + A5List.get(i).getSO2();
                if (A5List.get(i).getSO2() != 0) countSO2++;

                NO = NO + A5List.get(i).getNO();
                if (A5List.get(i).getNO() != 0) countN0++;

                NO2 = NO2 + A5List.get(i).getNO2();
                if (A5List.get(i).getNO2() != 0) countN02++;

                PM10 = PM10 + A5List.get(i).getPM10();
                if (A5List.get(i).getPM10() != 0) countPM10++;

                Ni = Ni + A5List.get(i).getNi();
                if (A5List.get(i).getNi() != 0) countNi++;

                NOx = NOx + A5List.get(i).getNOx();
                if (A5List.get(i).getNOx() != 0) countNOx++;

                Ozono = Ozono + A5List.get(i).getOzono();
                if (A5List.get(i).getOzono() != 0) countOzono++;

                As = As + A5List.get(i).getAs();
                if (A5List.get(i).getAs() != 0) countAs++;

                Pb = Pb + A5List.get(i).getPb();
                if (A5List.get(i).getPb() != 0) countPb++;

                BaP = BaP + A5List.get(i).getBaP();
                if (A5List.get(i).getBaP() != 0) countBaP++;

                Cd = Cd + A5List.get(i).getCd();
                if (A5List.get(i).getCd() != 0) countCd++;

                Ruido = Ruido + A5List.get(i).getRuido();
                if (A5List.get(i).getRuido() != 0) countRuido++;

            }

        }
        //Media
        A5 a5 = new A5("A5mediaYear",
                PM2/countPM2,
                SO2/countSO2,
                NO/countN0,
                NO2/countN02,
                PM10/countPM10,
                Ni/countNi,
                NOx/countNOx,
                Ozono/countOzono,
                As/countAs,
                Pb/countPb,
                BaP/countBaP,
                Cd/countCd,
                Ruido/countRuido);

        resetValues();
        return a5;
    }

    public static A5 getMediaMonth(final Context context, int MONTH , int YEAR) {

        ArrayList<A5> A5List = Preferences.getA5List(context);

        for (int i = 0; i < A5List.size(); i++) {
            String date[] = A5List.get(i).getDate().split("/");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);

            if (year == YEAR && month == MONTH) {

                System.out.println("fecha "+A5List.get(i).getDate());
                //TODO ACTIUONS
                PM2 = PM2 + A5List.get(i).getPM2();
                if (A5List.get(i).getPM2() != 0) countPM2++;

                SO2 = SO2 + A5List.get(i).getSO2();
                if (A5List.get(i).getSO2() != 0) countSO2++;

                NO = NO + A5List.get(i).getNO();
                if (A5List.get(i).getNO() != 0) countN0++;

                NO2 = NO2 + A5List.get(i).getNO2();
                if (A5List.get(i).getNO2() != 0) countN02++;

                PM10 = PM10 + A5List.get(i).getPM10();
                if (A5List.get(i).getPM10() != 0) countPM10++;

                Ni = Ni + A5List.get(i).getNi();
                if (A5List.get(i).getNi() != 0) countNi++;

                NOx = NOx + A5List.get(i).getNOx();
                if (A5List.get(i).getNOx() != 0) countNOx++;

                Ozono = Ozono + A5List.get(i).getOzono();
                if (A5List.get(i).getOzono() != 0) countOzono++;

                As = As + A5List.get(i).getAs();
                if (A5List.get(i).getAs() != 0) countAs++;

                Pb = Pb + A5List.get(i).getPb();
                if (A5List.get(i).getPb() != 0) countPb++;

                BaP = BaP + A5List.get(i).getBaP();
                if (A5List.get(i).getBaP() != 0) countBaP++;

                Cd = Cd + A5List.get(i).getCd();
                if (A5List.get(i).getCd() != 0) countCd++;

                Ruido = Ruido + A5List.get(i).getRuido();
                if (A5List.get(i).getRuido() != 0) countRuido++;
            }

        }
        //Media
        A5 a5 = new A5("A5mediaMonth",
                PM2/countPM2,
                SO2/countSO2,
                NO/countN0,
                NO2/countN02,
                PM10/countPM10,
                Ni/countNi,
                NOx/countNOx,
                Ozono/countOzono,
                As/countAs,
                Pb/countPb,
                BaP/countBaP,
                Cd/countCd,
                Ruido/countRuido);

        resetValues();
        return a5;
    }

    public static A5 getDay(final Context context,int DAY, int MONTH , int YEAR) {

        ArrayList<A5> A5List = Preferences.getA5List(context);

        for (int i = 0; i < A5List.size(); i++) {
            String date[] = A5List.get(i).getDate().split("/");
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);

            if (day == DAY && month == MONTH && year == YEAR ) {
                //TODO ACTIUONS
                PM2 = PM2 + A5List.get(i).getPM2();
                SO2 = SO2 + A5List.get(i).getSO2();
                NO = NO + A5List.get(i).getNO();
                NO2 = NO2 + A5List.get(i).getNO2();
                PM10 = PM10 + A5List.get(i).getPM10();
                Ni = Ni + A5List.get(i).getNi();
                NOx = NOx + A5List.get(i).getNOx();
                Ozono = Ozono + A5List.get(i).getOzono();
                As = As + A5List.get(i).getAs();
                Pb = Pb + A5List.get(i).getPb();
                BaP = BaP + A5List.get(i).getBaP();
                Cd = Cd + A5List.get(i).getCd();
                Ruido = Ruido + A5List.get(i).getRuido();
            }

        }
        //Media
        A5 a5 = new A5("A5Day",
                PM2,
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
                Cd,
                Ruido);

        resetValues();
        return a5;
    }

    private static void resetValues(){
        PM2 = 0;
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
        Ruido = 0;

        countPM2 = 0;
        countSO2 = 0;
        countN0 = 0;
        countN02 = 0;
        countPM10 = 0;
        countNi = 0;
        countNOx = 0;
        countOzono = 0;
        countAs = 0;
        countPb = 0;
        countBaP = 0;
        countCd = 0;
        countRuido = 0;
    }
}
