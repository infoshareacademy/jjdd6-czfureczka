package com.infoshareacademy.jjdd6.czfureczka.lookingForRouteShortName;

import com.infoshareacademy.jjdd6.czfureczka.model.Route;
import com.infoshareacademy.jjdd6.czfureczka.model.RoutesWithDate;
import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class RouteShortIdForRouteId {

    public List<String> routeShortNameForRouteId (List<Integer> stopIdInTrip) {

        String k = Repository.getInstance().getRoutes().keySet().stream()
                .collect(Collectors.toList()).get(0);

        RoutesWithDate routesWithDate = Repository.getInstance().getRoutes().get(k);

        List<Route> newRoute= routesWithDate.getRoutes();

        List<String> routShortName = newRoute.stream()
                .filter(s -> stopIdInTrip.contains(s.getRouteId()))
                .map(s -> s.getRouteShortName())
                .distinct()
                .collect(Collectors.toList());
        return routShortName;

    }

}
