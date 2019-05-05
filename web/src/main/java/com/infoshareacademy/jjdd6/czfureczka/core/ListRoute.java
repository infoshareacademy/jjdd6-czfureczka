package com.infoshareacademy.jjdd6.czfureczka.core;

import com.infoshareacademy.jjdd6.czfureczka.agency.AgenciesModeOfTransportation;
import com.infoshareacademy.jjdd6.czfureczka.agency.ModeOfTransportation;
import com.infoshareacademy.jjdd6.czfureczka.database.RouteStatistic;
import com.infoshareacademy.jjdd6.czfureczka.database.RouteStatisticDao;
import com.infoshareacademy.jjdd6.czfureczka.model.StopInTrip;
import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;
import com.infoshareacademy.jjdd6.czfureczka.transfer.Transfer;
import com.infoshareacademy.jjdd6.czfureczka.validation.Validation;
import com.infoshareacademy.jjdd6.czfureczka.viewModel.RouteWithModeOfTransportation;
import com.infoshareacademy.jjdd6.czfureczka.viewModel.TripWithStops;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class ListRoute {

    @Inject
    Validation validation;

    @Inject
    RouteStatisticDao routeStatisticDao;

    public List<String> getListAllRoute() {
        return Repository.getInstance().getRoutes().stream()
                .map(r -> r.getRouteShortName())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<RouteWithModeOfTransportation> getListOfAllLinesForTypeVehicle(ModeOfTransportation type) {
        List<Integer> stops = Repository.getInstance().getStopsInTrip().stream()
                .filter(s -> s.getStopId() != 0)
                .map(s->s.getRouteId())
                .distinct()
                .collect(Collectors.toList());

        return Repository.getInstance().getRoutes().stream()
                .filter(r0 -> stops.contains(r0.getRouteId()))
                .map(r -> new RouteWithModeOfTransportation(r.getRouteId(), r.getRouteShortName(), AgenciesModeOfTransportation.mapping.get(r.getAgencyId())))
                .filter(r1 -> r1.getModeOfTransportation() == type)
                .sorted()
                .collect(Collectors.toList());
    }

    public boolean checkNameOfRoute(String route) {
        Boolean result = validation.validationOfRoutName(route);
        if (result) {
            LocalDate now = LocalDate.now();
            routeStatisticDao.save(new RouteStatistic(route, now));
        }
        return result;
    }

    public String getNameRoute(String routeId){
        return Repository.getInstance().getRoutes().stream()
                .filter(r -> r.getRouteId() == Integer.valueOf(routeId))
                .map(r1 -> r1.getRouteShortName())
                .distinct()
                .collect(Collectors.joining());
    }

    public List<TripWithStops> getListStopsInTrip(String route) {
        if (checkRouteId(route)) {

            Integer routeId = Integer.valueOf(route);
            List<Integer> tripsId = Repository.getInstance().getTrips().stream()
                    .filter(t -> t.getRouteId() == routeId)
                    .map(t1 -> t1.getTripId())
                    .distinct()
                    .collect(Collectors.toList());

            List<TripWithStops> tripWithStopsList = new ArrayList<>();

            for (int i = 0; i < tripsId.size(); i++) {
                TripWithStops tripWithStops = new TripWithStops();
                tripWithStops.setRouteId(routeId);
                tripWithStops.setTripId(tripsId.get(i));
                List<String> stops = new ArrayList<>();

                Integer trip = i;

                List<Integer> stopSequence = Repository.getInstance().getStopsInTrip().stream()
                        .filter(s -> s.getRouteId() == routeId)
                        .filter(s1 -> s1.getTripId() == tripsId.get(trip))
                        .sorted(Comparator.comparingInt(StopInTrip::getStopSequence))
                        .map(StopInTrip::getStopId)
                        .collect(Collectors.toList());

                for (int j = 0; j < stopSequence.size(); j++) {
                    Integer stop = j;

                    String stopName = Repository.getInstance().getStops().stream()
                            .filter(s -> s.getStopId() == stopSequence.get(stop))
                            .map(s2 -> s2.getStopDesc())
                            .distinct()
                            .collect(Collectors.joining());

                    stops.add(stopName);

                    if (stop == stopSequence.size() - 1) {
                        tripWithStops.setStopEnd(stopName);
                    }
                }
                tripWithStops.setStops(stops.stream().distinct().collect(Collectors.toList()));
                tripWithStopsList.add(tripWithStops);
            }
            return tripWithStopsList;
        }
        return new ArrayList<>();
    }

    public boolean checkRouteId(String route){
        if (Repository.getInstance().getRoutes().stream().anyMatch(r -> Integer.valueOf(route) == r.getRouteId())){
            LocalDate now = LocalDate.now();
            routeStatisticDao.save(new RouteStatistic(Repository.getInstance().getRoutes().stream()
                    .filter(r -> r.getRouteId() == Integer.valueOf(route))
                    .map(r -> r.getRouteShortName())
                    .distinct()
                    .collect(Collectors.toList()).get(0), now));
            return true;
        }
        return false;
    }
}
