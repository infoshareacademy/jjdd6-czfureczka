package com.infoshareacademy.jjdd6.czfureczka.core;

import com.infoshareacademy.jjdd6.czfureczka.database.StopStatistic;
import com.infoshareacademy.jjdd6.czfureczka.database.StopStatisticDao;
import com.infoshareacademy.jjdd6.czfureczka.directconnection.DirectConnection;
import com.infoshareacademy.jjdd6.czfureczka.transfer.Transfer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Stateless
public class Trip {

    @Inject
    ListStops listStops;

    @Inject
    DirectConnection directConnection;

    @Inject
    Transfer transfer;

    @Inject
    StopStatisticDao stopStatisticDao;

    private static final Logger logger = Logger.getLogger(Trip.class.getName());

    public List<String> getDirectTrip(String initialStop, String destinationStop) {
        String start = cropTagFromStopName(initialStop);
        String end = cropTagFromStopName(destinationStop);

        if (listStops.checkNameOfStop(start) && listStops.checkNameOfStop(end)) {

            LocalDate now = LocalDate.now();
            stopStatisticDao.save(new StopStatistic(start, now));
            stopStatisticDao.save(new StopStatistic(end, now));

            List<String> trip = directConnection.checkSharedTrip(start, end);

            if (trip.size() != 0) {
                return trip;
            }
        }
        return new ArrayList<>();
    }

    public List<TripWithTransfer> getTrip(String initialStop, String destinationStop) {

        String start = cropTagFromStopName(initialStop);
        String end = cropTagFromStopName(destinationStop);

        if (listStops.checkNameOfStop(start) && listStops.checkNameOfStop(end)) {

            Map<Integer, List<String>> trip = transfer.transfer(start, end);
            logger.info("The size of the found map with solutions: " + trip.size());

            if (trip.size() != 0) {

                List<TripWithTransfer> result = new ArrayList<>();
                List<String> routeStart = new ArrayList<>();
                List<String> routeEnd = new ArrayList<>();

                Integer processingStage;
                List<Integer> number = new ArrayList<>(trip.keySet());
                for (int i = 0; i < number.size(); i++) {
                    TripWithTransfer tripWithTransfer = new TripWithTransfer();
                    processingStage = 0;

                    for (int j = 0; j < trip.get(number.get(i)).size(); j++) {
                        String word = trip.get(number.get(i)).get(j);

                        if (processingStage == 0) {
                            if (!word.equals("przesiadka na:")) {
                                routeStart.add(word);
                            }else {
                                processingStage = 1;
                                continue;
                            }
                        }

                        if (processingStage == 1){
                            if (!word.equals("następnie pojedź:")){
                                tripWithTransfer.setStop(word);
                            }else {
                                processingStage = 2;
                                continue;
                            }
                        }

                        if (processingStage == 2){
                            if (!word.equals("Jesteś u celu!")){
                                routeEnd.add(word);
                            }
                        }
                    }

                    tripWithTransfer.setRouteStart(routeStart.stream().distinct().collect(Collectors.toList()));
                    tripWithTransfer.setRouteEnd(routeEnd.stream().distinct().collect(Collectors.toList()));
                    result.add(tripWithTransfer);
                }

                logger.info("The size of the generated list of solutions: " + result.size());
                return result;
            }
        }
        return new ArrayList<>();
    }

    public String cropTagFromStopName(String longName) {
        if (longName.contains(":")) {
            return longName.split(": ")[longName.split(": ").length - 1];
        }
        return longName;
    }

}
