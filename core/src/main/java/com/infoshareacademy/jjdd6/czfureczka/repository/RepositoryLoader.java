package com.infoshareacademy.jjdd6.czfureczka.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.jjdd6.czfureczka.config.StopTimesConfig;
import com.infoshareacademy.jjdd6.czfureczka.config.Timetable;
import com.infoshareacademy.jjdd6.czfureczka.model.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositoryLoader {

    public boolean load() {
        try {

            Map<String, StopsWithDate> stops = loadStops();
            Map<String, RoutesWithDate> routes = loadLines();
            Map<String, TripsWithDate> trips = loadTrips();
            Map<String, StopsInTripWithDate> stopsInTrip = loadStopsInTrip();
            Map<Integer, StopTimesWithDate> stopTimes = loadStopTimes();


            Repository.getInstance().setRoutes(routes);
            Repository.getInstance().setStops(stops);
            Repository.getInstance().setTrips(trips);
            Repository.getInstance().setStopsInTrip(stopsInTrip);
            Repository.getInstance().setStopTimes(stopTimes);

            return true;
        } catch (IOException e) {
            System.err.println("Could not read stops data: " + e.getMessage());
            return false;
        }
    }

    private Map<String, StopsWithDate> loadStops() throws IOException {
        File stopsFile = new File("data", "stops.json");
        ObjectMapper mapper = getJsonObjectMapper();
        TypeReference mapType = new TypeReference<HashMap<String, StopsWithDate>>() {
        };
        return mapper.readValue(stopsFile, mapType);
    }

    private Map<String, RoutesWithDate> loadLines() throws IOException {
        File linesFile = new File("data", "routes.json");
        ObjectMapper mapper = getJsonObjectMapper();
        TypeReference mapType = new TypeReference<HashMap<String, RoutesWithDate>>() {
        };
        return mapper.readValue(linesFile, mapType);
    }

    private Map<String, TripsWithDate> loadTrips() throws IOException {
        File tripsFile = new File("data","trips.json");
        ObjectMapper mapper = getJsonObjectMapper();
        TypeReference mapType = new TypeReference<HashMap<String, TripsWithDate>>() {
        };
        return mapper.readValue(tripsFile, mapType);
    }

    private Map<String, StopsInTripWithDate> loadStopsInTrip() throws IOException {
        File stopsInTripFile = new File("data","stopsintrips.json");
        ObjectMapper mapper = getJsonObjectMapper();
        TypeReference mapType = new TypeReference<HashMap<String, StopsInTripWithDate>>() {
        };
        return mapper.readValue(stopsInTripFile, mapType);
    }

    private Map<Integer, StopTimesWithDate> loadStopTimes() throws IOException {
        Map<Integer, StopTimesWithDate> stopTimes = new HashMap<>();
        StopTimesConfig stopTimesConfig = loadConfig();
        List<Timetable> list = stopTimesConfig.getStopTimes();
        for (Timetable timetable : list) {
            File stopTimesFile = new File(timetable.getFile());
            ObjectMapper mapper = getJsonObjectMapper();
            stopTimes.put(timetable.getRouteId(), mapper.readValue(stopTimesFile, StopTimesWithDate.class));
        }
        return stopTimes;
    }

    private StopTimesConfig loadConfig() throws IOException{
        File stopTimesConfigFile = new File("data", "config.json");
        ObjectMapper mapper = getJsonObjectMapper();
        return mapper.readValue(stopTimesConfigFile, StopTimesConfig.class);
    }


    private ObjectMapper getJsonObjectMapper() {
        return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

}
