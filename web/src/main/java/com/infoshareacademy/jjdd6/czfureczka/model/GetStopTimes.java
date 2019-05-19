package com.infoshareacademy.jjdd6.czfureczka.model;

import com.infoshareacademy.jjdd6.czfureczka.servlet.Menu;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class GetStopTimes {

    private static final Logger logger = Logger.getLogger(GetStopTimes.class.getName());

    public List<StopTimes> getStopTimes(String routeId) {


        LocalDate lD = LocalDate.now();

        if (DayOfWeek.SATURDAY == lD.getDayOfWeek() || DayOfWeek.SUNDAY == lD.getDayOfWeek()) {
            lD=lD.plus(2, ChronoUnit.DAYS);
        }

        String date = String.valueOf(lD);

        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target("http://87.98.237.99:88/stopTimes?date=" + date + "&routeId=" + routeId);


        Response response = webTarget.request().accept(MediaType.APPLICATION_JSON_TYPE).get();

        StopTimesWithDate responseValue = response.readEntity(StopTimesWithDate.class);

        response.close();

        logger.info("Read json form url");


        return responseValue.getStopTimes();
    }

}
