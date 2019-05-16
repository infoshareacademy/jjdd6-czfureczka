package com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName;

import com.infoshareacademy.jjdd6.czfureczka.model.StopInTrip;
import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;

import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class RouteIdForStopId {

    public List<Integer> routeIdForStopId(List<Integer> stopId) {
        List<StopInTrip> newStopInTrip = Repository.getInstance().getStopsInTrip();

        List<Integer> stopIdsInTrip = newStopInTrip.stream()
                .filter(s -> stopId.contains(s.getStopId()))
                .map(s -> s.getRouteId())
                .distinct()
                .collect(Collectors.toList());
        return stopIdsInTrip;
    }
}
