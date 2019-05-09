package com.infoshareacademy.jjdd6.czfureczka.model;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;

public class GetStopTimes {


    public StopTimes getStopTimes(Date data, int routeID) {

        final Client client = ClientBuilder.newClient();

        final WebTarget webTarget = client.target("http://87.98.237.99:88/stopTimes");

        final Form params = new Form();
        params.param("data", String.valueOf(data));
        params.param("routeId", String.valueOf(routeID));


        final Response response = webTarget.request().accept(MediaType.APPLICATION_JSON_TYPE).post(Entity.form(params));

        final StopTimesWithDate responseValue = response.readEntity(StopTimesWithDate.class);

        response.close();

        return responseValue.getStopTimes().get(0);
    }
}
