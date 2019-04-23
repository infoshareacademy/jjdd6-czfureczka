package com.infoshareacademy.jjdd6.czfureczka.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.jjdd6.czfureczka.config.StopTimesConfig;
import com.infoshareacademy.jjdd6.czfureczka.config.Timetable;
import com.infoshareacademy.jjdd6.czfureczka.model.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RepositoryLoader {

    private static final String date = "2019-04-18";

    public boolean load(String path) {
        try {

            ExpeditionDataWithDate expeditionData = loadExpeditionData(path);
            List<Stop> stops = loadStops(path);
            List<Route> routes = loadLines(path);
            Map<String, TripsWithDate> trips = loadTrips(path);
            Map<String, StopsInTripWithDate> stopsInTrip = loadStopsInTrip(path);
            Map<Integer, StopTimesWithDate> stopTimes = loadStopTimes(path);

            List<RouteTrip> mainTrips = getMainTrips(expeditionData);

            Repository.getInstance().setExpeditionData(expeditionData);
            Repository.getInstance().setRoutes(routes);
            Repository.getInstance().setStops(stops);
            Repository.getInstance().setTrips(getMainTripForTrip(trips, mainTrips));
            Repository.getInstance().setStopsInTrip(getMainTripForStopInTrip(stopsInTrip, mainTrips));
            Repository.getInstance().setStopTimes(getMainTripForStopTimes(stopTimes, mainTrips));

            return true;
        } catch (IOException e) {
            System.err.println("Could not read stops data: " + e.getMessage());
            return false;
        }
    }

    private ExpeditionDataWithDate loadExpeditionData(String path) throws IOException {
        File expeditionDataFile = new File(path, "expeditiondata.json");
        ObjectMapper mapper = getJsonObjectMapper();
        return mapper.readValue(expeditionDataFile, ExpeditionDataWithDate.class);
    }

    private List<Stop> loadStops(String path) throws IOException {
        File stopsFile = new File(path, "stops.json");
        ObjectMapper mapper = getJsonObjectMapper();
        TypeReference mapType = new TypeReference<HashMap<String, StopsWithDate>>() {
        };
        Map<String, StopsWithDate> stops = mapper.readValue(stopsFile, mapType);
        return stops.get(date).getStops();
    }

    private List<Route> loadLines(String path) throws IOException {
        File linesFile = new File(path, "routes.json");
        ObjectMapper mapper = getJsonObjectMapper();
        TypeReference mapType = new TypeReference<HashMap<String, RoutesWithDate>>() {
        };
        Map<String, RoutesWithDate> routes = mapper.readValue(linesFile, mapType);
        return routes.get(date).getRoutes();
    }

    private Map<String, TripsWithDate> loadTrips(String path) throws IOException {
        File tripsFile = new File(path, "trips.json");
        ObjectMapper mapper = getJsonObjectMapper();
        TypeReference mapType = new TypeReference<HashMap<String, TripsWithDate>>() {
        };
        return mapper.readValue(tripsFile, mapType);
    }

    private Map<String, StopsInTripWithDate> loadStopsInTrip(String path) throws IOException {
        File stopsInTripFile = new File(path, "stopsintrips.json");
        ObjectMapper mapper = getJsonObjectMapper();
        TypeReference mapType = new TypeReference<HashMap<String, StopsInTripWithDate>>() {
        };
        return mapper.readValue(stopsInTripFile, mapType);
    }

    private Map<Integer, StopTimesWithDate> loadStopTimes(String path) throws IOException {
        Map<Integer, StopTimesWithDate> stopTimes = new HashMap<>();
        StopTimesConfig stopTimesConfig = loadConfig(path);
        List<Timetable> list = stopTimesConfig.getStopTimes();
        for (Timetable timetable : list) {
            File stopTimesFile = new File(path, timetable.getFile());
            ObjectMapper mapper = getJsonObjectMapper();
            stopTimes.put(timetable.getRouteId(), mapper.readValue(stopTimesFile, StopTimesWithDate.class));
        }
        return stopTimes;
    }

    private StopTimesConfig loadConfig(String path) throws IOException {
        File stopTimesConfigFile = new File(path, "config.json");
        ObjectMapper mapper = getJsonObjectMapper();
        return mapper.readValue(stopTimesConfigFile, StopTimesConfig.class);
    }

    private ObjectMapper getJsonObjectMapper() {
        return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private List<RouteTrip> getMainTrips(ExpeditionDataWithDate expeditionData) {
        return expeditionData.getExpeditionData().stream()
                .filter(ex -> ex.getMainRoute() == 1)
                .map(e -> new RouteTrip(e.getRouteId(), e.getTripId()))
                .distinct()
                .collect(Collectors.toList());
    }

    private List<Trip> getMainTripForTrip(Map<String, TripsWithDate> tripsWithDate, List<RouteTrip> mainTrips) {
        return tripsWithDate.get(date).getTrips().stream()
                .filter(t ->
                        mainTrips.stream().anyMatch(rt ->
                                rt.getRouteID() == t.getRouteId() && rt.getTripID() == t.getTripId()
                        )
                )
                .collect(Collectors.toList());
    }

    private List<StopInTrip> getMainTripForStopInTrip(Map<String, StopsInTripWithDate> stopsInTrip, List<RouteTrip> mainTrips) {
        return stopsInTrip.get(date).getStopsInTrip().stream()
                .filter(s -> mainTrips.stream().anyMatch(rt ->
                                rt.getRouteID() == s.getRouteId() && rt.getTripID() == s.getTripId()
                        )
                )
                .collect(Collectors.toList());
    }

    private Map<Integer, List<StopTimes>> getMainTripForStopTimes(Map<Integer, StopTimesWithDate> stopTimes, List<RouteTrip> mainTrips) {
        List<Integer> routeID = new ArrayList<>(stopTimes.keySet());
        Map<Integer, List<StopTimes>> newStopTime = new HashMap<>();
        for (int i = 0; i < routeID.size(); i++) {
            List<StopTimes> newStopTimes = stopTimes.get(routeID.get(i))
                    .getStopTimes()
                    .stream()
                    .filter(s -> mainTrips.stream().anyMatch(rt ->
                                    rt.getTripID() == s.getTripId() && rt.getRouteID() == s.getRouteId()
                            )
                    )
                    .collect(Collectors.toList());
            newStopTime.put(routeID.get(i), newStopTimes);
        }
        return newStopTime;
    }
}
