package com.infoshareacademy.jjdd6.czfureczka.model;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;

import java.io.File;
import java.io.IOException;
import java.util.*;
import static com.infoshareacademy.jjdd6.czfureczka.repository.Repository.*;

public class BuildStopsObjectArray {


    public static ArrayList buildStopsArrayList() {
        ArrayList stopsObjectsList = new ArrayList();
        String dateScope = "2019-04-14";
        StopsWithDate busStops = stopsParser(dateScope);
        //StopsWithDate busStops = stopsParser(dateScope);

        busStops.getStops().forEach(Stop -> {
            Stop stop = new Stop();
            stop.setStopId(Stop.getStopId());
            stop.setStopName(Stop.getStopName());
            stopsObjectsList.add(stop);
                }

        );

        return stopsObjectsList;
    }

    private static StopsWithDate stopsParser (String dateScope) {

        try {
            Map stopList = loadStops();
            StopsWithDate stopList2 = (StopsWithDate)stopList.get(dateScope);
            return stopList2;
        } catch (Exception e) {
            System.out.println("wyjątek ładowania przystanków");
        }

        return null;
    }


    private static Map<String, StopsWithDate> loadStops() throws IOException {
        File stopsFile = new File("stops.json");
        ObjectMapper mapper = getJsonObjectMapper();
        TypeReference mapType = new TypeReference<HashMap<String, StopsWithDate>>() {
        };
        return mapper.readValue(stopsFile, mapType);
    }

    private static ObjectMapper getJsonObjectMapper() {
        return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


}
