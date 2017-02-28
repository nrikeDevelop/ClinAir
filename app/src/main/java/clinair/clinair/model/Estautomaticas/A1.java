package clinair.clinair.model.Estautomaticas;

/**
 * Created by susy on 20/02/17.
 */

public class A1 {

    String place ="39.4781602;-0.3399280999999519" ;
    String date;
    float PM2;
    float PM1;
    float SO2;
    float NO;
    float NO2;
    float PM10;
    float NOx;
    float Ozono;

    public A1() {
    }

    public A1(String date, float PM2, float PM1, float SO2, float NO, float NO2, float PM10, float NOx, float ozono) {
        this.date = date;
        this.PM2 = PM2;
        this.PM1 = PM1;
        this.SO2 = SO2;
        this.NO = NO;
        this.NO2 = NO2;
        this.PM10 = PM10;
        this.NOx = NOx;
        Ozono = ozono;
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

    public float getPM1() {
        return PM1;
    }

    public void setPM1(float PM1) {
        this.PM1 = PM1;
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

    @Override
    public String toString() {
        return "A1{" +
                "place='" + place + '\'' +
                ", date='" + date + '\'' +
                ", PM2=" + PM2 +
                ", PM1=" + PM1 +
                ", SO2=" + SO2 +
                ", NO=" + NO +
                ", NO2=" + NO2 +
                ", PM10=" + PM10 +
                ", NOx=" + NOx +
                ", Ozono=" + Ozono +
                '}';
    }
}
