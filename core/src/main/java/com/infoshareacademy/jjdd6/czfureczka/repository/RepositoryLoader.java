package com.infoshareacademy.jjdd6.czfureczka.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.jjdd6.czfureczka.config.RoutesConfig;
import com.infoshareacademy.jjdd6.czfureczka.model.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RepositoryLoader {

    public boolean load() {
        try {
            Map<String, StopsWithDate> stops = loadStops();
            Map<String, RoutesWithDate> routes = loadLines();
            Map<String, TripsWithDate> trips = loadTrips();
            Map<String, StopsInTripWithDate> stopsInTrip = loadStopsInTrip();
            Map<String, StopTimesWithDate> stopTimes = loadStopTimes();

            Repository.getInstance().routes = routes;
            Repository.getInstance().stops = stops;
            Repository.getInstance().trips = trips;
            Repository.getInstance().stopsInTrip = stopsInTrip;
            Repository.getInstance().stopTimes = stopTimes;

            return true;
        } catch (IOException e) {
            System.out.println("Could not read stops data: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    private static Map<String, StopsWithDate> loadStops() throws IOException {
        File stopsFile = new File("data", "stops.json");
        ObjectMapper mapper = getJsonObjectMapper();
        TypeReference mapType = new TypeReference<HashMap<String, StopsWithDate>>() {
        };
        return mapper.readValue(stopsFile, mapType);
    }

    private static Map<String, RoutesWithDate> loadLines() throws IOException {
        File linesFile = new File("data", "routes.json");
        ObjectMapper mapper = getJsonObjectMapper();
        TypeReference mapType = new TypeReference<HashMap<String, RoutesWithDate>>() {
        };
        return mapper.readValue(linesFile, mapType);
    }

    private static Map<String, TripsWithDate> loadTrips() throws IOException {
        File tripsFile = new File("data","trips.json");
        ObjectMapper mapper = getJsonObjectMapper();
        TypeReference mapType = new TypeReference<HashMap<String, TripsWithDate>>() {
        };
        return mapper.readValue(tripsFile, mapType);
    }

    private static Map<String, StopsInTripWithDate> loadStopsInTrip() throws IOException {
        File stopsInTripFile = new File("data","stopsintrips.json");
        ObjectMapper mapper = getJsonObjectMapper();
        TypeReference mapType = new TypeReference<HashMap<String, StopsInTripWithDate>>() {
        };
        return mapper.readValue(stopsInTripFile, mapType);
    }

    private static Map<String, StopTimesWithDate> loadStopTimes() throws IOException {
        HashMap<String, StopTimesWithDate> stopTimes = new HashMap<>();
        for (String key : RoutesConfig.routesDataFiles.keySet()) {
            File stopTimesFile = new File(RoutesConfig.routesDataFiles.get(key));
            ObjectMapper mapper = getJsonObjectMapper();
            stopTimes.put(key, mapper.readValue(stopTimesFile, StopTimesWithDate.class));
        }
        return stopTimes;
    }


    private static ObjectMapper getJsonObjectMapper() {
        return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

}
