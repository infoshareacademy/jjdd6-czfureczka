package com.infoshareacademy.jjdd6.czfureczka.lookingForRouteShortName;

import java.util.List;

public class LookingForRouteShortName {

    public List<String> lookingForShortName (String StopDesc){

        StopIdForStopDesc stopIdForStopDesc = new StopIdForStopDesc();
        RouteIdForStopId routeIdForStopId = new RouteIdForStopId();
        RouteShortIdForRouteId routeShortIdForRouteId = new RouteShortIdForRouteId();

        List<Integer> first = stopIdForStopDesc.stopIdForStopsDesc(StopDesc);

        List<Integer> second = routeIdForStopId.routeIdForStopId(first);

        List<String> third = routeShortIdForRouteId.routeShortNameForRouteId(second);

        return third;
    }
}

