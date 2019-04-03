package com.infoshareacademy.jjdd6.czfureczka.model;

public class Stop {
    public int stopId;
    public String stopCode;
    public String stopName;
    public String stopShortName;
    public String stopDesc;
    public Double stopLat;
    public Double stopLon;
    public int zoneId;
    public int nonpassenger; // 1 = true => nie dla pasazera; sprawdzic mapowanie na boolean
}
