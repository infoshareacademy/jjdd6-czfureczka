package com.infoshareacademy.jjdd6.czfureczka.directconnection;

import com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName.RouteIdForStopId;
import com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName.RouteShortNamesForRouteId;
import com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName.StopIdForStopDesc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DirectConnection {

    public List<String> checkSharedTrip(String startingStop, String endingStop) {
        List<Integer> routsSharedTrip = haveRoutsSharedTrip(startingStop, endingStop);
        if (routsSharedTrip.size() == 0) {
            return new ArrayList<>();
        }
        RouteShortNamesForRouteId routeShortNamesForRouteId = new RouteShortNamesForRouteId();
        return new ArrayList<>(routeShortNamesForRouteId.routeShortNameForRouteId(routsSharedTrip));
    }

    private List<Integer> haveRoutsSharedTrip(String startingStop, String endingStop) {
        List<Integer> startingStops = conversionStopDescIntoRouteId(startingStop);
        List<Integer> endingStops = conversionStopDescIntoRouteId(endingStop);
        if (startingStops.size() > endingStops.size()) {
            return endingStops.stream()
                    .filter(startingStops::contains)
                    .collect(Collectors.toList());
        }
        return startingStops.stream()
                .filter(endingStops::contains)
                .collect(Collectors.toList());
    }

    public List<Integer> conversionStopDescIntoRouteId(String stopDesc) {
        StopIdForStopDesc stopIdForStopDesc = new StopIdForStopDesc();
        RouteIdForStopId routeIdForStopId = new RouteIdForStopId();
        return routeIdForStopId.routeIdForStopId(stopIdForStopDesc.stopIdForStopsDesc(stopDesc));
    }

}
