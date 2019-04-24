package com.infoshareacademy.jjdd6.czfureczka.fakeData;

import com.infoshareacademy.jjdd6.czfureczka.model.Route;
import com.infoshareacademy.jjdd6.czfureczka.model.Stop;
import com.infoshareacademy.jjdd6.czfureczka.model.StopInTrip;
import com.infoshareacademy.jjdd6.czfureczka.model.StopTimes;

import java.util.ArrayList;
import java.util.List;

public class FakeData {

    public List<Stop> fakeStops() {
        List<Stop> stops = new ArrayList<>();

        Stop s1 = new Stop();
        s1.setStopId(1);
        s1.setNonpassenger(0);
        s1.setStopDesc("Akademia Muzyczna");
        stops.add(s1);

        Stop s2 = new Stop();
        s2.setStopId(2);
        s2.setNonpassenger(0);
        s2.setStopDesc("Sikorskiego");
        stops.add(s2);

        Stop s3 = new Stop();
        s3.setStopId(3);
        s3.setNonpassenger(1);
        s3.setStopDesc("Wojska Polskiego");
        stops.add(s3);

        Stop s4 = new Stop();
        s4.setStopId(4);
        s4.setNonpassenger(0);
        s4.setStopDesc("Brama Wyżynna");
        stops.add(s4);

        Stop s5 = new Stop();
        s5.setStopId(5);
        s5.setNonpassenger(0);
        s5.setStopDesc("Reja");
        stops.add(s5);

        return stops;
    }

    public List<Route> fakeRoutes() {
        List<Route> routes = new ArrayList<>();

        Route r1 = new Route();
        r1.setRouteId(2);
        r1.setRouteShortName("2");
        routes.add(r1);

        Route r2 = new Route();
        r2.setRouteId(3);
        r2.setRouteShortName("3");
        routes.add(r2);

        Route r3 = new Route();
        r3.setRouteId(167);
        r3.setRouteShortName("167");
        routes.add(r3);

        Route r4 = new Route();
        r4.setRouteId(1000);
        r4.setRouteShortName("N5");
        routes.add(r4);

        return routes;
    }

    public List<StopInTrip> fakeStopInTrip() {
        List<StopInTrip> stopInTrips = new ArrayList<>();

        StopInTrip s1 = new StopInTrip();
        s1.setRouteId(2);
        s1.setStopId(1);
        s1.setTripId(1);
        s1.setStopSequence(1);
        stopInTrips.add(s1);

        StopInTrip s2 = new StopInTrip();
        s2.setRouteId(3);
        s2.setStopId(2);
        s2.setTripId(2);
        s2.setStopSequence(1);
        stopInTrips.add(s2);

        StopInTrip s3 = new StopInTrip();
        s3.setRouteId(2);
        s3.setStopId(4);
        s3.setTripId(1);
        s3.setStopSequence(2);
        stopInTrips.add(s3);

        StopInTrip s4 = new StopInTrip();
        s4.setRouteId(3);
        s4.setStopId(4);
        s4.setTripId(2);
        s4.setStopSequence(2);
        stopInTrips.add(s4);

        StopInTrip s5 = new StopInTrip();
        s5.setRouteId(1000);
        s5.setStopId(5);
        s5.setTripId(2);
        s5.setStopSequence(1);
        stopInTrips.add(s5);

        return stopInTrips;
    }

    public List<StopTimes> fakeStopTimes() {
        List<StopTimes> stopTimes = new ArrayList<>();

        StopTimes st1 = new StopTimes();
        st1.setDepartureTime("19:00:00");
        st1.setDepartureTime("19:10:00");
        st1.setDepartureTime("19:20:00");
        st1.setRouteId(12);

        return stopTimes;

    }
}
