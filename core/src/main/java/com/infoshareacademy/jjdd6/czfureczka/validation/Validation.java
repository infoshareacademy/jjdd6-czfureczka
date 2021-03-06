package com.infoshareacademy.jjdd6.czfureczka.validation;

import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;


import javax.ejb.Stateless;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Stateless
public class Validation {

    public boolean validationOfStopName(String stopName) {
        if (stopName != null && stopName.length() != 0) {
            String name = stopName.trim().toLowerCase();
            Long count = Repository.getInstance().getStops().stream()
                    .map(s -> s.getStopDesc().toLowerCase())
                    .distinct()
                    .filter(desc -> desc.equals(name))
                    .count();
            return count != 0;
        }
        return false;
    }

    public boolean validationOfRoutName(String routeName) {
        if (routeName != null && routeName.length() != 0) {
            String name = routeName.trim().toLowerCase();
            Long count = Repository.getInstance().getRoutes().stream()
                    .map(r -> r.getRouteShortName().toLowerCase())
                    .distinct()
                    .filter(n -> n.equals(name))
                    .count();
            return count != 0;
        }
        return false;
    }

    public boolean validationOfTimeDeparture(String departure) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(departure.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }
}




