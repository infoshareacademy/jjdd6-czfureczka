package com.infoshareacademy.jjdd6.czfureczka.repository;

import com.infoshareacademy.jjdd6.czfureczka.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {

    private static Repository instance;

    private Map<String, StopsWithDate> stops = new HashMap<>();
    private Map<String, RoutesWithDate> routes = new HashMap<>();
    private Map<String, TripsWithDate> trips = new HashMap<>();
    private Map<String, StopsInTripWithDate> stopsInTrip = new HashMap();
    private Map<Integer, StopTimesWithDate> stopTimes = new HashMap<>();

    private Repository() {

    }

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }

        return instance;
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

    public List<Trip> getTrips() {
        String date = new ArrayList<>(trips.keySet()).get(0);
        return trips.get(date).getTrips();
    }

    public void setTrips(Map<String, TripsWithDate> trips) {
        this.trips = trips;
    }

    public List<StopInTrip> getStopsInTrip() {
        String date = new ArrayList<>(stopsInTrip.keySet()).get(0);

        return stopsInTrip.get(date).getStopsInTrip();
    }

    public void setStopsInTrip(Map<String, StopsInTripWithDate> stopsInTrip) {
        this.stopsInTrip = stopsInTrip;
    }

    public Map<Integer, StopTimesWithDate> getStopTimes() {
        return stopTimes;
    }

    public void setStopTimes(Map<Integer, StopTimesWithDate> stopTimes) {
        this.stopTimes = stopTimes;
    }
}
