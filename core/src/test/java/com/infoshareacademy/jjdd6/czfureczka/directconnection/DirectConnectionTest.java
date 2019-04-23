package com.infoshareacademy.jjdd6.czfureczka.directconnection;

import com.infoshareacademy.jjdd6.czfureczka.fakeData.FakeData;
import com.infoshareacademy.jjdd6.czfureczka.repository.Repository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DirectConnectionTest {

    @BeforeAll
    static void setup(){
        FakeData fake = new FakeData();
        Repository.getInstance().setStops(fake.fakeStops());
        Repository.getInstance().setRoutes(fake.fakeRoutes());
        Repository.getInstance().setStopsInTrip(fake.fakeStopInTrip());
    }
    private DirectConnection directConnection = new DirectConnection();

    @Test
    void checkSharedTripWithCorrectStrings() {
        List<String> result = new ArrayList<>();
        result.add("2");
        Assertions.assertThat(directConnection.checkSharedTrip("Akademia Muzyczna", "Brama Wyżynna"))
                .isNotNull()
                .isEqualTo(result);
    }

    @Test
    void checkSharedTripWithIncorrectString() {
        Assertions.assertThat(directConnection.checkSharedTrip("Akademia Muzyczna", "Sikorskiego"))
                .isNotNull()
                .isEmpty();
    }

    @Test
    void conversionStopDescIntoRouteIdWithCorrectString() {
        List<Integer> result = new ArrayList<>();
        result.add(2);
        Assertions.assertThat(directConnection.conversionStopDescIntoRouteId("Akademia Muzyczna"))
                .isNotNull()
                .isEqualTo(result);
    }

    @Test
    void conversionStopDescIntoRoutesIdWithCorrectString() {
        List<Integer> result = new ArrayList<>();
        result.add(2);
        result.add(3);
        Assertions.assertThat(directConnection.conversionStopDescIntoRouteId("Brama Wyżynna"))
                .isNotNull()
                .isEqualTo(result);
    }
}