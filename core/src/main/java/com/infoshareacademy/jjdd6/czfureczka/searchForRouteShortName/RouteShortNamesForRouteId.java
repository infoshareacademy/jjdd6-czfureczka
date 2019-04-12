package com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName;

import com.infoshareacademy.jjdd6.czfureczka.model.Route;
import com.infoshareacademy.jjdd6.czfureczka.model.RoutesWithDate;
import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class RouteShortNamesForRouteId {

    public List<String> routeShortNameForRouteId(List<Integer> stopIdInTrip) {

        String data = Repository.getInstance().getRoutes().keySet().stream()
                .collect(Collectors.toList()).get(0);

        RoutesWithDate routesWithDate = Repository.getInstance().getRoutes().get(data);


        List<Route> newRoute = routesWithDate.getRoutes();

        List<String> routShortNames = newRoute.stream()
                .filter(s -> stopIdInTrip.contains(s.getRouteId()))
                .map(s -> s.getRouteShortName())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        return routShortNames;

    }

}
