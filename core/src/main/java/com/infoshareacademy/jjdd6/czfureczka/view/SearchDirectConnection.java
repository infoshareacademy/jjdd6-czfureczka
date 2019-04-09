package com.infoshareacademy.jjdd6.czfureczka.model;

import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchDirectConnection {


    // Przyjmuje słupekID, zwraca listę routeID, które przy nim stają

    static List<Integer> findDirectConnection(int from, int to) {

        return getRoutesIdForStop(from)
                .stream()
                .filter(a -> isRouteIdStoppingAtStopId(a, to)==true)
                .collect(Collectors.toList());
    }

    //czy na przystanku slupekID zatrzymuje się routeID

    static boolean isRouteIdStoppingAtStopId(int RouteID, int slupekID) {
        return getRoutesIdForStop(slupekID).contains(RouteID);
    }

    static List<Integer> getRoutesIdForStop (int slupekID) {

        String someDate= Repository.getInstance().getStopsInTrip().keySet().stream().collect(Collectors.toList()).get(0);
        return Repository.getInstance().getStopsInTrip().get(someDate)
                .getStopsInTrip()
                .stream()
                .filter(a -> a.getStopId() == slupekID)
                .map(a -> a.getRouteId())
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }

    // Przyjmuje routeID, zwraca nazwę i opis trasy

    static String  GetRouteNameFromID (int routeID) {

        String someDate = Repository.getInstance().getRoutes().keySet().stream().collect(Collectors.toList()).get(0);
        return   Repository.getInstance().getRoutes().get(someDate).getRoutes()
                .stream()
                .filter(a->a.getRouteId()==routeID)
                .sorted()
                .distinct()
                .map(a->a.getRouteShortName()+" "+a.getRouteLongName())
                .collect(Collectors.joining())
                ;
    }

    //Przyjmuje listę routeIDs, zwraca listę nazw z opisami tras

    static List<String> GetRoutesNamesFromIDs (List<Integer> routesIDs) {

        ArrayList<String> ret = new ArrayList<>();
        for (Integer routesID : routesIDs) {
            ret.add(GetRouteNameFromID(routesID));
        }
        return ret;
    }

    public static void main(String[] args) {}
}
