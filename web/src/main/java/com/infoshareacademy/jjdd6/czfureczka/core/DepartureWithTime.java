package com.infoshareacademy.jjdd6.czfureczka.core;

import com.infoshareacademy.jjdd6.czfureczka.database.StopStatistic;
import com.infoshareacademy.jjdd6.czfureczka.database.StopStatisticDao;
import com.infoshareacademy.jjdd6.czfureczka.departureTimes.DepartureTimes;
import com.infoshareacademy.jjdd6.czfureczka.model.Stop;
import com.infoshareacademy.jjdd6.czfureczka.model.StopTimes;
import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;
import com.infoshareacademy.jjdd6.czfureczka.validation.Validation;
import com.infoshareacademy.jjdd6.czfureczka.viewModel.TimetableForStop;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Stateless
public class DepartureWithTime {

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

                if (trip.checkTripId(tripId)) {
                    LocalDate now = LocalDate.now();
                    stopStatisticDao.save(new StopStatistic(stopDesc, now));
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

        List<String> result = Repository.getInstance().getStopTimes().get(routeId).stream()
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
}
