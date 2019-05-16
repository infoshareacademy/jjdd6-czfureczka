package com.infoshareacademy.jjdd6.czfureczka.core;

import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;
import com.infoshareacademy.jjdd6.czfureczka.validation.Validation;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class ListStops {

    @Inject
    Validation validation;

    public boolean checkNameOfStop(String name){

        return validation.validationOfStopName(name);
    }

    public List<String> getListAllStops(){
        return Repository.getInstance().getStops().stream()
                .map(s -> s.getStopDesc())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}
