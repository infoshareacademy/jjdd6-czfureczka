package com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName;

import com.infoshareacademy.jjdd6.czfureczka.model.Route;
import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class RouteShortNamesForRouteId {

    public List<String> routeShortNameForRouteId(List<Integer> stopIdInTrip) {
        List<Route> newRoute = Repository.getInstance().getRoutes();

        return newRoute.stream()
                .filter(s -> stopIdInTrip.contains(s.getRouteId()))
                .map(s -> s.getRouteShortName())
                .distinct()
                .collect(Collectors.toList());
    }

}
