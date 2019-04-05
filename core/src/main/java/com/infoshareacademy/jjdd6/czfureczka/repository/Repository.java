package com.infoshareacademy.jjdd6.czfureczka.repository;

import com.infoshareacademy.jjdd6.czfureczka.model.*;

import java.util.HashMap;
import java.util.Map;

public class Repository {

    private static Repository instance;

    private Map<String, StopsWithDate> stops = new HashMap<>();
    private Map<String, RoutesWithDate> routes = new HashMap<>();
    private Map<String, TripsWithDate> trips = new HashMap<>();
    private Map<String, StopsInTripWithDate> stopsInTrip = new HashMap();
    private Map<String, StopTimesWithDate> stopTimes = new HashMap<>();

    private Repository() {

    }

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }

        return instance;
    }

    public Map<String, StopsWithDate> getStops() {
        return stops;
    }

    public void setStops(Map<String, StopsWithDate> stops) {
        this.stops = stops;
    }

    public Map<String, RoutesWithDate> getRoutes() {
        return routes;
    }

    public void setRoutes(Map<String, RoutesWithDate> routes) {
        this.routes = routes;
    }

    public Map<String, TripsWithDate> getTrips() {
        return trips;
    }

    public void setTrips(Map<String, TripsWithDate> trips) {
        this.trips = trips;
    }

    public Map<String, StopsInTripWithDate> getStopsInTrip() {
        return stopsInTrip;
    }

    public void setStopsInTrip(Map<String, StopsInTripWithDate> stopsInTrip) {
        this.stopsInTrip = stopsInTrip;
    }

    public Map<String, StopTimesWithDate> getStopTimes() {
        return stopTimes;
    }

    public void setStopTimes(Map<String, StopTimesWithDate> stopTimes) {
        this.stopTimes = stopTimes;
    }
}
