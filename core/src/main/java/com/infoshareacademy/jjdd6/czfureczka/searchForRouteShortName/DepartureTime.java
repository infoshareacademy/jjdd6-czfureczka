package com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName;

import com.infoshareacademy.jjdd6.czfureczka.model.*;
import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;

import java.sql.Time;
import java.util.*;
import java.util.stream.Collectors;

public class DepartureTime {

    List<Integer> allStopTimes = Repository
            .getInstance()
            .getStopTimes()
            .keySet().stream()
            .collect(Collectors.toList());

    StopIdForStopDesc stopIdForStopDesc = new StopIdForStopDesc();
    RouteIdForStopId routeIdForStopId = new RouteIdForStopId();


    public Map<String, List<String>> departureTime(String stopDesc, String departurTime) {

        List<Integer> stopIds = stopIdForStopDesc.stopIdForStopsDesc(stopDesc);
        List<Integer> routeIds = routeIdForStopId.routeIdForStopId(stopIds);

        List<Integer> routShortNames = allStopTimes.stream()
                .filter(routeIds::contains)
                .collect(Collectors.toList());

        Map<String, List<String>> departure = new HashMap<>();

        for (int i = 0; i < routShortNames.size(); i++) {

            List<StopTimes> stops = Repository
                    .getInstance()
                    .getStopTimes()
                    .get(routShortNames.get(i));

            Integer routeID = routShortNames.get(i);
            String routeId = routeID.toString();

            List<Trip> newTrip = Repository
                    .getInstance()
                    .getTrips();

            List<Integer> tripId = stops.stream()
                    .map(StopTimes::getTripId)
                    .distinct()
                    .collect(Collectors.toList());

            for (int j = 0; j < tripId.size(); j++) {

                Integer trip = tripId.get(j);

                List<String> name = newTrip.stream()
                        .filter(f -> routeID.equals(f.getRouteId()))
                        .filter(l -> trip.equals(l.getTripId()))
                        .map(o -> o.getTripHeadsign().replaceAll("[(0-9)]", "").trim())
                        .collect(Collectors.toList());

                String tripHeadsign = name.toString();


                List<String> firstTime = stops.stream()
                        .filter(s -> stopIds.contains(s.getStopId()))
                        .filter(f -> trip.equals(f.getTripId()))
                        .map(StopTimes::getDepartureTime)
                        .collect(Collectors.toList());

                String date = "1899-12-30";
                String date1 = "1899-12-31";

                List<String> secondTime = firstTime.stream()
                        .map(s -> s.split("T"))
                        .flatMap(Arrays::stream)
                        .filter(f -> !f.contains(date) && !f.contains(date1))
                        .sorted()
                        .collect(Collectors.toList());

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
                //  System.out.println("Kierunek = " + departure.keySet() + ", Godziny odjazdu = " + departure.values());
            }

        }
        System.out.println(Collections.singletonList(departure));
        return departure;
    }

    public Map<String, List<String>> departureTime(String stopDesc) {


        List<Integer> stopIds = stopIdForStopDesc.stopIdForStopsDesc(stopDesc);
        List<Integer> routeIds = routeIdForStopId.routeIdForStopId(stopIds);

        List<Integer> routShortNames = allStopTimes.stream()
                .filter(routeIds::contains)
                .collect(Collectors.toList());

        Map<String, List<String>> departure = new HashMap<>();

        for (int i = 0; i < routShortNames.size(); i++) {

            List<StopTimes> stops = Repository
                    .getInstance()
                    .getStopTimes()
                    .get(routShortNames.get(i));
            Integer routeID = routShortNames.get(i);
            String routeId = routeID.toString();

            List<Trip> newTrip = Repository
                    .getInstance()
                    .getTrips();

            List<Integer> tripId = stops.stream()
                    .map(StopTimes::getTripId)
                    .distinct()
                    .collect(Collectors.toList());

            for (int j = 0; j < tripId.size(); j++) {

                Integer trip = tripId.get(j);

                List<String> name = newTrip.stream()
                        .filter(f -> routeID.equals(f.getRouteId()))
                        .filter(l -> trip.equals(l.getTripId()))
                        .map(o -> o.getTripHeadsign().replaceAll("[(0-9)]", "").trim())
                        .collect(Collectors.toList());

                String tripHeadsign = name.toString();

                List<String> firstTime = stops.stream()
                        .filter(s -> stopIds.contains(s.getStopId()))
                        .filter(f -> trip.equals(f.getTripId()))
                        .map(StopTimes::getDepartureTime)
                        .collect(Collectors.toList());

                String date = "1899-12-30";
                String date1 = "1899-12-31";

                List<String> secondTime = firstTime.stream()
                        .map(s -> s.split("T"))
                        .flatMap(Arrays::stream)
                        .filter(f -> !f.contains(date) && !f.contains(date1))
                        .sorted()
                        .collect(Collectors.toList());


                departure.put(routeId + tripHeadsign, secondTime);

            }

        }

        System.out.println(Collections.singletonList(departure));
        return departure;
    }
}