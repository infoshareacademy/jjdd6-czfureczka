package com.infoshareacademy.jjdd6.czfureczka.model;

class Stop {
    private int stopId;
    private String stopCode;
    private String stopName;
    private String stopShortName;
    private String stopDesc;
    private Double stopLat;
    private Double stopLon;
    private int zoneId;
    private int nonpassenger; // 1 = true => nie dla pasazera; sprawdzic mapowanie na boolean

    Stop (){}

    public int getStopId() {
        return stopId;
    }

    public void setStopId(int stopId) {
        this.stopId = stopId;
    }

    public String getStopCode() {
        return stopCode;
    }

    public void setStopCode(String stopCode) {
        this.stopCode = stopCode;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public String getStopShortName() {
        return stopShortName;
    }

    public void setStopShortName(String stopShortName) {
        this.stopShortName = stopShortName;
    }

    public String getStopDesc() {
        return stopDesc;
    }

    public void setStopDesc(String stopDesc) {
        this.stopDesc = stopDesc;
    }

    public Double getStopLat() {
        return stopLat;
    }

    public void setStopLat(Double stopLat) {
        this.stopLat = stopLat;
    }

    public Double getStopLon() {
        return stopLon;
    }

    public void setStopLon(Double stopLon) {
        this.stopLon = stopLon;
    }

    public int getZoneId() {
        return zoneId;
    }

    public void setZoneId(int zoneId) {
        this.zoneId = zoneId;
    }

    public int getNonpassenger() {
        return nonpassenger;
    }

    public void setNonpassenger(int nonpassenger) {
        this.nonpassenger = nonpassenger;
    }

}
