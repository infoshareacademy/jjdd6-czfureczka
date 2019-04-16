package com.infoshareacademy.jjdd6.czfureczka.model;

public class Stop {
    private int stopId; //identyfikator słupka przystankowego unikalny w skali Trójmiasta
    private String stopCode; //numer słupka przystankowego unikalny w ramach przystanku
    private String stopName; //nazwa przystanku pochodząca z programu do układania rozkładu jazdy
    private String stopShortName; //identyfikator słupka przystankowego, unikalny w skali Organizatora
    private String stopDesc; //nazwa przystanku pochodząca z systemu TRISTAR
    private Double stopLat; //współrzędne geograficzne
    private Double stopLon; //współrzędne geograficzne
    private int zoneId; //unikalny identyfikator miasta/gminy
    private int nonpassenger; // 1 = true => nie dla pasazera; sprawdzic mapowanie na boolean

    public  int getStopId() {
        return stopId;
    }

    public String getStopCode() {
        return stopCode;
    }

    public String getStopName() {
        return stopName;
    }

    public String getStopShortName() {
        return stopShortName;
    }

    public String getStopDesc() {
        return stopDesc;
    }

    public Double getStopLat() {
        return stopLat;
    }

    public Double getStopLon() {
        return stopLon;
    }

    public int getZoneId() {
        return zoneId;
    }

    public int getNonpassenger() {
        return nonpassenger;
    }

    public void setStopId(int stopId) {
        this.stopId = stopId;
    }

    public void setStopCode(String stopCode) {
        this.stopCode = stopCode;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public void setStopShortName(String stopShortName) {
        this.stopShortName = stopShortName;
    }

    public void setStopDesc(String stopDesc) {
        this.stopDesc = stopDesc;
    }

    public void setStopLat(Double stopLat) {
        this.stopLat = stopLat;
    }

    public void setStopLon(Double stopLon) {
        this.stopLon = stopLon;
    }

    public void setZoneId(int zoneId) {
        this.zoneId = zoneId;
    }

    public void setNonpassenger(int nonpassenger) {
        this.nonpassenger = nonpassenger;
    }
}
