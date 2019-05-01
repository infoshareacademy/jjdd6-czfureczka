package com.infoshareacademy.jjdd6.czfureczka.statistic;

import com.infoshareacademy.jjdd6.czfureczka.database.RouteStatistic;
import com.infoshareacademy.jjdd6.czfureczka.database.RouteStatisticDao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Stateless
public class PopularRoute {

    @Inject
    RouteStatisticDao statisticDao;

    public RouteCount getMostPopularRoute(){
        List<RouteCount> test = getSortRoutes(1);
        return test.get(0);
    }

    public List<RouteStatistic> getAll(){
        return statisticDao.findAll(RouteStatistic.class);
    }

    public List<RouteCount> getSortRoutes(Integer limit){
        List<RouteCount> result = new ArrayList<>();
        Map<String, String> popularRoutes = statisticDao.findPopular(RouteStatistic.class);
        Integer iter = popularRoutes.size();
        for (int i = 0; i < iter; i++) {
            String key = new ArrayList<>(popularRoutes.keySet()).get(0);
            result.add(new RouteCount(key, popularRoutes.get(key)));
            popularRoutes.remove(key);
        }
        return result.stream()
                .sorted()
                .limit(limit)
                .collect(Collectors.toList());
    }

}