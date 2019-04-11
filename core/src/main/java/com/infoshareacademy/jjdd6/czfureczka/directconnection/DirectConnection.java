package com.infoshareacademy.jjdd6.czfureczka.directconnection;

import com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName.RouteIdForStopId;
import com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName.RouteShortNamesForRouteId;
import com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName.StopIdForStopDesc;

import java.util.List;
import java.util.stream.Collectors;

public class DirectConnection {

    public String checkSharedTrip(String startingStop, String endingStop) {
        List<Integer> routsSharedTrip = haveRoutsSharedTrip(startingStop, endingStop);
        if (routsSharedTrip.size() == 0) {
            return "Brak bezpośredniego połączenia.";
        }
        RouteShortNamesForRouteId routeShortNamesForRouteId = new RouteShortNamesForRouteId();
        return routeShortNamesForRouteId.routeShortNameForRouteId(routsSharedTrip).stream()
                .collect(Collectors.joining(", "));
    }

    private List<Integer> haveRoutsSharedTrip(String startingStop, String endingStop) {
        StopIdForStopDesc stopIdForStopDesc = new StopIdForStopDesc();
        RouteIdForStopId routeIdForStopId = new RouteIdForStopId();
        List<Integer> startingStops = routeIdForStopId.routeIdForStopId(stopIdForStopDesc.stopIdForStopsDesc(startingStop));
        List<Integer> endingStops = routeIdForStopId.routeIdForStopId(stopIdForStopDesc.stopIdForStopsDesc(endingStop));
        if (startingStops.size() > endingStops.size()) {
            return endingStops.stream()
                    .filter(startingStops::contains)
                    .collect(Collectors.toList());
        }
        return startingStops.stream()
                .filter(endingStops::contains)
                .collect(Collectors.toList());
    }

}
