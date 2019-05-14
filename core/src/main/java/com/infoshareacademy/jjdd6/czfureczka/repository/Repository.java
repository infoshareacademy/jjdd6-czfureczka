package com.infoshareacademy.jjdd6.czfureczka.repository;

import com.infoshareacademy.jjdd6.czfureczka.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {

    private static Repository instance;

    private ExpeditionDataWithDate expeditionData = new ExpeditionDataWithDate();
    private List<Stop> stops = new ArrayList<>();
    private List<Route> routes = new ArrayList<>();
    private List<Trips> trips = new ArrayList<>();
    private List<StopInTrip> stopsInTrip = new ArrayList<>();
    private Map<Integer, List<StopTimes>> stopTimes = new HashMap<>();

    private Repository() {

    }

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }

        return instance;
    }

    public ExpeditionDataWithDate getExpeditionData() {
        return expeditionData;
    }

    public void setExpeditionData(ExpeditionDataWithDate expeditionData) {
        this.expeditionData = expeditionData;
    }

    public List<Stop> getStops() {
        return stops;
    }

    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public void setTrips(List<Trips> trips) {
        this.trips = trips;
    }

    public List<Trips> getTrips() {
        return trips;
    }

    public List<StopInTrip> getStopsInTrip() {
        return stopsInTrip;
    }

    public void setStopsInTrip(List<StopInTrip> stopsInTrip) {
        this.stopsInTrip = stopsInTrip;
    }

    public Map<Integer, List<StopTimes>> getStopTimes() {
        return stopTimes;
    }

    public void setStopTimes(Map<Integer, List<StopTimes>> stopTimes) {
        this.stopTimes = stopTimes;
    }
}
