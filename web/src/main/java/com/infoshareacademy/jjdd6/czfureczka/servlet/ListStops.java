package com.infoshareacademy.jjdd6.czfureczka.servlet;

import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class ListStops {

    public List<String> getListStops(){
        return Repository.getInstance().getStops().stream()
                .map(s -> s.getStopDesc())
                .distinct()
                .collect(Collectors.toList());
    }
}
