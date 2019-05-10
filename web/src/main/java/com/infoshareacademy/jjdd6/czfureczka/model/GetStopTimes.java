package com.infoshareacademy.jjdd6.czfureczka.model;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class GetStopTimes {


    public void getStopTimes() {

        LocalDate date = LocalDate.now();

        final Client client = ClientBuilder.newClient();

        final WebTarget webTarget = client.target("http://87.98.237.99:88/stopTimes?date=2019-05-10&routeId=130");


        final Response response = webTarget.request().accept(MediaType.APPLICATION_JSON_TYPE).get();

        StopTimesWithDate responseValue = response.readEntity(StopTimesWithDate.class);

        response.close();

        responseValue.getStopTimes();
    }

}
