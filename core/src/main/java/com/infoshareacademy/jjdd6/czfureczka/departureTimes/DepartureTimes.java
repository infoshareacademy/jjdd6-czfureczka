package com.infoshareacademy.jjdd6.czfureczka.departureTimes;

import com.infoshareacademy.jjdd6.czfureczka.model.*;
import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;
import com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName.RouteIdForStopId;
import com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName.StopIdForStopDesc;

import java.sql.Time;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class DepartureTimes {


    public Map<String, List<String>> departureTimes(String stopDesc, String departurTime) {
        Map<String, List<String>> departureTimes = departureTime(stopDesc, departurTime);
        return departureTimes;
    }

    public Map<String, List<String>> departureTimes(String stopDesc) {
        Map<String, List<String>> departureTimes = departureTime(stopDesc);
        return departureTimes;
    }

    private Logger logger = Logger.getLogger(DepartureTimes.class.getName());

    private Map<String, List<String>> departureTime(String stopDesc, String departurTime) {

        StopIdForStopDesc stopIdForStopDesc = new StopIdForStopDesc();
        RouteIdForStopId routeIdForStopId = new RouteIdForStopId();

        List<Integer> stopIds = stopIdForStopDesc.stopIdForStopsDesc(stopDesc);
        List<Integer> routeIds = routeIdForStopId.routeIdForStopId(stopIds);

        List<Integer> routShortNames = routShortNames(routeIds);

        Map<String, List<String>> departure = new HashMap<>();

        for (int i = 0; i < routShortNames.size(); i++) {

            List<StopTimes> stops = Repository
                    .getInstance()
                    .getStopTimes()
                    .get(routShortNames.get(i));

            List<Trip> newTrip = Repository
                    .getInstance()
                    .getTrips();

            List<Integer> tripId = tripId(stops);

            Integer routeID = routShortNames.get(i);

            String routeId = routeID.toString();

            for (int j = 0; j < tripId.size(); j++) {

                Integer trip = tripId.get(j);

                String tripHeadsign = tripHeadsing(newTrip, routeID, trip);

                List<String> firstTime = firstTime(stops, stopIds, trip);

                List<String> secondTime = secondTime(firstTime);

                List<Time> times = secondTime.stream()
                        .map(Time::valueOf)
                        .collect(Collectors.toList());

                Time time = Time.valueOf(departurTime);

                List<String> timeOfDeparture = times.stream()
                        .filter(s -> s.after(time))
                        .limit(5)
                        .map(m -> m.toString())
                        .collect(Collectors.toList());

                if (timeOfDeparture.size() < 5) {

                    Time time2 = Time.valueOf("00:00:00");

                    List<String> timeOfDeparture2 = times.stream()
                            .filter(s -> s.after(time2))
                            .limit(5 - timeOfDeparture.size())
                            .map(m -> m.toString())
                            .collect(Collectors.toList());

                    timeOfDeparture.addAll(timeOfDeparture2);
                }

                departure.put(routeId + tripHeadsign, timeOfDeparture);
            }
        }

        return departure;
    }

    private Map<String, List<String>> departureTime(String stopDesc) {

        StopIdForStopDesc stopIdForStopDesc = new StopIdForStopDesc();
        RouteIdForStopId routeIdForStopId = new RouteIdForStopId();

        List<Integer> stopIds = stopIdForStopDesc.stopIdForStopsDesc(stopDesc);
        List<Integer> routeIds = routeIdForStopId.routeIdForStopId(stopIds);

        List<Integer> routShortNames = routShortNames(routeIds);

        Map<String, List<String>> departure = new HashMap<>();

        for (int i = 0; i < routShortNames.size(); i++) {

            List<StopTimes> stops = Repository
                    .getInstance()
                    .getStopTimes()
                    .get(routShortNames.get(i));

            List<Trip> newTrip = Repository
                    .getInstance()
                    .getTrips();

            List<Integer> tripId = tripId(stops);

            Integer routeID = routShortNames.get(i);

            String routeId = routeID.toString();

            for (int j = 0; j < tripId.size(); j++) {

                Integer trip = tripId.get(j);

                String tripHeadsign = tripHeadsing(newTrip, routeID, trip);

                List<String> firstTime = firstTime(stops, stopIds, trip);

                List<String> secondTime = secondTime(firstTime);

                departure.put(routeId + tripHeadsign, secondTime);
            }
        }

        // System.out.println(Collections.singletonList(departure));
        return departure;
    }

    private List<Integer> routShortNames(List<Integer> routeIds) {

        List<Integer> allStopTimes = Repository
                .getInstance()
                .getStopTimes()
                .keySet().stream()
                .collect(Collectors.toList());

        List<Integer> routShortNames = allStopTimes.stream()
                .filter(routeIds::contains)
                .collect(Collectors.toList());

        return routShortNames;
    }

    private List<Integer> tripId(List<StopTimes> stops) {

        List<Integer> tripId = stops.stream()
                .map(StopTimes::getTripId)
                .distinct()
                .collect(Collectors.toList());
        return tripId;
    }

    private String tripHeadsing(List<Trip> newTrip, Integer routeID, Integer trip) {

        List<String> name = newTrip.stream()
                .filter(f -> routeID.equals(f.getRouteId()))
                .filter(l -> trip.equals(l.getTripId()))
                .map(o -> o.getTripHeadsign().replaceAll("[(0-9)]", "").trim())
                .collect(Collectors.toList());

        String tripHeadsign = name.toString();

        return tripHeadsign;
    }

    private List<String> firstTime(List<StopTimes> stops, List<Integer> stopIds, Integer trip) {

        List<String> firstTime = stops.stream()
                .filter(s -> stopIds.contains(s.getStopId()))
                .filter(f -> trip.equals(f.getTripId()))
                .map(StopTimes::getDepartureTime)
                .collect(Collectors.toList());

        return firstTime;
    }

    private List<String> secondTime(List<String> firstTime) {

        final String date = "1899-12-30";
        final String date1 = "1899-12-31";

        List<String> secondTime = firstTime.stream()
                .map(s -> s.split("T"))
                .flatMap(Arrays::stream)
                .filter(f -> !f.contains(date) && !f.contains(date1))
                .sorted()
                .collect(Collectors.toList());

        return secondTime;
    }
}