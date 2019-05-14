package com.infoshareacademy.jjdd6.czfureczka.core;

import com.infoshareacademy.jjdd6.czfureczka.database.StopStatistic;
import com.infoshareacademy.jjdd6.czfureczka.database.StopStatisticDao;
import com.infoshareacademy.jjdd6.czfureczka.departureTimes.DepartureTimes;
import com.infoshareacademy.jjdd6.czfureczka.model.GetStopTimes;
import com.infoshareacademy.jjdd6.czfureczka.model.Stop;
import com.infoshareacademy.jjdd6.czfureczka.model.StopTimes;
import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;
import com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName.RouteIdForStopId;
import com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName.StopIdForStopDesc;
import com.infoshareacademy.jjdd6.czfureczka.validation.Validation;
import com.infoshareacademy.jjdd6.czfureczka.viewModel.TimetableForStop;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.sql.Time;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Stateless
public class Departure {
    private static final Logger logger = Logger.getLogger(DepartureWithTime.class.getName());

    @Inject
    StopStatisticDao stopStatisticDao;

    @Inject
    Validation validation;

    @Inject
    DepartureTimes departureTimes;

    @Inject
    Trip trip;

    @Inject
    ListRoute listRoute;

    @Inject
    GetStopTimes getStopTimes;

    @Inject
    StopIdForStopDesc stopIdForStopDesc;

    @Inject
    RouteIdForStopId routeIdForStopId;


    public List<TimetableForStop> getTimetableForStop(String name, String time) {
        Map<String, List<String>> timetable = getTimetable(name, time);
        logger.info("Timetable size: " + timetable.size());
        List<String> routes = new ArrayList<>(timetable.keySet());
        List<TimetableForStop> result = new ArrayList<>();

        for (int i = 0; i < routes.size(); i++) {
            TimetableForStop timetableForStop = new TimetableForStop();
            List<String> times = new ArrayList<>();
            timetableForStop.setRouteId(routes.get(i));
            for (int j = 0; j < timetable.get(routes.get(i)).size(); j++) {
                String longTime = timetable.get(routes.get(i)).get(j);
                longTime = longTime.replaceAll(":00", "");
                times.add(longTime);
            }
            timetableForStop.setTime(times);
            result.add(timetableForStop);
        }
        return result;
    }

    public List<String> getFullTimetableForView(String stopDesc, String tripId, String routeId) {
        if (validation.validationOfStopName(stopDesc)) {
            if (listRoute.checkRouteId(routeId)) {
                LocalDate now = LocalDate.now();
                stopStatisticDao.save(new StopStatistic(stopDesc, now));
                if (trip.checkTripId(tripId)) {
                    return cropDateFromTime(getFullTimetable(stopDesc, Integer.valueOf(tripId), Integer.valueOf(routeId)));
                }
            }
        }
        return new ArrayList<>();
    }

    private Map<String, List<String>> getTimetable(String name, String time) {
        time = time.trim() + ":00";
        name = trip.cropTagFromStopName(name);
        if (validation.validationOfTimeDeparture(time)) {
            if (validation.validationOfStopName(name)) {
                LocalDate now = LocalDate.now();
                stopStatisticDao.save(new StopStatistic(name, now));
                return departureTimes.departureTimes(name, time);
            }
            logger.info("Incorrect name of the stop.");
        }
        logger.info("Incorrect time.");
        return new HashMap<>();
    }


    private List<String> getFullTimetable(String stopDesc, Integer tripId, Integer routeId) {
        List<Integer> stop = Repository.getInstance().getStops().stream()
                .filter(s -> s.getStopDesc().equals(stopDesc))
                .map(Stop::getStopId)
                .distinct()
                .collect(Collectors.toList());

        String route = String.valueOf(routeId);

        List<String> result = getStopTimes.getStopTimes(route).stream()
                .filter(s -> s.getTripId() == tripId)
                .filter(s -> stop.contains(s.getStopId()))
                .map(StopTimes::getDepartureTime)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        return result;
    }

    private List<String> cropDateFromTime(List<String> timeWithDate) {
        List<String> result = timeWithDate.stream()
                .map(s -> {
                    if (s.contains("1899-12-30T")) {
                        return s.split("1899-12-30T")[1];
                    } else if (s.contains("1899-12-31T")) {
                        return s.split("1899-12-31T")[1];
                    }
                    return s;
                })
                .map(s -> s.split(":00")[0])
                .collect(Collectors.toList());
        return result;
    }


    private Map<String, List<String>> departureTime(String name, String time) {

        time = time.trim() + ":00";

        List<Integer> stopIds = stopIdForStopDesc.stopIdForStopsDesc(name);
        List<Integer> routeIds = routeIdForStopId.routeIdForStopId(stopIds);

        List<Integer> routShortNames = routShortNames(routeIds);
        List<String>  route=routShortNames.stream().map(m->m.toString()).collect(Collectors.toList());

        Map<String, List<String>> departure = new HashMap<>();


        for (int i = 0; i < routShortNames.size(); i++) {

            List<StopTimes> stops = getStopTimes.getStopTimes(route.get(i));

            List<com.infoshareacademy.jjdd6.czfureczka.model.Trip> newTrip = Repository
                    .getInstance()
                    .getTrips();

            List<Integer> tripId = tripId(stops);

            Integer routeID = routShortNames.get(i);

            String routeId = routeID.toString();

            for (int j = 0; j < tripId.size(); j++) {

                Integer trip = tripId.get(j);

                String tripHeadsign = tripHeadsing(newTrip, routeID, trip);

                List<String> firstTime = firstTime(stops, stopIds, trip);

                List<String> secondTime = cropDateFromTime(firstTime);

                List<Time> times = secondTime.stream()
                        .map(Time::valueOf)
                        .collect(Collectors.toList());

                Time timee = Time.valueOf(time);

                List<String> timeOfDeparture = times.stream()
                        .filter(s -> s.after(timee))
                        .limit(5)
                        .map(m -> m.toString())
                        .collect(Collectors.toList());

                if (timeOfDeparture.size() < 5) {

                    Time time2 = Time.valueOf("00:00:00");

                    List<String> timeOfDeparture2 = times.stream()
                            .filter(s -> s.after(time2))
                            .limit(5 - timeOfDeparture.size())
                            .map(m -> m.toString())
                            .collect(Collectors.toList());

                    timeOfDeparture.addAll(timeOfDeparture2);
                }

                departure.put(routeId + tripHeadsign, timeOfDeparture);
            }
        }

        return departure;
    }

    private List<Integer> routShortNames(List<Integer> routeIds) {

        List<Integer> allStopTimes = Repository
                .getInstance()
                .getStopTimes()
                .keySet().stream()
                .collect(Collectors.toList());

        List<Integer> routShortNames = allStopTimes.stream()
                .filter(routeIds::contains)
                .collect(Collectors.toList());

        return routShortNames;
    }

    private List<Integer> tripId(List<StopTimes> stops) {

        List<Integer> tripId = stops.stream()
                .map(StopTimes::getTripId)
                .distinct()
                .collect(Collectors.toList());
        return tripId;
    }

    private String tripHeadsing(List<com.infoshareacademy.jjdd6.czfureczka.model.Trip> newTrip, Integer routeID, Integer trip) {

        List<String> name = newTrip.stream()
                .filter(f -> routeID.equals(f.getRouteId()))
                .filter(l -> trip.equals(l.getTripId()))
                .map(o -> o.getTripHeadsign().replaceAll("[(0-9)]", "").trim())
                .collect(Collectors.toList());

        String tripHeadsign = name.toString();

        return tripHeadsign;
    }

    private List<String> firstTime(List<StopTimes> stops, List<Integer> stopIds, Integer trip) {

        List<String> firstTime = stops.stream()
                .filter(s -> stopIds.contains(s.getStopId()))
                .filter(f -> trip.equals(f.getTripId()))
                .map(StopTimes::getDepartureTime)
                .collect(Collectors.toList());

        return firstTime;
    }


}

