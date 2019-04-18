package com.infoshareacademy.jjdd6.czfureczka.repository;

import com.infoshareacademy.jjdd6.czfureczka.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {

    private static Repository instance;

    private ExpeditionDataWithDate expeditionData = new ExpeditionDataWithDate();
    private Map<String, StopsWithDate> stops = new HashMap<>();
    private Map<String, RoutesWithDate> routes = new HashMap<>();
    private List<Trip> trips = new ArrayList<>();
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
        String date = new ArrayList<>(stops.keySet()).get(0);
        return stops.get(date).getStops();
    }

    public void setStops(Map<String, StopsWithDate> stops) {
        this.stops = stops;
    }

    public List<Route> getRoutes() {
        String date = new ArrayList<>(routes.keySet()).get(0);
        return routes.get(date).getRoutes();
    }

    public void setRoutes(Map<String, RoutesWithDate> routes) {
        this.routes = routes;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public List<Trip> getTrips() {
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
