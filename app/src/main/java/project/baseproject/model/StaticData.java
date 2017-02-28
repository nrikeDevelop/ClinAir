package project.baseproject.model;

import android.os.Environment;

/**
 * Created by susy on 14/02/17.
 */
public class StaticData {

    public static String url_dataSensorsCSV = "http://mapas.valencia.es/lanzadera/opendata/Estautomaticas/CSV";
    public static String getUrl_dataSensorsCSV() {return url_dataSensorsCSV;}

    public static String url_dataA1 = "http://mapas.valencia.es/WebsMunicipales/uploads/atmosferica/1A.csv";
    public static String getUrl_dataA1() {
        return url_dataA1;
    }

    public static String url_dataA3 = "http://mapas.valencia.es/WebsMunicipales/uploads/atmosferica/3A.csv";
    public static String getUrl_dataA3() {
        return url_dataA3;
    }

    public static String url_dataA4 = "http://mapas.valencia.es/WebsMunicipales/uploads/atmosferica/4A.csv";
    public static String getUrl_dataA4() {
        return url_dataA4;
    }

    public static String url_dataA5 = "http://mapas.valencia.es/WebsMunicipales/uploads/atmosferica/5A.csv";
    public static String getUrl_dataA5() {
        return url_dataA5;
    }

    public static String url_dataA6 = "http://mapas.valencia.es/WebsMunicipales/uploads/atmosferica/6A.csv";
    public static String getUrl_dataA6() {
        return url_dataA6;
    }

    public static String url_dataA7 = "http://mapas.valencia.es/WebsMunicipales/uploads/atmosferica/7A.csv";
    public static String getUrl_dataA7() {
        return url_dataA7;
    }


    //PATH_FOLDER
    static String name_folder = "datathon";
    public static String  path_folder = Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+name_folder;

    public static String getPath_folder() {
        return path_folder;
    }

}