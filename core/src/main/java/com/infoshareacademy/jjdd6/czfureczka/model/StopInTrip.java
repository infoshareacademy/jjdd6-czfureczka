package com.infoshareacademy.jjdd6.czfureczka.model;

public class StopInTrip {

    private int routeId; //dentyfikator linii, do której przynależy słupek; wartość routeId z zasobu Lista linii
    private int tripId; //identyfikator wariantu/trasy, do której przynależy słupek. Wartość tripId z zasobu Lista tras
    private int stopId; //identyfikator słupka; wartość stopId z zasobu Lista przystanków

    public int getRouteId() {
        return routeId;
    }

    public int getTripId() {
        return tripId;
    }

    public int getStopId() {
        return stopId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public void setStopId(int stopId) {
        this.stopId = stopId;
    }
}
