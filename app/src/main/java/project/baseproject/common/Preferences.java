package project.baseproject.common;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import project.baseproject.model.Estautomaticas.A1;
import project.baseproject.model.Estautomaticas.A3;
import project.baseproject.model.Estautomaticas.A4;
import project.baseproject.model.Estautomaticas.A5;
import project.baseproject.model.Estautomaticas.A6;
import project.baseproject.model.Estautomaticas.A7;

public class Preferences {

    static final String PREFERENCES = "PROJECT_BASE";

    public static void setDataObject(Context context, String data) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(data, "data_object");
        editor.commit();
    }

    public static String getDataObject(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES, context.MODE_PRIVATE);
        return preferences.getString("data_object", "not_data");
    }

    public static void setDataRequest(Context context, boolean bool) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("data_request", bool);
        editor.commit();
    }

    public static boolean getDataRequest(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES, context.MODE_PRIVATE);
        return preferences.getBoolean("data_request", false);
    }

    public static void setPermissions(Context context, boolean permission) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("permission", permission);
        editor.commit();
    }

    public static boolean getPermissions(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES, context.MODE_PRIVATE);
        return preferences.getBoolean("permission", false);
    }

    public static void setA1List(Context context, ArrayList<A1> A1csvList) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("object_csvA1", new Gson().toJson(A1csvList));
        editor.commit();
    }

    public static ArrayList<A1> getA1List(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES, context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = preferences.getString("object_csvA1", null);
        Type type = new TypeToken<ArrayList<A1>>() {}.getType();
        ArrayList<A1> arrayList = gson.fromJson(json, type);
        return arrayList;
    }

    public static void setA3List(Context context, ArrayList<A3> A3csvList) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("object_csvA3", new Gson().toJson(A3csvList));
        editor.commit();
    }

    public static ArrayList<A3> getA3List(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES, context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = preferences.getString("object_csvA3", null);
        Type type = new TypeToken<ArrayList<A3>>() {}.getType();
        ArrayList<A3> arrayList = gson.fromJson(json, type);
        return arrayList;
    }

    public static void setA4List(Context context, ArrayList<A4> A4csvList) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("object_csvA4", new Gson().toJson(A4csvList));
        editor.commit();
    }

    public static ArrayList<A4> getA4List(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES, context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = preferences.getString("object_csvA4", null);
        Type type = new TypeToken<ArrayList<A4>>() {}.getType();
        ArrayList<A4> arrayList = gson.fromJson(json, type);
        return arrayList;
    }

    public static void setA5List(Context context, ArrayList<A5> A5csvList) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("object_csvA5", new Gson().toJson(A5csvList));
        editor.commit();
    }

    public static ArrayList<A5> getA5List(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES, context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = preferences.getString("object_csvA5", null);
        Type type = new TypeToken<ArrayList<A5>>() {}.getType();
        ArrayList<A5> arrayList = gson.fromJson(json, type);
        return arrayList;
    }

    public static void setA6List(Context context, ArrayList<A6> A6csvList) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("object_csvA6", new Gson().toJson(A6csvList));
        editor.commit();
    }

    public static ArrayList<A6> getA6List(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES, context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = preferences.getString("object_csvA6", null);
        Type type = new TypeToken<ArrayList<A6>>() {}.getType();
        ArrayList<A6> arrayList = gson.fromJson(json, type);
        return arrayList;
    }

    public static void setA7List(Context context, ArrayList<A7> A7csvList) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("object_csvA7", new Gson().toJson(A7csvList));
        editor.commit();
    }

    public static ArrayList<A7> getA7List(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES, context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = preferences.getString("object_csvA7", null);
        Type type = new TypeToken<ArrayList<A7>>() {}.getType();
        ArrayList<A7> arrayList = gson.fromJson(json, type);
        return arrayList;
    }

    public static void setLastQuery(Context context, String query) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(query,"last_query");
        editor.commit();
    }

    public static String getLastQuery(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES, context.MODE_PRIVATE);
        return preferences.getString("last_query", "not_data");
    }

}
