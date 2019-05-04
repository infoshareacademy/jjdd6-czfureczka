package com.infoshareacademy.jjdd6.czfureczka.core;

import com.infoshareacademy.jjdd6.czfureczka.database.StopStatistic;
import com.infoshareacademy.jjdd6.czfureczka.database.StopStatisticDao;
import com.infoshareacademy.jjdd6.czfureczka.departureTimes.DepartureTimes;
import com.infoshareacademy.jjdd6.czfureczka.validation.Validation;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

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
}
