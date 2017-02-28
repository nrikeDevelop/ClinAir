package clinair.clinair.model.Estautomaticas;

/**
 * Created by susy on 20/02/17.
 */

public class A6 {

    String place = "39.4583194;-0.3435168999999405";
    String date;
    float PM2;
    float PM1;
    float S02;
    float CO;
    float NO;
    float NO2;
    float PM10;
    float NOx;
    float Ozono;
    float vel;

    public A6() {
    }

    public A6(String date, float PM2, float PM1, float s02, float CO, float NO, float NO2, float PM10, float NOx, float ozono, float vel) {
        this.date = date;
        this.PM2 = PM2;
        this.PM1 = PM1;
        S02 = s02;
        this.CO = CO;
        this.NO = NO;
        this.NO2 = NO2;
        this.PM10 = PM10;
        this.NOx = NOx;
        Ozono = ozono;
        this.vel = vel;
    }

    public float getOzono() {
        return Ozono;
    }

    public void setOzono(float ozono) {
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

    public float getS02() {
        return S02;
    }

    public void setS02(float s02) {
        S02 = s02;
    }

    public float getCO() {
        return CO;
    }

    public void setCO(float CO) {
        this.CO = CO;
    }

    public float getNOx() {
        return NOx;
    }

    public void setNOx(float NOx) {
        this.NOx = NOx;
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

    public float getVel() {
        return vel;
    }

    public void setVel(float vel) {
        this.vel = vel;
    }

    @Override
    public String toString() {
        return "A6{" +
                "place='" + place + '\'' +
                ", date='" + date + '\'' +
                ", S02=" + S02 +
                ", CO=" + CO +
                ", Ozono=" + Ozono +
                ", NOx=" + NOx +
                ", NO=" + NO +
                ", NO2=" + NO2 +
                ", PM10=" + PM10 +
                ", PM2=" + PM2 +
                ", PM1=" + PM1 +
                ", vel=" + vel +
                '}';
    }
}
