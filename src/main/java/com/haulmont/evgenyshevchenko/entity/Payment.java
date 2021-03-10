package com.haulmont.evgenyshevchenko.entity;

public class Payment {
    private String date;
    private double platezh;
    private double percents;
    private double bodyCredit;
    private double ostatok;

    public Payment() {
    }

    public Payment(String date, double platezh, double percents, double bodyCredit, double ostatok) {
        this.date = date;
        this.platezh = platezh;
        this.percents = percents;
        this.bodyCredit = bodyCredit;
        this.ostatok = ostatok;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPlatezh() {
        return platezh;
    }

    public void setPlatezh(double platezh) {
        this.platezh = platezh;
    }

    public double getPercents() {
        return percents;
    }

    public void setPercents(double percents) {
        this.percents = percents;
    }

    public double getBodyCredit() {
        return bodyCredit;
    }

    public void setBodyCredit(double bodyCredit) {
        this.bodyCredit = bodyCredit;
    }

    public double getOstatok() {
        return ostatok;
    }

    public void setOstatok(double ostatok) {
        this.ostatok = ostatok;
    }
}
