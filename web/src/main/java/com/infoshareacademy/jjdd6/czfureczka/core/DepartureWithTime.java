package com.infoshareacademy.jjdd6.czfureczka.core;

import com.infoshareacademy.jjdd6.czfureczka.database.StopStatistic;
import com.infoshareacademy.jjdd6.czfureczka.database.StopStatisticDao;
import com.infoshareacademy.jjdd6.czfureczka.model.GetStopTimes;
import com.infoshareacademy.jjdd6.czfureczka.model.Stop;
import com.infoshareacademy.jjdd6.czfureczka.model.StopTimes;

import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;
import com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName.RouteIdForStopId;
import com.infoshareacademy.jjdd6.czfureczka.searchForRouteShortName.RouteShortNamesForRouteId;
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
public class DepartureWithTime {

    private static final Logger logger = Logger.getLogger(DepartureWithTime.class.getName());

    @Inject
    private StopStatisticDao stopStatisticDao;

    @Inject
    private Validation validation;

    @Inject
    private Trip trip;

    @Inject
    private ListRoute listRoute;

    @Inject
    private GetStopTimes getStopTimes;

    @Inject
    private StopIdForStopDesc stopIdForStopDesc;

    @Inject
    private RouteIdForStopId routeIdForStopId;

    @Inject
    private RouteShortNamesForRouteId shortNamesForRouteId;


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

            if (times.size() != 0) {
                timetableForStop.setTime(times);
                result.add(timetableForStop);
            }
        }
        return result;
    }

    public List<String> getFullTimetableForView(String stopDesc, String tripId, String routeId) {
        if (validation.validationOfStopName(stopDesc)) {
            if (listRoute.checkRouteId(routeId)) {

                if (trip.checkTripId(tripId)) {
                    LocalDate now = LocalDate.now();
                    stopStatisticDao.save(new StopStatistic(stopDesc, now));

                    List<String> timeTable=cropDateFromTime(getFullTimetable(stopDesc, Integer.valueOf(tripId), Integer.valueOf(routeId)));
                    logger.info(timeTable.toString()+"timetable");
                    if (timeTable.isEmpty() || timeTable.size()==0){
                        timeTable.add("Brak danych");
                    }
                    return timeTable;
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
                return departure(name, time);
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
                .sorted()
                .collect(Collectors.toList());
        return result;
    }

    private List<String> secondTime(List<String> firstTime) {

        final String date = "1899-12-30";
        final String date1 = "1899-12-31";

        List<String> secondTime = firstTime.stream()
                .map(s -> s.split("T"))
                .flatMap(Arrays::stream)
                .filter(f -> !f.contains(date) && !f.contains(date1))
                .sorted()
                .collect(Collectors.toList());
        return secondTime;
    }

    private List<StopTimes> stopTime(List<Integer> routeIds) {

        List<StopTimes> stops = new ArrayList<>();

        for (int i = 0; i < routeIds.size(); i++) {
            String route = routeIds.get(i).toString().trim();
            List<StopTimes> stop = getStopTimes.getStopTimes(route);
            stops.addAll(stop);
        }

        return stops;
    }

    private Map<String, List<String>> departure(String name, String time) {

        Map<String, List<String>> departure = new TreeMap<>();

        List<Integer> stopIds = stopIdForStopDesc.stopIdForStopsDesc(name);
        List<Integer> routeIds = routeIdForStopId.routeIdForStopId(stopIds);

        List<StopTimes> stops = stopTime(routeIds);

        List<Integer> allStopTime = stops.stream()
                .map(m -> m.getRouteId())
                .distinct()
                .collect(Collectors.toList());

        for (int i = 0; i < allStopTime.size(); i++) {

            Integer routeID = allStopTime.get(i);

            List<StopTimes> stop = stops.stream()
                    .filter(f -> routeID.equals(f.getRouteId()))
                    .collect(Collectors.toList());

            List<Integer> tripId = Repository.getInstance().getExpeditionData().getExpeditionData().stream()
                    .filter(ex -> ex.getMainRoute() == 1)
                    .distinct()
                    .filter(f -> routeID.equals(f.getRouteId()))
                    .map(m -> m.getTripId())
                    .distinct()
                    .collect(Collectors.toList());

            for (int j = 0; j < tripId.size(); j++) {

                Integer trip = tripId.get(j);

                List<String> departureTimes = secondTime(firstTime(stop, stopIds, trip));

                List<Time> times = departureTimes.stream()
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

                if (!timeOfDeparture.isEmpty() || timeOfDeparture.size() != 0) {
                    List<String> stopEnds = listRoute.getListStopsInTrip(routeID).stream()
                            .filter(f -> trip.equals(f.getTripId()))
                            .map(m -> m.getStopEnd())
                            .distinct()
                            .collect(Collectors.toList());

                    String stopEnd = stopEnds.get(0);

                    List<Integer> listOfRoute = Arrays.asList(routeID);
                    String nameRoute = shortNamesForRouteId.routeShortNameForRouteId(listOfRoute).get(0);

                    departure.put(nameRoute + " Kierunek " + stopEnd, timeOfDeparture);
                }
            }
        }

        return departure;
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