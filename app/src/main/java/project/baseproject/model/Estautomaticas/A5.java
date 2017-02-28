package project.baseproject.model.Estautomaticas;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by susy on 14/02/17.
 */

public class A5 {

    String place = "39.4805623;-0.367704099999969";
    String date;
    float PM2;
    float SO2;
    float NO;
    float NO2;
    float PM10;
    float Ni;
    float NOx;
    float Ozono;
    float As;
    float Pb;
    float BaP;
    float Cd;
    float Ruido;


    public A5(String date, float PM2, float SO2, float NO, float NO2, float PM10, float ni, float NOx, float ozono, float as, float pb, float baP, float cd, float ruido) {
        this.date = date;
        this.PM2 = PM2;
        this.SO2 = SO2;
        this.NO = NO;
        this.NO2 = NO2;
        this.PM10 = PM10;
        Ni = ni;
        this.NOx = NOx;
        Ozono = ozono;
        As = as;
        Pb = pb;
        BaP = baP;
        Cd = cd;
        Ruido = ruido;
    }

    public A5() {
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getPM2() {
        return PM2;
    }

    public void setPM2(float PM2) {
        this.PM2 = PM2;
    }

    public float getSO2() {
        return SO2;
    }

    public void setSO2(float SO2) {
        this.SO2 = SO2;
    }

    public float getNO() {
        return NO;
    }

    public void setNO(float NO) {
        this.NO = NO;
    }

    public float getNO2() {
        return NO2;
    }

    public void setNO2(float NO2) {
        this.NO2 = NO2;
    }

    public float getPM10() {
        return PM10;
    }

    public void setPM10(float PM10) {
        this.PM10 = PM10;
    }

    public float getNi() {
        return Ni;
    }

    public void setNi(float ni) {
        Ni = ni;
    }

    public float getNOx() {
        return NOx;
    }

    public void setNOx(float NOx) {
        this.NOx = NOx;
    }

    public float getOzono() {
        return Ozono;
    }

    public void setOzono(float ozono) {
        Ozono = ozono;
    }

    public float getAs() {
        return As;
    }

    public void setAs(float as) {
        As = as;
    }

    public float getPb() {
        return Pb;
    }

    public void setPb(float pb) {
        Pb = pb;
    }

    public float getBaP() {
        return BaP;
    }

    public void setBaP(float baP) {
        BaP = baP;
    }

    public float getCd() {
        return Cd;
    }

    public void setCd(float cd) {
        Cd = cd;
    }

    public float getRuido() {
        return Ruido;
    }

    public void setRuido(float ruido) {
        Ruido = ruido;
    }



    @Override
    public String toString() {
        return "A5{" +
                "place='" + place + '\'' +
                ", date='" + date + '\'' +
                ", PM2=" + PM2 +
                ", SO2=" + SO2 +
                ", NO=" + NO +
                ", NO2=" + NO2 +
                ", PM10=" + PM10 +
                ", Ni=" + Ni +
                ", NOx=" + NOx +
                ", Ozono=" + Ozono +
                ", As=" + As +
                ", Pb=" + Pb +
                ", BaP=" + BaP +
                ", Cd=" + Cd +
                ", Ruido=" + Ruido +
                '}';
    }
}
