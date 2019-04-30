package com.infoshareacademy.jjdd6.czfureczka.core;

import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;
import com.infoshareacademy.jjdd6.czfureczka.validation.Validation;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class ListRoute {

    @Inject
    Validation validation;

    public List<String> getListAllRoute(){
        return Repository.getInstance().getRoutes().stream()
                .map(r -> r.getRouteShortName())
                .distinct()
                .collect(Collectors.toList());
    }

    public boolean checkNameOfRoute(String route){
        return validation.validationOfRoutName(route);
    }

}
