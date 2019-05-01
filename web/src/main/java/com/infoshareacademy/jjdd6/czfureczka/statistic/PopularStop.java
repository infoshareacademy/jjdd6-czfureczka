package com.infoshareacademy.jjdd6.czfureczka.statistic;

import com.infoshareacademy.jjdd6.czfureczka.database.StopStatistic;
import com.infoshareacademy.jjdd6.czfureczka.database.StopStatisticDao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Stateless
public class PopularStop {

    @Inject
    StopStatisticDao statisticDao;

    public StopCount getMostPopularStop(){
        List<StopCount> test = getSortStops(1);
        return test.get(0);
    }

    public List<StopStatistic> getAll(){
        return statisticDao.findAll(StopStatistic.class);
    }

    public List<StopCount> getSortStops(Integer limit){
        List<StopCount> result = new ArrayList<>();
        Map<String, String> popularStops = statisticDao.findPopular(StopStatistic.class);
        Integer iter = popularStops.size();
        for (int i = 0; i < iter; i++) {
            String key = new ArrayList<>(popularStops.keySet()).get(0);
            result.add(new StopCount(key, popularStops.get(key)));
            popularStops.remove(key);
        }
        return result.stream()
                .sorted()
                .limit(limit)
                .collect(Collectors.toList());
    }

}
