package clinair.clinair.model.Estautomaticas;

/**
 * Created by susy on 20/02/17.
 */

public class A4 {
    String place="39.4591145;-0.3772500999999693";
    String date;
    float light;
    float PM2;
    float PM1;
    float Xileno;
    float SO2;
    float CO;
    float NO;
    float NO2;
    float PM10;
    float NOx;
    float Ozono;
    float Tolueno;
    float Benzeno;
    float Ruido;
    float vel;
    float temp;
    float hreal;
    float pres;

    public A4() {
    }

    public A4(String date, float light, float PM2, float PM1, float xileno, float SO2, float CO, float NO, float NO2, float PM10, float NOx, float ozono, float tolueno, float benzeno, float ruido, float vel, float temp, float hreal, float pres) {
        this.date = date;
        this.light = light;
        this.PM2 = PM2;
        this.PM1 = PM1;
        Xileno = xileno;
        this.SO2 = SO2;
        this.CO = CO;
        this.NO = NO;
        this.NO2 = NO2;
        this.PM10 = PM10;
        this.NOx = NOx;
        Ozono = ozono;
        Tolueno = tolueno;
        Benzeno = benzeno;
        Ruido = ruido;
        this.vel = vel;
        this.temp = temp;
        this.hreal = hreal;
        this.pres = pres;
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

    public float getLight() {
        return light;
    }

    public void setLight(float light) {
        this.light = light;
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

    public float getXileno() {
        return Xileno;
    }

    public void setXileno(float xileno) {
        Xileno = xileno;
    }

    public float getSO2() {
        return SO2;
    }

    public void setSO2(float SO2) {
        this.SO2 = SO2;
    }

    public float getCO() {
        return CO;
    }

    public void setCO(float CO) {
        this.CO = CO;
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

    public float getTolueno() {
        return Tolueno;
    }

    public void setTolueno(float tolueno) {
        Tolueno = tolueno;
    }

    public float getBenzeno() {
        return Benzeno;
    }

    public void setBenzeno(float benzeno) {
        Benzeno = benzeno;
    }

    public float getRuido() {
        return Ruido;
    }

    public void setRuido(float ruido) {
        Ruido = ruido;
    }

    public float getVel() {
        return vel;
    }

    public void setVel(float vel) {
        this.vel = vel;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getHreal() {
        return hreal;
    }

    public void setHreal(float hreal) {
        this.hreal = hreal;
    }

    public float getPres() {
        return pres;
    }

    public void setPres(float pres) {
        this.pres = pres;
    }

    @Override
    public String toString() {
        return "A4{" +
                "place='" + place + '\'' +
                ", date='" + date + '\'' +
                ", light=" + light +
                ", PM2=" + PM2 +
                ", PM1=" + PM1 +
                ", Xileno=" + Xileno +
                ", SO2=" + SO2 +
                ", CO=" + CO +
                ", NO=" + NO +
                ", NO2=" + NO2 +
                ", PM10=" + PM10 +
                ", NOx=" + NOx +
                ", Ozono=" + Ozono +
                ", Tolueno=" + Tolueno +
                ", Benzeno=" + Benzeno +
                ", Ruido=" + Ruido +
                ", vel=" + vel +
                ", temp=" + temp +
                ", hreal=" + hreal +
                ", pres=" + pres +
                '}';
    }
}
