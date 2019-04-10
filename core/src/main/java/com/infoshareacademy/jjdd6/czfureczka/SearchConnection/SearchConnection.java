package com.infoshareacademy.jjdd6.czfureczka.SearchConnection;

import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



public class SearchConnection {

    public List<Integer> FindDirectConnection(List<Integer> from, List<Integer> to) {

        ArrayList<Integer> ret = new ArrayList<>();
        for (Integer f : from) {
            for (Integer t : to) {
                ret.addAll(FindDirectConnection(f, t));
            }
        }

        return ret
                .stream()
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }


    public List<Integer> FindDirectConnection(int from, int to) {

        return GetRoutesIdForStop(from)
                .stream()
                .sorted()
                .filter(a -> IsRouteIdStoppingAtStopId(a, to)==true)
                .collect(Collectors.toList());
    }


    public boolean IsRouteIdStoppingAtStopId(int RouteID, int slupekID) {
        return GetRoutesIdForStop(slupekID).contains(RouteID);
    }


    public List<Integer> GetRoutesIdForStop (int slupekID) {

        String someDate= Repository
                .getInstance()
                .getStopsInTrip()
                .keySet()
                .stream()
                .collect(Collectors.toList())
                .get(0);

        return Repository.getInstance().getStopsInTrip().get(someDate)
                .getStopsInTrip()
                .stream()
                .filter(a -> a.getStopId() == slupekID)
                .map(a -> a.getRouteId())
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }


    public String  GetRouteNameFromID (int routeID) {

        String someDate = Repository
                .getInstance()
                .getRoutes()
                .keySet()
                .stream()
                .collect(Collectors.toList())
                .get(0);

        return   Repository.getInstance().getRoutes().get(someDate).getRoutes()
                .stream()
                .filter(a->a.getRouteId()==routeID)
                .sorted()
                .distinct()
                .map(a->a.getRouteShortName()+" "+a.getRouteLongName())
                .collect(Collectors.joining())
                ;
    }


    public List<String> GetRoutesNamesFromIDs (List<Integer> routesIDs) {

        ArrayList<String> ret = new ArrayList<>();
        for (Integer routesID : routesIDs) {
            ret.add(GetRouteNameFromID(routesID));
        }
        return ret;
    }
}
