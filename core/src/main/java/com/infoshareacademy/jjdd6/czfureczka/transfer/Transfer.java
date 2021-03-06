package com.infoshareacademy.jjdd6.czfureczka.transfer;

import com.infoshareacademy.jjdd6.czfureczka.directconnection.DirectConnection;
import com.infoshareacademy.jjdd6.czfureczka.model.Stop;
import com.infoshareacademy.jjdd6.czfureczka.model.StopInTrip;
import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;
import com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName.StopIdForStopDesc;

import javax.ejb.Stateless;
import java.util.*;
import java.util.stream.Collectors;

@Stateless
public class Transfer {

    public Map<Integer, List<String>> transfer(String startingStop, String endingStop) {
        Map<Integer, List<String>> result = new TreeMap<>();
        DirectConnection directConnection = new DirectConnection();
        List<Integer> transferStopsId = transferStops(startingStop.trim(), endingStop.trim());
        if (transferStopsId.size() == 0) {
            return new HashMap<>();
        }
        Map<String, List<String>> firstStepTrip = new HashMap<>();
        Map<String, List<String>> secondStepTrip = new HashMap<>();
        List<String> transferStopsDesc = transferStopsId.stream()
                .map(this::convertStopIdIntoStopDesc)
                .collect(Collectors.toList());
        for (String s : transferStopsDesc) {
            if (directConnection.checkSharedTrip(startingStop.trim(), s).size() != 0) {
                firstStepTrip.put(s, directConnection.checkSharedTrip(startingStop.trim(), s));
            }
            if (directConnection.checkSharedTrip(s, endingStop.trim()).size() != 0) {
                secondStepTrip.put(s, directConnection.checkSharedTrip(s, endingStop.trim()));
            }
        }
        List<String> firstStepTransferStopsNames = firstStepTrip.keySet().stream().distinct().collect(Collectors.toList());
        List<String> secondStepTransferStopNames = secondStepTrip.keySet().stream().distinct().collect(Collectors.toList());
        firstStepTransferStopsNames.addAll(secondStepTransferStopNames);
        List<String> distinctTransferStopsNames = firstStepTransferStopsNames.stream().distinct().sorted().collect(Collectors.toList());
        Integer numberResult = 0;

        for (String change : distinctTransferStopsNames) {
            List<String> transfer = new ArrayList<>();
            if (firstStepTrip.get(change) != null && firstStepTrip.get(change).size() != 0) {
                if (secondStepTrip.get(change) != null && secondStepTrip.get(change).size() != 0) {
                    transfer.addAll(firstStepTrip.get(change));
                    transfer.add("przesiadka na:");
                    transfer.add(change);
                    transfer.add("następnie pojedź:");
                    transfer.addAll(secondStepTrip.get(change));
                    transfer.add("Jesteś u celu!");
                    result.put(numberResult, transfer);
                    numberResult++;
                }
            }
        }
        return result;
    }

    private List<Integer> transferStops(String startingStop, String endingStop) {
        DirectConnection directConnection = new DirectConnection();
        StopIdForStopDesc stopID = new StopIdForStopDesc();
        List<Integer> startRoutId = directConnection.conversionStopDescIntoRouteId(startingStop);
        List<Integer> endingRoutId = directConnection.conversionStopDescIntoRouteId(endingStop);
        List<Integer> startTripId = startRoutId.stream()
                .map(s -> convertRouteIdIntoTripId(s, stopID.stopIdForStopsDesc(startingStop)))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        List<Integer> endingTripId = endingRoutId.stream()
                .map(s -> convertRouteIdIntoTripId(s, stopID.stopIdForStopsDesc(endingStop)))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        List<Integer> sharedStops = new ArrayList<>();
        for (Integer value : startTripId)
            for (Integer integer : endingTripId) {
                sharedStops.addAll(sharedStopsForTrips(value, integer));
            }
        if (sharedStops.size() == 0) {
            return new ArrayList<>();
        }
        return sharedStops.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    private List<Integer> convertRouteIdIntoTripId(Integer routId, List<Integer> stopId) {
        List<StopInTrip> newStopsInTrip = Repository.getInstance().getStopsInTrip();
        return newStopsInTrip.stream()
                .filter(s -> s.getRouteId() == routId)
                .filter(s1 -> stopId.contains(s1.getStopId()))
                .map(StopInTrip::getTripId)
                .distinct()
                .collect(Collectors.toList());
    }

    private List<Integer> convertTripIdIntoAllStopsId(Integer tripId) {
        List<StopInTrip> newStopsInTrip = Repository.getInstance().getStopsInTrip();
        return newStopsInTrip.stream()
                .filter(s -> s.getTripId() == tripId)
                .map(StopInTrip::getStopId)
                .distinct()
                .collect(Collectors.toList());
    }

    private List<Integer> sharedStopsForTrips(Integer firstTripId, Integer secondTripId) {
        List<Integer> firstAllStops = convertTripIdIntoAllStopsId(firstTripId);
        List<Integer> secondAllStops = convertTripIdIntoAllStopsId(secondTripId);
        return firstAllStops.stream()
                .filter(secondAllStops::contains)
                .collect(Collectors.toList());
    }

    private String convertStopIdIntoStopDesc(Integer stopsId) {
        List<Stop> newStops = Repository.getInstance().getStops();
        return newStops.stream()
                .filter(s -> s.getStopId() == stopsId)
                .map(Stop::getStopDesc)
                .distinct()
                .collect(Collectors.joining(", "));
    }

}
