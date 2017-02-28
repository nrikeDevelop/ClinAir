package clinair.clinair.model.Estautomaticas;

/**
 * Created by susy on 20/02/17.
 */

public class A7 {

    String place ="39.4576833;-0.40144899999995687";
    String date;
    float S02;
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

    public A7(String date, float s02, float NO, float NO2, float PM10, float ni, float NOx, float ozono, float as, float pb, float baP, float cd) {
        this.date = date;
        S02 = s02;
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
    }

    public A7() {
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

    @Override
    public String toString() {
        return "A7{" +
                "place='" + place + '\'' +
                ", date='" + date + '\'' +
                ", S02=" + S02 +
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
                '}';
    }
}
