package com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName;

import com.infoshareacademy.jjdd6.czfureczka.model.StopInTrip;
import com.infoshareacademy.jjdd6.czfureczka.model.StopsInTripWithDate;
import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class RouteIdForStopId {

    public List<Integer> routeIdForStopId(List<Integer> stopId) {

        String data = Repository.getInstance().getStopsInTrip().keySet().stream()
                .collect(Collectors.toList()).get(0);

        StopsInTripWithDate stopsInTripWithDate = Repository.getInstance().getStopsInTrip().get(data);


        List<StopInTrip> newStopInTrip = stopsInTripWithDate.getStopsInTrip();

        List<Integer> stopIdsInTrip = newStopInTrip.stream()
                .filter(s -> stopId.contains(s.getStopId()))
                .map(s -> s.getRouteId())
                .distinct()
                .collect(Collectors.toList());
        return stopIdsInTrip;
    }
}
