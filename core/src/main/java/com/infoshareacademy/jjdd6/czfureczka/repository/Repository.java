package com.infoshareacademy.jjdd6.czfureczka.repository;

import com.infoshareacademy.jjdd6.czfureczka.model.*;

import java.util.HashMap;
import java.util.Map;

public class Repository {

    private static Repository instance;

    public Map<String, StopsWithDate> stops = new HashMap<>();
    public Map<String, RoutesWithDate> routes = new HashMap<>();
    public Map<String, TripsWithDate> trips = new HashMap<>();
    public Map<String, StopsInTripWithDate> stopsInTrip = new HashMap();
    public Map<String, StopTimesWithDate> stopTimes = new HashMap<>();

    private Repository() {

    }

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }

        return instance;
    }
}
