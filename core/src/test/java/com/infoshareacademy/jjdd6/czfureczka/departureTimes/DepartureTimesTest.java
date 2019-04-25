package com.infoshareacademy.jjdd6.czfureczka.departureTimes;

import com.infoshareacademy.jjdd6.czfureczka.fakeData.FakeData;
import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DepartureTimesTest {

    @BeforeAll
    static void setup() {
        FakeData fake = new FakeData();
        Repository.getInstance().setStops(fake.fakeStops());
        Repository.getInstance().setRoutes(fake.fakeRoutes());
        Repository.getInstance().setStopsInTrip(fake.fakeStopInTrip());
        Repository.getInstance().setStopTimes(fake.fakeStopTimes());
        Repository.getInstance().setTrips(fake.fakeTrip());
    }

    private DepartureTimes departureTimes = new DepartureTimes();


    @Test
    void departureTimesWithCorrectMap() {
        Map<String, List<String>> result = new HashMap<>();
        List<String> times = new ArrayList<>();
        times.add("19:00:00");
        times.add("19:10:00");
        result.put("2[Pruszcz Komarowo - Pruszcz Rondo Kociewskie]", times);
        Assertions.assertThat(departureTimes.departureTimes("Akademia Muzyczna"))
                .isNotNull()
                .isEqualTo(result);

    }

}

