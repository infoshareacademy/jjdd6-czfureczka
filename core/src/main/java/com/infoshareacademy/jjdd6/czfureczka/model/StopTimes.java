package com.infoshareacademy.jjdd6.czfureczka.model;

public class StopTimes {

    private int routeId; //identyfikator linii, której dotyczy wpis; wartość routeId z zasobu Lista linii
    private int tripId; //identyfikator wariantu/trasy, której dotyczy wpis. Wartość tripId z zasobu Lista tras
    private int agencyId; //identyfikator floty, do której należy linia
    private String arrivalTime; //zdefiniowany czas przyjazdu na przystanek; w formacie „YYYY-MM-DD”+T+”HH:MM:SS”
    private String departureTime; //zdefiniowany czas odjazdu z przystanku; w formacie „YYYY-MM-DD”+T+”HH:MM:SS”
    private int stopId; //identyfikator słupka przystankowego; wartość stopId z zasobu Lista przystanków
    private int stopSequence; //numer porządkowy w ramach kursu
    private String date; //data, dla której obowiązuje rozkład
    private String busServiceName; //zadanie pojazdu. Kursy pogrupowane w zadanie tworzą rozkład jazdy dla pojedynczego pojazdu;
    private int nonpassenger; //flaga określająca czy słupek na trasie jest przeznaczony dla pasażera
    private int onDemand; //Flaga określająca, czy słupek ma status na żądanie
    private int virtual; //Flaga określająca, czy słupek jest wirtualny (nieprzeznaczony dla pasażera)
    private String stopShortName; //identyfikator słupka przystankowego, unikalny w skali Organizatora

    public int getRouteId() {
        return routeId;
    }

    public int getTripId() {
        return tripId;
    }

    public int getAgencyId() {
        return agencyId;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public int getStopId() {
        return stopId;
    }

    public int getStopSequence() {
        return stopSequence;
    }

    public String getDate() {
        return date;
    }

    public String getBusServiceName() {
        return busServiceName;
    }

    public int getNonpassenger() {
        return nonpassenger;
    }

    public int getOnDemand() {
        return onDemand;
    }

    public int getVirtual() {
        return virtual;
    }

    public String getStopShortName() {
        return stopShortName;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void setStopId(int stopId) {
        this.stopId = stopId;
    }

    public void setStopSequence(int stopSequence) {
        this.stopSequence = stopSequence;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setBusServiceName(String busServiceName) {
        this.busServiceName = busServiceName;
    }

    public void setNonpassenger(int nonpassenger) {
        this.nonpassenger = nonpassenger;
    }

    public void setOnDemand(int onDemand) {
        this.onDemand = onDemand;
    }

    public void setVirtual(int virtual) {
        this.virtual = virtual;
    }

    public void setStopShortName(String stopShortName) {
        this.stopShortName = stopShortName;
    }
}
