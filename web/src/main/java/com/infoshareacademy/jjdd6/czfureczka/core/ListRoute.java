package com.infoshareacademy.jjdd6.czfureczka.core;

import com.infoshareacademy.jjdd6.czfureczka.agency.AgenciesModeOfTransportation;
import com.infoshareacademy.jjdd6.czfureczka.agency.ModeOfTransportation;
import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;
import com.infoshareacademy.jjdd6.czfureczka.validation.Validation;
import com.infoshareacademy.jjdd6.czfureczka.viewModel.RouteWithModeOfTransportation;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class ListRoute {

    @Inject
    Validation validation;

    public List<String> getListAllRoute() {
        return Repository.getInstance().getRoutes().stream()
                .map(r -> r.getRouteShortName())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<RouteWithModeOfTransportation> getListOfAllLinesForTypeVehicle(ModeOfTransportation type) {
        return Repository.getInstance().getRoutes().stream()
                .map(r -> new RouteWithModeOfTransportation(r.getRouteId(), r.getRouteShortName(), AgenciesModeOfTransportation.mapping.get(r.getAgencyId())))
                .filter(r1 -> r1.getModeOfTransportation() == type)
                .sorted()
                .collect(Collectors.toList());
    }

    public boolean checkNameOfRoute(String route) {
        return validation.validationOfRoutName(route);
    }

}
