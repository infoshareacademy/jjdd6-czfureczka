package com.infoshareacademy.jjdd6.czfureczka.SearchConnection;

import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchConnection {

    public List<Integer> findDirectConnection(List<Integer> from, List<Integer> to) {

        ArrayList<Integer> ret = new ArrayList<>();
        for (Integer f : from) {
            for (Integer t : to) {
                ret.addAll(findDirectConnection(f, t));
            }
        }

        return ret
                .stream()
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Integer> findDirectConnection(int from, int to) {

        return getRoutesIdForStop(from)
                .stream()
                .sorted()
                .filter(a -> isrouteIdStoppingAtstopId(a, to) == true)
                .collect(Collectors.toList());
    }

    public boolean isrouteIdStoppingAtstopId(int routeId, int stopId) {
        return getRoutesIdForStop(stopId).contains(routeId);
    }


    public List<Integer> getRoutesIdForStop(int stopId) {

        return Repository
                .getInstance()
                .getStopsInTrip()
                .stream()
                .filter(a -> a.getStopId() == stopId)
                .map(a -> a.getRouteId())
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }


    public String getRouteNameFromId(int routeId) {

        return Repository
                .getInstance()
                .getRoutes()
                .stream()
                .filter(a -> a.getRouteId() == routeId)
                .sorted()
                .distinct()
                .map(a -> a.getRouteShortName() + " " + a.getRouteLongName())
                .collect(Collectors.joining());
    }

    public List<String> getRoutesNamesFromIDs(List<Integer> routesIDs) {

        return routesIDs
                .stream()
                .map(a -> getRouteNameFromId(a))
                .collect(Collectors.toList());
    }
}
