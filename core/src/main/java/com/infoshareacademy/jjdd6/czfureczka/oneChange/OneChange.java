package com.infoshareacademy.jjdd6.czfureczka.oneChange;

import com.infoshareacademy.jjdd6.czfureczka.model.StopInTrip;
import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;
import com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName.RouteIdForStopId;
import com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName.RouteShortNamesForRouteId;
import com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName.StopIdForStopDesc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OneChange {

    public List<Integer> giveAllStopIdInOneLine(int tripId) {
        String date = new ArrayList<>(Repository.getInstance().getStopsInTrip().keySet()).get(0);
        List<StopInTrip> stopInTrips = Repository.getInstance().getStopsInTrip().get(date).getStopsInTrip();
        return stopInTrips.stream()
                .filter(s1 -> s1.getTripId() == tripId)
                .map(s2 -> s2.getStopId())
                .collect(Collectors.toList());

    }
    public String oneChange (String startingStop, String endingstop){
        List<String> transferStops = giveOneChange(startingStop, endingstop);
        String firstStepTrip = transferStops.stream()
                .flatMap(t->giveOneChange(startingStop,t).stream())
                .distinct()
                .collect(Collectors.joining(", "));
        String secondStep = transferStops.stream()
                .flatMap(t-> giveOneChange(t, endingstop).stream())
                .distinct()
                .collect(Collectors.joining(", "));
        return "Należy jechać: "
                + firstStepTrip
                + " do przystanku: "
                + transferStops.stream().collect(Collectors.joining(", "))
                + " następnie pojechać: "
                + secondStep;

    }

    private List<String> giveOneChange (String startingStop, String endingstop){
        List<Integer> transferStops = lookingForTransferStop(startingStop, endingstop);
        List<String> transferStop = new ArrayList<>();
        if (transferStops.size()==0){
            transferStop.add("Brak połączenia");
            return transferStop;
        }
        RouteIdForStopId routeIdForStopId = new RouteIdForStopId();
        RouteShortNamesForRouteId routeShortIdForRouteId = new RouteShortNamesForRouteId();
        List<Integer> routeIds = routeIdForStopId.routeIdForStopId(transferStops);

        return routeShortIdForRouteId.routeShortNameForRouteId(routeIds);
    }

    public List<Integer> lookingForTransferStop(String startingStop, String endingstop){
        StopIdForStopDesc stopIdForStopDesc = new StopIdForStopDesc();
        List<Integer> startingStops = giveTripId(stopIdForStopDesc.stopIdForStopsDesc(startingStop));
        List<Integer> endingStops = giveTripId(stopIdForStopDesc.stopIdForStopsDesc(endingstop));
        List<Integer> startStopsIDs = startingStops.stream()
                .flatMap(s-> giveAllStopIdInOneLine(s).stream())
                .collect(Collectors.toList());
        List<Integer> endStopID = endingStops.stream()
                .flatMap(s-> giveAllStopIdInOneLine(s).stream())
                .collect(Collectors.toList());
        if (startStopsIDs.size()>endStopID.size()){
            return endStopID.stream()
                    .filter(startStopsIDs::contains)
                    .distinct()
                    .collect(Collectors.toList());
        }
        return startStopsIDs.stream()
                .filter(endStopID::contains)
                .distinct()
                .collect(Collectors.toList());

    }
    public String checkSharedTrip (String startingStop, String endingstop){
        List<Integer> routsSharedTrip = haveRoutsSharedTrip(startingStop, endingstop);
        if (routsSharedTrip.size()==0){
            return "Brak bezpośredniego połączenia.";
        }
        RouteShortNamesForRouteId routeShortNamesForRouteId = new RouteShortNamesForRouteId();
        return routeShortNamesForRouteId.routeShortNameForRouteId(routsSharedTrip).stream()
                .collect(Collectors.joining(", "));
    }


    private List<Integer> haveRoutsSharedTrip(String startingStop, String endingstop) {
        StopIdForStopDesc stopIdForStopDesc = new StopIdForStopDesc();
        RouteIdForStopId routeIdForStopId = new RouteIdForStopId();
        List<Integer> startingStops = routeIdForStopId.routeIdForStopId(stopIdForStopDesc.stopIdForStopsDesc(startingStop));
        List<Integer> endingStops = routeIdForStopId.routeIdForStopId(stopIdForStopDesc.stopIdForStopsDesc(endingstop));
        if (startingStops.size()>endingStops.size()){
            return endingStops.stream()
                    .filter(e -> startingStops.contains(e))
                    .collect(Collectors.toList());
        }
        return startingStops.stream()
                .filter(s -> endingStops.contains(s))
                .collect(Collectors.toList());
    }



    private List<Integer> giveTripId (List<Integer> stopId){
        String date = new ArrayList<>(Repository.getInstance().getStopsInTrip().keySet()).get(0);
        List<StopInTrip> stopInTrips = Repository.getInstance().getStopsInTrip().get(date).getStopsInTrip();
        return stopInTrips.stream()
                .filter(s -> stopId.contains(s.getStopId()))
                .map(s1 -> s1.getTripId())
                .distinct()
                .collect(Collectors.toList());
    }

}
