package com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName;

import java.util.List;

public class SearchForRouteShortName {

    public List<String> lookingForShortName(String stopDesc) {

        StopIdForStopDesc stopIdForStopDesc = new StopIdForStopDesc();
        RouteIdForStopId routeIdForStopId = new RouteIdForStopId();
        RouteShortNamesForRouteId routeShortIdForRouteId = new RouteShortNamesForRouteId();

        List<Integer> stopIds = stopIdForStopDesc.stopIdForStopsDesc(stopDesc.trim());

        List<Integer> routeIds = routeIdForStopId.routeIdForStopId(stopIds);

        return routeShortIdForRouteId.routeShortNameForRouteId(routeIds);
    }
}

